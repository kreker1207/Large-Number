public class Tests {
    public static void testOperation(String testName, String hex1, String hex2,String[] results) {
        LargeNumber numberA = new LargeNumber();
        numberA.setHex(hex1);
        LargeNumber numberB = new LargeNumber();
        numberB.setHex(hex2);
        LargeNumber tester = new LargeNumber();

        System.out.println("===== " + testName + " =====");
        System.out.println("numberA: "+numberA.getHex());
        System.out.println("numberB: "+numberB.getHex());

        System.out.println("=====");
        // Test XOR
        String xorResult = tester.XOR(numberA,numberB);
        ////using this because there are some not trim values could appear;
        String res1 = xorResult.contains(results[0]) ?" Correct!!":" Wrong!!";
        System.out.println("XOR: " + xorResult + res1);

        // Test OR
        String orResult = tester.OR(numberA,numberB);
        String res2 = orResult.contains(results[1]) ?" Correct!!":" Wrong!!";
        System.out.println("OR: " + orResult+ res2);

        // Test AND
        String andResult = tester.AND(numberA,numberB);
        String res3 = andResult.contains(results[2]) ?" Correct!!":" Wrong!!";
        System.out.println("AND: " + andResult+res3);

        // Test NOT (INV)
        String invResult = tester.INV(numberA);
        String res4 = invResult.contains(results[3]) ?" Correct!!":" Wrong!!";
        System.out.println("INV: " + invResult+res4);

        // Test Shift Right
        String shiftRightResult = tester.shiftR(numberA, 3);
        String res5 = shiftRightResult.contains(results[4]) ?" Correct!!":" Wrong!!";
        System.out.println("Shift Right: " + shiftRightResult + res5);

        // Test Shift Left
        String shiftLeftResult = tester.shiftL(numberA, 2);
        String res6 = shiftLeftResult.contains(results[5]) ?" Correct!!":" Wrong!!";
        System.out.println("Shift Left: " + shiftLeftResult+ res6);

        // Test ADD
        String addResult = tester.ADD(numberA, numberB);
        String res7 = addResult.contains(results[6]) ?" Correct!!":" Wrong!!";
        System.out.println("ADD: " + addResult+ res7);

        // Test SUB
        String subResult = tester.SUB(numberA, numberB);
        String res8 = subResult.contains(results[7]) ?" Correct!!":" Wrong!!";
        System.out.println("SUB: " + subResult+ res8);

        // Test MOD
        String modResult = tester.MOD(numberA,numberB);
        String res9 = modResult.contains(results[8]) ?" Correct!!":" Wrong!!";
        System.out.println("MOD: " + modResult+res9);

        System.out.println("======================\n");
    }

}
