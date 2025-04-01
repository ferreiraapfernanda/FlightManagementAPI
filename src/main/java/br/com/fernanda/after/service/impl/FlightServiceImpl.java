package br.com.fernanda.after.service.impl;

import br.com.fernanda.after.domain.annotation.ReferenceFlow;
import br.com.fernanda.core.ExternalAPI;
import br.com.fernanda.domain.Flight;
import br.com.fernanda.domain.FlightRequest;
import br.com.fernanda.enums.ReferenceEnum;
import br.com.fernanda.services.FlightService;
import org.springframework.stereotype.Service;

import static java.time.LocalTime.now;

@Service
public class FlightServiceImpl implements FlightService {

    private ExternalAPI externalAPI;

    @ReferenceFlow(ReferenceEnum.CREATE_FLIGHT)
    @Override
    public Flight createFlight(FlightRequest flightRequest){
        return externalAPI.create(flightRequest.getDate(), flightRequest.getAirline(), now()).block();
    }
}
