package com.serg.labinvestigations.types;

import java.util.Arrays;
import java.util.Optional;

public enum PatientType {
  HUMAN("Людина"),
  CAT("Кіт"),
  DOG("Собака");

  private final String description;

  public static Optional<PatientType> resolveFromString(String textValue) {
    return Arrays.stream(PatientType.values()).filter(i->i.getDescription().equals(textValue)).findFirst();
  }
  PatientType(String name) {
    this.description = name;
  }

  public String getDescription() {
    return description;
  }
}
