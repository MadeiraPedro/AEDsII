import java.util.*;
import java.io.*;

/**
* @author Pedro Madeira - 655678
*/


public class Sequencial{

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
			String id = "";
			String name = "";
			String key = "";
			String artists = "";
			String release_date = "";
			double acousticness = 0.0;
			double danceability = 0.0;
			double energy = 0.0;
			int duration_ms = 0;
			double instrumentalness = 0.0;
			double valence = 0.0;
			int popularity = 0;
			float tempo = 0;
			double liveness = 0.0;
			double loudness = 0.0;
			double speechiness = 0.0;
			int year = 0;
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
		int x, flag, flag2, comparacoes = 0;
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

		str = MyIO.readLine();

		while(!ehFIM(str)){

			int f = 0;

			for(int i = 0; i < entrada.size(); i++){
				if(entrada.get(i).equals(str)){
					f = 1;
					i = entrada.size();
				}
				comparacoes++;
			}

			if(f == 1){
				System.out.println("SIM");
			}
			else{
				System.out.println("NAO");
			}

			str = MyIO.readLine();

		}//fim while()

		tempoFinal = System.currentTimeMillis() - tempoInicial;

		BufferedWriter log = new BufferedWriter(new FileWriter("matricula_sequencial.txt"));
		log.write("655678\t"+tempoFinal+"\t"+comparacoes); ;
		log.close();


	}//fim main()
	
}//fim ClasseJava()
