package com.example.demo.entity;


@Entity
@Table(name=" ")
public class Course{
     
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique=true)
    private String code;

    @Column(nullable=false)
    private String Title;

    @Column(nullable=false)
    private String credits;
}