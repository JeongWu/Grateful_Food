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
public class Gazok extends Food {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gazok_id")
    private Long id;
    private String gazok_zokbal; //종류 앞발 뒷발
    private String gazok_taste; //맛 매운맛, 달콤한맛


}
