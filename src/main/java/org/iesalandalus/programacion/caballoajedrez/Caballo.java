package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {
	private Color color;
	private Posicion posicion;
	
	public Color getColor() {
		return color;
	}
	
	private void setColor(Color color) {
		this.color = color;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Caballo () {
		color=Color.NEGRO;
		posicion=new Posicion(8,'b');
	}
	
	public Caballo(Color color) {
		this.color=color;
		if (color==color.BLANCO) {
			posicion=new Posicion(1,'b');
		} else {
			posicion=new Posicion(8,'b');
		}
	}
	
	public Caballo(Color color, char columna) {
		if (Character.toLowerCase(columna)=='b' || Character.toLowerCase(columna)=='g') {
			this.color=color;
			if (color==Color.NEGRO) {
				posicion=new Posicion(8, columna);
			} else {
				posicion=new Posicion(1, columna);
			}
		} else {
			throw new IllegalArgumentException ("La columna es inválida. Debe ser b o g");
		}
	}
	
	
}
