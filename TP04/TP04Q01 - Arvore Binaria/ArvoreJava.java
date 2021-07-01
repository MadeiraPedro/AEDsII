import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class ArvoreJava{

	static int QntMusica = 170625; //valor global contendo a quantidade total de musicas 

	/**
	 * Classe Musica 
	 */

	public static class Musica{
		
		private String id;
		private String name;
		private String key;
		private String artists;
		private String release_date;
		private double acousticness;
		private double danceability;
		private double energy;
		private int duration_ms;
		private double instrumentalness;
		private double valence;
		private int popularity;
		private float tempo;
		private double liveness;
		private double loudness;
		private double speechiness;
		private int year;



		// == Construtores ==

		public Musica(){
			id = "";
			name = "";
			key = "";
			artists = "";
			release_date = "";
			acousticness = 0.0;
			danceability = 0.0;
			energy = 0.0;
			duration_ms = 0;
			instrumentalness = 0.0;
			valence = 0.0;
			popularity = 0;
			tempo = 0;
			liveness = 0.0;
			loudness = 0.0;
			speechiness = 0.0;
			year = 0;
		}
		
		// == Getters ==

		public String getId() {return id;}
		public String getName() {return name;}
		public String getKey() {return key;}
		public String getArtists() {return artists;}

		public double getAcousticness() {return acousticness;}
		public double getDanceability() {return danceability;}
		public double getEnergy() {return energy;}
		public double getInstrumentalness() {return instrumentalness;}
		public double getValence() {return valence;}
		public double getLiveness() {return liveness;}
		public double getLoudness() {return loudness;}
		public double getSpeechiness() {return speechiness;}

		public float getTempo() {return tempo;}

		public int getDuration_ms() {return duration_ms;}
		public int getPopularity() {return popularity;}
		public int getYear() {return year;}
		public String getRelease_date() {return release_date;}

		// == Setters ==

		public void setId(String id) {this.id = id;}
		public void setName(String name) {this.name = name;}
		public void setKey(String key) {this.key = key;}
		public void setArtists(String artists) {this.artists = artists;}

		public void setAcousticness(double acousticness) {this.acousticness = acousticness;}
		public void setDanceability(double danceability) {this.danceability = danceability;}
		public void setEnergy(double energy) {this.energy = energy;}
		public void setInstrumentalness(double instrumentalness) {this.instrumentalness = instrumentalness;}
		public void setValence(double valence) {this.valence = valence;}
		public void setLiveness(double liveness) {this.liveness = liveness;}
		public void setLoudness(double loudness) {this.loudness = loudness;}
		public void setSpeechiness(double speechiness) {this.speechiness = speechiness;}

		public void setTempo(float tempo) {this.tempo = tempo;}

		public void setDuration_ms(int duration_ms) {this.duration_ms = duration_ms;}
		public void setPopularity(int popularity) {this.popularity = popularity;}
		public void setYear(int year) {this.year = year;}
		public void setRelease_date(String release_date) {this.release_date = release_date;}


	}//fim Musica()


	public static class No {
		public Musica elemento; // Conteudo do no.
		public No esq, dir;  // Filhos da esq e dir.
	 
		/**
		 * Construtor da classe.
		 * @param elemento Conteudo do no.
		 */
		public No(Musica elemento){
		   this(elemento, null, null);
		}
	 
		/**
		 * Construtor da classe.
		 * @param elemento Conteudo do no.
		 * @param esq No da esquerda.
		 * @param dir No da direita.
		 */
		public No(Musica elemento, No esq, No dir) {
		   this.elemento = elemento;
		   this.esq = esq;
		   this.dir = dir;
		}
	 }//fim No()
	 
  
  
	 /**
	  * Arvore binaria de pesquisa
	  * @author Max do Val Machado
	 */
	 public static class ArvoreBinaria{
		private No raiz; // Raiz da arvore.
  
		/**
		 * Construtor da classe.
		 */
		public ArvoreBinaria() {
		   raiz = null;
		}
  
		/**
		 * Metodo publico iterativo para pesquisar elemento.
		 * @param x Elemento que sera procurado.
		 * @return <code>true</code> se o elemento existir,
		 * <code>false</code> em caso contrario.
		 */
		public boolean pesquisar(Musica x) {
			System.out.println(x.getId());
			System.out.print("raiz ");
		   	return pesquisar(x, raiz);
		}
  
		/**
		 * Metodo privado recursivo para pesquisar elemento.
		 * @param x Elemento que sera procurado.
		 * @param i No em analise.
		 * @return <code>true</code> se o elemento existir,
		 * <code>false</code> em caso contrario.
		 */
		private boolean pesquisar(Musica x, No i) {
		   	boolean resp;
		   	if (i == null) {
				resp = false;
		   	}
		   	else if (x.getId() == i.elemento.getId()) {
			  	resp = true;
		   	}
		   	else if (x.getId().compareTo(i.elemento.getId()) < 0) {
				System.out.print("esq ");
			  	resp = pesquisar(x, i.esq);
		   	}
		   	else {
				System.out.print("dir ");
			  	resp = pesquisar(x, i.dir);
		   	}
		   	return resp;
		}
  
		/**
		 * Metodo publico iterativo para exibir elementos.
		 */
		public void caminharCentral() {
		   System.out.print("[ ");
		   caminharCentral(raiz);
		   System.out.println("]");
		}
  
		/**
		 * Metodo privado recursivo para exibir elementos.
		 * @param i No em analise.
		 */
		private void caminharCentral(No i) {
		   if (i != null) {
			  caminharCentral(i.esq); // Elementos da esquerda.
			  System.out.print(i.elemento.getId() + " "); // Conteudo do no.
			  caminharCentral(i.dir); // Elementos da direita.
		   }
		}
  
		/**
		 * Metodo publico iterativo para exibir elementos.
		 */
		public void caminharPre() {
		   System.out.print("[ ");
		   caminharPre(raiz);
		   System.out.println("]");
		}
  
		/**
		 * Metodo privado recursivo para exibir elementos.
		 * @param i No em analise.
		 */
		private void caminharPre(No i) {
		   if (i != null) {
			  System.out.print(i.elemento.getId() + " "); // Conteudo do no.
			  caminharPre(i.esq); // Elementos da esquerda.
			  caminharPre(i.dir); // Elementos da direita.
		   }
		}
  
		/**
		 * Metodo publico iterativo para exibir elementos.
		 */
		public void caminharPos() {
		   System.out.print("[ ");
		   caminharPos(raiz);
		   System.out.println("]");
		}
  
		/**
		 * Metodo privado recursivo para exibir elementos.
		 * @param i No em analise.
		 */
		private void caminharPos(No i) {
		   if (i != null) {
			  caminharPos(i.esq); // Elementos da esquerda.
			  caminharPos(i.dir); // Elementos da direita.
			  System.out.print(i.elemento.getId() + " "); // Conteudo do no.
		   }
		}
  
  
		/**
		 * Metodo publico iterativo para inserir elemento.
		 * @param x Elemento a ser inserido.
		 * @throws Exception Se o elemento existir.
		 */
		public void inserir(Musica x) throws Exception {
		   raiz = inserir(x, raiz);
		}
  
		/**
		 * Metodo privado recursivo para inserir elemento.
		 * @param x Elemento a ser inserido.
		 * @param i No em analise.
		 * @return No em analise, alterado ou nao.
		 * @throws Exception Se o elemento existir.
		 */
		private No inserir(Musica x, No i) throws Exception {
		   if (i == null) {
			  i = new No(x);
  
		   } else if (x.getId().compareTo(i.elemento.getId()) < 0) {
			  i.esq = inserir(x, i.esq);
  
		   } else if (x.getId().compareTo(i.elemento.getId()) > 0) {
			  i.dir = inserir(x, i.dir);
  
		   } else {
			  throw new Exception("Erro ao inserir!");
		   }
  
		   return i;
		}
  
		/**
		 * Metodo publico para inserir elemento.
		 * @param x Elemento a ser inserido.
		 * @throws Exception Se o elemento existir.
		 */
		public void inserirPai(Musica x) throws Exception {
		   if(raiz == null){
			  raiz = new No(x);
		   } else if(x.getId().compareTo(raiz.elemento.getId()) < 0){
			  inserirPai(x, raiz.esq, raiz);
		   } else if(x.getId().compareTo(raiz.elemento.getId()) > 0){
			  inserirPai(x, raiz.dir, raiz);
		   } else {
			  throw new Exception("Erro ao inserirPai!");
		   }
		}
  
		/**
		 * Metodo privado recursivo para inserirPai elemento.
		 * @param x Elemento a ser inserido.
		 * @param i No em analise.
		 * @param pai No superior ao em analise.
		 * @throws Exception Se o elemento existir.
		 */
		private void inserirPai(Musica x, No i, No pai) throws Exception {
		   if (i == null) {
			  if(x.getId().compareTo(i.elemento.getId()) < 0){
				 pai.esq = new No(x);
			  } else {
				 pai.dir = new No(x);
			  }
		   } else if (x.getId().compareTo(i.elemento.getId()) < 0) {
			  inserirPai(x, i.esq, i);
		   } else if (x.getId().compareTo(i.elemento.getId()) > 0) {
			  inserirPai(x, i.dir, i);
		   } else {
			  throw new Exception("Erro ao inserirPai!");
		   }
		}
  
  
		/**
		 * Metodo publico iterativo para remover elemento.
		 * @param x Elemento a ser removido.
		 * @throws Exception Se nao encontrar elemento.
		 */
		public void remover(Musica x) throws Exception {
		   raiz = remover(x, raiz);
		}
  
		/**
		 * Metodo privado recursivo para remover elemento.
		 * @param x Elemento a ser removido.
		 * @param i No em analise.
		 * @return No em analise, alterado ou nao.
		 * @throws Exception Se nao encontrar elemento.
		 */
		private No remover(Musica x, No i) throws Exception {
  
		   if (i == null) {
			  throw new Exception("Erro ao remover!");
  
		   } else if (x.getId().compareTo(i.elemento.getId()) < 0) {
			  i.esq = remover(x, i.esq);
  
		   } else if (x.getId().compareTo(i.elemento.getId()) > 0) {
			  i.dir = remover(x, i.dir);
  
		   // Sem no a direita.
		   } else if (i.dir == null) {
			  i = i.esq;
  
		   // Sem no a esquerda.
		   } else if (i.esq == null) {
			  i = i.dir;
  
		   // No a esquerda e no a direita.
		   } else {
			  i.esq = maiorEsq(i, i.esq);
		   }
  
		   return i;
		}
  
		/**
		 * Metodo para trocar o elemento "removido" pelo maior da esquerda.
		 * @param i No que teve o elemento removido.
		 * @param j No da subarvore esquerda.
		 * @return No em analise, alterado ou nao.
		 */
		private No maiorEsq(No i, No j) {
  
		   // Encontrou o maximo da subarvore esquerda.
		   if (j.dir == null) {
			  i.elemento = j.elemento; // Substitui i por j.
			  j = j.esq; // Substitui j por j.ESQ.
  
		   // Existe no a direita.
		   } else {
			  // Caminha para direita.
			  j.dir = maiorEsq(i, j.dir);
		   }
		   return j;
		}
  
		/**
		 * Metodo que retorna o maior elemento da árvore
		 * @return int maior elemento da árvore
		 */
		/*public int getMaior(){
		   int resp = -1;
  
		   if(raiz != null){
			  No i;
			  for(i = raiz; i.dir != null; i = i.dir);
			  resp = i.elemento;
		   }
  
		   return resp;
		}*/
  
  
		/**
		 * Metodo que retorna o menor elemento da árvore
		 * @return int menor elemento da árvore
		 */
		/*public int getMenor(){
		   int resp = -1;
  
		   if(raiz != null){
			  No i;
			  for(i = raiz; i.esq != null; i = i.esq);
			  resp = i.elemento;
		   }
  
		   return resp;
		}*/
  
  
		/**
		 * Metodo que retorna a altura da árvore
		 * @return int altura da árvore
		 */
		/*public int getAltura(){
		   return getAltura(raiz, 0);
		}*
  
  
		/**
		 * Metodo que retorna a altura da árvore
		 * @return int altura da árvore
		 */
		/*public int getAltura(No i, int altura){
		   if(i == null){
			  altura--;
		   } else {
			  int alturaEsq = getAltura(i.esq, altura + 1);
			  int alturaDir = getAltura(i.dir, altura + 1);
			  altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
		   }
		   return altura;
		}*/
  
  
		/**
		 * Metodo publico iterativo para remover elemento.
		 * @param x Elemento a ser removido.
		 * @throws Exception Se nao encontrar elemento.
		 */
		public void remover2(Musica x) throws Exception {
		   if (raiz == null) {
			  throw new Exception("Erro ao remover2!");
		   } else if(x.getId().compareTo(raiz.elemento.getId()) < 0){
			  remover2(x, raiz.esq, raiz);
		   } else if (x.getId().compareTo(raiz.elemento.getId()) > 0){
			  remover2(x, raiz.dir, raiz);
		   } else if (raiz.dir == null) {
			  raiz = raiz.esq;
		   } else if (raiz.esq == null) {
			  raiz = raiz.dir;
		   } else {
			  raiz.esq = maiorEsq(raiz, raiz.esq);
		   }
		}
  
		/**
		 * Metodo privado recursivo para remover elemento.
		 * @param x Elemento a ser removido.
		 * @param i No em analise.
		 * @param pai do No em analise.
		 * @throws Exception Se nao encontrar elemento.
		 */
		private void remover2(Musica x, No i, No pai) throws Exception {
		   if (i == null) {
			  throw new Exception("Erro ao remover2!");
		   } else if (x.getId().compareTo(i.elemento.getId()) < 0) {
			  remover2(x, i.esq, i);
		   } else if (x.getId().compareTo(i.elemento.getId()) > 0) {
			  remover2(x, i.dir, i);
		   } else if (i.dir == null) {
			  pai = i.esq;
		   } else if (i.esq == null) {
			  pai = i.dir;
		   } else {
			  i.esq = maiorEsq(i, i.esq);
		   }
		}
  
		public Musica getRaiz() throws Exception {
		   return raiz.elemento;
		}
  
		public static boolean igual (ArvoreBinaria a1, ArvoreBinaria a2){
		   return igual(a1.raiz, a2.raiz);
		}
  
		private static boolean igual (No i1, No i2){
		   boolean resp;
		   if(i1 != null && i2 != null){
			  resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
		   } else if(i1 == null && i2 == null){
			  resp = true;
		   } else {
			  resp = false; 
		   }
		   return resp;
		}
  
		/*public int soma(){
		   return soma(raiz);
		}*/
  
		/*public int soma(No i){
		   int resp = 0;
		   if(i != null){
			  resp = i.elemento + soma(i.esq) + soma(i.dir);
		   }
		   return resp;
		}*/
  
		/*public int quantidadePares(){
		   return quantidadePares(raiz);
		}*/
  
		/*public int quantidadePares(No i){
		   int resp = 0;
		   if(i != null){
			  resp = ((i.elemento % 2 == 0) ? 1 : 0) + quantidadePares(i.esq) + quantidadePares(i.dir);
		   }
		   return resp;
		}*/
  
		/*public boolean hasDiv11(){
		   return hasDiv11(raiz);
		}*/
  
		/*public boolean hasDiv11(No i){
		   boolean resp = false;
		   if(i != null){
			  resp = (i.elemento % 11 == 0) || hasDiv11(i.esq) || hasDiv11(i.dir);
		   }
		   return resp;
		}*/
  
	 }//fim ArvoreBinaria()
	

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
	 * Fucao main() contendo a leitura do arquivo linha a linha juntamente com a separaçao dos modulos aderindo ao respectivo objeto Musica
	 * logo apos e feito a leitura da entrada padrao, onde e feito uma pesquisa sequencial ultilizando o atributo ID como chave. 
	 * 
	 * @param args
	 * @throws IOException para tratamento de execoes
	 */

    public static void main(String[] args) throws IOException {
	
		long tempoInicial = System.currentTimeMillis();
		long tempoFinal;

		BufferedReader br = new BufferedReader(new FileReader("/tmp/data.csv"));
		String linha = br.readLine(); //ignorando a primeira linha
		String str = "";
		String aux, dia, mes, ano;
		int x, flag, flag2, comparacoes = 0, movimentacoes = 0;
		ArrayList<String> entrada = new ArrayList<String>();

		Musica[] musica = new Musica[QntMusica];
		
		for(int i = 0; i < QntMusica; i++){

			dia = "";
			mes = "";
			ano = "";
			aux = "";
			x = 0;
			flag = 0;
			flag2 = 0;

			musica[i] = new Musica();
			linha = br.readLine();
			
			//========================= Valence =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setValence(Double.parseDouble(aux));
			aux = "";
			x++;

			//========================= Year =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setYear(Integer.parseInt(aux));
			aux = "";
			x++;

			//========================= Acousticness =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setAcousticness(Double.parseDouble(aux));
			aux = "";
			x++;

			//========================= Artists =========================
			while(linha.charAt(x) != ']'){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			aux += ']';
			aux = aux.replaceAll("\"", "");
			aux = aux.replaceAll("'", "");
			musica[i].setArtists(aux);
			aux = "";
			while(linha.charAt(x) != ','){ x++; }
			x++;

			//========================= Danceability =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setDanceability(Double.parseDouble(aux));
			aux = "";
			x++;

			//========================= Duration_ms =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setDuration_ms(Integer.parseInt(aux));
			aux = "";
			x++;
			//========================= Energy =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setEnergy(Double.parseDouble(aux));
			aux = "";
			x+=3;

			//========================= Id =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setId(aux);
			aux = "";
			x++;

			//========================= Instrumentalness =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setInstrumentalness(Double.parseDouble(aux));
			aux = "";
			x++;

			//========================= Key =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setKey(aux);
			aux = "";
			x++;
			
			//========================= Livenes =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setLiveness(Double.parseDouble(aux));
			aux = "";
			x++;

			//========================= Loudness =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setLoudness(Double.parseDouble(aux));
			aux = "";
			x+=3;

			//========================= Name =========================
			if(linha.charAt(x) == '"'){
				flag2 = 1;
			}

			while(flag != 1){

				if(flag2 == 1){
					if(linha.charAt(x) == '"' && linha.charAt(x+1) == ',' && linha.charAt(x+2) >= '0' && linha.charAt(x+2) <= '9'){
						flag = 1;
						x++;
					}
					else{
						aux += linha.charAt(x);
						x++;
					}
				}//fim if()
				else{
					if(linha.charAt(x) == ',' && linha.charAt(x+1) >= '0' && linha.charAt(x+1) <= '9' && linha.charAt(x+2) == ',' && linha.charAt(x+3) >= '1' && linha.charAt(x+3) <= '2'|| linha.charAt(x) == ',' && linha.charAt(x+1) >= '0' && linha.charAt(x+1) <= '9' && linha.charAt(x+3) == ',' && linha.charAt(x+4) >= '1' && linha.charAt(x+4) <= '2'|| linha.charAt(x) == ',' && linha.charAt(x+1) >= '0' && linha.charAt(x+1) <= '9' && linha.charAt(x+4) == ',' && linha.charAt(x+5) >= '1' && linha.charAt(x+5) <= '2'){
						flag = 1;
					}
					else{
						aux += linha.charAt(x);
						x++;
					}
				}//fim else()

			}//fim while()

			aux = aux.replaceAll("\"", "");
			musica[i].setName(aux);
			aux = "";
			x++;

			//========================= Popularity =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}
			musica[i].setPopularity(Integer.parseInt(aux));
			aux = "";
			x++;

			//========================= Release_date =========================
			while(linha.charAt(x) != ','){

				if(linha.charAt(x) != '-' && ano.length() < 4){
					ano += linha.charAt(x);
				}
				else if(linha.charAt(x) != '-' && mes.length() < 2){
					mes += linha.charAt(x);
				}
				else if(linha.charAt(x) != '-' && dia.length() < 2){
					dia += linha.charAt(x);
				}
				x++;
			}//fim while()
			if(mes.length() < 2){
				aux += "01/01/" + ano;
			}
			else{
				aux += dia + "/" + mes + "/" + ano;
			}

			musica[i].setRelease_date(aux);
			aux = "";
			x++;

			//========================= Speechiness =========================
			while(linha.charAt(x) != ','){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setSpeechiness(Double.parseDouble(aux));
			aux = "";
			x++;

			//========================= Tempo ========================= 
			while(x != linha.length()){
				aux += linha.charAt(x);
				x++;
			}//fim while()
			musica[i].setTempo(Float.parseFloat(aux));
			aux = "";
			x++;

		}// fim for(i)

		br.close(); //fechando arquivo date.csv

		str = MyIO.readLine();

		while(!ehFIM(str)){
			entrada.add(str);
			str = MyIO.readLine();
		}

		ArrayList<String> entrada2 = new ArrayList<String>();
		
		str = MyIO.readLine();

		while(!ehFIM(str)){
			entrada2.add(str);
			str = MyIO.readLine();
		}


		try{


			ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

			for(int i = 0; i < entrada.size(); i++){
				for(int j = 0; j < QntMusica; j++){
					if(musica[j].getId().equals(entrada.get(i))){
						arvoreBinaria.inserir(musica[j]);

						j = QntMusica; //parando execucao do for(j)
					}
				}//fim for(j)
			}//fim for(i)

			for(int i = 0; i < entrada2.size(); i++){
				for(int j = 0; j < QntMusica; j++){
					if(musica[j].getId().equals(entrada2.get(i))){
						if(arvoreBinaria.pesquisar(musica[j]) == true){
							System.out.print("SIM");
						}else{
							System.out.print("NAO");
						}
						System.out.println("");

						j = QntMusica; //parando execucao do for(j)
					}
				}//fim for(j)
			}//fim for(i)

			
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}

		tempoFinal = System.currentTimeMillis() - tempoInicial;

		BufferedWriter log = new BufferedWriter(new FileWriter("matricula_arvoreBinaria..txt"));
		log.write("655678\t"+tempoFinal+"\t"+comparacoes+"\t"+movimentacoes); ;
		log.close();


	}//fim main()
	
}//fim ArvoreJava()
