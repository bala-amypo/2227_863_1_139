package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String title;
    
    private Double credits;


    public Course(String code,String title,Double credits){
        this.code=code;
        this.title=title;
        this.credits=credits;
    }
}