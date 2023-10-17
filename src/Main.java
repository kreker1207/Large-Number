import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String hex = "97f92a75b3faf8939e8e98b96476fd22";
        LargeNumber numberA = new LargeNumber();
        numberA.setHex(hex);
        System.out.println(numberA.getHex());
        System.out.println(Arrays.toString(numberA.getLargeDecValue()));
        System.out.println(numberA.convertArrayToDecimal());
        Tests tests = new Tests();
        tests.testConvert(hex);
    }
}