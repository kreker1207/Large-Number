public class Main {
    public static void main(String[] args) {
        String hex1 = "24dca";
        String hex2 = "512acdc";
        LargeNumber numberA = new LargeNumber();
        numberA.setHex(hex1);
        LargeNumber numberB = new LargeNumber();
        numberB.setHex(hex2);
        String xorResult = new LargeNumber().XOR(numberA,numberB);
        String orResult = new LargeNumber().OR(numberA,numberB);
        System.out.println(xorResult);
        System.out.println(orResult);

        Tests tests = new Tests();
    }
}