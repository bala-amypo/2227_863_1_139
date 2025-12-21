package com.example.demo.service.impl;

import com.example.demo.entity.CourseMapping;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.entity.TransferRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseMappingRepository;
import com.example.demo.repository.ProgramRepository;
import com.example.demo.service.TransferValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferValidationServiceImpl implements TransferValidationService {

    private final ProgramRepository programRepository;
    private final CourseMappingRepository courseMappingRepository;

    public TransferValidationServiceImpl(
            ProgramRepository programRepository,
            CourseMappingRepository courseMappingRepository) {
        this.programRepository = programRepository;
        this.courseMappingRepository = courseMappingRepository;
    }

    @Override
    public TransferEvaluationResult evaluateTransfer(TransferRequest request) {

        Long sourceProgramId = request.getSourceProgram().getId();
        Long targetProgramId = request.getTargetProgram().getId();

        if (!programRepository.existsById(sourceProgramId)) {
            throw new ResourceNotFoundException("Source program not found");
        }

        if (!programRepository.existsById(targetProgramId)) {
            throw new ResourceNotFoundException("Target program not found");
        }

        double totalCredits = 0;

        List<CourseMapping> mappings = courseMappingRepository.findAll();

        for (CourseMapping mapping : mappings) {
            totalCredits += mapping.getTargetCourse().getCredits();
        }

        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setTransferRequest(request);
        result.setTotalTransferableCredits(totalCredits);

        if (totalCredits > 0) {
            result.setRemarks("APPROVED");
        } else {
            result.setRemarks("REJECTED");
        }

        return result;
    }
}