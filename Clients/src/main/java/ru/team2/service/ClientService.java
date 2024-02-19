package ru.team2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.team2.entity.Client;
import ru.team2.exception.ItemNotFoundException;
import ru.team2.repository.ClientsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientsRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Client not found, id = " + id));
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client update(Client client) {
        findById(client.getId());
        return repository.save(client);
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

}
