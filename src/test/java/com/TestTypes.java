package com;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TestTypes {

  @BeforeEach
  public void beforeEach(){
    System.out.println("BeforeEach methodu çalıştı");
  }

  @AfterEach
  public void afterEach(){
    System.out.println("AfterEach methodu çalıştı");
  }

  @BeforeAll
  public void beforeAll(){
    System.out.println("BeforeAll methodu çalıştı");
  }

  @AfterAll
  public void afterAll(){
    System.out.println("AfterAll methodu çalıştı");
  }

  @Test
  public void test(){
    System.out.println("Test methodu çalıştı");
  }

  @Test
  public void test2(){
    System.out.println("Test 2 methodu çalıştı");
  }


  @Tag("repeated")
  @RepeatedTest(1)
  public void repeatedTest(){
    System.out.println("RepeatedTest methodu çalıştı");
    fail("fail");
  }


}
