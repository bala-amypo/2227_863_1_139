package com.example.demo.entity;


@Entity
@Table(name = "transfer_requests")
public class TransferRequest{

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;   

   private String studentId;

   @ManyToOne
   @JoinColumn(name=)
   private 

}