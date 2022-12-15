package com.example.demo.logging.service;

import com.example.demo.logging.annotation.LogMethod;
import com.example.demo.logging.model.BankInfo;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@LogMethod
@Log4j2
public class BankingServiceImpl implements BankingService {

  @Override
  public BankInfo getBankInfo(Long employeeId) {
    Faker faker = new Faker();
    return BankInfo.builder()
        .bankNumber(UUID.randomUUID().toString())
        .email(faker.internet().safeEmailAddress())
        .lastName(faker.name().lastName())
        .firstName(faker.name().firstName())
        .balance(faker.number().digit())
        .build();
  }

}
