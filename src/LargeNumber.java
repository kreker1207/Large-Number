public class LargeNumber {

    private int[] largeDecValue;
    private String hexValue;
    int bits;

    public LargeNumber() {
        bits = 8;
    }

    public void setHex(String largeNumber){
        if(largeNumber == null || largeNumber.equals("")){
            throw new IllegalArgumentException("Invalid input");
        }
        this.hexValue = largeNumber;
        this.bits = 32;
        largeDecValue = setLargeValue(hexValue,bits);
    }
    public String getHex(){
        return this.hexValue;
    }

    public static String XOR(LargeNumber numberA, LargeNumber numberB){
        return "";
    }
    public static String OR(LargeNumber numberA, LargeNumber numberB){
        return "";
    }
    public static String AND(LargeNumber numberA, LargeNumber numberB){
        return "";
    }
    public static String INV(LargeNumber numberA, LargeNumber numberB){
        return "";
    }
    public static String shiftR(LargeNumber numberA, int n){
        return "";
    }
    public static String shiftL(LargeNumber numberA,int n){
        return "";
    }
    public int[] getLargeDecValue(){
        return this.largeDecValue;
    }

    private int[] setLargeValue(String hexNumber, int bits){
        if (!hexNumber.matches("[0-9A-Fa-f]+")) {
            throw new IllegalArgumentException("Invalid hexadecimal number.");
        }
        long decimalNumber = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            char hexChar = hexNumber.charAt(i);
            int hexValue = Character.digit(hexChar, 16);
            decimalNumber = decimalNumber * 16 + hexValue;
        }
        System.out.println(decimalNumber);
        int numElements = (int) Math.ceil((double) Long.SIZE / bits);
        int[] decimalArray = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            decimalArray[i] = (int) ((decimalNumber >> (bits * i)) & ((1L << bits) - 1));
        }
        return decimalArray;
    }
    public long convertArrayToDecimal(){
        long decimal = 0;
        for(int i = 0; i< largeDecValue.length; i++){
            decimal += ((long) largeDecValue[i]) << (bits*i);
        }
        return decimal;
    }
}
