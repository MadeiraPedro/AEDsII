#include <stdio.h>     // para entradas e saida
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes

/**
* @author Pedro Madeira - 655678
*/

/**
* Esta funcao cria um arquivo .txt e nele salva n termos reais que sao lidos da entrada padrao
* 
*@param real - variavel usada para salvar valores lidos pelo scanf e ser direcionado ao arquivo
*@param n - variavel onde contem a quantidade de termos que serao gravados no arquivo
*/

void saveArq(double real , int n){	

	FILE *arq = fopen("exemplo.txt", "w");

	for(int i = 0; i < n; i++){	
		scanf("%lf", &real);
		fprintf(arq, "%lf\n", real);
	}
	fclose(arq);
}

/**
* Essa funcao abre um arquivo .txt, le o seu conteudo e printa do ultimo ao primeiro valor de forma 'reduzida' (%g)
* 
*@param n - variavel onde contem a quantidade de termos que serao lidos
*/

void printArq(int n){

    FILE *arq2 = fopen("exemplo.txt", "r");

	double aux = 0.0;
	int inteiro = 0, n2 = n;
		
	for(int i = 0; i < n; n--){
        n2 = n;
        for(int j = 0; j < n2; n2--){
            fscanf(arq2, "%lf\n", &aux);
        }
        inteiro = (int)aux;

		if(aux == (long) aux)	
			printf("%d\n", inteiro);

		else
			printf("%g\n", aux);

        rewind(arq2);

	}
	fclose(arq2);
}

/**
* Funcao main contendo a leitura do numero de termos a serem lidos (n) e dedicada a chamar as demais funcoes passando (n) por parametro. 
* 
*/
	
int main(){
	
	int n = 0;
    scanf("%d", &n);
	double real = 0.0;
	saveArq(real, n);
	printArq(n);	
	        
}
