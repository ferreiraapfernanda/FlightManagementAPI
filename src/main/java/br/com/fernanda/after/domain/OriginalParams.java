package br.com.fernanda.after.domain;

import br.com.fernanda.enums.ReferenceEnum;

public record OriginalParams(Object request, String methodName, ReferenceEnum reference) {

}
