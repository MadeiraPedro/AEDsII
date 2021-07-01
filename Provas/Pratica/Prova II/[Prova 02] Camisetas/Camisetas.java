import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class Camisetas{


    public static void main(String[] args){

		int n = MyIO.readInt();
		int pequenas = 0, medias = 0;

		for(int i = 0; i < n; i++){
			int aux = 0;
			aux = MyIO.readInt();
			if(aux == 1) pequenas++;
			else medias++;
		}

		int pequenasProduzidas = MyIO.readInt(), mediasProduzidas = MyIO.readInt();

		if(pequenasProduzidas == pequenas && mediasProduzidas == medias) System.out.println("S");
		else System.out.println("N");


	}//fim main()
	
}//fim Camisetas()
