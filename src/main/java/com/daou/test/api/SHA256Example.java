package com.daou.test.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * com.test.api
 *
 * @DATE 2023-03-22
 * @Author daou
 * @Version 1.0
 */
public class SHA256Example {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    String input = "daourecycle0322eb49b67112818a1322b57ca2151f54fff16debc1e8486f2933cf264ef4510f41";
    String encrypted = encryptSHA256(input);
    System.out.println("Input string: " + input);
    System.out.println("Encrypted string: " + encrypted);
  }

  public static String encryptSHA256(String input) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] hash = md.digest(input.getBytes());
    StringBuilder hexString = new StringBuilder();
    for (byte b : hash) {
      String hex = Integer.toHexString(0xff & b);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }
}
