package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	static Caballo caballo=new Caballo();
	
	public static void main(String[] args) {
		int opcion=0;
		
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
		do {
			mostrarMenu();
			opcion=elegirOpcion();
			ejecutarOpcion(opcion);
		} while (opcion!=0);
		
	}
	
	private static void mostrarMenu() {
		System.out.println("MENÚ");
		System.out.println("----");
		System.out.println("1. Crear caballo por defecto (Negro posición 8b).");
		System.out.println("2. Crear caballo de un color. ");
		System.out.println("3. Crear caballo de un color en una columna inicial válida.");
		System.out.println("4. Mover el caballo.");
		System.out.println("0. Salir");
	}
	
	private static int elegirOpcion() {
		System.out.println("Selecciona una opción:");
		int opcion=Entrada.entero();
		while (opcion<0 || opcion>4) {
			System.out.println("Opción inválida. Seleccione una opción (0-4):");
			opcion=Entrada.entero();
		}
		return opcion;		
	}
	
	private static void ejecutarOpcion(int opcion) {
		switch (opcion){
		case 1:
			crearCaballoDefecto();
			break;
		case 2:
			crearCaballoDefectoColor();
			break;
		case 3:
			crearCaballoColorPosicion();
			break;		
		case 4:
			System.out.println(caballo.toString());
			mover();
			break;
		case 0:
		
		}
	}
	
	private static void crearCaballoDefecto() {
		caballo=new Caballo();
		System.out.println(caballo.toString());
	}
	
	private static void crearCaballoDefectoColor() {
		Color color=elegirColor();
		caballo=new Caballo(color);
		System.out.println(caballo.toString());
	}
	
	private static Color elegirColor() {
		
		System.out.print("Escribe 1 si quieres que el caballo sea Blanco y 2 para que el caballo sea Negro: ");
		int opcion=Entrada.entero();
		while (opcion!=1 && opcion!=2) {
			System.out.print("Opción inválida. Debe introducir un 1 para Blanco o un 2 para Negro: ");
			opcion=Entrada.entero();
		}
		return opcion==1?Color.BLANCO:Color.NEGRO;
	}
	
	private static void crearCaballoColorPosicion() {
		Color color=elegirColor();
		char columna=elegirColumnaInicial();
		try {
			caballo=new Caballo (color, columna);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(caballo.toString());
		
	}
	
	private static char elegirColumnaInicial() {
		System.out.print("Seleccione una columna inicial. Recuerda que ebe ser b o g: ");
		char columna=Entrada.caracter();
		return columna;
	}
	
	private static void mover() {
		mostrarMenuDirecciones();
		try {
			caballo.mover(elegirDireccion());
			System.out.println(caballo.toString());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void mostrarMenuDirecciones() {
		System.out.println("1. Arriba-Izquierda.");
		System.out.println("2. Arriba-Derecha.");
		System.out.println("3. Derecha-Arriba.");
		System.out.println("4. Derecha-Abajo.");
		System.out.println("5. Abajo-Derecha.");
		System.out.println("6. Abajo-izquierda.");
		System.out.println("7. Izquierda-Arriba.");
		System.out.println("8. Izquierda-Abajo.");
	}
	
	private static Direccion elegirDireccion() {
		Direccion direccion=Direccion.ABAJO_DERECHA;
		System.out.println("Selecciona una dirección:");
		int opcion=Entrada.entero();
		while (opcion<1 || opcion>8) {
			System.out.println("Opción inválida. Seleccione una dirección (1-8):");
			opcion=Entrada.entero();
		}
		switch (opcion) {
			case 1:
				direccion=Direccion.ARRIBA_IZQUIERDA;
				break;
			case 2:
				direccion=Direccion.ARRIBA_DERECHA;
				break;
			case 3:
				direccion=Direccion.DERECHA_ARRIBA;
				break;
			case 4:
				direccion=Direccion.DERECHA_ABAJO;
				break;
			case 5:
				direccion=Direccion.ABAJO_DERECHA;
				break;
			case 6:
				direccion=Direccion.ABAJO_IZQUIERDA;
				break;
			case 7:
				direccion=Direccion.IZQUIERDA_ARRIBA;
				break;
			case 8:
				direccion=Direccion.IZQUIERDA_ABAJO;
				break;
		}
		return direccion;
		
	}
}