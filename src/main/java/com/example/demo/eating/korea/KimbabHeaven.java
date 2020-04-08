package com.example.demo.eating.korea;


import com.example.demo.domain.Food;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@DiscriminatorValue("K")
public class KimbabHeaven extends Food {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heaven_id")
    private Long id;
    private  String heaven_value;
    private String heaven_taste;

}
