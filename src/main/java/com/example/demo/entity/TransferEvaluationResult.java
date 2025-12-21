package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "transfer_request_id")
    private TransferRequest transferRequest;

    private Double totalTransferableCredits;
    private String remarks;

    public TransferEvaluationResult() {
    }

    public TransferEvaluationResult(
            TransferRequest transferRequest,
            Double totalTransferableCredits,
            String remarks) {

        this.transferRequest = transferRequest;
        this.totalTransferableCredits = totalTransferableCredits;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public TransferRequest getTransferRequest() {
        return transferRequest;
    }

    public void setTransferRequest(TransferRequest transferRequest) {
        this.transferRequest = transferRequest;
    }

    public Double getTotalTransferableCredits() {
        return totalTransferableCredits;
    }

    public void setTotalTransferableCredits(Double totalTransferableCredits) {
        this.totalTransferableCredits = totalTransferableCredits;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
