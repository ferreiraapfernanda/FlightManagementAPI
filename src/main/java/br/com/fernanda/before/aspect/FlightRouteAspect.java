package br.com.fernanda.before.aspect;

import br.com.fernanda.enums.ReferenceEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class FlightRouteAspect {

    @AfterReturning(pointcut = "execution(* br.com.fernanda.before.services.impl.FlightServiceImpl.*(..)", returning = "result")
    public void afterMethodReturn(JoinPoint joinPoint, Object result){

        String methodName = joinPoint.getSignature().getName();
        Object request = joinPoint.getArgs();

        ReferenceEnum reference = getReference(methodName);

        sendEvent(request, result, reference);

    }

    private void sendEvent(Object request, Object result, ReferenceEnum reference) {
        /**
         * envia ao Kafka
         */
    }

    private ReferenceEnum getReference(String methodName) {
        return switch (methodName) {
            case "postCreateFlight" -> ReferenceEnum.CREATE_FLIGHT;
            case "postDeleteFlight" -> ReferenceEnum.DELETE_FLIGHT;
            case "postDeleteFlightById" -> ReferenceEnum.DELETE_FLIGHT_BY_ID;
            case "postDelayFlight" -> ReferenceEnum.DELAY_FLIGHT;
            /**
             * mais métodos
             */
            default -> null;
        };
    }
}
