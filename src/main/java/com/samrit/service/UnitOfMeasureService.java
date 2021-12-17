package com.samrit.service;

import com.samrit.commands.UnitOfMeasureCommand;

import java.util.Set;


public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
