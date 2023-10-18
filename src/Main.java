public class Main {
    public static void main(String[] args) {
        String hex1 = "32DD2";
        String hex2 = "207cd";

        LargeNumber numberA = new LargeNumber();
        numberA.setHex(hex1);
        LargeNumber numberB = new LargeNumber();
        numberB.setHex(hex2);
        String xorResult = new LargeNumber().XOR(numberA,numberB);
        String orResult = new LargeNumber().OR(numberA,numberB);
        String andResult = new LargeNumber().AND(numberA,numberB);
        System.out.println(xorResult);
        System.out.println("======================");
        System.out.println(orResult);
        System.out.println("======================");
        System.out.println(andResult);
        System.out.println("======================");
        System.out.println(new LargeNumber().INV(numberA));
        System.out.println("======================");
        System.out.println(new LargeNumber().shiftR(numberA,3));
        System.out.println("======================");
        System.out.println(new LargeNumber().shiftL(numberA,1));
        System.out.println("======================");
        System.out.println(new LargeNumber().ADD(numberA,numberB));
        System.out.println("======================");
        System.out.println(new LargeNumber().SUB(numberA,numberB));
        System.out.println("======================");


        Tests tests = new Tests();
    }
}