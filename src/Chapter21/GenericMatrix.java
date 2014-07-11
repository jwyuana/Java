package Chapter21;

public abstract class GenericMatrix<E extends Number> {
	
	protected abstract E add(E o1, E o2);
	protected abstract E multiply(E o1, E o2);
	protected abstract E zero();
	
	public E[][] addMatrix(E[][] matrix1, E[][] matrix2){
		if((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length))
			throw new RuntimeException("do not have the same size");
		
		E[][] rst = (E[][]) new Number[matrix1.length][matrix1[0].length];
		
		for(int i = 0; i < rst.length; i++)
			for(int j = 0; j < rst[i].length; j++)
				rst[i][j] = add(matrix1[i][j], matrix2[i][j]);
		
		return rst;
	}
	
	public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2){
		if(matrix1[0].length != matrix2.length)
			throw new RuntimeException("do not have the same size");
		
		E[][] rst = (E[][]) new Number[matrix1.length][matrix2[0].length];
		
		for(int i = 0; i < rst.length; i++)
			for(int j = 0; j < rst[0].length; j++){
				rst[i][j] = zero();
				for(int k = 0; k < matrix1[0].length; k++)
					rst[i][j] = add(rst[i][j], multiply(matrix1[i][k], matrix2[k][j]));
			}
		
		return rst;
	}
	
	public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op){
		
	}

}
