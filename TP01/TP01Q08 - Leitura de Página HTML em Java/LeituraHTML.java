import java.util.*;
import java.io.*;
import java.net.*;

/**
* @author Pedro Madeira - 655678
*/

public class LeituraHTML {

	public static String getHtml(String endereco){
		URL url;
		InputStream is = null;
		BufferedReader br;
		String resp = "", line;
  
		try {
		   url = new URL(endereco);
		   is = url.openStream();  // throws an IOException
		   br = new BufferedReader(new InputStreamReader(is));
  
		   while ((line = br.readLine()) != null) {
			  resp += line + "\n";
		   }
		} catch (MalformedURLException mue) {
		   mue.printStackTrace();
		} catch (IOException ioe) {
		   ioe.printStackTrace();
		} 
  
		try {
		   is.close();
		} catch (IOException ioe) {
		   // nothing to see here
  
		}
  
		return resp;
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
		String endereco, html;
		String str = MyIO.readLine();

		while(!ehFIM(str)){ 
			
			int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0, x9 = 0, x10 = 0, x11 = 0, x12 = 0, x13 = 0, x14 = 0, x15 = 0, x16 = 0, x17 = 0, x18 = 0, x19 = 0, x20 = 0, x21 = 0, x22 = 0, x23 = 0, x24 = 0, x25 = 0;
			String x26 = str;

			endereco = MyIO.readLine();
      		html = getHtml(endereco);

			for(int i = 0; i < html.length(); i++){

				if((int)html.charAt(i) == 97){ x1++; }
				else if((int)html.charAt(i) == 101) { x2++; }
				else if((int)html.charAt(i) == 105) { x3++; }
				else if((int)html.charAt(i) == 111) { x4++; }
				else if((int)html.charAt(i) == 117) { x5++; }
				else if((int)html.charAt(i) == 225) { x6++; }
				else if((int)html.charAt(i) == 233) { x7++; }
				else if((int)html.charAt(i) == 237) { x8++; }
				else if((int)html.charAt(i) == 243) { x9++; }
				else if((int)html.charAt(i) == 250) { x10++; }
				else if((int)html.charAt(i) == 224) { x11++; }
				else if((int)html.charAt(i) == 232) { x12++; }
				else if((int)html.charAt(i) == 236) { x13++; }
				else if((int)html.charAt(i) == 242) { x14++; }
				else if((int)html.charAt(i) == 249) { x15++; }
				else if((int)html.charAt(i) == 227) { x16++; }
				else if((int)html.charAt(i) == 245) { x17++; }
				else if((int)html.charAt(i) == 226) { x18++; }
				else if((int)html.charAt(i) == 234) { x19++; }
				else if((int)html.charAt(i) == 238) { x20++; }
				else if((int)html.charAt(i) == 244) { x21++; }
				else if((int)html.charAt(i) == 251) { x22++; }
				else if(html.charAt(i) >= 'b' && html.charAt(i) <= 'd' || html.charAt(i) >= 'f' && html.charAt(i) <= 'h' || html.charAt(i) >= 'j' && html.charAt(i) <= 'n' || html.charAt(i) >= 'p' && html.charAt(i) <= 't' || html.charAt(i) >= 'v' && html.charAt(i) <= 'z') { x23++; }

			}//fim for()

			MyIO.println("a("+x1+") e("+x2+") i("+x3+") o("+x4+") u("+x5+") á("+x6+") é("+x7+") í("+x8+") ó("+x9+") ú("+x10+") à("+x11+") è("+x12+") ì("+x13+") ò("+x14+") ù("+x15+") ã("+x16+") õ("+x17+") â("+x18+") ê("+x19+") î("+x20+") ô("+x21+") û("+x22+") consoante("+x23+") <br>(0) <table>(0) "+x26);

			str = MyIO.readLine();

		}//fim while()

	}
}
