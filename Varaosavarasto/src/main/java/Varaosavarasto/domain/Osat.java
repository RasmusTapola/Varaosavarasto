package Varaosavarasto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Osat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private double price, weight;
	

	@Column(name = "production_year")
	private int year;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Autoid")
	private Auto auto;

	public Osat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Osat(String name, int year, double price, double weight) {
		super();
		this.name = name;
		this.weight = weight;
		this.year = year;
		this.price = price;
	}

	public Osat(String name, int year, double price, double weight, Auto auto) {
		super();
		this.name = name;
		this.weight = weight;
		this.year = year;
		this.price = price;
		this.auto = auto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	@Override
	public String toString() {
		return "Varaosa [id=" + id + ", year=" + year + ", price=" + price + ", weight=" + weight +", auto=" + auto + "]";
	}

//	@Override
//	public String toString() {
//		return "Car [brand=" + brand + ", model=" + model + ", color=" + color + ", registerNumber=" + registerNumber
//				+ ", year=" + year + ", price=" + price + "]";
//	}

}
