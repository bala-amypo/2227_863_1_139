package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "transfer_request_id")
    private TransferRequest transferRequest;

    private Double totalTransferableCredits;
    private String remarks;

    public TransferEvaluationResult(TransferRequest transferRequest, Double totalTransferableCredits, String remarks) {
        this.transferRequest = transferRequest;
        this.totalTransferableCredits = totalTransferableCredits;
        this.remarks = remarks;
    }
}
