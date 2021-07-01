import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class Solitario{


	/**
	 * Fucao main() contendo a leitura do arquivo linha a linha juntamente com a separaçao dos modulos aderindo ao respectivo objeto Musica
	 * logo apos e feito a leitura da entrada padrao, onde e feito uma pesquisa sequencial ultilizando o atributo ID como chave. 
	 * 
	 * @param args
	 * @throws IOException para tratamento de execoes
	 */

    public static void main(String[] args) throws IOException {

		String entrada = MyIO.readLine();
		int n = 0;

		while(entrada.charAt(0) != '0'){

			n = Integer.parseInt(entrada);
			int[] array = new int[n];
			int count = 0, aux = 0;

			for(int x  = 0; x < n; x++){array[x] = MyIO.readInt();}

			for(int i = 0; i < n; i++){
				aux = array[i];
				count = 0;

				for(int j = 0; j < n; j++){
					if(count < 3){
						if(aux == array[j]) {count++;}
					}
					else{ j = n;}

				} //fim for(j)

				if(count == 1 || count == 3){
					System.out.println(array[i]);
					i = n;
				}

			}//fim for(i)

			entrada = MyIO.readLine();

		}//fim while()

	}//fim main()
	
}//fim Solitario()
