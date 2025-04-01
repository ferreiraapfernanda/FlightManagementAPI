package br.com.fernanda.after.domain.factory;

import br.com.fernanda.after.domain.EventRequest;
import br.com.fernanda.domain.FlightRequest;
import br.com.fernanda.domain.PlaneRequest;

public class EventRequestFactory {

    private EventRequestFactory(){}

    public static EventRequest adapt(Object request){
        if(request instanceof FlightRequest flightRequest){
            return adaptFlightRequest(flightRequest);
        }

        if(request instanceof PlaneRequest planeRequest){
            return adaptPlaneRequest(planeRequest);
        }

        /**
         * outras classes
         */

        return new EventRequest();
    }

    private static EventRequest adaptPlaneRequest(PlaneRequest planeRequest) {
        EventRequest eventRequest = new EventRequest();
        eventRequest.setModel(planeRequest.getModel());
        eventRequest.setCreatedAt(planeRequest.getCreatedAt());
        return eventRequest;
    }

    private static EventRequest adaptFlightRequest(FlightRequest flightRequest) {
        EventRequest eventRequest = new EventRequest();
        eventRequest.setDate(flightRequest.getDate());
        eventRequest.setAirline(flightRequest.getAirline());
        return eventRequest;
    }
}
