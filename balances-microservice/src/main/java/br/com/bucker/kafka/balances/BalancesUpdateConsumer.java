package br.com.bucker.kafka.balances;

import br.com.bucker.events.Event;
import br.com.bucker.usecase.UseCase;
import br.com.bucker.usecase.balances.update.UpdateBalancesInputDTO;
import br.com.bucker.usecase.balances.update.UpdateBalancesOutputDTO;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.CompletionStage;

public class BalancesUpdateConsumer {

    @Inject
    UseCase<UpdateBalancesInputDTO, UpdateBalancesOutputDTO> updateBalancesUseCase;

    @Incoming("balances")
    public CompletionStage<Void> consume(Message<Event<BalanceUpdateInputDTO>> message) {
        Event<BalanceUpdateInputDTO> balance = message.getPayload();

        Log.infof("Consuming balance: %s", balance);

        UpdateBalancesInputDTO updateBalancesInputDTO = new UpdateBalancesInputDTO(
                balance.payload().accountIDFrom(),
                balance.payload().accountIDTo(),
                balance.payload().balanceAccountIDFrom(),
                balance.payload().balanceAccountIDTo(),
                LocalDateTime.ofInstant(balance.dateTime(), ZoneId.systemDefault())
        );

        return Uni.createFrom().item(updateBalancesInputDTO)
                .runSubscriptionOn(Infrastructure.getDefaultWorkerPool())
                .chain(() -> Uni.createFrom().item(updateBalancesUseCase.execute(updateBalancesInputDTO)))
                .subscribeAsCompletionStage()
                .thenAccept(output -> {
                    Log.info(output.message());
                    message.ack();
                });
    }

}
