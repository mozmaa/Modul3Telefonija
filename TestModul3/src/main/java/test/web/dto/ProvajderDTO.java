package test.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;


public class ProvajderDTO {

	private Long id;
	
	private String naziv;
	
	private String adresa;
	
	private Map<Long, String> pretplate = new LinkedHashMap<>();

	public ProvajderDTO() {}

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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Map<Long, String> getPretplate() {
		return pretplate;
	}

	public void setPretplate(Map<Long, String> pretplate) {
		this.pretplate = pretplate;
	}
	
	
}
