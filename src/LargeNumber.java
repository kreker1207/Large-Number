public class LargeNumber {

    private int[] largeValue;
    private int[] hexInBinary;
    private String hexValue;
    private int bits;

    public LargeNumber() {
        bits = 8;
    }

    public int[] getHexInBinary() {
        return hexInBinary;
    }

    public void setHex(String largeNumber){
        if(largeNumber == null || largeNumber.equals("")){
            throw new IllegalArgumentException("Invalid input");
        }
        this.hexValue = largeNumber;
        this.bits = 32;
        largeValue = hexStringToIntArray(largeNumber);
        hexInBinary = hexToBinaryArray(largeNumber);
    }
    public String getHex(){
        return this.hexValue;
    }

    public String XOR(LargeNumber numberA, LargeNumber numberB){
       if(!isValid(numberA) || !isValid(numberB)){
           throw new IllegalArgumentException("Your number is not valid");
       }
       int[] numberArrayA = numberA.getHexInBinary();
       int[] numberArrayB = numberB.getHexInBinary();
       int[] result = xorArrays(numberArrayA,numberArrayB);
       return binaryArrayToHex(result);
    }
    ////// Works correctly only for hexes with the same length
    private int[] xorArrays(int[] arrayA, int[] arrayB) {
        int length = Math.max(arrayA.length,arrayB.length);
        int []result = new int[length];
        for(int i = 0; i< length;i++){
            int a = (i< arrayA.length)?arrayA[i]:0;
            int b = (i< arrayB.length)? arrayB[i]:0;
            result[i] = a ^ b;
        }
        return result;
    }


    public String OR(LargeNumber numberA, LargeNumber numberB){
        if(!isValid(numberA) || !isValid(numberB)){
            throw new IllegalArgumentException("Your number is not valid");
        }
        int[] numberArrayA = numberA.getHexInBinary();
        int[] numberArrayB = numberB.getHexInBinary();
        int[] result = orArrays(numberArrayA,numberArrayB);
        return binaryArrayToHex(result);
    }
    private int[] orArrays(int[] arrayA, int[] arrayB) {
        int length = Math.max(arrayA.length,arrayB.length);
        int []result = new int[length];
        for(int i = 0; i< length;i++){
            int bitA = (i < arrayA.length) ? arrayB[i] : 0;
            int bitB = (i < arrayA.length) ? arrayB[i] : 0;
            result[i] = bitA | bitB;
        }
        return result;
    }

    public String AND(LargeNumber numberA, LargeNumber numberB){
        return "";
    }
    public String INV(LargeNumber numberA, LargeNumber numberB){
        return "";
    }
    public String shiftR(LargeNumber numberA, int n){
        return "";
    }
    public String shiftL(LargeNumber numberA,int n){
        return "";
    }
    public int[] getLargeValue(){
        return this.largeValue;
    }
    private int[] hexStringToIntArray(String hexString){
        hexString = hexString.replaceAll("^0x|0X","");
        if(!isHex(hexString)){
            throw new IllegalArgumentException("Invalid hexadecimal number");
        }
        String[] hexPair = hexString.split("(?<=\\G.{2})");
        int[] result = new int[hexPair.length];
        for(int i = 0; i< hexPair.length;i++){
            result[i] = Integer.parseInt(hexPair[i],16);
        }
        return result;
    }


    private String intArrayToHexString(int[] intArray) {
        StringBuilder sb = new StringBuilder();
        for (int num : intArray) {
            sb.append(String.format("%02x", num));
        }

        return sb.toString();
    }

    private int[] hexToBinaryArray(String hexNumber) {
        int[] binaryArray = new int[hexNumber.length() * 4];
        for (int i = 0; i < hexNumber.length(); i++) {
            char hexChar = hexNumber.charAt(i);
            int decimalValue = Character.digit(hexChar, 16);
            String binaryString = Integer.toBinaryString(decimalValue);
            int padding = 4 - binaryString.length();
            for (int j = 0; j < binaryString.length(); j++) {
                binaryArray[i * 4 + j + padding] = binaryString.charAt(j) - '0';
            }
        }
        return binaryArray;
    }
    private String binaryArrayToHex(int[] binaryArray) {
        StringBuilder hexNumber = new StringBuilder();
        for (int i = 0; i < binaryArray.length; i += 4) {
            int decimalValue = 0;
            for (int j = 0; j < 4; j++) {
                decimalValue = decimalValue * 2 + binaryArray[i + j];
            }
            hexNumber.append(Integer.toHexString(decimalValue));
        }
        return hexNumber.toString();
    }
    private boolean isValid(LargeNumber number){
        return number != null && !number.getHex().equals("") && isHex(number.getHex());
    }
    private boolean isHex(String hexValue){
        return hexValue.matches("[0-9A-Fa-f]+");
    }
}
