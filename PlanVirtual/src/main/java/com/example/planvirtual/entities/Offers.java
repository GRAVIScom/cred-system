package com.example.planvirtual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity
@Table(name = "offers", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "limits", nullable = false)
    @NonNull
    Long limits;

    @Column(name = "summ", nullable = false)
    @NonNull
    Long summa;

    @Column(name = "rate", nullable = false)
    @NonNull
    Double rate;

    @Column(name = "date_payment", nullable = false)
    @NonNull
    Date datePayment;
}
