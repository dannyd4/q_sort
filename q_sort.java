import java.util.Arrays;
import java.util.Scanner;

public class q_sort {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Input number of array items: ");
        int n = iScanner.nextInt();
        iScanner.close();

        int[] array0 = array_creator_int(n);
        System.out.println("Array in:  " + Arrays.toString(array0));

        qu_sort(array0, 0, array0.length - 1);
        System.out.println("Array out: " + array_to_String(array0));
    }

    public static int[] array_creator_int(int n) {
        int[] myArray = new int[n];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 101) - 50;
        }
        return myArray;
    }

    public static void qu_sort(int[] arr, int from, int to) {
        if (from < to) {
            int divide_index = partition(arr, from, to);
            
            qu_sort(arr, from, divide_index - 1);
            qu_sort(arr, divide_index, to);
        }
        
    }

    public static int partition(int[] arr, int from, int to) {
        int li = from;
        int ri = to;

        int pivot = arr[from];
        while (li <= ri) {
            while (arr[li] < pivot) {
                li++;

            }
            while (arr[ri] > pivot) {
                ri--;
            }
            if (li <= ri) {
                swap(arr, ri, li);
                li++;
                ri--;

            }
        }
        return li;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static String array_to_String(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);

        }
        sb.append("]");
        return sb.toString();
    }
}
