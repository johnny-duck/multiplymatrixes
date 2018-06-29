import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matA = new int[n][n];
        int[][] matB = new int[n][n];
        //populate
        populateMatrix(matA);
        populateMatrix(matB);
        //multiplication
        printMatrix(matA);
        System.out.println(" * ");
        printMatrix(matB);
        System.out.println(" = ");
        printMatrix(multiplyTwoMatrixes(matA, matB));
        //printMatrix(multiplyTwoMatrixesOptim(matA, matB));


    }

    public static void populateMatrix(int[][] matrix) {
        //for each line
        for (int linie = 0; linie < matrix.length; linie++) {
            //for each column
            for (int coloana = 0; coloana < matrix[linie].length; coloana++) {
                matrix[linie][coloana] = (int) (Math.random() * 3);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int linie = 0; linie < matrix.length; linie++) {
            for (int coloana = 0; coloana < matrix[linie].length; coloana++) {
                System.out.print(matrix[linie][coloana] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyTwoMatrixes(int[][] matA, int[][] matB) {
        //both params have the same length
        int[][] sum = new int[matA.length][matA.length];
        int element = 0;
        for (int linie = 0; linie < matA.length; linie++) {
            for (int coloana = 0; coloana < matA[linie].length; coloana++) {
                for (int i = 0; i < matA.length; i++) {
                    element += matA[linie][i] * matB[i][coloana];
                }
                sum[linie][coloana] = element;
                element = 0;
            }
        }
        return sum;
    }
//not finished
    public static int[][] multiplyTwoMatrixesOptim(int[][] matA, int[][] matB) {
        //both params have the same length
        int[][] sum = new int[matA.length][matA.length];
        int element = 0;
        for (int i = 0; i < matA.length; i++) {
            for (int linie = 0; linie < matA.length; linie++) {
                for (int coloana = 0; coloana < matA[linie].length; coloana++) {

                    element += matA[linie][i] * matB[i][coloana];
                    sum[linie][coloana] = element;
                }
                element = 0;
            }

        }
        return sum;
    }
}
