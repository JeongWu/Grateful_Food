package com.example.demo.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class OrderSearch {

    @Id
    private Long id;
    private String memberName;
    private DeliveryStatus deliveryStatus;
    public OrderSearch(){
    }
}
