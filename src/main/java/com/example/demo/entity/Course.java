package com.example.demo.entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="courses")
public class Course{
     
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique=true)
    private String code;

    @Column(nullable=false)
    private String Title;

    @Column(nullable=false)
    private Double credits;
}