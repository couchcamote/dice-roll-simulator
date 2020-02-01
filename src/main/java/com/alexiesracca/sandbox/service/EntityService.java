package com.alexiesracca.sandbox.service;

import java.time.LocalDateTime;

import com.alexiesracca.sandbox.entity.GenericEntity;

public class EntityService {

    final static String DEFAULT = "SYSTEM";
    public static void updateEntity(GenericEntity entity){
        entity.setCreatedBy(DEFAULT);
        entity.setLastModifiedBy(DEFAULT);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setLastModifiedDate(LocalDateTime.now());
    }
}