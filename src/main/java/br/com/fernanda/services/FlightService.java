package br.com.fernanda.services;

import br.com.fernanda.domain.Flight;
import br.com.fernanda.domain.FlightRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

public interface FlightService {

    public Flight createFlight(FlightRequest flightRequest);
}
