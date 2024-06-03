/* 
 * Write a program that finds the most optimized set of 6 units to shop with for values
fewer than 100. Example: Units used are 1, 2, 5, 10, 20, 50 1: 1 (1 unit used) 2: 2 (1
unit used) 3: 1+2 (2 units used) 4: 2+2 (2 units used) ... 98: 1+2+5+20+20+50 (6 units
used) 99: 2+2+5+20+20+50 (6 units used) AVG of units = 3.4
 */
import java.util.*;
import java.util.Arrays;

public class AvgOfUnits {
 
    public static void main(String[] args) {
        int[] units = {1, 2, 5, 10, 20, 50};
        int maxValue = 100;
 
        double averageUnits = calculateAvgUnits(units, maxValue);
        System.out.printf("Average number of units used: %.2f\n", averageUnits);
    }
 
    public static double calculateAvgUnits(int[] units, int maxValue) {
        int count = 0;
        int totalUnits = 0;
        Arrays.sort(units);
        reverse(units);
 
        for (int i = 1; i < maxValue; i++) {
            int remainingValue = i;
            int numUnits = 0;
 
            for (int unit : units) {
                while (remainingValue >= unit && numUnits < 6) {
                    remainingValue -= unit;
                    numUnits++;
                }
            }
 
            if (remainingValue == 0 && numUnits <= 6) {
                count++;
                totalUnits += numUnits;
            }
        }
 
        return count == 0 ? 0 : (double) totalUnits / count;
    }
 
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}