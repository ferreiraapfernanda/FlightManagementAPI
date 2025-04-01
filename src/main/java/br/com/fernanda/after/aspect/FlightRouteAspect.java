package br.com.fernanda.after.aspect;

import br.com.fernanda.after.domain.EventRequest;
import br.com.fernanda.after.domain.EventResponse;
import br.com.fernanda.after.domain.OriginalParams;
import br.com.fernanda.after.domain.annotation.ReferenceFlow;
import br.com.fernanda.after.domain.factory.EventRequestFactory;
import br.com.fernanda.after.domain.factory.EventResponseFactory;
import br.com.fernanda.enums.ReferenceEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class FlightRouteAspect {

    @Pointcut("execution(* br.com.fernanda.before.services.impl.FlightServiceImpl.*(..)")
    public void flightMethods() {

    }

    @Pointcut("execution(* br.com.fernanda.services.impl.PlaneServiceImpl.*(..)")
    public void planeMethods(){

    }

    @Around("flightMethods() || planeMethods()")
    public Object aroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        Method method = methodSignature.getMethod();

        Object request = joinPoint.getArgs();

        ReferenceEnum reference = method.getAnnotation(ReferenceFlow.class).value();

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            OriginalMethodTracker.setMethod(new OriginalParams(request, methodName, reference));
            throw e;
        }

        EventRequest eventRequest = EventRequestFactory.adapt(request); // tratamento da request
        EventResponse eventResponse = EventResponseFactory.adapt(result); // tratamento da response

        sendEvent(eventRequest, eventResponse, reference);

        return result;

    }

    @AfterReturning(pointcut = "br.com.fernanda.exception.ErrorHandler.*(..)", returning = "newResponse")
    public void afterErrorHandler(JoinPoint joinPoint, Object newResponse){
        OriginalParams originalParams = OriginalMethodTracker.getFirstMethod();
        OriginalMethodTracker.clear();
        sendEvent(originalParams.request(), newResponse, originalParams.reference());
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
