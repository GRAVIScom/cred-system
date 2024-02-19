package ru.team2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.team2.entity.Client;
import ru.team2.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Client", description = "Client API")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientService service;

    @GetMapping
    @Operation(summary = "Get all clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = service.findAll();
        logger.info("getting clients list: {}", clients);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client details")
    public Client getClientById(@PathVariable("id") long clientId) {
        return service.findById(clientId);
    }

    @PostMapping
    @Operation(summary = "Create a new client")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        service.save(client);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/clients/" + client.getId());
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update a client")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        service.update(client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}")
    @Operation(summary = "Delete a client by id")
    public ResponseEntity<Client> deleteClientById(@PathVariable long clientId) {
        service.deleteById(clientId);
        return ResponseEntity.ok().build();
    }

}
