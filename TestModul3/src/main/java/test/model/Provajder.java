package test.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Provajder {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String adresa;
	
	@OneToMany (mappedBy = "provajder" , fetch = FetchType.EAGER)
	private List<Pretplata> pretplate = new ArrayList<>();
	
	public Provajder () {}

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

	public List<Pretplata> getPretplate() {
		return pretplate;
	}

	public void setPretplate(List<Pretplata> pretplate) {
		this.pretplate = pretplate;
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
		Provajder other = (Provajder) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Provajder [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + "]";
	}
	
	
}
