#include <stdio.h>     // para entradas e saida
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes

/**
* @author Pedro Madeira - 655678
*/

	/**
	* Funcao que recebe um vetor de caracteress e compara um a um para saber se eh vogai
	* 
	* @param i - variavel que eh usada como posicao no vetor para ir "adando" caracter por caracter
	* @param str - vetor de caracteress contendo uma sequencia de letras
	* @return - retorna true caso o caracter for vogal
	*/

	bool Vogal(int i, char str[]){

		bool SoVogal = false;

		if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u')
			SoVogal = true;
		
		return SoVogal;
	}

	/**
	* Funçao que recebe um vetor de caracteress de letras, faz a checagem juntamente com a funçao Vogal() para saber se o conteudo é apenas vogal
	* 
	* @param str - vetor de caracteress contendo uma sequencia de letras
	* @return - retorna true caso todo o vetor de caracteress for vogal
	*/

	bool IsVogal(char str[]){

		bool isVogal = false;
		int cont = 0;

		for(int i = 0; i < strlen(str); i++){
			if (Vogal(i, str) == true) cont++;
		}

		if(cont == strlen(str)) isVogal = true;

		return isVogal;

	}//fim IsVogal()

	/**
	* Funçao que recebe um vetor de caracteress e compara se o seu conteudo NAO contem nenhuma vogal.
	* 
	* @param str - vetor de caracteress contendo uma sequencia de letras
	* @return - retorna true caso o vetor de caracteress comparada nao tiver nenhuma vogal
	*/

	bool IsConsoante(char str[]){

		bool isConsoante = false;
		int cont = 0;

		for(int i = 0; i < strlen(str); i++){
			if (Vogal(i, str) == false) cont++;
		}

		if(cont == strlen(str))
			isConsoante = true;

		return isConsoante;

	}//fim IsConsoante()

	/**
	* Recebe um vetor de caracteres e compara se seu conteudo contem apenas numeros
	* 
	* @param str - vetor de caracteres contendo uma sequencia de numeros ou ('.' | ',' )
	* @return - retorna true caso o conteudo do vetor de caracteres contenha apenas numeros
	*/

	bool IsInteiro(char str[]){
		bool ehInteiro = false;
		int count = 0;

		for(int i = 0; i < strlen(str); i++){

			if(str[i] >= '0' && str[i] <= '9')
				count ++;

		}//fim for (i)

		if (count == strlen(str)) ehInteiro = true;

		return ehInteiro;


	}//fim IsInteiro()

	/**
	* Recebe um vetor de caracteres de numeros ou ('.' | ',') e testa se a mesma nao eh inteira
	* 
	* @param str - vetor de caracteres contendo uma sequencia de numeros ou ('.' | ',')
	* @return - retorna true caso o conteudo do vetor de caracteres contenha apenas numeros e um '.' ou ',' .
	*/

	bool IsReal(char str[]){

		bool ehReal = false;

		if(IsInteiro(str) == false) ehReal = true;

		return ehReal;

	}//fim IsReal()
	
	/**
	* Funcao criada para filtrar e direcionar cada vetor de caracteres para que possa ser feito os testes
	* 
	* @param str - vetor de caracteres contendo uma sequencia de caracteres ou numeros
	*/

	void ValidarLinha(char str[]){

		int letra = 0, num = 0, v_p = 0;

		for(int i = 0; i < strlen(str); i++){
			
			if(str[i] >= 'a' && str[i] <= 'z' || str[i] >= 'A' && str[i] <= 'Z')
				letra++;
			else if (str[i] >= '0' && str[i] <= '9' || str[i] == '.' || str[i] == ','){
				num++;
				if (str[i] == '.' || str[i] == ',') v_p++;
			}
		}

		if (v_p > 1) num = 0; //anular caso tiver mais de uma virgula ou ponto

		if (letra == strlen(str)){

            for(int i = 0; i < '\0'; i++){
			    str[i] = tolower(str[i]);
            }

			if (IsVogal(str) == true) printf("SIM NAO NAO NAO\n");
			
			else if (IsConsoante(str) == true) printf("NAO SIM NAO NAO\n");

			else printf("NAO NAO NAO NAO\n");
			
		}
		else if (num == strlen(str)){
			
			if(IsInteiro(str) == true) printf("NAO NAO SIM SIM\n");

			else if (IsReal(str) == true) printf("NAO NAO NAO SIM\n");

			else printf("NAO NAO NAO NAO\n");

		}
		else 
			printf("NAO NAO NAO NAO\n");

	}

	/**
	* Funcao do tipo boolean que recebe um vetor de caracteres e verifica se a mesma corresponde a sequencia de caracteres 'FIM'.
	* 
	* @param palavra - vetor de caracteres que contem uma linha lida
	* @return - retorna uma variavel do tipo boolean (flag) que caso o vetor de caracteres for igual a 'FIM' retorna (true) caso nao retorna (false)
	*/

	bool ehFIM (char palavra[]){

    bool flag = false;

    if(strlen(palavra) == 3 && palavra[0] == 'F' && palavra[1] =='I' && palavra[2] == 'M')
        flag = true;

    return flag;

    }//fim ehFIM

	/**
	* Funcao main onde e lido o vetor de caracteres e passado por parametro as demais.
	* contem um laco de repeticao onde o mesmo ira parar quando detectar a palavra 'FIM'.
	* 
	*/

	int main (void){
	
		char str[1024];
        scanf(" %[^\n]s", str); //scanf "adaptado" para ler uma linha inteira

		while(!ehFIM(str)){

			ValidarLinha(str);

			scanf(" %[^\n]s", str);
		}

	}//fim main()
