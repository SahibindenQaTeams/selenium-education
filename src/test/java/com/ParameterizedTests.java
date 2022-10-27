package com;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
public class ParameterizedTests {


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


  @Tag("hotfix")
  @Tag("S360")
  @ParameterizedTest
  @ValueSource(strings = {"A","B","C"})
  public void parameterizedTestForString(String value){
    System.out.println("ParameterizedTest methodu çalıştı - Value : "+ value);
  }

  @Tags({@Tag("ALISVERIS"),  @Tag("hotfix")})
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4})
  public void parameterizedTestForInteger(Integer value){
    System.out.println("ParameterizedTest methodu çalıştı - Value : "+ value);
  }

  @ParameterizedTest
  @EnumSource(names = {"ALI","VELI"}, mode = Mode.EXCLUDE)
  public void parameterizedTestForEnum(EnumParameterized value){
    System.out.println("ParameterizedTest methodu çalıştı - EnumSource -> Value : "+ value);
  }



}
