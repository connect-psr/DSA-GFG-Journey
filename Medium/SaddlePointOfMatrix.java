import java.util.*;

public class SaddlePointOfMatrix{
    public static void getSaddlePoint(int mat[][]){
        if(mat == null || mat.length <= 0){
            System.out.println("Matrix is invalid..");
            return;
        }

        for(int i = 0; i < mat.length; ++i){
            int min = mat[i][0];
            int col = 0, row = 0;
            for(int j = 0; j < mat[0].length; ++j){
                if(mat[i][j] <= min){
                    min = mat[i][j];
                    col = j;
                    row = i;
                }
            }
            int counter = 0;
            for(int k = 0; k < mat[0].length; ++k){
                if(row != k && mat[k][col] < min){
                    counter++;
                }
            }

            if(counter == mat[0].length-1){
                System.out.println("Saddle Point :- "+mat[row][col]);
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the M x N Matrix size: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("Enter "+m+" by "+n+" matrix array:");
        int mat[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; ++j){
                mat[i][j] = sc.nextInt();
            }
        }

        SaddlePointOfMatrix.getSaddlePoint(mat);
    }
}