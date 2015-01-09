package model;

public class Persona {
	private String dni;
	private String nom;
	private String cognom1;
	private String cognom2;
	private int edat;
	
	
	public Persona(String d,String n, String c1, String c2, int edat ){
		this.dni=d;
		this.nom=n;
		this.cognom1=c1;
		this.cognom2=c2;
		this.edat=edat;
	}
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognom1() {
		return cognom1;
	}
	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}
	public String getCognom2() {
		return cognom2;
	}
	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	
	
	
}
