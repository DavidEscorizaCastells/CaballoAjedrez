package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;
	
	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		if (fila>=1 && fila <=8) {
			this.fila = fila;
		} else {
			throw new IllegalArgumentException ("La fila no es correcta. Debe ser un número entre 1 y 8");
		}
	}
	
	public char getColumna() {
		return columna;
	}
	
	public void setColumna(char columna) {
		if (Character.toLowerCase(columna)>='a' && Character.toLowerCase(columna)<='h') {
			this.columna = columna;
		} else {
			throw new IllegalArgumentException ("La columna no es correcta. Debe ser una letra entre a y h");
		}
	}
	
	public Posicion (int fila, char columna) {
		if (fila>=1 && fila<=8 && Character.toLowerCase(columna)>='a' && Character.toLowerCase(columna)>='h') {
			this.fila=fila;
			this.columna=columna;
		} else {
			throw new IllegalArgumentException("La posición no existe. La fila debe ser entre 1 y 8 y la columna entre a y h.");
		}
	}
}
