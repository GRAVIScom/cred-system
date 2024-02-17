package com.example.planvirtual.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "loan_offers")
@Getter
@Setter
public class Loan_offers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "id_client", nullable = false)
    Long clientId;

    @Column(name = "id_loan_template", nullable = false)
    Long loanTemplateId;

    @Column(name = "limits", nullable = false)
    Long limits;

    @Column(name = "summ", nullable = false)
    Long summa;

    @Column(name = "rate", nullable = false)
    double rate;

    @Column(name = "create_date", nullable = false)
    Date dateLoan;
}
