package com.daou.test.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * com.test.date
 *
 * @DATE 2023-03-20
 * @Author daou
 * @Version 1.0
 */
public class YearMMdd {
  public static void main(String args[]){

    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")));
  }
}
