package com.example.planvirtual.repositories;

import com.example.planvirtual.entities.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface LoanOffersRepository extends JpaRepository<Offers, Long> {
    @Query(value = "select summ from offers where offers.id = :loanId", nativeQuery = true)
    Long getSumById(@Param("loanId") int loanId);

    @Query(value = "select limits from offers where offers.id = :loanId", nativeQuery = true)
    Long getLimitById(@Param("loanId") int loanId);

    @Query(value = "select rate from offers where offers.id = :loanId", nativeQuery = true)
    double getRateById(@Param("loanId") int loanId);

    @Query(value = "select date_payment from offers where offers.id = :loanId", nativeQuery = true)
    Date getDateById(int loanId);

}
