package ra.util;

import java.util.Iterator;
import java.util.Scanner;

public class Input {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String nextLine (String mess) {
        System.out.print(mess + " > ");
        return SCANNER.nextLine();
    }

    public static boolean nextBoolean (String mess) {
        System.out.print(mess + " > ");
        return Boolean.parseBoolean(SCANNER.nextLine());
    }

    public static int nextInt (String mess) {
        while (true) {
            try {
                System.out.print(mess + " > ");
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("type input error");
            }
        }
    }

    public static byte nextByte (String mess) {
        while (true) {
            try {
                System.out.print(mess + " > ");
                return Byte.parseByte(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("type input error");
            }
        }
    }

    public static float nextFloat (String mess) {
        while (true) {
            try {
                System.out.print(mess + " > ");
                return Float.parseFloat(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("type input error");
            }
        }
    }



}
