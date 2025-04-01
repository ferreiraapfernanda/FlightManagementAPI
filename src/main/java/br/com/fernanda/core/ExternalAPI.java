package br.com.fernanda.core;

import br.com.fernanda.domain.Flight;
import reactor.core.publisher.Mono;

import java.nio.channels.MembershipKey;
import java.time.LocalTime;
import java.util.Date;

public class ExternalAPI {
    public Mono<Flight> create(Date date, String airline, LocalTime now) {
        return null;
    }
}
