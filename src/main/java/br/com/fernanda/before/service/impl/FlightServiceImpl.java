package br.com.fernanda.before.service.impl;

import br.com.fernanda.domain.FlightRequest;
import br.com.fernanda.services.FlightService;
import br.com.fernanda.core.ExternalAPI;
import br.com.fernanda.domain.Flight;
import org.springframework.stereotype.Service;

import java.util.Date;

import static java.time.LocalTime.now;

@Service
public class FlightServiceImpl implements FlightService {

    private ExternalAPI externalAPI;

    public Flight createFlight(FlightRequest flightRequest){
        return externalAPI.create(flightRequest.getDate(), flightRequest.getAirline(), now()).block();
    }
}
