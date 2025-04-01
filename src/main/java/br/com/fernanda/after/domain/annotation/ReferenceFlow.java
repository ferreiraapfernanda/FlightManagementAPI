package br.com.fernanda.after.domain.annotation;

import br.com.fernanda.enums.ReferenceEnum;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ReferenceFlow {
    ReferenceEnum value();
}
