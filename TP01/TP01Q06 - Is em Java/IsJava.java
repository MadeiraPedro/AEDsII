import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/

public class IsJava {

	/**
	 * Funcao que recebe uma string e compara caracter por caracter para saber se sao vogais
	 * 
	 * @param i - variavel que eh usada como posicao na string para ir "adando" caracter por caracter
	 * @param str - string contendo uma sequencia de letras
	 * @return - retorna true caso o caracter for vogal
	 */

	public static boolean Vogal(int i, String str){

		boolean SoVogal = false;

		if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
			SoVogal = true;
		
		return SoVogal;
	}

	/**
	 * Funçao que recebe uma string de letras faz a checagem juntamente com a funçao Vogal() para saber se o conteudo é apenas vogal
	 * 
	 * @param str - string contendo uma sequencia de letras
	 * @return - retorna true caso toda a string for vogal
	 */

	public static boolean IsVogal(String str){
		boolean isVogal = false;
		int cont = 0;

		for(int i = 0; i < str.length(); i++){
			if (Vogal(i, str) == true) cont++;  //enviando a posiçao de (i) juntamente com a string e a cada vez que o caracter for vogal soma um no contador
		}

		if(cont == str.length()) isVogal = true; //se a quantidade do contador for igual ao tamanho da string quer dizer que toda a string é VOGAL

		return isVogal;

	}//fim IsVogal()

	/**
	 * Funçao que recebe uma string e compara se o seu conteudo NAO contem nenhuma vogal.
	 * 
	 * @param str - string contendo uma sequencia de letras
	 * @return - retorna true caso a string comparada nao tiver nenhuma vogal
	 */

	public static boolean IsConsoante(String str){ 

		boolean isConsoante = false;
		int cont = 0;

		for(int i = 0; i < str.length(); i++){
			if (Vogal(i, str) == false) cont++; //enviando a posiçao de (i) juntamente com a string e a cada vez que o caracter NAO for vogal soma um no contador
		}

		if(cont == str.length()) //se a quantidade do contador for igual ao tamanho da string quer dizer que toda a string é CONSOANTE
			isConsoante = true;

		return isConsoante;

	}//fim IsConsoante()

	/**
	 * Recebe uma string e compara se seu conteudo contem apenas numeros
	 * 
	 * @param str - string contendo uma sequencia de numeros ou ('.' | ',' )
	 * @return - retorna true caso o conteudo da string contenha apenas numeros
	 */

	public static boolean IsInteiro(String str){ 
		boolean ehInteiro = false;
		int cont = 0;

		for(int i = 0; i < str.length(); i++){

			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') //checando as posiçoes da string a procura de numeros
				cont ++; //se achar um numero inteiro soma +1 no contador

		}//fim for (i)

		if (cont == str.length()) ehInteiro = true; //se a quantidade do contador for igual ao tamanho da string quer dizer que toda a string é CONSOANTE

		return ehInteiro;


	}//fim IsInteiro()

	/**
	 * Recebe uma string de numeros ou ('.' | ',') e testa se a mesma nao eh inteira
	 * 
	 * @param str - string contendo uma sequencia de numeros ou ('.' | ',')
	 * @return - retorna true caso o conteudo da string contenha apenas numeros e um '.' ou ',' .
	 */

	public static boolean IsReal(String str){

		boolean ehReal = false;

		if(IsInteiro(str) == false) ehReal = true;

		return ehReal;

	}//fim IsReal()
	
	/**
	 * Funcao criada para filtrar e direcionar cada string para que possa ser feito os testes
	 * 
	 * @param str - string contendo uma sequencia de caracteres ou numeros
	 */

	public static void ValidarLinha(String str){

		int letra = 0, num = 0, v_p = 0;

		for(int i = 0; i < str.length(); i++){
			
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				letra++;
			else if (str.charAt(i) >= '0' && str.charAt(i) <= '9' || str.charAt(i) == '.' || str.charAt(i) == ','){
				num++;
				if (str.charAt(i) == '.' || str.charAt(i) == ',') v_p++;
			}
		}

		if (v_p > 1) num = 0; //anular caso tiver mais de uma virgula ou ponto

		if (letra == str.length()){

			str = str.toLowerCase(); //trasformando a string toda em minuscula para facilitar os testes

			if (IsVogal(str) == true) System.out.println("SIM NAO NAO NAO");
			
			else if (IsConsoante(str) == true) System.out.println("NAO SIM NAO NAO");

			else System.out.println("NAO NAO NAO NAO");
			
		}
		else if (num == str.length()){
			
			if(IsInteiro(str) == true) System.out.println("NAO NAO SIM SIM");

			else if (IsReal(str) == true) System.out.println("NAO NAO NAO SIM");

			else System.out.println("NAO NAO NAO NAO");

		}
		else 
			System.out.println("NAO NAO NAO NAO");

	}

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
	 * Funcao main onde e lido a string e passada por parametro as demais
	 * contem um laco de repeticao onde o mesmo ira parar quando detectar a palavra 'FIM'
	 * 
	 */

	public static void main (String[] args){
	
		String str = MyIO.readLine();

		while(!ehFIM(str)){ 

			ValidarLinha(str);

			str = MyIO.readLine();
		}

	}//fim main()
}
