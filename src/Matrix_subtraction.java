/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
import java.util.*;
public class Matrix_subtraction {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the no. of rows");
        int rows=s.nextInt();
        System.out.println("enter the no. of columns");
        int columns=s.nextInt();
        int[][] a =new int [rows][columns];
        int [][] b=new int [rows][columns];
        System.out.println("enter the first matrix");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                a[i][j]=s.nextInt();
            }
        }
        System.out.println("enter the second matrix");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                b[i][j]=s.nextInt();
            }
        }
        int [][]c=new int[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                c[i][j]=a[i][j]-b[i][j];
            }
        }
        System.out.println("the subtraction of the two matrices is");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                System.out.println(c[i][j]+"");
            }
            System.out.println();
        }
    }

}
