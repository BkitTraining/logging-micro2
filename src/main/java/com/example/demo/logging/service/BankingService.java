package com.example.demo.logging.service;

import com.example.demo.logging.exception.ResourceNotFoundException;
import com.example.demo.logging.model.BankInfo;

public interface BankingService {

  BankInfo getBankInfo(Long employeeId) throws ResourceNotFoundException;

}
