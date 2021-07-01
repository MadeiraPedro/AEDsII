import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class Bingo{


    public static void main(String[] args){

		int n = MyIO.readInt(), k = MyIO.readInt(), u = MyIO.readInt();
		int[][] cartela = new int[n][k];
		int[] count_cartela = new int[n];

		for(int i = 0; i < n; i++){ //preenchendo array com 0.
			count_cartela[i] = 0;
		}

		for(int i = 0; i < n; i++){
			for(int j = 0; j < k; j++){
				cartela[i][j] = MyIO.readInt();
			}
		}

		for(int x = 0; x < u; x++){

			int numero = MyIO.readInt();

			for(int i = 0; i < n; i++){
				for(int j = 0; j < k; j++){
					if(cartela[i][j] == numero)
						count_cartela[i]++;
				}
			}

			for(int y = 0; y < n; y++){
				if(count_cartela[y] == k){
					System.out.print((y+1) + " ");
					x = u;
				}
			}

		}//fim for(x)
		
	}//fim main()
	
}//fim Bingo()
