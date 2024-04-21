package br.com.bucker.api;

import br.com.bucker.usecase.UseCase;
import br.com.bucker.usecase.balances.findall.FindAllUseCaseInputDTO;
import br.com.bucker.usecase.balances.findall.FindAllUseCaseOutputDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api")
public class BalancesAPI {

    @Inject
    UseCase<FindAllUseCaseInputDTO, FindAllUseCaseOutputDTO> findAllUseCase;

    @GET
    @Path("/balances/{accountId:.*}")
    public FindAllUseCaseOutputDTO findAll(@PathParam("accountId") String accountId) {
        return findAllUseCase.execute(new FindAllUseCaseInputDTO(accountId));
    }

}
