package com.example.demo.service;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.entity.TransferRequest;

public interface TransferValidationService {

    TransferEvaluationResult evaluateTransfer(TransferRequest request);
}