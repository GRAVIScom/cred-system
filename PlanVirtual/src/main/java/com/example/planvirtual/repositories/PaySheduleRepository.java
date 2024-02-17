package com.example.planvirtual.repositories;

import com.example.planvirtual.entities.PayShedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaySheduleRepository extends JpaRepository<PayShedule, Long> {
}
