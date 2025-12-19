package com.example.demo.entity;

@Entity
@Table(name = "universities")
public class University{
        

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        
        private String name;

        private String country;



}