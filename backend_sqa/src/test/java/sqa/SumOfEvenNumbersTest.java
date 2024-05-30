/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqa;

/**
 *
 * @author Admin
 */
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class SumOfEvenNumbersTest {
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        assertEquals("Dãy không có số nào.", SumOfEvenNumbers.calculateSumOfEvenNumbers(arr));
    }

    @Test
    public void testNoEvenNumberGreaterThanZero() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals("Không có số chẵn > 0 trong dãy.", SumOfEvenNumbers.calculateSumOfEvenNumbers(arr));
    }

    @Test
    public void testEvenNumbersGreaterThanZero() {
        int[] arr = {2, 4, 6, 8, 10};
        assertEquals("Tổng các số chẵn > 0 trong dãy là: 30", SumOfEvenNumbers.calculateSumOfEvenNumbers(arr));
    }

    @Test
    public void testEvenNumbersIncludingZero() {
        int[] arr = {-2, 1, 4, 3, 6};
        assertEquals("Tổng các số chẵn > 0 trong dãy là: 10", SumOfEvenNumbers.calculateSumOfEvenNumbers(arr));
    }
}
