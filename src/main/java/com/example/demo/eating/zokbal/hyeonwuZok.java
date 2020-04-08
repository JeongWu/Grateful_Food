package com.example.demo.eating.zokbal;

import com.example.demo.domain.Food;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@DiscriminatorValue("Z")
public class hyeonwuZok extends Food{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hyeonwu_id")
    private Long id;
    private String hyeonwu_zokbal;
    private String hyeonwu_taste; //빨간맛 꿀맛 마늘맛

}
