package com.github.example;

import org.eclipse.microprofile.graphql.NonNull;

public class DescribedValue<V> {

  @NonNull V value;

  String description;

  public DescribedValue() {
  }

  public DescribedValue(V value, String description) {
    this.value = value;
    this.description = description;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
