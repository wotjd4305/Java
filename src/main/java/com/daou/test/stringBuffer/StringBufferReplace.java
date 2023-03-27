package com.daou.test.stringBuffer;

/**
 * com.test.stringBuffer
 *
 * @DATE 2023-03-13
 * @Author daou
 * @Version 1.0
 */
public class StringBufferReplace {
  public static void main(String args[]){
    String str = "CD";
    StringBuffer sb = new StringBuffer("abcdefghijklm");


    System.out.println(sb.replace(2,8,str));
  }
}
