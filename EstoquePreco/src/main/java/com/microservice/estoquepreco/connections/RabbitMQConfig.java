package com.microservice.estoquepreco.connections;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

public class RabbitMQConfig {
    private static final String NOME_EXCHANGE = "amq.direct";

    private Queue fila(String nomeFila) {
        return new Queue(nomeFila, true, false, false) { };
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca) {
        return new Binding(fila.getName(), Binding.DestinationType.EXCHANGE, troca.getName(), fila.getName(), null);
    }
}