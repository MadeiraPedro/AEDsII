import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class QuicksortLista{

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

	
	public static class CelulaDupla {
		public Musica elemento;
		public CelulaDupla ant;
		public CelulaDupla prox;
	
		/**
		 * Construtor da classe.
		 */
		public CelulaDupla() {
			//this(0);
		}
	
	
		/**
		 * Construtor da classe.
		 * @param elemento int inserido na celula.
		 */
		public CelulaDupla(Musica elemento) {
			this.elemento = elemento;
			this.ant = this.prox = null;
		}

	}//fim CelulaDupla()
	
	
	public static class ListaDupla {
		private CelulaDupla primeiro;
		private CelulaDupla ultimo;
	
	
		/**
		 * Construtor da classe que cria uma lista dupla sem elementos (somente no cabeca).
		 */
		public ListaDupla() {
			primeiro = new CelulaDupla();
			ultimo = primeiro;
		}
	
	
		/**
		 * Insere um elemento na primeira posicao da lista.
		* @param x int elemento a ser inserido.
		 */
		public void inserirInicio(Musica x) {

			CelulaDupla tmp = new CelulaDupla(x);
	
			tmp.ant = primeiro;
			tmp.prox = primeiro.prox;
			primeiro.prox = tmp;
			if(primeiro == ultimo){
				ultimo = tmp;
			}else{
				tmp.prox.ant = tmp;
			}
			tmp = null;
		}
	
	
		/**
		 * Insere um elemento na ultima posicao da lista.
		* @param x int elemento a ser inserido.
		 */
		public void inserirFim(Musica x) {
			ultimo.prox = new CelulaDupla(x);
		  	ultimo.prox.ant = ultimo;
			ultimo = ultimo.prox;
		}
	
	
		/**
		 * Remove um elemento da primeira posicao da lista.
		* @return resp int elemento a ser removido.
		 * @throws Exception Se a lista nao contiver elementos.
		 */
		public Musica removerInicio() throws Exception {
			if (primeiro == ultimo) {
				throw new Exception("Erro ao remover (vazia)!");
			}
	
		  	CelulaDupla tmp = primeiro;
			primeiro = primeiro.prox;
			Musica resp = primeiro.elemento;
		  	tmp.prox = primeiro.ant = null;
		  	tmp = null;
			return resp;
		}
	
	
		/**
		 * Remove um elemento da ultima posicao da lista.
		* @return resp int elemento a ser removido.
		 * @throws Exception Se a lista nao contiver elementos.
		 */
		public Musica removerFim() throws Exception {
			if (primeiro == ultimo) {
				throw new Exception("Erro ao remover (vazia)!");
			} 
			Musica resp = ultimo.elemento;
			ultimo = ultimo.ant;
			ultimo.prox.ant = null;
			ultimo.prox = null;

			return resp;
		}
	
	
		/**
		* Insere um elemento em uma posicao especifica considerando que o 
		* primeiro elemento valido esta na posicao 0.
		* @param x int elemento a ser inserido.
		 * @param pos int posicao da insercao.
		 * @throws Exception Se <code>posicao</code> invalida.
		 */
		public void inserir(Musica x, int pos) throws Exception {
	
			int tamanho = tamanho();
	
			if(pos < 0 || pos > tamanho){
				throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
			} else if (pos == 0){
				inserirInicio(x);
			} else if (pos == tamanho){
				inserirFim(x);
			} else {
				// Caminhar ate a posicao anterior a insercao
				CelulaDupla i = primeiro;
				for(int j = 0; j < pos; j++, i = i.prox);
				
				CelulaDupla tmp = new CelulaDupla(x);
				tmp.ant = i;
				tmp.prox = i.prox;
				tmp.ant.prox = tmp.prox.ant = tmp;
				tmp = i = null;
			}
		}
	
	
		/**
		* Remove um elemento de uma posicao especifica da lista
		* considerando que o primeiro elemento valido esta na posicao 0.
		 * @param posicao Meio da remocao.
		* @return resp int elemento a ser removido.
		 * @throws Exception Se <code>posicao</code> invalida.
		 */
		public Musica remover(int pos) throws Exception {

			Musica resp;
		  	int tamanho = tamanho();
	
			if (primeiro == ultimo){
				throw new Exception("Erro ao remover (vazia)!");
	
			} else if(pos < 0 || pos >= tamanho){
					throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
			} else if (pos == 0){
				resp = removerInicio();
			} else if (pos == tamanho - 1){
				resp = removerFim();
			} else {
				// Caminhar ate a posicao anterior a insercao
				CelulaDupla i = primeiro.prox;
				for(int j = 0; j < pos; j++, i = i.prox);
				
				i.ant.prox = i.prox;
				i.prox.ant = i.ant;
				resp = i.elemento;
				i.prox = i.ant = null;
				i = null;
			  }
	
			return resp;
		}
	
	
		/**
		 * Mostra os elementos da lista separados por espacos.
		 */
		public void mostrar() {
			for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
				System.out.println(i.elemento.getId() +" ## "+ i.elemento.getArtists() +" ## "+ i.elemento.getName() +" ## "+ i.elemento.getRelease_date() +" ## "+ i.elemento.getAcousticness() +" ## "+ i.elemento.getDanceability() +" ## "+ i.elemento.getInstrumentalness() +" ## "+ i.elemento.getLiveness() +" ## "+ i.elemento.getLoudness() +" ## "+ i.elemento.getSpeechiness() +" ## "+ i.elemento.getEnergy() +" ## "+ i.elemento.getDuration_ms());
			}
		}
	
	
		/**
		 * Mostra os elementos da lista de forma invertida 
		* e separados por espacos.
		 */
		public void mostrarInverso() {
			//System.out.print("[ ");
			for (CelulaDupla i = ultimo; i != primeiro; i = i.ant){
				System.out.print(i.elemento + " ");
		  	}
			//System.out.println("] "); // Termina de mostrar.
		}
		
		/**
	 	* Calcula e retorna o tamanho, em numero de elementos, da lista.
	 	* @return resp int tamanho
	 	*/
		public int tamanho() {
			int tamanho = 0; 
			for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
			return tamanho;
		}

	}//fim ListaDupla()
	


	public static class Geracao {
		protected Musica[] array;
		protected int n;
		protected int aux;
	 
	 
		 /**
		  * Construtor.
		  */
		public Geracao(){
		   array = new Musica[100];
		   n = array.length;
		   aux = -1;
		}
	 
	 
		 /**
		  * Construtor.
		  * @param int tamanho do array de numeros inteiros.
		  */
		public Geracao(int tamanho){
		   array = new Musica[tamanho];
		   n = array.length;
		   aux = -1;
		}
	 
		/**
		* Recebe um Efetua a leitura dos elementos via entrada padrao.
		*/
		public void entrada(Musica[] vet){
		   n = vet.length;
		   array = new Musica[n];
		   for(int i = 0; i < n; i++){
			  array[i] = vet[i];
		   }
		}
	 
	 
		 /**
		  * Mostra os k primeiros elementos do array.
		  * @param int k indica a quantidade de elementos do array a serem mostrados.
		  */
		public void mostrar(int k) {
			System.out.print("[");
			
			for (int i = 0; i < k; i++) {
			System.out.print(" ("+i+")" + array[i]);
			}
			
			System.out.println("]");
		}
	 
	 
		 /**
		  * Mostra os elementos do array.
		  */
		public void mostrar() {
	 
		   for (int i = 0; i < n; i++) {
			  System.out.println(array[i].getId() +" ## "+ array[i].getArtists() +" ## "+ array[i].getName() +" ## "+ array[i].getRelease_date() +" ## "+ array[i].getAcousticness() +" ## "+ array[i].getDanceability() +" ## "+ array[i].getInstrumentalness() +" ## "+ array[i].getLiveness() +" ## "+ array[i].getLoudness() +" ## "+ array[i].getSpeechiness() +" ## "+ array[i].getEnergy() +" ## "+ array[i].getDuration_ms());
		   }
	 
		}

		public Musica retornar(){
			aux++;
			return array[aux];
		}
	 
	 
		/**
		 * Troca o conteudo de duas posicoes do array
		 * @param i int primeira posicao
		 * @param j int segunda posicao
		 */
		public void swap(int i, int j) {
		   Musica temp = array[i];
		   array[i] = array[j];
		   array[j] = temp;
		}
	 
	 
		/**
		 * Retorna o timestamp atual
		 * @return timestamp atual
		 */
		public long now(){
		   return new Date().getTime();
		}
	
	}//fim Geracao();
	 


	public static class Quicksort extends Geracao {

		/**
		* Construtor.
		*/
		public Quicksort(){
		  super();
	    }
	
	
		/**
		* Construtor.
		* @param int tamanho do array de numeros inteiros.
		*/
	   	public Quicksort(int tamanho){
		  super(tamanho);
	   	}
	
	
		/**
		 * Algoritmo de ordenacao Quicksort.
		 */
	   	//@Override
	   	public void sort() {
		  	quicksort(0, n-1);
	   	}
	
		public void swap(int i, int j) {
			Musica temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	
	
		/**
		 * Algoritmo de ordenacao Quicksort.
		* @param int esq inicio do array a ser ordenado
		* @param int dir fim do array a ser ordenado
		 */
		private void quicksort(int esq, int dir) {
			int i = esq, j = dir;
			Musica pivo = array[(dir+esq)/2];
			while (i <= j) {
				while (array[i].getDuration_ms() < pivo.getDuration_ms()) i++;
				while (array[j].getDuration_ms() > pivo.getDuration_ms()) j--;
				if (i <= j) {
					swap(i, j);
					i++;
					j--;
				}
			}
			if (esq < j)  quicksort(esq, j);
			if (i < dir)  quicksort(i, dir);
		}

	}//fim Quicksort()
	


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

		br.close();

		str = MyIO.readLine();

		while(!ehFIM(str)){
			entrada.add(str);
			str = MyIO.readLine();
		}

		
		Musica[] posicoes = new Musica[entrada.size()];
		Quicksort quick = new Quicksort(entrada.size());

		for(int i = 0; i < entrada.size(); i++){
			for(int j = 0; j < QntMusica; j++){
				if(musica[j].getId().equals(entrada.get(i))){
					posicoes[i] = musica[j];

					j = QntMusica; //parando execucao do for(j)
				}
				comparacoes++;
			}//fim for(j)
		}//fim for(i)

		//====================== sort ============================
		quick.entrada(posicoes);
		quick.sort();
		//quick.mostrar();
	  	//========================================================

		ListaDupla lista = new ListaDupla();

		try{

			for(int i = 0; i < posicoes.length; i++){
				lista.inserir(quick.retornar(), i);
			}

			lista.mostrar();

		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}

		tempoFinal = System.currentTimeMillis() - tempoInicial;

		BufferedWriter log = new BufferedWriter(new FileWriter("matricula_quicksort2.txt"));
		log.write("655678\t"+tempoFinal+"\t"+comparacoes+"\t"+movimentacoes); ;
		log.close();


	}//fim main()
	
}//fim QuicksortLista()
