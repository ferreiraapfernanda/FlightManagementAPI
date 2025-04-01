package br.com.fernanda.after.aspect;

import br.com.fernanda.after.domain.OriginalParams;
import lombok.Getter;

public class OriginalMethodTracker {

    @Getter
    private static final ThreadLocal<OriginalParams> firstMethod = new ThreadLocal<OriginalParams>();

    public static void setMethod(OriginalParams originalParams) {

        if(firstMethod.get() != null){
            clear();
        }

        firstMethod.set(originalParams);
    }

    public static void clear() {
        firstMethod.remove();
    }

}

