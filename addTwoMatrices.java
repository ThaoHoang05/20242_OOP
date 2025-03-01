import java.util.Scanner;
import java.util.Arrays;

public class addTwoMatrices {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap kich co ma tran:");
        int n = keyboard.nextInt();
        int m = keyboard.nextInt(); // Removed (m) from the nextInt() method
        
        int[][] A = new int[n][m];
        int[][] B = new int[n][m];
        
        System.out.println("Nhap thong so ma tran A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = keyboard.nextInt();
            }
            System.out.println();
        }
        
        System.out.println("Nhap thong so ma tran B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = keyboard.nextInt();
            }
            System.out.println();
        }
        
        int[][] C = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        
        System.out.println("Ket qua: A+B = ");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(C[i]));
        }
    }
}
