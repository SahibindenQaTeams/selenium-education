package com;

import static org.junit.jupiter.api.Assertions.fail;

import extension.LogExtension;
import extension.TestExtension;
import extension.TestStatusExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TestExtension.class, LogExtension.class, TestStatusExtension.class})
public class TestClass2 extends BaseTest {

  @Test
  public void test1() {
    fail("test");
  }

  @Test
  public void test2() {

  }

  @Test
  public void test3() {

  }

  @Test
  public void test4() {

  }
}
