package br.com.fernanda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class PlaneRequest {

    private String model;
    private Date createdAt;
}
