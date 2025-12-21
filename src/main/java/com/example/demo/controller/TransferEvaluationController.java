package com.example.demo.controller;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferValidationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
public class TransferEvaluationController {

    private final TransferValidationService transferValidationService;

    public TransferEvaluationController(
            TransferValidationService transferValidationService) {
        this.transferValidationService = transferValidationService;
    }

    @PostMapping("/evaluate")
    public TransferEvaluationResult evaluateTransfer(
            @RequestBody TransferEvaluationResult request) {

        return transferValidationService.evaluateTransfer(request);
    }
}
