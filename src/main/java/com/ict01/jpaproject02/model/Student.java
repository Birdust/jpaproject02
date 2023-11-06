package com.ict01.jpaproject02.model;

import lombok.*;

import javax.persistence.*;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 30)
  private String name;

  @Column(length = 30)
  private String email;

  @Column(length = 100)
  private String address;
}
