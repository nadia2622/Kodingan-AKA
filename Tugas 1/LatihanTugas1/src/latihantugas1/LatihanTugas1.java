/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihantugas1;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class LatihanTugas1 {

    /**
     * @param args the command line arguments
     */
        // Sequential Search
    public static int sequentialSearch(int[] A, int n, int x) {
        int position = 1;
        while (position <= n && A[position - 1] != x) {
            position++;
        }
        if (position > n) {
            position = 0;
        }
        return position;
    }

    // Binary Search
    public static int binarySearch(int[] A, int n, int x) {
        int low = 1, high = n, position = 0;
        while (low <= high && position == 0) {
            int mid = (low + high) / 2;
            if (x == A[mid - 1]) {
                position = mid;
            } else if (x < A[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] sizes = {32, 1024, 32768};
        Random rand = new Random();

        System.out.printf("%-10s %-20s %-20s%n", "n", "Sequential Time (ns)", "Binary Time (ns)");
        System.out.println("-------------------------------------------------------------");

        for (int n : sizes) {
            int[] data = new int[n];

            // generate angka random
            for (int i = 0; i < n; i++) {
                data[i] = rand.nextInt(n * 10); // angka acak
            }

            // angka yang dicari (bisa random juga)
            int x = data[rand.nextInt(n)];

            // Sequential Search timing
            long startSeq = System.nanoTime();
            sequentialSearch(data, n, x);
            long endSeq = System.nanoTime();
            long timeSeq = endSeq - startSeq;

            // Binary Search butuh array terurut
            Arrays.sort(data);
            long startBin = System.nanoTime();
            binarySearch(data, n, x);
            long endBin = System.nanoTime();
            long timeBin = endBin - startBin;

            // cetak hasil
            System.out.printf("%-10d %-20d %-20d%n", n, timeSeq, timeBin);
        }
    }
}
