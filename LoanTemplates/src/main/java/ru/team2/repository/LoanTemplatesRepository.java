package ru.team2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.team2.entity.LoanTemplate;

import java.util.List;

@Repository
public interface LoanTemplatesRepository extends JpaRepository<LoanTemplate, Long> {
    List<LoanTemplate> findAllByName(String name);
}