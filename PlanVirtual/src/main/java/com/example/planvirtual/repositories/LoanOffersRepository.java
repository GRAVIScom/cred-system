package com.example.planvirtual.repositories;

import com.example.planvirtual.entities.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public interface LoanOffersRepository extends JpaRepository<Offers, Long> {
    @Query(value = "select l1.summ from public.offers l1 where l1.id = 41", nativeQuery = true)
    @Transactional
    long getSumById(@Param("id") int loanId);

    @Query(value = "select limits from offers where id = :loanId", nativeQuery = true)
    @Transactional
    Long getLimitById(@Param("loanId") int loanId);

    @Query(value = "select rate from offers where id = :loanId", nativeQuery = true)
    @Transactional
    double getRateById(@Param("loanId") int loanId);

    @Query(value = "select datepayment from OFFERS where OFFERS.id = :loanId", nativeQuery = true)
    @Transactional
    Date getDateById(int loanId);

    Optional<Offers> getAllById(Long id);
}
