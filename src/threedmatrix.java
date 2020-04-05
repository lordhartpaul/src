/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
public class threedmatrix {
public static void main(String args[])
{
        int threed[][][]=new int[3][3][2];
    int i,j,k;
    for(i=0;i<3;i++)
        for(j=0;j<3;j++)
            for(k=0;k<2;k++)
                threed[i][j][k]=(i-j)-k;
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            for(k=0;k<2;k++)
            
                System.out.print(threed[i][j][k]+"");
            
            System.out.println();
        }
        System.out.println();
    }
}
}
