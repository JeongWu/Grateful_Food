package com.example.demo.eating.pizza;

import com.example.demo.domain.Food;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("P")
public class Domino extends Food {

    private String domino_value;
    private String domino_taste;

}
