import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class ArvoreAN{

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


	public static class NoAN{
		public boolean cor;
		public Musica elemento;
		public NoAN esq, dir;

		public NoAN (){
			//this(-1);
		}
		public NoAN (Musica elemento){
			this(elemento, false, null, null);
		}
		public NoAN (Musica elemento, boolean cor){
			this(elemento, cor, null, null);
		}
		public NoAN (Musica elemento, boolean cor, NoAN esq, NoAN dir){
		  this.cor = cor;
		  this.elemento = elemento;
		  this.esq = esq;
		  this.dir = dir;
		}
	 }//fim NoAN()
  
  
	 public static class Alvinegra {
		private NoAN raiz; // Raiz da arvore.
	 
		/**
		 * Construtor da classe.
		 */
		public Alvinegra() {
		   raiz = null;
		}
	 
		/**
		 * Metodo publico iterativo para pesquisar elemento.
		 * @param elemento Elemento que sera procurado.
		 * @return <code>true</code> se o elemento existir,
		 * <code>false</code> em caso contrario.
		 */
		public boolean pesquisar(Musica elemento) {
			System.out.println(elemento.getId());
			System.out.print("raiz ");
		   	return pesquisar(elemento, raiz);
		}
	 
		/**
		 * Metodo privado recursivo para pesquisar elemento.
		 * @param elemento Elemento que sera procurado.
		 * @param i NoAN em analise.
		 * @return <code>true</code> se o elemento existir,
		 * <code>false</code> em caso contrario.
		 */
		private boolean pesquisar(Musica elemento, NoAN i) {
			boolean resp;
		   	if (i == null) {
				resp = false;
		 	} 
		   	else if (elemento.getId() == i.elemento.getId()) {
				resp = true;
		   	} 
		   	else if (elemento.getId().compareTo(i.elemento.getId()) < 0) {
				System.out.print("esq ");
			  	resp = pesquisar(elemento, i.esq);
		   	} 
		   	else {
				System.out.print("dir ");
			  	resp = pesquisar(elemento, i.dir);
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
		 * @param i NoAN em analise.
		 */
		private void caminharCentral(NoAN i) {
		   if (i != null) {
			  caminharCentral(i.esq); // Elementos da esquerda.
			  System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
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
		 * @param i NoAN em analise.
		 */
		private void caminharPre(NoAN i) {
		   if (i != null) {
			  System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
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
		 * @param i NoAN em analise.
		 */
		private void caminharPos(NoAN i) {
		   if (i != null) {
			  caminharPos(i.esq); // Elementos da esquerda.
			  caminharPos(i.dir); // Elementos da direita.
			  System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
		   }
		}
	 
	 
		/**
		 * Metodo publico iterativo para inserir elemento.
		 * @param elemento Elemento a ser inserido.
		 * @throws Exception Se o elemento existir.
		 */
		public void inserir(Musica elemento) throws Exception {
		
		   //Se a arvore estiver vazia
		   if(raiz == null){
			  raiz = new NoAN(elemento);
			  //System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");
	 
		   //Senao, se a arvore tiver um elemento 
		   } else if (raiz.esq == null && raiz.dir == null){
			  if (elemento.getId().compareTo(raiz.elemento.getId()) < 0){
				 raiz.esq = new NoAN(elemento);
				 //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").");
			  } else {
				 raiz.dir = new NoAN(elemento);
				 //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
			  }
	 
		   //Senao, se a arvore tiver dois elementos (raiz e dir)
		   } else if (raiz.esq == null){
	 
			  if(elemento.getId().compareTo(raiz.elemento.getId()) < 0){
				 raiz.esq = new NoAN(elemento);
				 //System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
	 
			  } else if (elemento.getId().compareTo(raiz.dir.elemento.getId()) < 0){
				 raiz.esq = new NoAN(raiz.elemento);
				 raiz.elemento = elemento;
				 //System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
	 
			  } else {
				 raiz.esq = new NoAN(raiz.elemento);
				 raiz.elemento = raiz.dir.elemento;
				 raiz.dir.elemento = elemento;
				 //System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
			  }
	 
			  raiz.esq.cor = raiz.dir.cor = false;
			  
		   //Senao, se a arvore tiver dois elementos (raiz e esq)
		   } else if (raiz.dir == null){
			  
			  if(elemento.getId().compareTo(raiz.elemento.getId()) > 0){
				 raiz.dir = new NoAN(elemento);
				 //System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
			  } else if (elemento.getId().compareTo(raiz.dir.elemento.getId()) > 0){
				 raiz.dir = new NoAN(raiz.elemento);
				 raiz.elemento = elemento;
				 //System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
			  } else {
				 raiz.dir = new NoAN(raiz.elemento);
				 raiz.elemento = raiz.esq.elemento;
				 raiz.esq.elemento = elemento;
				 //System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
			  }
	 
			  raiz.esq.cor = raiz.dir.cor = false;
	 
		   //Senao, a arvore tem tres ou mais elementos
		   } else {
			  //System.out.println("Arvore com tres ou mais elementos...");
			  inserir(elemento, null, null, null, raiz);
		   }
	 
		   raiz.cor = false;
		}
	 
		private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i){
	 
		   //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
		   if(pai.cor == true){
	 
			  //4 tipos de reequilibrios e acoplamento
			  if(pai.elemento.getId().compareTo(avo.elemento.getId()) > 0){ // rotacao a esquerda ou direita-esquerda
				 if(i.elemento.getId().compareTo(pai.elemento.getId()) > 0){
					avo = rotacaoEsq(avo);
				 } else {
					avo = rotacaoDirEsq(avo);
				 }
	 
			  } else { // rotacao a direita ou esquerda-direita
				 if(i.elemento.getId().compareTo(pai.elemento.getId()) < 0){
					avo = rotacaoDir(avo);
				 } else {
					avo = rotacaoEsqDir(avo);
				 }
			  }
	 
			  if (bisavo == null){
				 raiz = avo;
			  } else if(avo.elemento.getId().compareTo(bisavo.elemento.getId()) < 0){
				 bisavo.esq = avo;
			  } else {
				 bisavo.dir = avo;
			  }
	 
			  //reestabelecer as cores apos a rotacao
			  avo.cor = false;
			  avo.esq.cor = avo.dir.cor = true;
			  //System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir(" + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
		   } //if(pai.cor == true)
		}
	 
		/**
		 * Metodo privado recursivo para inserir elemento.
		 * @param elemento Elemento a ser inserido.
		 * @param avo NoAN em analise.
		 * @param pai NoAN em analise.
		 * @param i NoAN em analise.
		 * @throws Exception Se o elemento existir.
		 */
		private void inserir(Musica elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
		   if (i == null) {
	 
			  if(elemento.getId().compareTo(pai.elemento.getId()) < 0){
				 i = pai.esq = new NoAN(elemento, true);
			  } else {
				 i = pai.dir = new NoAN(elemento, true);
			  }
	 
			  if(pai.cor == true){
				 balancear(bisavo, avo, pai, i);
			  }
	 
		   } else {
	 
			 //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
			  if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
				 i.cor = true;
				 i.esq.cor = i.dir.cor = false;
				 if(i == raiz){
					i.cor = false;
				 }else if(pai.cor == true){
					balancear(bisavo, avo, pai, i);
				 }
			  }
	 
			  if (elemento.getId().compareTo(i.elemento.getId()) < 0) {
				 inserir(elemento, avo, pai, i, i.esq);
			  } else if (elemento.getId().compareTo(i.elemento.getId()) > 0) {
				 inserir(elemento, avo, pai, i, i.dir);
			  } else {
				 throw new Exception("Erro inserir (elemento repetido)!");
			  }
		   }
		}
	 
		private NoAN rotacaoDir(NoAN no) {
		   //System.out.println("Rotacao DIR(" + no.elemento + ")");
		   NoAN noEsq = no.esq;
		   NoAN noEsqDir = noEsq.dir;
	 
		   noEsq.dir = no;
		   no.esq = noEsqDir;
	 
		   return noEsq;
		}
	 
		private NoAN rotacaoEsq(NoAN no) {
		   //System.out.println("Rotacao ESQ(" + no.elemento + ")");
		   NoAN noDir = no.dir;
		   NoAN noDirEsq = noDir.esq;
	 
		   noDir.esq = no;
		   no.dir = noDirEsq;
		   return noDir;
		}
	 
		private NoAN rotacaoDirEsq(NoAN no) {
		   no.dir = rotacaoDir(no.dir);
		   return rotacaoEsq(no);
		}
	 
		private NoAN rotacaoEsqDir(NoAN no) {
		   no.esq = rotacaoEsq(no.esq);
		   return rotacaoDir(no);
		}
  
	 }//fim Alvinegra()

	

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


			Alvinegra arvore = new Alvinegra();

			for(int i = 0; i < entrada.size(); i++){
				for(int j = 0; j < QntMusica; j++){
					if(musica[j].getId().equals(entrada.get(i))){
						arvore.inserir(musica[j]);

						j = QntMusica; //parando execucao do for(j)
					}
				}//fim for(j)
			}//fim for(i)

			for(int i = 0; i < entrada2.size(); i++){
				for(int j = 0; j < QntMusica; j++){
					if(musica[j].getId().equals(entrada2.get(i))){
						if(arvore.pesquisar(musica[j]) == true){
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

		BufferedWriter log = new BufferedWriter(new FileWriter("matricula_alvinegra.txt"));
		log.write("655678\t"+tempoFinal+"\t"+comparacoes+"\t"+movimentacoes); ;
		log.close();


	}//fim main()
	
}//fim ArvoreAN()
