package ru.team2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan_templates")
@Data
@NoArgsConstructor
public class LoanTemplate {

    public LoanTemplate(Long id, String name, Long limits, Long rate) {
        this.id = id;
        this.name = name;
        this.limits = limits;
        this.rate = rate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long limits;
    private Long rate;


}