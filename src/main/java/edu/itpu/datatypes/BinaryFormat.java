package edu.itpu.datatypes;

/**
 * You can use any of predefined format:
 * <ul>
 *   <li>{@link BinaryFormat#LONG_FORMAT} - 64 bits, 4 bits group</li>
 *   <li>{@link BinaryFormat#INT_FORMAT} - 32 bits, 4 bits group</li>
 *   <li>{@link BinaryFormat#SHORT_FORMAT} - 16 bits, 4 bits group</li>
 *   <li>{@link BinaryFormat#BYTE_FORMAT} - 8 bits, 4 bits group</li>
 *   <li>{@link BinaryFormat#FOUR_BITS} - 4 bits, 4 bits group (so only one group)</li>
 * </ul>
 * 
 * If you want to define your own, just create a new {@link BinaryFormat}.
 * 
 * <pre>{@code
 *   BinaryFormat fmt = new BinaryFormat(12, 3);
 *   String binString = fmt.format(Integer.toBinaryString(42));
 * }</pre>
 * 
 * @param length how many bits must be shown
 * @param groupSize how many bits must be in groups separated by underscore (_)
 */
record BinaryFormat(int length, int groupSize) {
  
  public static final BinaryFormat LONG_FORMAT = new BinaryFormat(64, 4);
  public static final BinaryFormat INT_FORMAT = new BinaryFormat(32, 4);
  public static final BinaryFormat SHORT_FORMAT = new BinaryFormat(16, 4);
  public static final BinaryFormat BYTE_FORMAT = new BinaryFormat(8, 4);
  public static final BinaryFormat FOUR_BITS = new BinaryFormat(4, 4);

  /**
   * You can pass here a binary string. To get binary string from a primitive, you can call
   * {@code toBinaryString} method of corresponding wrapper class.
   * 
   * For example:
   * <pre>{@code
   *  format(Integer.toBinaryString(42));
   *  format(Long.toBinaryString(42L));
   *  format(Byte.toBinaryString(42));
   * }</pre>
   */
  public String format(String binaryString) {
    String binStr = String.format(format(), binaryString).replace(' ', '0');
    int totalGroups = totalGroups();
    String[] arr = new String[totalGroups];
    for (int i = 0; i < totalGroups; ++i) {
      arr[i] = binStr.substring(groupSize * i, groupSize * (i + 1));
    }
    return String.join("_", arr);
  }

  private String format() {
    return String.format("%%%ds", length);
  }

  private int totalGroups() {
    return length / groupSize;
  }
}
