import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class Biblioteca{

	/**
	* Funcao do tipo boolean que recebe uma string e verifica se a mesma corresponde a sequencia de caracteres 'FIM'.
	* 
	* @param str - string contendo uma linha de entrada
	* @return - retorna uma variavel do tipo boolean (flag) que caso a string for igual a 'FIM' retorna (true) caso nao retorna (false)
	*/

	public static boolean ehFIM(String str){ //função booleana para receber uma string e verificar se a mesma é FIM, caso seja ela retorna true

		boolean flag = false;

		if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')
			flag = true;
		

		return flag;
	}

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

		for(int i = 0; i < 2; i++){

			n = Integer.parseInt(entrada);
			String[] array = new String[n];

			for(int j = 0; j < n; j++){
				entrada = MyIO.readLine();
				array[j] = entrada;
			}

			//========= insertion sort ===============================
			for (int x = 1; x < array.length; x++) {
				String tmp = array[x];
				int y = x - 1;
	
				while ((y >= 0) && (array[y].compareTo(tmp) > 0)) {
					array[y + 1] = array[y];
					y--;
				}
				array[y + 1] = tmp;
			  }
			//========================================================

			for(int k = 0; k < n; k++){
				System.out.println(array[k]);
			}

			if(i == 0) {entrada = MyIO.readLine();}
		}


	}//fim main()
	
}//fim Biblioteca()
