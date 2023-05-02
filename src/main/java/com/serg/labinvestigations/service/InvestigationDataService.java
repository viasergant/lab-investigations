package com.serg.labinvestigations.service;

import com.serg.labinvestigations.entity.InvestigationData;

import java.time.LocalDate;
import java.util.List;

public interface InvestigationDataService {
    InvestigationData save(InvestigationData investigationData);

    List<InvestigationData> findAll();

    void remove(InvestigationData data);

    List<InvestigationData> findWithFilter(String name, LocalDate from, LocalDate to);
}
