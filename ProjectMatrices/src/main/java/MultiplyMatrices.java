import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.SECONDS;

public class MultiplyMatrices {
    // Class variables
    private short arr_size;
    private int [][] matrix_one;
    private int [][] matrix_two;

    // simple constructor to set size
    public MultiplyMatrices (short arr_size) {
        this.arr_size = arr_size;
        this.matrix_one = new int [arr_size][arr_size];
        this.matrix_two = new int [arr_size][arr_size];
    }

    // encapsulation getters and setters
    public short getSize() {

        return this.arr_size;
    }

    public int [][] getFirst() {

        return matrix_one;
    }

    public int [][] getSecond() {

        return matrix_two;
    }

    public void setFirst(int [][] matrix) {

        this.matrix_one = matrix;
    }

    public void setSecond(int [][] matrix) {

        this.matrix_two = matrix;
    }

    public void fillMatrixes() {
        Random generator_1 = new Random();
        Random generator_2 = new Random();
        short arr_size =  getSize();
       // int [][] tempOne = new int [arr_size][arr_size];
       // int [][] tempTwo = new int [arr_size][arr_size];

        for (int i = 0; i < arr_size; i++) {

            for (int j = 0; j < arr_size; j++) {
                // since both arrays are same size
                matrix_one[i][j] = generator_1.nextInt(100);
                matrix_two[i][j] = generator_2.nextInt(100);
            }
        }
        /* Too slow going this way
        setFirst(tempOne);
        // setSecond(tempTwo);
        // junk unneeded arrays
        tempOne = null;
        tempTwo = null;
        System.gc();
         */
    }

    public void printMatrixes(int[][] matrix, short size) {
        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "] ");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
            }
        System.out.println();
        }

    public void Multiplication(short size, int [][] matrix_one,
                               int [][] matrix_two)
    {
        // temp array for result
        int[][] result = new int[size][size];

        // Standart matrix multiplication (dot product)
        for (int i = 0; i < size; i++) {
            for ( int j = 0; j < size; j++) {
                for (int t = 0; t < size; t++)
                    result[i][j] += matrix_one[i][t] * matrix_two[t][j];
            }
        }
        System.out.println("The result is ");
        printMatrixes(result, size);
    }

    public static void main(String[] args)
    {
        Scanner size = new Scanner(System.in);
        short arr_size = 0;
        System.out.println("Enter size of matrices");
        try {
            arr_size = size.nextShort();
        }

         catch (java.util.InputMismatchException e) {
            main(null);
    }
        // Matrixes size between 1..10000.
        if (arr_size > 10000 || arr_size < 1 )
        {
            System.out.println("Please enter number smaller than 10001 " +
                    "and bigger than 0");
            main(null);
        }
        size.close();
        // task requires to print execution time
        long startTime = Instant.now().toEpochMilli();

        // Class's MultiplyMatrices object multiplication
        MultiplyMatrices multiplication = new MultiplyMatrices(arr_size);
        multiplication.fillMatrixes();
        System.out.println("Matrix One");
        multiplication.printMatrixes(multiplication.getFirst(), arr_size);
        System.out.println("Matrix Two");
        multiplication.printMatrixes(multiplication.getSecond(),
                arr_size);
        multiplication.Multiplication(arr_size, multiplication.getFirst(),
                multiplication.getSecond());

        long endTime = Instant.now().toEpochMilli();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " Miliseconds");
    }
}
