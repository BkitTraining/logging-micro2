package com.example.demo.logging.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankInfo {

  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private String bankNumber;
  private String balance;

}
