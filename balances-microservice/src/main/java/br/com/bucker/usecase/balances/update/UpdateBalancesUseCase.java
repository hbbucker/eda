package br.com.bucker.usecase.balances.update;

import br.com.bucker.model.BalancesModel;
import br.com.bucker.usecase.UseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
@Named("UpdateBalancesUseCase")
public class UpdateBalancesUseCase implements UseCase<UpdateBalancesInputDTO, UpdateBalancesOutputDTO> {

    @Override
    @Transactional
    public UpdateBalancesOutputDTO execute(UpdateBalancesInputDTO input) {
        BalancesModel balance = new BalancesModel();
        balance.id = UUID.randomUUID().toString();
        balance.accountIDFrom = input.accountIDFrom();
        balance.accountIDTo = input.accountIDTo();
        balance.balanceAccountIDFrom = input.balanceAccountIDFrom();
        balance.balanceAccountIDTo = input.balanceAccountIDTo();
        balance.timestamp = input.timestamp();
        balance.persist();

        return new UpdateBalancesOutputDTO("Balances updated successfully! ID: %s".formatted(balance.id));
    }
}
