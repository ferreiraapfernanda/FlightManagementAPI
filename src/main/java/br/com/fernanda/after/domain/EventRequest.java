package br.com.fernanda.after.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest extends AnotherBaseRequest {

    private Date date, createdAt;
    private String airline, model;

    /**
     * Outros campos
     */

}
