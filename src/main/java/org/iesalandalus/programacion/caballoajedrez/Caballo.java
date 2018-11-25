package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

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
	
	public Caballo(Caballo otroCaballo) {
		this.color=otroCaballo.color;
		this.posicion=otroCaballo.posicion;
	}
	
	public void mover(Direccion direccion) throws OperationNotSupportedException {
		switch (direccion) {
			case ARRIBA_IZQUIERDA:
				if(posicion.getFila()+2<=8 && posicion.getColumna()-1>='a') {
					posicion.setFila(posicion.getFila()+2);
					posicion.setColumna((char)(posicion.getColumna()-1));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
			case ARRIBA_DERECHA:
				if(posicion.getFila()+2<=8 && posicion.getColumna()+1>='h') {
					posicion.setFila(posicion.getFila()+2);
					posicion.setColumna((char)(posicion.getColumna()+1));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
			case DERECHA_ARRIBA:
				if(posicion.getFila()+1<=8 && posicion.getColumna()+2>='h') {
					posicion.setFila(posicion.getFila()+1);
					posicion.setColumna((char)(posicion.getColumna()+2));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
			case DERECHA_ABAJO:
				if(posicion.getFila()-1<=1 && posicion.getColumna()+2>='h') {
					posicion.setFila(posicion.getFila()-1);
					posicion.setColumna((char)(posicion.getColumna()+2));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
			case ABAJO_DERECHA:
				if(posicion.getFila()-2<=1 && posicion.getColumna()+1>='h') {
					posicion.setFila(posicion.getFila()-2);
					posicion.setColumna((char)(posicion.getColumna()+1));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
			case ABAJO_IZQUIERDA:
				if(posicion.getFila()-2<=1 && posicion.getColumna()-1>='a') {
					posicion.setFila(posicion.getFila()-2);
					posicion.setColumna((char)(posicion.getColumna()-1));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
			case IZQUIERDA_ARRIBA:
				if(posicion.getFila()+1<=8 && posicion.getColumna()-2>='a') {
					posicion.setFila(posicion.getFila()+1);
					posicion.setColumna((char)(posicion.getColumna()-2));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
			case IZQUIERDA_ABAJO:
				if(posicion.getFila()-1<=1 && posicion.getColumna()-2>='a') {
					posicion.setFila(posicion.getFila()-1);
					posicion.setColumna((char)(posicion.getColumna()-2));
				} else {
					throw new OperationNotSupportedException ("El movimiento no puede realizarse.");
				}
				break;
		}
		
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Caballo) {
			Caballo otroCaballo=(Caballo) objeto;
			if (color==otroCaballo.color && posicion.equals(otroCaballo.getPosicion())) {
				return true;
			}
		}
		return false;
	}
}
