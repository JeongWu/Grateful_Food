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



    private  String heaven_value;
    private String heaven_taste;

}
