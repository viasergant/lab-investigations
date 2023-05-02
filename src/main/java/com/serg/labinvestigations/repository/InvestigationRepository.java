package com.serg.labinvestigations.repository;

import com.serg.labinvestigations.entity.InvestigationData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface InvestigationRepository extends CrudRepository<InvestigationData, Long> {
    public List<InvestigationData> findAll();
    @Query("from InvestigationData i where lower(i.name) like lower(concat('%', :name,'%'))")
    public List<InvestigationData> findByName(@Param("name") String name);
}
