package com.cusl.projetctsanta.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 12/2/2022
 **/


@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "santa")
public class Santa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "refID",nullable = true)
    private int refID;

}
