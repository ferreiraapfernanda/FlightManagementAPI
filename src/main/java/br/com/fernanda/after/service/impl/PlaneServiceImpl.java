package br.com.fernanda.after.service.impl;

import br.com.fernanda.after.domain.annotation.ReferenceFlow;
import br.com.fernanda.enums.ReferenceEnum;
import br.com.fernanda.services.PlaneService;

import java.util.Date;

public class PlaneServiceImpl implements PlaneService {

    @ReferenceFlow(ReferenceEnum.CREATE_PLANE)
    @Override
    public Long create(String model, Date createdAt) {
        return 0L;
    }
}
