#include <stdio.h>     // para entradas e saida
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes

/**
* @author Pedro Madeira - 655678
*/


/**
* Essa funcao recebe dois vetores de caracteres e salva um de forma invertida no outro
* 
*@param invertida - vetor de caracteres destinado a receber outro vetor de caracter de forma invertida
*@param palavra - vetor de caracteres que contem uma linha lida
*/

void inverter(char invertida[1000], char palavra[1000]){ //funçao para inverter o vetor de caracteres

    for(int i = 0; i < strlen(palavra); i++){ 

        invertida[i] = palavra[strlen(palavra)-1-i];


    }//fim for (i)

}//fim inverter()

/**
* Essa funcao recebe dois vetores de caracteres manda para uma funcao inverter e salvar em outro, os compara para saber se o vetor invertido eh igual ao normal caso seje, retorna (true)
* 
*@param invertida - vetor de caracteres destinado a receber outro vetor de caracter de forma invertida
*@param palavra - vetor de caracteres que contem uma linha lida
*@return - 
*/

bool palin(char palavra[1000], char invertida[1000]){

    bool ehPalin = false;
    int aux;

    inverter(invertida, palavra);

    aux = strcmp(palavra, invertida); //comparando se o vetor invertido é igual ao normal, caso seja, ehPalin retorna verdadeiro

    if(aux == 0) ehPalin = true;

    return ehPalin;

}//fim palin()

/**
* Funcao do tipo boolean que recebe uma string e verifica se a mesma corresponde a sequencia de caracteres 'FIM'.
* 
* @param palavra - vetor de caracteres que contem uma linha lida
* @return - retorna uma variavel do tipo boolean (flag) que caso a string for igual a 'FIM' retorna (true) caso nao retorna (false)
*/
bool ehFIM (char palavra[]){  //função booleana para receber uma string e verificar se a mesma é FIM, caso seja ela retorna true

    bool flag = false;

    if(strlen(palavra) == 3 && palavra[0] == 'F' && palavra[1] =='I' && palavra[2] == 'M')
        flag = true;

    return flag;

}//fim ehFIM

/**
* Funcao main contendo a leitura do vetor de caracteres que e passado por parametro as demais funcoes, tambem onde eh gerada a saida do progama.
* 
*/

int main(void) {

    bool resp = true;
    char palavra[1000], invertida[1000]; //declarando tamanho de 1000 para evitar erros como (segmentation fault (core dumped))

    scanf(" %[^\n]s", palavra); //scanf "adaptado" para ler uma linha inteira

    while(!ehFIM(palavra)){ //enquanto a funçao ehFIM for diferente de FIM

        fflush(stdin);

        strcpy(invertida, palavra);

        resp = palin(palavra , invertida);

        if (resp == true) printf("SIM\n");
        else printf("NAO\n");
   
        scanf(" %[^\n]s", palavra); //scanf "adaptado" para ler uma linha inteira

    }//fim while()

}//fim main()
