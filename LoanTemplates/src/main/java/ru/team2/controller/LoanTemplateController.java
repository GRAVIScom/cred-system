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
import ru.team2.entity.LoanTemplate;
import ru.team2.service.LoanTemplateService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/loantemplates", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "LoanTemplate", description = "Loan Template API")
public class LoanTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(LoanTemplateController.class);

    private final LoanTemplateService service;

    @GetMapping
    @Operation(summary = "Get all Loan Templates")
    public ResponseEntity<List<LoanTemplate>> getAllLoanTemplates() {
        List<LoanTemplate> loanTemplates = service.findAll();
        logger.info("getting loan templates list: {}", loanTemplates);
        return new ResponseEntity<>(loanTemplates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get loan template details")
    public LoanTemplate getLoanTemplateById(@PathVariable("id") long loanTemplateId) {
        return service.findById(loanTemplateId);
    }

    @PostMapping
    @Operation(summary = "Create a new Loan Template")
    public ResponseEntity<LoanTemplate> createLoanTemplate(@RequestBody LoanTemplate loanTemplate) {
        service.save(loanTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/loanTemplates/" + loanTemplate.getId());
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update a Loan Template")
    public ResponseEntity<LoanTemplate> updateLoanTemplate(@RequestBody LoanTemplate loanTemplate) {
        service.update(loanTemplate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{loanTemplateId}")
    @Operation(summary = "Delete a Loan Template by id")
    public ResponseEntity<LoanTemplate> deleteLoanTemplateById(@PathVariable long loanTemplateId) {
        service.deleteById(loanTemplateId);
        return ResponseEntity.ok().build();
    }

}