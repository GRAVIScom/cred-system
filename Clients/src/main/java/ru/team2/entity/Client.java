package ru.team2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
public class Client {

    public Client(Long id, String name, String phone, String email, String passport) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.passport = passport;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String passport;

}
