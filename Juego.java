package HeroesYVillanos;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
	private ArrayList<String> personajes = new ArrayList<String>(); // De prueba
	private ArrayList<String> liga = new ArrayList<String>(); // De prueba

	public Juego() { // CONTRUCTOR DE PRUEBA // De prueba
		personajes.add("Juan");
		personajes.add("Pedro");
		liga.add("Liga1");
	}

	private boolean validaCadena(String s) {
		if (s.isBlank() || s.isEmpty())
			return false;
		return true;

	}
	
	private String ingresoTipo(String s) {
		boolean continua;
		Scanner leer =  new Scanner(System.in);
		int aux=0;
		String tipo="";
		System.out.print("Ingrese tipo de " + s +"(1)Heroe / (2)Villano : ");
		do {
			continua = false;
			try { // MANEJO DE EXCEPCION PARA EL CASO DE INGRESO DE STRING

				aux = Integer.parseInt(leer.nextLine()); // LO LEO COMO STRING PARA QUE LEA TODA LA LINEA Y NO DEJE NADA EN EL BUFFER

				while (aux != 1 && aux != 2) {
					System.out.print("La opcion ingresada es incorrecta, ingrese 1 para Heroe o 2 para Villano : ");
					aux = Integer.parseInt(leer.nextLine());
				}
				if (aux == 1)
					tipo = "Heroe";
				if (aux == 2)
					tipo = "Villano";

			} catch (Exception ex) {
				System.out.print("La opcion ingresada es incorrecta, ingrese 1 para Heroe o 2 para Villano : ");
				continua = true;
			}
		} while (continua == true);
		
		return tipo;
	}

	public void crearPersonaje() {
		String nombreReal, nombreFantasia, tipoDePersonaje;
		String msg = "";
		int aux, velocidad, fuerza, resistencia, destreza;
		boolean continua;

		Scanner leer = new Scanner(System.in);
		boolean valido;

		// INGRESO NOMBRE REAL
		System.out.print("Ingrese nombre del nuevo Personaje: ");
		nombreReal = leer.nextLine();

		do {
			valido = validaCadena(nombreReal);
			if (!valido)
				msg = "El nombre ingresado no es valido, ingrese uno valido: ";
			else {
				valido = !personajes.stream().anyMatch(nombreReal.trim()::equalsIgnoreCase); // VALIDA QUE NO EXISTE EL NOMBRE EN PERSONAJE IGNORANDO MAYUSCULAS Y MINUSCULAS trim() elimina espacios blanco en el inicio y fin
				if (!valido)
					msg = "El nombre ingresado ya existe, ingrese otro: ";
			}
			if (!valido) {
				System.out.print(msg);
				nombreReal = leer.nextLine();
			}
		} while (!valido);

		// INGRESO NOMBRE DE FANTASIA
		System.out.print("Ingrese nombre de fantasia del nuevo Personaje: ");
		nombreFantasia = leer.nextLine();
		do {
			valido = validaCadena(nombreFantasia);
			if (!valido)
				msg = "El nombre de fantasiao no es valido, ingrese uno valido: ";
			else {
				valido = !personajes.stream().anyMatch(nombreFantasia.trim()::equalsIgnoreCase); // VALIDA QUE NO EXISTE EL NOMBRE FANTASIA EN PERSONAJE IGNORANDO MAYUSCULAS Y  MINUSCULAS
				if (!valido)
					msg = "El nombre de fantasia ingresado ya existe, ingrese otro: ";
			}
			if (!valido) {
				System.out.print(msg);
				nombreFantasia = leer.nextLine();
			}
		} while (!valido);
		
		// INGRESO tipo de personaje. Heroe o Villano
		tipoDePersonaje=ingresoTipo("Personaje");
		

		// INGRESO CARACTERISTICAS // debo manejar las excepciones para numeros grandes
		// y cadenas
		System.out.print("Ingreso de caracteristicas del Personaje ");

		velocidad = ingresoCaracteristica("Velocidad");

		fuerza = ingresoCaracteristica("Fuerza");

		resistencia = ingresoCaracteristica("Resistencia");

		destreza = ingresoCaracteristica("Destreza");
	}

	private int ingresoCaracteristica(String s) {
		int aux = 0;
		boolean continua;
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese " + s + ": ");

		do {
			continua = false;
			try { // MANEJO DE EXCEPCION PARA EL CASO DE INGRESO DE STRING
				
				aux = Integer.parseInt(leer.nextLine());
				
				while (aux <= 0 || aux > 1000) {
					System.out.print("El valor de " + s + " es incorrecto, ingrese un nro entre 1 y 1000 : ");
					aux = Integer.parseInt(leer.nextLine());
				}
			} catch (Exception ex) {
				System.out.print("El valor de " + s + " es incorrecto, ingrese un nro entre 1 y 1000: ");
				continua = true;
			}
		} while (continua == true);
		
		return aux;
	}
	
	
	public void crearLiga() {
		String msg="", nombreLiga, tipoLiga, nombreAux;
		Scanner leer = new Scanner(System.in);
		boolean valido, continua;
		int aux=0;
		
		
		// INGRESO NOMBRE de LIGA
		System.out.print("Ingrese nombre de la nueva Liga: ");
		nombreLiga = leer.nextLine();

		do {
			valido = validaCadena(nombreLiga);
			if (!valido)
				msg = "El nombre de Liga ingresado no es valido, ingrese uno valido: ";
			else {
				valido = !liga.stream().anyMatch(nombreLiga.trim()::equalsIgnoreCase); // VALIDA QUE NO EXISTE EL NOMBRE EN LIGA IGNORANDO MAYUSCULAS Y MINUSCULAS trim() elimina espacios en blanco en el inicio y fin
				if (!valido)
					msg = "El nombre de Liga ingresado ya existe, ingrese otro: ";
			}
			if (!valido) {
				System.out.print(msg);
				nombreLiga = leer.nextLine();
			}
		} while (!valido);
		
		
		tipoLiga=ingresoTipo("Liga");
		
		
		//debo instanciar la liga antes de agregar
		
		//la liga ha sido creada
		
		//AGREGO PERSONAJE O LIGA
		
		System.out.println("AGREGAR PERSONAJES O LIGA A LA LIGA '" + nombreLiga + "' ");
		
		System.out.print("Presione 1 para agregar un Personaje o 2 para agregar una Liga: ");
		
		do {
			continua = false;
			try { // MANEJO DE EXCEPCION PARA EL CASO DE INGRESO DE STRING

				aux = Integer.parseInt(leer.nextLine()); // LO LEO COMO STRING PARA QUE LEA TODA LA LINEA Y NO DEJE NADA EN EL BUFFER

				while (aux != 1 && aux != 2) {
					System.out.print("La opcion ingresada es incorrecta, ingrese 1 para Personaje o 2 para Liga : ");
					aux = Integer.parseInt(leer.nextLine());
				}
			} catch (Exception ex) {
				System.out.print("La opcion ingresada es incorrecta,ingrese 1 para Personaje o 2 para Liga : ");
				continua = true;
			}
		} while (continua == true);
		
		
		if(aux==1)
		{
			System.out.print("Ingrese nombre de Personaje: ");
			nombreAux = leer.nextLine();
			if(this.validaCadena(nombreAux)&& personajes.stream().anyMatch(nombreAux.trim()::equalsIgnoreCase));
				
		}
	}

}
