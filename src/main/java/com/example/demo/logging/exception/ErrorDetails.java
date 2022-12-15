package com.example.demo.logging.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
public class ErrorDetails {

  private final Date timestamp;
  private final String message;
  private final String details;

}
