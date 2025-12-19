package com.example.demo.entity;


@Entity
@Table(name = "")
public class TransferRequest{

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;   

   @Column(nullable=false)
   private String studentId;

   
}