package com.mariya.EmployeeCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

enum employmentType {
  PERMANENT,
  CONTRACT
}

@Entity
@Table(name = "employees")
public class Employee {

  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @Getter
  @Setter
  private String firstName;

  @Column
  @Getter
  @Setter
  private String lastName;

  @Column
  @Getter
  @Setter
  private String email;

  @Column
  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  private employmentType type;

  public Employee() {
  }

  public Employee(String firstName, String lastName, String email, employmentType type) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.type = type;

  }

}
