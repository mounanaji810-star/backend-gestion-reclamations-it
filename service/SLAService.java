package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.SLA;
import com.projet.itreclamation.repository.SLARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SLAService {

    private final SLARepository repository;

    public SLA create(SLA sla) {
        return repository.save(sla);
    }

    public List<SLA> getAll() {
        return repository.findAll();
    }

    public Optional<SLA> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<SLA> getByDescription(String description) {
        return repository.findByDescription(description);
    }

    public SLA update(SLA sla) {
        return repository.save(sla);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}