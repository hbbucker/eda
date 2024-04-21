package br.com.bucker.kafka;

import br.com.bucker.events.Event;
import br.com.bucker.kafka.balances.BalanceUpdateInputDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class EventKafkaDeserializer extends ObjectMapperDeserializer<Event<BalanceUpdateInputDTO>> {

    public EventKafkaDeserializer() {
        super(new TypeReference<Event<BalanceUpdateInputDTO>>() { });
    }

    public EventKafkaDeserializer(Class<Event<BalanceUpdateInputDTO>> type) {
        super(type);
    }
}
