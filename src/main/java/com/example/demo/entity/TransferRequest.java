package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transfer_requests")
public class TransferRequest{

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;   

   private String studentId;

   @ManyToOne
   @JoinColumn(name="source_program_id")
   private Program sourceProgram;

   @ManyToOne
   @JoinColumn(name="target_program_id")
   private Program targetProgram;
   
   @OneToMany(cascade = CascadeType.ALL)
   private List<CompletedCourse> completedcourses;

   @Enumerated(EnumType.STRING)
   private TransferStatus status;
   
   public TransferRequest(String studentId,Program sourceProgram,Program targetProgram,List<CompletedCourse> completedcourses,TransferStatus status ){
      this.studentId=studentId;
      this.sourceProgram=sourceProgram;
      this.targetProgram=targetProgram;
      this.completedcourses=completedcourses;
      this.TransferStatus status;
   }
}