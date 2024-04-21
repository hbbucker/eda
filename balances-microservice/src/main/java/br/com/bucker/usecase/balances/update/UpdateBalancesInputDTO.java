package br.com.bucker.usecase.balances.update;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDateTime;

@RegisterForReflection
public record UpdateBalancesInputDTO(
        String accountIDFrom,
        String accountIDTo,
        Double balanceAccountIDFrom,
        Double balanceAccountIDTo,
        LocalDateTime timestamp) {
}
