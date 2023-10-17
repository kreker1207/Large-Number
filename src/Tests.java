import java.math.BigInteger;

public class Tests {
    public void testConvert(String hex) {
        LargeNumber largeNumber = new LargeNumber();
        largeNumber.setHex(hex);
        BigInteger bigInteger = new BigInteger(hex,16);
        long testedDecimal = largeNumber.convertArrayToDecimal();
        if(String.valueOf(testedDecimal).equals(String.valueOf(bigInteger))){
            System.out.println("testConvert passed");
        }else System.out.println("Expected result: "+ bigInteger + "  Actual: " + testedDecimal);
    }
}
