package br.com.bucker.kafka.balances;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record BalanceUpdateInputDTO(
        @JsonProperty("account_id_from")
        String accountIDFrom,
        @JsonProperty("account_id_to")
        String accountIDTo,
        @JsonProperty("balance_account_id_from")
        Double balanceAccountIDFrom,
        @JsonProperty("balance_account_id_to")
        Double balanceAccountIDTo
) {
}
