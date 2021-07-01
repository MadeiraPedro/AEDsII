import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/

public class CiframentoCesar2 {

	static int KEY = 3; //variavel global usada para determinar a quantidade de casas que cada caracter ira andar.

	/**
	 * Essa funcao recebe uma string e salva em outra de forma criptografada onde eh incrementado 3 casas a frente de cada caracter contido na string
	 * 
	 * @param str string contendo uma linha de entrada
	 * @return retorna uma nova string ja criptografada.
	 */

	public static String cifra (String str){
		
		String cifrado = "";

		for(int i = 0; i < str.length(); i++){
			char str_cifra = (char)(( str.charAt(i)) + KEY); //pegando caracteres separados da string e adicinando 3 casas a frente
			cifrado += str_cifra; //salvando os caracteres criptografados em uma nova string
		}//fim for(i)

		return cifrado;

	}

	 /**
	  * Funcao do tipo boolean que recebe uma string e verifica se a mesma corresponde a sequencia de caracteres 'FIM'.
	  * @param str - string contendo uma linha de entrada
	  * @return - retorna uma variavel do tipo boolean (flag) que caso a string for igual a 'FIM' retorna (true) caso nao retorna (false)
	  */

	public static boolean ehFIM(String str){ 
		boolean flag = false;

		if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
			flag = true;
		}

		return flag;

	}


	/**
	* Funcao main contendo a leitura da string que e passada por parametro as demais funcoes.
	*/

	public static void main (String[] args){

		MyIO.setCharset("ISO-8859-1");
	
		String str = MyIO.readLine();

		while(!ehFIM(str)){ 
			
			MyIO.println(cifra(str));

			str = MyIO.readLine();

		}//fim while()
	}
}
