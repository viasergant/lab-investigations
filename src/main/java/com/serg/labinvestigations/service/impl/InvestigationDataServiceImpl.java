package com.serg.labinvestigations.service.impl;


import com.serg.labinvestigations.entity.InvestigationData;
import com.serg.labinvestigations.repository.InvestigationRepository;
import com.serg.labinvestigations.service.InvestigationDataService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class InvestigationDataServiceImpl implements InvestigationDataService {
    private final InvestigationRepository repository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public InvestigationDataServiceImpl(InvestigationRepository repository) {
        this.repository = repository;
    }
    @Override
    public InvestigationData save(InvestigationData data) {
        return repository.save(data);
    }

    @Override
    public List<InvestigationData> findAll() {
        return repository.findAll();
    }

    @Override
    public void remove(InvestigationData data) {
        repository.delete(data);
    }

    @Override
    public List<InvestigationData> findWithFilter(String name, LocalDate from, LocalDate to) {
        StringBuilder queryStr = new StringBuilder();
        boolean hasCondition = false;
        queryStr.append("select i from InvestigationData i ");
        if (StringUtils.hasLength(name) || from != null || to != null) {
            queryStr.append(" where ");
        }
        if (StringUtils.hasLength(name)) {
            queryStr.append(" lower(i.name) like lower(concat('%', :name,'%')) ");
            hasCondition = true;
        }
        if (from != null) {
            if (hasCondition) {
                queryStr.append(" and ");
            }
            queryStr.append(" i.date >= :startDate ");
            hasCondition = true;
        }
        if (to != null) {
            if (hasCondition) {
                queryStr.append(" and ");
            }
            queryStr.append(" i.date <= :endDate ");
        }
        String queryS = queryStr.toString();
        Query query = entityManager.createQuery(queryStr.toString());
        if (queryS.contains("name")) {
            query.setParameter("name", name);
        }
        if (queryS.contains("startDate")) {
            query.setParameter("startDate", from);
        }
        if (queryS.contains("endDate")) {
            query.setParameter("endDate", to);
        }
        return query.getResultList();
    }
}
