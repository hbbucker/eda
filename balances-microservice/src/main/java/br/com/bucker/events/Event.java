package br.com.bucker.events;

import br.com.bucker.kafka.ISO8601InstantDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.Instant;

@RegisterForReflection
public record Event<T>(
        @JsonProperty("Name")
        String name,
        @JsonProperty("DateTime")
        @JsonDeserialize(using = ISO8601InstantDeserializer.class)
        Instant dateTime,
        @JsonProperty("Payload")
        T payload
) {
}
