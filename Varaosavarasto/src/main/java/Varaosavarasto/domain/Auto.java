package Varaosavarasto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Auto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 1, max = 30)
	private String Nimi;
	@Size(min = 1, max = 30)
	private String Merkki;
	@Size(min = 1, max = 30)
	private String Malli;

	@Min(value = 0, message = "min value is 0")
	@Max(value = 2024000, message = "max value is 202400")
	private int yob;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "auto")
	private List<Osat> osat;

	public Auto() {
		super();
	}

	public Auto(String nimi, String merkki, String malli, int yob) {
		super();
		this.Nimi = nimi;
		this.Merkki = merkki;
		this.Malli = malli;
		this.yob = yob;
	}

	public Auto(String nimi, String merkki, String malli, int yob, List<Osat> osat) {
		super();
		this.Nimi = nimi;
		this.Merkki = merkki;
		this.Malli = malli;
		this.yob = yob;
		this.osat = osat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Nimi;
	}

	public void setName(String name) {
		this.Nimi = name;
	}

	public String getMerkki() {
		return Merkki;
	}

	public void setMerkki(String merkki) {
		this.Merkki = merkki;
	}

	public String getMalli() {
		return Malli;
	}

	public void setMalli(String malli) {
		this.Malli = malli;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}

	public List<Osat> getOsat() {
		return osat;
	}

	public void setCars(List<Osat> osat) {
		this.osat = osat;
	}

//	@Override
//	public String toString() {
//		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", ssn="
//				+ ssn + ", yob=" + yob + ", cars=" + cars + "]";
//	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", Name=" + Nimi + ", Mark=" + Merkki + ", type=" + Malli+ ", yob=" + yob + "]";
	}

}
