package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;

@MicronautTest
class MockBeansExampleTest {

  @Inject
  EmbeddedApplication<?> application;

  @Inject
  @Named("bean1")
  MockedBean mockedBean1;

  @Inject
  @Named("bean2")
  MockedBean mockedBean2;

  @MockBean(named = "bean1", bean = MockedBean.class)
  MockedBean mockedBean1() {
    return Mockito.mock(MockedBean.class);
  }
  @MockBean(named = "bean2", bean = MockedBean.class)
  MockedBean mockedBean2() {
    return Mockito.mock(MockedBean.class);
  }

  @Test
  void testItWorks() {
    Assertions.assertTrue(MockUtil.isMock(mockedBean1));
    Assertions.assertTrue(MockUtil.isMock(mockedBean2));
  }

}
