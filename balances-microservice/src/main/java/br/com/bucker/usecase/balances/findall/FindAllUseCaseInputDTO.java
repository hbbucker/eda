package br.com.bucker.usecase.balances.findall;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record FindAllUseCaseInputDTO(
        @JsonProperty("account_id")
        String accountId
) {
}
