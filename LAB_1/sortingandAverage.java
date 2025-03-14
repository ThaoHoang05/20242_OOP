import java.util.Scanner;
import java.util.Arrays;

public class sortingandAverage {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = keyboard.nextInt();
        }
        Arrays.sort(arr);
        double sum = 0.0;
        for (int i = 0; i < n; i++) sum += arr[i];
        double avg = sum/n;
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }
}