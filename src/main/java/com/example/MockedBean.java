package com.example;
import io.micronaut.context.annotation.EachProperty;

@EachProperty("mocked-beans")
public class MockedBean {
  String prop;
}
