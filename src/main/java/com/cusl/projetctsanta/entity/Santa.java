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
    @Column(name = "memberNo",nullable = false)
    private String memberNo;
    @Column(name = "initName",nullable = false)
    private String initName;
    @Column(name = "fullName",nullable = false)
    private String fullName;
    @Column(name = "refID",nullable = true)
    private String refID;

}
