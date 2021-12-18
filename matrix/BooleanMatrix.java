public class BooleanMatrix {
    static void modify(int mat[][]){
        boolean row =  false;
        boolean col =  false;

        for(int i = 0 ; i<mat.length;i++){
            for(int j = 0 ; j<mat[0].length;j++){
                if(i==0 && mat[i][j] ==1)
                    row = true;
                if(j==0 && mat[i][j] ==1)
                   col = true;
                if(mat[i][j] == 1){
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }    
            }
        }
        for(int i = 1;i<mat.length;i++)
            for(int j = 1;j<mat[0].length;j++)
                if(mat[0][j] ==1 || mat[i][0] ==1 )
                    mat[i][j] = 1;
        if(row)
            for(int i=0;i<mat[0].length;i++)
                mat[0][i] = 1;
        if(col)
            for(int i=0;i<mat.length;i++)
                mat[i][0] = 1;
    }
    public static void printMatrix(int mat[][]){
        for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat[0].length; j ++){
                System.out.print( mat[i][j] );
            }
                System.out.println("");
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 1},
        {0, 0, 1, 0},
        {0, 0, 0, 0}};
                
        System.out.println("Input Matrix :");
        printMatrix(mat);
            
        modify(mat);
            
        System.out.println("Matrix After Modification :");
        printMatrix(mat);
    }
}
