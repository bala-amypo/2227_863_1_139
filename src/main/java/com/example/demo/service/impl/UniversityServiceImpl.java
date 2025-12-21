package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University createUniversity(University university) {

        if (universityRepository.findByNameIgnoreCase(
                university.getName()).isPresent()) {

            throw new ValidationException("University already exists");
        }

        return universityRepository.save(university);
    }

    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University getUniversityById(Long id) {

        return universityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("University not found"));
    }
}
