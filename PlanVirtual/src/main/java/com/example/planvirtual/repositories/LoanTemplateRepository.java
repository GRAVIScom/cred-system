package com.example.planvirtual.repositories;

import com.example.planvirtual.entities.LoanTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTemplateRepository extends JpaRepository<LoanTemplate, Long> {
}
