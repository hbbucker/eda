package br.com.bucker.usecase.balances.findall;

import java.util.Optional;

import br.com.bucker.model.BalancesModel;
import br.com.bucker.usecase.UseCase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class FindAllUseCase implements UseCase<FindAllUseCaseInputDTO, FindAllUseCaseOutputDTO> {
    @Override
    public FindAllUseCaseOutputDTO execute(FindAllUseCaseInputDTO input) {
        Optional<BalancesModel> lastBalance = BalancesModel
                .find("accountIDFrom = ?1", Sort.by("timestamp").descending(), input.accountId())
                .firstResultOptional();
        
        if (lastBalance.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return new FindAllUseCaseOutputDTO(
                lastBalance.get().accountIDFrom,
                lastBalance.get().accountIDTo,
                lastBalance.get().balanceAccountIDFrom,
                lastBalance.get().balanceAccountIDTo,
                lastBalance.get().timestamp
        );
    }
}
