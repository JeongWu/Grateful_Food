package com.example.demo.eating.chicken;

import com.example.demo.domain.Food;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@DiscriminatorValue("C")
public class KFC extends Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kfc_id")
    private Long id;
    private String kfc_value;
    private String kfc_taste;

}
