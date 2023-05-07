package com.qendel.authenticationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private int price;
    @Lob
    private byte[] data;

    private String details;

    private String tutorName;

    public Video(String name, int price, byte[] data) {
        this.name = name;
        this.price = price;
        this.data = data;
    }
}
