package com.example.planvirtual.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "pay_shedule")
@Getter
@Setter
public class PayShedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "datePayment", nullable = false)
    Date date;

    @Column(name = "summ_body", nullable = false)
    Long sumBody;

    @Column(name = "sum_percent", nullable = false)
    Long sumPercent;
}
