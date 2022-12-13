package pbl.model.entities; 
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List; 

/**
 * A Classe que representa os grupos do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class Partida extends Entidade {
		private LocalDate data;
		private LocalTime horario;
		private String local;
		private int time1;
		private int golsTime1;
		private int cartAmaTime1;
		private int cartVerTime1;
		private int time2;
		private int golsTime2;
		private int cartAmaTime2;
		private int cartVerTime2;
		private List<JogadorGols> jogsGols1;
		private List<JogadorGols> jogsGols2;
		private List<JogadorCartoes> jogsCarts1;
		private List<JogadorCartoes> jogsCarts2;
		
		/**
		 * Construtor da classe partida.
		 * @param nome Nome da partida.
		 * @param data  Data da partida.
		 * @param horario Horario da partida.
		 * @param local Local da partida.
		 * @param time1 Primeiro time da partida.
		 * @param golsTime1 Quantidade de gols que o primeiro time fez na partida.
		 * @param cartAmaTime1 Quantidade de cartões amarelos que o primeiro time recebeu na partida.
		 * @param cartVerTime1 Quantidade de cartões vermelhos que o primeiro time recebeu na partida.
		 * @param time2 Segundo time da partida.
		 * @param golsTime2 Quantidade de gols que o segundo time fez na partida.
		 * @param cartAmaTime2 Quantidade de cartões amarelos que o segundo time recebeu na partida.
		 * @param cartVerTime2 Quantidade de cartões vermelhos que o segundo time recebeu na partida.
		 * @param jogsGols1 Lista de id e quantidade de gols que cada jogador do time 1 fez na partida.
		 * @param jogsGols2 Lista com id e quantidade de gols que cada jogador do time 2 fez na partida.
		 * @param jogsCarts1 Lista com id e quantidade de cartões vermelhos e amarelos que cada jogador do time 1 recebeu na partida.
		 * @param jogsCarts2 Lista com id e quantidade de cartões vermelhos e amarelos que cada jogador do time 2 recebeu na partida.
		 */
		
		public Partida(String nome, LocalDate data, LocalTime horario,String local, int time1, int golsTime1, int cartAmaTime1, int cartVerTime1, int time2, int golsTime2, int cartAmaTime2, int cartVerTime2, List<JogadorGols> jogsGols1, List<JogadorGols> jogsGols2, List<JogadorCartoes> jogsCarts1, List<JogadorCartoes> jogsCarts2){
			this.nome = nome;
			this.data = data;
			this.horario = horario;
			this.local = local;
			this.time1 = time1;
			this.golsTime1 = golsTime1;
			this.cartAmaTime1 = cartAmaTime1;
			this.cartVerTime1 = cartVerTime1;
			this.time2 = time2;
			this.golsTime2 = golsTime2;
			this.cartAmaTime2 = cartAmaTime2;
			this.cartVerTime2 = cartVerTime2;
			this.jogsGols1 = jogsGols1;
			this.jogsGols2 = jogsGols2;
			this.jogsCarts1 = jogsCarts1;
			this.jogsCarts2 = jogsCarts2;
		}

		/**
		 * Método que retorna as informações da Partida quando printar o objeto.
		 * @return Retorna uma String com as informações da Partida.
		 */
		
		public String toString() {
			return "ID da partida: "+ id + "\nNome da Partida: " + nome + "\nData da partida: " + data + "\nHorario da partida: " + horario + "\nLocal da partida: " + local + "\nPrimeiro time da partida: " + time1 + "\nQuantidades de gols do primeiro time: " + golsTime1 + "\nQuantidade de cartões amarelos do primeiro time:" + cartAmaTime1 + "\nQuantidade de cartões vermelhos do primeiro time:" + cartVerTime1 + "\nSegundo time da partida: " +  time2 + "\nQuantidades de gols do segundo time: " + golsTime2 + "\nQuantidade de cartões amarelos do segundo time:" + cartAmaTime2 + "\nQuantidade de cartões vermelhos do segundo time:" + cartVerTime2;
		}

		/**
		 * Retorna a data da partida.
		 * @return Retorna o LocalDate com a data da partida.
		 */
		
		public LocalDate getData() {
			return data;
		}
		
		/**
		 * Atualiza a data da partida.
		 * @param dataHora LocalDate com a nova data da partida.
		 */
		
		public void setData(LocalDate dataHora) {
			this.data = dataHora;
		}

		/**
		 * Retorna o local da partida.
		 * @return Retorna uma String com o local da partida.
		 */
		
		public String getLocal() {
			return local;
		}

		/**
		 * Atualiza o local da partida.
		 * @param local Uma String com o novo local da partida.
		 */
		
		public void setLocal(String local) {
			this.local = local;
		}
		
		/**
		 * Retorna o primeiro time da partida.
		 * @return Retorna um inteiro com o id da seleção do primeiro time da partida.
		 */
		
		public int getTime1() {
			return time1;
		}

		/**
		 * Atualiza o primeiro time da partida.
		 * @param time1 Um inteiro com o id da nova seleção do primeiro time da partida.
		 */
		
		public void setTime1(int time1) {
			this.time1 = time1;
		}

		/**
		 * Retorna o segundo time da partida.
		 * @return Retorna um inteiro com o id da seleção do segundo time da partida.
		 */
		
		public int getTime2() {
			return time2;
		}

		/**
		 * Atualiza o segundo time da partida.
		 * @param time2 Um inteiro com o id da nova seleção do primeiro time da partida.
		 */
		
		public void setTime2(int time2) {
			this.time2 = time2;
		}

		/**
		 * retorna a quantidade de gols do time 1 na partida.
		 * @return retorna um inteiro com a quantidade de gols do time 1 na partida.
		 */
		
		public int getGolstime1() {
			return golsTime1;
		}

		/**
		 * Atualiza a quantidade de gols do time 1 na partida.
		 * @param golsTime1 um inteiro com o nova quantidade de gols do time 1 na partida.
		 */
		
		public void setGolstime1(int golsTime1) {
			this.golsTime1 = golsTime1;
		}

		/**
		 * retorna a quantidade de gols do time 2 na partida.
		 * @return retorna um inteiro com a quantidade de gols do time 2 na partida.
		 */
		
		public int getGolstime2() {
			return golsTime2;
		}

		/**
		 * Atualiza a quantidade de gols do time 2 na partida.
		 * @param golsTime1 um inteiro com o nova quantidade de gols do time 2 na partida.
		 */
		
		public void setGolstime2(int golsTime2) {
			this.golsTime2 = golsTime2;
		}

		/**
		 * Retorna o horario da partida.
		 * @return retorna um LocalTime com o horario da partida.
		 */
		
		public LocalTime getHorario() {
			return horario;
		}

		/**
		 * Atualiza o horario da partida
		 * @param um LocalTime com o novo horario da partida.
		 */
		
		public void setHorario(LocalTime horario) {
			this.horario = horario;
		}

		/**
		 * retorna a quantidade de cartões vermelhos do time 1 na partida.
		 * @return retorna um inteiro com a quantidade de cartões vermelhos do time 1 na partida.
		 */
		
		public int getCartVerTime1() {
			return cartVerTime1;
		}

		/**
		 * Atualiza a quantidade de cartões vermelhos do time 1 na partida.
		 * @param cartVerTime1 um inteiro com a nova quantidade de cartões vermelhos do time 1 na partida.
		 */
		
		public void setCartVerTime1(int cartVerTime1) {
			this.cartVerTime1 = cartVerTime1;
		}

		/**
		 * retorna a quantidade de cartões amarelos do time 1 na partida.
		 * @return retorna um inteiro com a quantidade de cartões amarelos do time 1 na partida.
		 */
		
		public int getCartAmaTime1() {
			return cartAmaTime1;
		}

		/**
		 * Atualiza a quantidade de cartões amarelos do time 1 na partida.
		 * @param cartVerTime1 um inteiro com a nova quantidade de cartões amarelos do time 1 na partida.
		 */
		
		public void setCartAmaTime1(int cartAmaTime1) {
			this.cartAmaTime1 = cartAmaTime1;
		}

		/**
		 * retorna a quantidade de cartões amarelos do time 2 na partida.
		 * @return retorna um inteiro com a quantidade de cartões amarelos do time 2 na partida.
		 */
		
		public int getCartAmaTime2() {
			return cartAmaTime2;
		}

		/**
		 * Atualiza a quantidade de cartões amarelos do time 1 na partida.
		 * @param cartVerTime1 um inteiro com a nova quantidade de cartões amarelos do time 1 na partida.
		 */
		
		public void setCartAmaTime2(int cartAmaTime2) {
			this.cartAmaTime2 = cartAmaTime2;
		}

		/**
		 * retorna a quantidade de cartões vermelhos do time 1 na partida.
		 * @return retorna um inteiro com a quantidade de cartões vermelhos do time 1 na partida.
		 */
		
		public int getCartVerTime2() {
			return cartVerTime2;
		}

		/**
		 * Atualiza a quantidade de cartões vermelhos do time 1 na partida.
		 * @param cartVerTime1 um inteiro com a nova quantidade de cartões vermelhos do time 1 na partida.
		 */
		
		public void setCartVerTime2(int cartVerTime2) {
			this.cartVerTime2 = cartVerTime2;
		}

		/**
		 * Retorna a lista dos jogadores do time 1 que fizeram gols e a quantidade de gols.
		 * @return Uma lista com os jogadores do time 1 que fizeram gols e a quantidade de gols.
		 */
		
		public List<JogadorGols> getJogsGols1() {
			return jogsGols1;
		}
		
		/**
		 * Atualiza a lista dos jogadores do time 1 que fizeram gols e a quantidade de gols.
		 * @param jogsGols1 Uma lista com os novos jogadores do time 1 que fizeram gols e a quantidade de gols.
		 */
		
		public void setJogsGols1(List<JogadorGols> jogsGols1) {
			this.jogsGols1 = jogsGols1;
		}

		/**
		 * Retorna a lista dos jogadores do time 2 que fizeram gols e a quantidade de gols.
		 * @return Uma lista com os jogadores do time 2 que fizeram gols e a quantidade de gols.
		 */
		
		public List<JogadorGols> getJogsGols2() {
			return jogsGols2;
		}

		/**
		 * Atualiza a lista dos jogadores do time 2 que fizeram gols e a quantidade de gols.
		 * @param jogsGols2 Uma lista com os novos jogadores do time 2 que fizeram gols e a quantidade de gols.
		 */
		
		public void setJogsGols2(List<JogadorGols> jogsGols2) {
			this.jogsGols2 = jogsGols2;
		}

		/**
		 * Retorna a lista dos jogadores do time 2 que receberam cartão e a quantidade de cartões.
		 * @return Uma lista com os jogadores do time 2 que receberam cartão e a quantidade de cartões.
		 */
		
		public List<JogadorCartoes> getJogsCarts2() {
			return jogsCarts2;
		}

		/**
		 * Atualiza a lista dos jogadores do time 2 que fizeram gols e a quantidade de gols.
		 * @param jogsGols1 Uma lista com os novos jogadores do time 2 que fizeram gols e a quantidade de gols.
		 */
		
		public void setJogsCarts2(List<JogadorCartoes> jogsCarts2) {
			this.jogsCarts2 = jogsCarts2;
		}

		/**
		 * Retorna a lista dos jogadores do time 1 que receberam cartão e a quantidade de cartões.
		 * @return Uma lista com os jogadores do time 1 que receberam cartão e a quantidade de cartões.
		 */
		
		public List<JogadorCartoes> getJogsCarts1() {
			return jogsCarts1;
		}

		/**
		 * Atualiza a lista dos jogadores do time 2 que fizeram gols e a quantidade de gols.
		 * @param jogsGols1 Uma lista com os novos jogadores do time 2 que fizeram gols e a quantidade de gols.
		 */
		
		public void setJogsCarts1(List<JogadorCartoes> jogsCarts1) {
			this.jogsCarts1 = jogsCarts1;
		}

}
