import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class Dicionario{

    public static void main(String[] args){


		ArrayList<String> dicionario = new ArrayList<String>();
		String linha = "";

		for(int i = 0; i < 7; i++){

			String aux = "";
			linha = MyIO.readLine();

			if(linha.length() > 1){

				aux = linha.replace("$", " ");
				aux = aux.replace("*", " ");
				aux = aux.replace("(", " ");
				aux = aux.replace(":", " ");
				aux = aux.replace("#", " ");
				aux = aux.replace(".", " ");
				aux = aux.replace("\"", " ");
				aux = aux.replace(" ", "|");
				aux = aux.replace("|||", "|");
				aux = aux.replace("||", "|");
				aux = aux.replace("|", " ");


				aux = aux.toLowerCase();

				//System.out.println(aux);

				String sep[] = aux.split(" ", -1);
				//System.out.println("Linha ("+i+"). sep tam:"+ sep.length);
					for(int x = 0; x < sep.length; x++){
						if(sep[x].length() > 0)
							dicionario.add(sep[x]);
					}

			}//fim if()

		}//fim for(i)

		String[] array = new String[dicionario.size()];
		int t = 0;


		for(String palavra : dicionario){
			array[t++] = palavra;
		}

		/*for(int i = 0; i < array.length; i++){
			int flag = 0;

			for(int j = 0; j < array.length; j++){
				if(dicionario.get(i).equals(array[j])){
					flag++;
				}
			}
			if(flag > 1) dicionario.remove(i);
		}*/

		//======================================================================
		for (int x = 1; x < array.length; x++) {
			String tmp = array[x];
			int y = x - 1;

			while ((y >= 0) && (array[y].compareTo(tmp) > 0)) {
				array[y + 1] = array[y];
				y--;
			}
			array[y + 1] = tmp;
		}
		//======================================================================


		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}


	}//fim main()
	
}//fim Dicionario()
