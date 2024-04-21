package br.com.bucker.usecase.balances.findall;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDateTime;

@RegisterForReflection
public record FindAllUseCaseOutputDTO(
        String accountIDFrom,
        String accountIDTo,
        Double balanceAccountIDFrom,
        Double balanceAccountIDTo,
        LocalDateTime timestamp
) {
}
