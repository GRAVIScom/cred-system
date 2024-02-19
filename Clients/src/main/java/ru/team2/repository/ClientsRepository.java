package ru.team2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.team2.entity.Client;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByName(String name);
}

