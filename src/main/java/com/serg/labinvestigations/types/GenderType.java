package com.serg.labinvestigations.types;

import java.util.Arrays;
import java.util.Optional;

public enum GenderType {
  MALE("чол"),
  FEMALE("жін");

  private final String description;

  public static Optional<GenderType> resolveFromString(String textValue) {
    return Arrays.stream(GenderType.values()).filter(i->i.getDescription().equals(textValue)).findFirst();
  }

  GenderType(String name) {
    this.description = name;
  }

  public String getDescription() {
    return description;
  }
}
