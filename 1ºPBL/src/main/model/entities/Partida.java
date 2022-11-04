package main.model.entities; 
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List; 


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
		private List<Integer> jogsGols1;
		private List<Integer> jogsGols2;
		private List<Integer> jogsCarts1;
		private List<Integer> jogsCarts2;
		
		public Partida(String nome, LocalDate data, LocalTime horario,String local, int time1, int golsTime1, int cartAmaTime1, int cartVerTime1, int time2, int golsTime2, int cartAmaTime2, int cartVerTime2, List<Integer> jogsGols1, List<Integer> jogsGols2, List<Integer> jogsCarts1, List<Integer> jogsCarts2){
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

		public String toString() {
			return "ID da partida: "+ id + "\nNome da Partida: " + nome + "\nData da partida: " + data + "\nHorario da partida: " + horario + "\nLocal da partida: " + local + "\nPrimeiro time da partida: " + time1 + "\nQuantidades de gols do primeiro time: " + golsTime1 + "\nQuantidade de cartões amarelos do primeiro time:" + cartAmaTime1 + "\nQuantidade de cartões vermelhos do primeiro time:" + cartVerTime1 + "\nSegundo time da partida: " +  time2 + "\nQuantidades de gols do segundo time: " + golsTime2 + "\nQuantidade de cartões amarelos do segundo time:" + cartAmaTime2 + "\nQuantidade de cartões vermelhos do segundo time:" + cartVerTime2;
		}

		public LocalDate getData() {
			return data;
		}

		public void setData(LocalDate dataHora) {
			this.data = dataHora;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}

		public int getTime1() {
			return time1;
		}

		public void setTime1(int time1) {
			this.time1 = time1;
		}

		public int getTime2() {
			return time2;
		}

		public void setTime2(int time2) {
			this.time2 = time2;
		}

		public int getGolstime1() {
			return golsTime1;
		}

		public void setGolstime1(int golsTime1) {
			this.golsTime1 = golsTime1;
		}

		public int getGolstime2() {
			return golsTime2;
		}

		public void setGolstime2(int golsTime2) {
			this.golsTime2 = golsTime2;
		}

		public LocalTime getHorario() {
			return horario;
		}

		public void setHorario(LocalTime horario) {
			this.horario = horario;
		}

		public int getCartVerTime1() {
			return cartVerTime1;
		}

		public void setCartVerTime1(int cartVerTime1) {
			this.cartVerTime1 = cartVerTime1;
		}

		public int getCartAmaTime1() {
			return cartAmaTime1;
		}

		public void setCartAmaTime1(int cartAmaTime1) {
			this.cartAmaTime1 = cartAmaTime1;
		}

		public int getCartAmaTime2() {
			return cartAmaTime2;
		}

		public void setCartAmaTime2(int cartAmaTime2) {
			this.cartAmaTime2 = cartAmaTime2;
		}

		public int getCartVerTime2() {
			return cartVerTime2;
		}

		public void setCartVerTime2(int cartVerTime2) {
			this.cartVerTime2 = cartVerTime2;
		}

		public List<Integer> getJogsGols1() {
			return jogsGols1;
		}

		public void setJogsGols1(List<Integer> jogsGols1) {
			this.jogsGols1 = jogsGols1;
		}

		public List<Integer> getJogsGols2() {
			return jogsGols2;
		}

		public void setJogsGols2(List<Integer> jogsGols2) {
			this.jogsGols2 = jogsGols2;
		}

		public List<Integer> getJogsCarts2() {
			return jogsCarts2;
		}

		public void setJogsCarts2(List<Integer> jogsCarts2) {
			this.jogsCarts2 = jogsCarts2;
		}

		public List<Integer> getJogsCarts1() {
			return jogsCarts1;
		}

		public void setJogsCarts1(List<Integer> jogsCarts1) {
			this.jogsCarts1 = jogsCarts1;
		}

		public int getGolsTime1() {
			return golsTime1;
		}

		public void setGolsTime1(int golsTime1) {
			this.golsTime1 = golsTime1;
		}

		public int getGolsTime2() {
			return golsTime2;
		}

		public void setGolsTime2(int golsTime2) {
			this.golsTime2 = golsTime2;
		}

		

}
