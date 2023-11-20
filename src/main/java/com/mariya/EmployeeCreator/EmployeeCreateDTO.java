package com.mariya.EmployeeCreator;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class EmployeeCreateDTO {

  @NotBlank(message = "First name is mandatory")
  @Getter
  @Setter
  private String firstName;

  @NotBlank(message = "Last name is mandatory")
  @Getter
  @Setter
  private String lastName;

  @NotBlank(message = "Email is mandatory")
  @Getter
  @Setter
  @Email
  private String email;

  @NotBlank(message = "Type is mandatory")
  @Getter
  @Setter
  private String type;

  public EmployeeCreateDTO(String firstName, String lastName, String email, String type) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.type = type;

  }
}
