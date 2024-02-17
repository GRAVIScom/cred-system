package com.example.planvirtual.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "loan_templates")
@Getter
@Setter
public class LoanTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "limits", nullable = false)
    Long limits;

    @Column(name = "rate", nullable = false)
    Long rate;
}
