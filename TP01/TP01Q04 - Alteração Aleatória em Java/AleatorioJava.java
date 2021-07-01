import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/

public class AleatorioJava{

	/**
	 * Esta funcao recebe uma string e uma variavel random onde atraves dela e gerada dois caracteres aleatorios para que possa ser feito a troca na string durante a funcao
	 * 
	 * @param LetrasAleatoria - funcao do tipo random que atraves sao gerados dois caracteres aleatorios do tipo char
	 * @param str - string contendo uma linha lida
	 * @return retorna a string modificada com alguns caracteres substiduidos
	 */

	public static String Alteracao(Random LetraAleatoria ,String str){

		char OldChar = (char)('a' + (Math.abs(LetraAleatoria.nextInt()) % 26));
		char NewChar = (char)('a' + (Math.abs(LetraAleatoria.nextInt()) % 26));

		str = str.replace(OldChar, NewChar);	
		
		return str;
	}

	/**
	* Funcao do tipo boolean que recebe uma string e verifica se a mesma corresponde a sequencia de caracteres 'FIM'.
	* 
	* @param str - string contendo uma linha de entrada
	* @return - retorna uma variavel do tipo boolean (flag) que caso a string for igual a 'FIM' retorna (true) caso nao retorna (false)
	*/

	public static boolean ehFIM(String str){ 
										
		boolean flag = false;

		if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')
			flag = true;

		return flag;

	}//fim ehFIM()

	/**
	* Funcao main onde eh gerado a funcao random e tambem onde eh lida a string str que sao passadas por referencia para as demais funcoes
	* nela esta contida o laco de repeticao juntamente com a condicao de parada
	*/

	public static void main(String[] args){
			
		Random LetraAleatoria = new Random();
		LetraAleatoria.setSeed(4);

		String str = MyIO.readLine();

	    while(!ehFIM(str)){ 

			System.out.println(Alteracao(LetraAleatoria, str));

			str = MyIO.readLine();

		}//fim while()
		
		
	}//fim main()
	
}//fim palinJava