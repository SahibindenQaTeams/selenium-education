package com;

public enum EnumParameterized {

  AHMET(1999,"Ankara"),
  MEHMET(1994,"İstanbul"),
  ALI(1993,"Çorum"),
  VELI(1995,"Bolu");

  int yil;
  String il;

  EnumParameterized(int yil, String il) {
    this.yil = yil;
    this.il = il;
  }

  public int getYil() {
    return yil;
  }

  public String getIl() {
    return il;
  }
}
