package test.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pretplata {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "imeKorisnika")
	private String imeKorisnika;
	
	@Column (name = "pretplatnicikiBroj")  
	private String pretplatnicikiBroj;
	
	@Column (name = "datumPocetka")
	private LocalDateTime datumPocetka;
	
	@Column (name = "TrajanjeUgovora")
	private int TrajanjeUgovora;
	
	@ManyToOne
	Tarifa tarifa;
	
	@ManyToOne
	Provajder provajder;
	
	public Pretplata () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPretplatnicikiBroj() {
		return pretplatnicikiBroj;
	}

	public void setPretplatnicikiBroj(String pretplatnicikiBroj) {
		this.pretplatnicikiBroj = pretplatnicikiBroj;
	}

	public LocalDateTime getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(LocalDateTime datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public int getTrajanjeUgovora() {
		return TrajanjeUgovora;
	}

	public void setTrajanjeUgovora(int trajanjeUgovora) {
		TrajanjeUgovora = trajanjeUgovora;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Provajder getProvajder() {
		return provajder;
	}

	public void setProvajder(Provajder provajder) {
		this.provajder = provajder;
	}
	

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pretplata other = (Pretplata) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pretplata [id=" + id + ", pretplatnicikiBroj=" + pretplatnicikiBroj + ", datumPocetka=" + datumPocetka
				+ ", TrajanjeUgovora=" + TrajanjeUgovora + "]";
	}

	
}
