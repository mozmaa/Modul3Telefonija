package test.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class TarifaDTO {

	private Long id;
	
	private String naziv;
	
	private String opis;
	
	private Double cena;
	
	private Map<Long, String> pretplate = new LinkedHashMap<>();
	
	public TarifaDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Map<Long, String> getPretplate() {
		return pretplate;
	}

	public void setPretplate(Map<Long, String> pretplate) {
		this.pretplate = pretplate;
	}
	
	
}
