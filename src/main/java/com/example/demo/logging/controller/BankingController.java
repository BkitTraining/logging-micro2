package com.example.demo.logging.controller;

import com.example.demo.logging.annotation.LogMethod;
import com.example.demo.logging.exception.ResourceNotFoundException;
import com.example.demo.logging.model.BankInfo;
import com.example.demo.logging.service.BankingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro2")
@AllArgsConstructor
@LogMethod
@Log4j2
public class BankingController {

  private final BankingService bankingService;

  @GetMapping("/banking/{id}")
  public BankInfo getBankInfo(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
    return bankingService.getBankInfo(employeeId);
  }

}
