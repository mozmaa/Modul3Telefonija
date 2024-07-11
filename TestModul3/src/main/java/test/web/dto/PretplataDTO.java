package test.web.dto;



public class PretplataDTO {

	private Long id;
	
	private String imeKorisnika;
	
	private String pretplatnicikiBroj;
	
	private String datumPocetka;
	
	private Integer TrajanjeUgovora;
	
	private Long tarifaId;
	
	private String tarifaIme;
	
	private Double cena;
	
	private Long provajderId;
	
	private String provajderIme;
	
	public PretplataDTO () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public String getPretplatnicikiBroj() {
		return pretplatnicikiBroj;
	}

	public void setPretplatnicikiBroj(String pretplatnicikiBroj) {
		this.pretplatnicikiBroj = pretplatnicikiBroj;
	}

	public String getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Integer getTrajanjeUgovora() {
		return TrajanjeUgovora;
	}

	public void setTrajanjeUgovora(Integer trajanjeUgovora) {
		TrajanjeUgovora = trajanjeUgovora;
	}

	public Long getTarifaId() {
		return tarifaId;
	}

	public void setTarifaId(Long tarifaId) {
		this.tarifaId = tarifaId;
	}

	public String getTarifaIme() {
		return tarifaIme;
	}

	public void setTarifaIme(String tarifaIme) {
		this.tarifaIme = tarifaIme;
	}

	public Long getProvajderId() {
		return provajderId;
	}

	public void setProvajderId(Long provajderId) {
		this.provajderId = provajderId;
	}

	public String getProvajderIme() {
		return provajderIme;
	}

	public void setProvajderIme(String provajderIme) {
		this.provajderIme = provajderIme;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	
	
}
