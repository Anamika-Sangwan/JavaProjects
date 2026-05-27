package FindingPi;

import java.util.*;
import java.lang.*;

class FindingPi {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the decimal place:- ");
        int n = s.nextInt();
        System.out.println("Pi upto " + n + "decimal places is:- ");
        System.out.printf("%." + n + "f", Math.PI);
    }
}