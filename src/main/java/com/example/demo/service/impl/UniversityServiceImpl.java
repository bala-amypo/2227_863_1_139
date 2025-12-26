package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private UniversityRepository repository;

    public UniversityServiceImpl() {
    }

    public UniversityServiceImpl(UniversityRepository repository) {
        this.repository = repository;
    }

    public void setRepository(UniversityRepository repository) {
        this.repository = repository;
    }

    @Override
    public University createUniversity(University university) {
        return repository.save(university);
    }

    @Override
    public University updateUniversity(Long id, University updated) {
        University existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));

        existing.setName(updated.getName());
        existing.setCountry(updated.getCountry());
        existing.setAccreditationLevel(updated.getAccreditationLevel());
        existing.setActive(updated.getActive());

        return repository.save(existing);
    }

    @Override
    public University getUniversityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));
    }

    @Override
    public void deactivateUniversity(Long id) {
        University u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));
        u.setActive(false);
        repository.save(u);
    }

    @Override
    public List<University> getAllUniversities() {
        return repository.findAll();
    }
}
