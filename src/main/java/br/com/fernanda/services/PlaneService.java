package br.com.fernanda.services;

import br.com.fernanda.domain.Flight;

import java.util.Date;

public interface PlaneService {

    public Long create(String model, Date createdAt);
}
