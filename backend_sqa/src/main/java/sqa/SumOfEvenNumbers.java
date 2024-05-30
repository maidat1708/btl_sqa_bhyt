/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqa;

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong dãy: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Dãy không có số nào.");
            return;
        }

        int sum = 0;
        System.out.println("Nhập các số trong dãy:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num > 0 && num % 2 == 0) {
                sum += num;
            }
        }

        if (sum > 0) {
            System.out.println("Tổng các số chẵn > 0 trong dãy là: " + sum);
        } else {
            System.out.println("Không có số chẵn > 0 trong dãy.");
        }
    }

    static String calculateSumOfEvenNumbers(int[] arr) {
        if(arr.length == 0) return "Dãy không có số nào.";
        int sum =  0;
        boolean flag = false;
        for(int n: arr){
            if(n > 0 && n%2 == 0){
                sum += n;
                flag = true;
            }
        }
        if(!flag) return "Không có số chẵn > 0 trong dãy.";
        return String.format("Tổng các số chẵn > 0 trong dãy là: %d", sum);
    }
}
