import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/

public class palinJava{
	

	/**
	 * Essa funcao recebe uma string e faz comparacoes para saber se esta eh ou nao um palindromo.
	 * 
	 * @param str - string contendo uma linha de caracteres a ser testada para palindromo.
	 * @return - retorna uma variavel do tipo boolean (ehPalin) que caso for confirmado que a string eh palindromo recebe (true) caso nao recebe (false).
	 */

	public static boolean palin(String str){

		boolean ehPalin = true;
		
		if(str.length() == 2 ) //primeira verificação caso a string tenha tamanho 2
			if(str.charAt(0) != str.charAt(1))
				ehPalin = false;

		for(int i = 0 ; i < str.length()/2 ;i++){ //segunda verificaçao

			if(str.charAt(i) != str.charAt(str.length()-1-i))
				ehPalin = false;
			

		}//fim for(i)
				
		return ehPalin;

	}//fim palin()

	/**
	 * Funcao do tipo boolean que recebe uma string e verifica se a mesma corresponde a sequencia de caracteres 'FIM'.
	 * 
	 * @param str - string contendo uma linha de entrada
	 * @return - retorna uma variavel do tipo boolean (flag) que caso a string for igual a 'FIM' retorna (true) caso nao retorna (false)
	 */

	public static boolean ehFIM(String str){  //função booleana para receber uma string e verificar se a mesma é FIM, caso seja ela retorna true
										
		boolean flag = false;

		if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
			flag = true;
		}

		return flag;

	}//fim ehFIM()

	/**
	 * Funcao main contendo a leitura da string que e passada por parametro as demais funcoes, tambem onde eh gerada a saida do progama.
	 * 
	 * @param args
	 */

	public static void main(String[] args){
        	
		boolean resp = false;
		String str = MyIO.readLine();

	    while(!ehFIM(str)){ //enquanto a funçao ehFIM for diferente de FIM

			resp = palin(str);

			if(resp == true) System.out.println("SIM");

			else System.out.println("NAO");
				
			str = MyIO.readLine();
				   
		}//fim while()
		
	}//fim main()
	
}//fim palinJava