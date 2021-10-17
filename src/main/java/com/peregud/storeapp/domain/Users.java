package com.peregud.storeapp.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public String username;

  public String password;

  public String role;
}
