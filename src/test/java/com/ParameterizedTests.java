package com;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
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


  //parametrik olarak A,B,C değerilerini teker teker aynı testi çalıştırıp değerlerini dinamik olarak kullanmamızı sağlar
  @Tag("hotfix")
  @Tag("S360")
  @ParameterizedTest
  @ValueSource(strings = {"A","B","C"})
  public void parameterizedTestForString(String value){
    System.out.println("ParameterizedTest methodu çalıştı - Value : "+ value);
  }

  //parametrik olarak 1,2,3,4 değerilerini teker teker aynı testi çalıştırıp değerlerini dinamik olarak kullanmamızı sağlar
  @Tags({@Tag("ALISVERIS"),  @Tag("hotfix")})
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4})
  public void parameterizedTestForInteger(Integer value){
    System.out.println("ParameterizedTest methodu çalıştı - Value : "+ value);
  }

  //parametrik olarak Enum classı içerisinde tanımlanmış değerleri teker teker aynı testi çalıştırıp değerlerini dinamik olarak kullanmamızı sağlar
  //Enum classı içerisinde o nesneye ait değerler verilebilir ve kullanılan nesnenin içerisinde bulunan değerler alınabilir
  @ParameterizedTest
  //Bütün değerleri alır
  @EnumSource()
  //ALI,VELI değerlerini alır sadece
  //@EnumSource(names = {"ALI","VELI"}, mode = Mode.EXCLUDE)
  //ALI,VELI değerleri hariç diğer değerleri alır
  //@EnumSource(names = {"ALI","VELI"}, mode = Mode.INCLUDE)
  //EnumParameterized enum class ını parametre olarak verdiğimizde @EnumSource sayesinde otomatik olarak o enum clasında bulunan değerleri kullandırır
  public void parameterizedTestForEnum(EnumParameterized value){
    System.out.println("ParameterizedTest methodu çalıştı - EnumSource -> Value : "+ value +" - Yıl -> "+ value.getYil() +" - İl -> "+value.getIl());
  }

  //CsvFileSource parametre olarak resources değerini verdiğimizde proje içserisinde bulunan resources klasörü altında bulunan ilgili dosyayı okur
  //csv file içerisinde bulunan sütün sayısı kadar bu testin methodunda parametre tanımlaması yapılmalıdır bu değerler satır satır okunur ve test satır uzunluğu boyunca çalıştırılır teker teker
  @ParameterizedTest
  @CsvFileSource(resources = "/csvFile.csv")
  public void parameterizedTestForCsvFileSource(String name, Integer year){
    System.out.println("ParameterizedTest methodu çalıştı - CsvFileSource -> Name : " + name +" - Year : "+year);
  }

  //Csv dosyası yerine csv tipinde değerler verip teker teker çalıştırmamızı sağlar
  @ParameterizedTest
  @CsvSource({
      "apple,1",
      "banana,3",
      "orange,2",
  })
  public void parameterizedTestCsvSource(String fruit, int rank) {
    System.out.println("ParameterizedTest methodu çalıştı - CsvSource -> Fruit : " + fruit +" - Rank : "+rank);
  }

  //MethodSource dinamik olarak değerler için bir method oluşturulup bu method içerisinde bulunan değeri return ettirip bu değerleri almamıza olanak tanır
  //static olarak tanımlanan stringProvider methodunun ismini MethodSource a tanıtmamız gerekmektedir
  @ParameterizedTest
  @MethodSource("stringProvider")
  public void parameterizedTestMethodSourceForString(String value) {
    System.out.println("ParameterizedTest çalıştı - MethodSource for String -> " + value);
  }

  static Stream<String> stringProvider() {
    return Stream.of("apple", "banana");
  }

  //MethodSource dinamik olarak değerler için bir method oluşturulup bu method içerisinde bulunan değeri return ettirip bu değerleri almamıza olanak tanır
  //static olarak tanımlanan stringProvider methodunun ismini MethodSource a tanıtmamız gerekmektedir
  @ParameterizedTest
  @MethodSource("range")
  void parameterizedTestMethodSourceForInteger(int value) {
    System.out.println("ParameterizedTest çalıştı - MethodSource for Integer -> " + value);
  }

  static IntStream range() {
    return IntStream.range(0, 20).skip(10);
  }


}
