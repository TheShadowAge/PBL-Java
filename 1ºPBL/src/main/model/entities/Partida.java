package main.model.entities; 
import java.time.LocalDateTime; 


public class Partida extends Entidade {
		private String codigo;
		private LocalDateTime dataHora;
		private String local;
		private int time1;
		private int time2;
		private int golstime1;
		private int golstime2;
		
		Partida(String nome, String codigo, LocalDateTime dataHora, String local, int time1, int time2, int golstime1, int golstime2){
			this.nome = nome;
			this.codigo = codigo;
			this.dataHora = dataHora;
			this.local = local;
			this.time1 = time1;
			this.time2 = time2;
			this.golstime1 = golstime1;
			this.golstime2 = golstime2;
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public LocalDateTime getDataHora() {
			return dataHora;
		}

		public void setDataHora(LocalDateTime dataHora) {
			this.dataHora = dataHora;
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
			return golstime1;
		}

		public void setGolstime1(int golstime1) {
			this.golstime1 = golstime1;
		}

		public int getGolstime2() {
			return golstime2;
		}

		public void setGolstime2(int golstime2) {
			this.golstime2 = golstime2;
		}
		
		
		
}
