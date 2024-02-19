package ru.team2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.team2.entity.LoanTemplate;
import ru.team2.exception.ItemNotFoundException;
import ru.team2.repository.LoanTemplatesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanTemplateService {

    private final LoanTemplatesRepository repository;

    public List<LoanTemplate> findAll() {
        return repository.findAll();
    }

    public LoanTemplate findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Loan Template not found, id = " + id));
    }

    public LoanTemplate save(LoanTemplate loanTemplate) {
        return repository.save(loanTemplate);
    }

    public LoanTemplate update(LoanTemplate loanTemplate) {
        findById(loanTemplate.getId());
        return repository.save(loanTemplate);
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

}