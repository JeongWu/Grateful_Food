package com.example.demo.eating.chicken;


import com.example.demo.domain.Food;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("C")
public class BBQ extends Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbq_id")
    private Long id;
    private String bbq_value;
    private String bbq_taste;

}
