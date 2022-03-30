package qa.quru;

public class TestClass {


    private static double firstGlobalDouble = 5.54D;
    private static double secondGlobalDouble = 1012.5423D;

    public static void main(String[] args) {

        byte firstPositiveByte = 120;           // 8 bit -128 ... 127
        byte secondPositiveByte = 127;
        byte negativeByte = -128;
        short pShort = 32767;       // 16 bit -32768 ... 32767


        int pInt = 2_147_483_647;  // 32 bit -2 ^ 31 ... (2 ^ 31) -1
        long pLong = 1_000_000_000_000L; // 64 bit -2 ^ 63 ... (2 ^ 63) -1


        firstPositiveByte += 8; //overflow to negative
        secondPositiveByte += 265; // overflow twice to negative
        negativeByte -= 3; // overflow to positive

        System.out.println(firstPositiveByte);
        System.out.println(secondPositiveByte);
        System.out.println(negativeByte);

        pShort = (short) (pShort + 10); //overflow to negative
        System.out.println(pShort);

        pInt = (int) (pInt + 2);  //overflow to negative
        System.out.println(pInt);
        pInt = (int) (pInt + pLong); //multi times overflow
        System.out.println(pInt);

        System.out.println(getNode(140, 96));
        System.out.println(getNode(125, 50));

        System.out.println(isGreaterThanAll(132423.22343F));
        System.out.println(isGreaterThanAll(10.23F));
        System.out.println(!isGreaterThanAll(1.23F));

        System.out.println(isGreaterThanAny(10.23F));
        System.out.println(isGreaterThanAny(1.23F));
    }


    public static boolean isGreaterThanAll(float f) {
        return f > firstGlobalDouble && f > secondGlobalDouble;
    }

    public static boolean isGreaterThanAny(float f) {
        return f > firstGlobalDouble || f > secondGlobalDouble;
    }

    public static int getNode(int a, int b) { //euclid algorithm
        int nod = 0;
        if (a >= b) nod = b;
        else {
            nod = a;
        }

        while (a % b != 0) {
            if (a > b) {
                a = a % b;
                if (a == 0) {
                    nod = b;
                    break;
                }

            } else {
                b = b % a;
                if (b == 0) {
                    nod = a;
                    break;
                }
            }
        }
        return nod;
    }
}
