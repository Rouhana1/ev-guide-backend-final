package com.example.cms.model.repository;

import com.example.cms.model.entity.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStation, Long> {

}
