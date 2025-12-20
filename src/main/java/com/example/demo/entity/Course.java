package com.example.demo.entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="courses")
public class Course{
     
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String code;

    private String Title;
    
    private Double credits;


    public Course(String code,String Title,Double credits){
        this.
    }
}