package com.example.demo.entity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
   private 

}