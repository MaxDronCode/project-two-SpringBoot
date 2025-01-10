package com.travelport.projecttwo.repository;

import com.travelport.projecttwo.repository.entities.SaleCabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISalesCabRepository extends JpaRepository<SaleCabEntity, String> {

    // Forma 1: si no mapeas la relación con "product" dentro de SalesDetEntity
    @Query("""
        SELECT DISTINCT sc
        FROM SaleCabEntity sc
        JOIN FETCH sc.details d
        WHERE sc.clientId = :clientId
    """)
    List<SaleCabEntity> findAllByClientId(@Param("clientId") String clientId);
}
