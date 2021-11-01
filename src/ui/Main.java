package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Curso;
import model.Estudiante;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static Curso curso;

	public static void main(String [] juank) throws IOException {
		curso = new Curso("APOII", 3);
		Menu();
	}



	public static void Menu() throws IOException {
		int o = -1;
		do {

			System.out.print("======================================================================\n");
			System.out.print("Bienvinid@ a Eliminando Estudiantes con Estructuras Lineales Enlazadas\n");
			System.out.print("======================================================================\n");
			System.out.print("(1) Agregar estudiantes\n"
					+ "(2) Eliminar un estudiante\n"
					+ "(3) Imprimir la lista de estudiantes\n"
					+ "(0) Para salir\n"
					+ "Opcion: ");
			o = Integer.parseInt(br.readLine());

			switch(o){
			case 1:
				try {
					System.out.print("\n================================");
					System.out.print("Registra " + curso.getNumEstudiantes() + " estudiantes por favor");
					System.out.print("================================");
					addEstudiante(0);
				} catch (IOException e) {
					System.out.println("Por favor ingrese texto valido");
				}
				break;
			case 2:
				try {
					eliminarEstudiante();
				} catch (IOException e) {
					System.out.println("Por favor ingrese texto valido");
				}
				break;
			case 3:
				imprimirEstudiantes();
				break;
			default:
				o = 0;
				System.out.print("\n=================");
				System.out.print("\nHasta la proxima\n");
				System.out.print("=================\n");
				break;
			}

		} while(o != 0);
	}


	public static void addEstudiante(int i) throws IOException {
		
		if (i<curso.getNumEstudiantes()) {
			
			System.out.print("\nCodigo: ");
			String code = br.readLine();
			System.out.print("Nombre: ");
			String name = br.readLine();

			Estudiante nuevo = new Estudiante(code, name);
			curso.addEstudiante(nuevo);
			addEstudiante(i+1);
		}


	}


	public static void eliminarEstudiante() throws IOException {
		System.out.print("Codigo del Estudiante: ");
		String code = br.readLine();

		int confirmation = curso.eliminarEstudiantes(code);
		if(confirmation == 1) {
			System.out.println("===========================================");
			System.out.println("Se ha eliminado correctamente el estudiante");
			System.out.println("===========================================\n");
		} else if(confirmation == 2){
			System.out.println("=============================================");
			System.out.println("=======No hay estudiantes registrados========");
			System.out.println("Intentalo cuando hayas registrado estudiantes");
			System.out.println("=============================================\n");
		}else {
			System.out.println("=====================================");
			System.out.println("No existen estudiantes con ese codigo");
			System.out.println("=====================================\n");
		}
	}


	public static void imprimirEstudiantes() {
		System.out.println("==============================");
		System.out.println("=====Estudiantes Actuales=====");
		
		System.out.println(curso.pintarGeneral());
		System.out.print("==============================\n");
		
	}


}
