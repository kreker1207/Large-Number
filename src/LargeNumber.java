import java.util.Arrays;
import java.util.function.IntBinaryOperator;

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
        return performBitwiseOperation(numberA,numberB,(a,b)->a ^ b);
    }
    public String OR(LargeNumber numberA, LargeNumber numberB){
        return performBitwiseOperation(numberA, numberB, (a, b) -> a | b);
    }

    public String AND(LargeNumber numberA, LargeNumber numberB){
        return performBitwiseOperation(numberA,numberB,(a,b)-> a & b);
    }
    public String INV(LargeNumber numberA){
        if(!isValid(numberA)){
            throw new IllegalArgumentException("Your number is not valid");
        }
        int[] numberBinary = numberA.getHexInBinary();
        int[] result = new int[numberBinary.length];
        for(int i= 0; i< result.length;i++){
            result[i] = (numberBinary[i]==0)?1:0;
        }
        return binaryArrayToHex(result);
    }
    public String shiftR(LargeNumber numberA, int n){
        if(!isValid(numberA)){
            throw new IllegalArgumentException("Your number is not valid");
        }
        if(n<0){throw new IllegalArgumentException("You can not shift to negative number of bits");}

        int[] shiftNumber = numberA.getHexInBinary();
        int zeroesBeforeOne = 0;
        for(;zeroesBeforeOne < shiftNumber.length; zeroesBeforeOne++){
            if(shiftNumber[zeroesBeforeOne] > 0) {
                break;
            }
        }
        if(shiftNumber.length - n - zeroesBeforeOne <= 0){
            return "0";
        }
        int[] result = new int[shiftNumber.length -n - zeroesBeforeOne];
        System.arraycopy(shiftNumber,zeroesBeforeOne,result,0,result.length);
        System.out.println(Arrays.toString(result));
        return binaryArrayToHex(result);
    }
    public String shiftL(LargeNumber numberA,int n){
        if(!isValid(numberA)){
            throw new IllegalArgumentException("Your number is not valid");
        }
        if(n<0){throw new IllegalArgumentException("You can not shift to negative number of bits");}

        int[] shiftNumber = numberA.getHexInBinary();
        System.out.println(Arrays.toString(shiftNumber));
        int zeroesBeforeOne = 0;
        for(;zeroesBeforeOne < shiftNumber.length; zeroesBeforeOne++){
            if(shiftNumber[zeroesBeforeOne] > 0) {
                break;
            }
        }
        int[] trimArray = new int[shiftNumber.length-zeroesBeforeOne];
        System.arraycopy(shiftNumber,zeroesBeforeOne,trimArray,0,shiftNumber.length-zeroesBeforeOne);
        System.out.println(Arrays.toString(trimArray));
        int newLength = trimArray.length + n;
        if(newLength <= 0){
            return "0";
        }
        int[] result = new int[newLength];
        for(int i = newLength-n;i<newLength;i++){
            Arrays.fill(result,i,newLength,0);
        }
        System.arraycopy(trimArray,0,result,0,result.length-1);
        System.out.println(Arrays.toString(result));
        return binaryArrayToHex(result);
    }
    public int[] getLargeValue(){
        return this.largeValue;
    }

    private String performBitwiseOperation(LargeNumber numberA, LargeNumber numberB, IntBinaryOperator operation) {
        if (!isValid(numberA) || !isValid(numberB)) {
            throw new IllegalArgumentException("Your number is not valid");
        }

        int[] numberArrayA = numberA.getHexInBinary();
        int[] numberArrayB = numberB.getHexInBinary();
        int[] result = applyBinaryOperation(numberArrayA, numberArrayB, operation);
        return binaryArrayToHex(result);
    }
    private int[] applyBinaryOperation(int[] arrayA, int[] arrayB, IntBinaryOperator operation) {
        int length = Math.max(arrayA.length, arrayB.length);
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int a = (i < arrayA.length) ? arrayA[i] : 0;
            int b = (i < arrayB.length) ? arrayB[i] : 0;
            result[i] = operation.applyAsInt(a, b);
        }

        return result;
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
            for (int j = 0; j < 4 && i+j<binaryArray.length; j++) {
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
