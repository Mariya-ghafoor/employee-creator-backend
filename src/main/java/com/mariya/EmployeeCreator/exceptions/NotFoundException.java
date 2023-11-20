package com.mariya.EmployeeCreator.exceptions;

public class NotFoundException extends RuntimeException {

  private String message;

  public NotFoundException(String message) {
    super();
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }

}
