package edu.itpu.datatypes;

import static edu.itpu.datatypes.BinaryFormat.*;

public class BitHelper {
  
  private static final int a = 0b0000_0000_0001_0000_0000_0000_0011_0001;
  private static final int b = 0b1000_0000_1111_0000_0000_0000_1111_0000;
  
  private static final long l = 0b0000_0000_0000_1111_1111_0000_0000_0000_1111_0000_1111_0000_1111_0000_1111_0000L;

  public static void main(String[] args) {
    print("a", a);
    print("b", b);
    
    // Bitwise
    print("~a", ~a);
    print("a & b", a & b);
    print("a | b", a | b);
    print("a ^ b", a ^ b);
    
    // Shifts
    print("b << 1", b << 1);
    print("b << 5", b << 5);
    print("b >> 1", b << 1);
    print("b >> 5", b >> 5);
    print("b >>> 5", b >>> 5);
    
    // Casting
    print("l", l);
    printAsLong("(int) l", (int) l);
  }

  public static void print(String expr, long a) {
    printFull(expr, LONG_FORMAT.format(Long.toBinaryString(a)), a);
  }
  
  public static void print(String expr, int a) {
    printFull(expr, INT_FORMAT.format(Integer.toBinaryString(a)), a);
  }
  
  public static void printAsLong(String expr, int a) {
    printFull(expr, LONG_FORMAT.format(Integer.toBinaryString(a)), a);
  }
  
  public static void prints(String expr, int a) {
    printFull(expr, FOUR_BITS.format(Integer.toBinaryString(a)), a);
  }
  
  private static void printFull(String expr, String binaryString, long value) {
    System.out.printf("%8s: %s = %d%n", expr, binaryString, value);
  }
}
