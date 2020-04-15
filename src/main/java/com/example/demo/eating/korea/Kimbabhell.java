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
public class Kimbabhell extends Food {


    private  String hell_value;
    private String hell_taste;




}
