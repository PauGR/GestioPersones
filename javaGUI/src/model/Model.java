package model;

import java.util.LinkedList;

public class Model extends LinkedList<Persona> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index;
	private int totalReg = 0;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void add(int index, Persona s) {
		super.add(index, s);
	}

	public int getTotalReg() {
		return totalReg;
	}

	public void setTotalReg(int totalReg) {
		this.totalReg = totalReg;
	}

	public Model getDades() {
		return this;
	}

}
