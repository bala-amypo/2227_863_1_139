package com.example.demo.entity;




@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "universities")
public class University{
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(unique=true)
        private String name;
        
        private String country;
        

        public University(String name,String country){
                this.name=name;
                this.country=country;
        }
}