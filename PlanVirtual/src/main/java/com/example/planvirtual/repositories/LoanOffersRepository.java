package com.example.planvirtual.repositories;

import com.example.planvirtual.entities.Loan_offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface LoanOffersRepository extends JpaRepository<Loan_offers, Long> {
    @Query(value = "select summa from Loan_offers where id = :loanId", nativeQuery = false)
    Long getSumById(@Param("loanId") int loanId);

    @Query(value = "select limits from loan_offers where id = :loanId", nativeQuery = true)
    Long getLimitById(@Param("loanId") int loanId);

    @Query(value = "select rate from Loan_offers where id = :loanId", nativeQuery = false)
    double getRateById(@Param("loanId") int loanId);

    @Query(value = "select create_date from loan_offers where id = :loanId", nativeQuery = true)
    Date getDateById(@Param("loanId") int loanId);

    @Query(value = "select dateLoan from Loan_offers where clientId = 12", nativeQuery = false)
    Optional<Loan_offers> getAllByClientId(Long clientId);
}
