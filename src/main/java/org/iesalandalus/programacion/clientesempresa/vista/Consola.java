package org.iesalandalus.programacion.clientesempresa.vista;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.iesalandalus.programacion.clientesempresa.MainApp;
import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	public Consola() {}
	
	
	public void mostrarMenu() {
		
		System.out.println( " Debe elegir entre las siguientes opciones:  "
				+ "INSERTAR"
				+ "BUSCAR "
				+ "BORRAR"
				+ "MOSTRAR TODOS LOS CLIENTES"
				+ "MOSTRAR LOS CLIENTES QUE HAN NACIDO ENTRE FECHAS"
				+ "SALIR");
	}
	
	public Opcion elegirOpcion() {
		
		System.out.println(" Introduce la opcion");

		int opcion=Entrada.entero();
	
		
		if (opcion==1) {return Opcion.INSERTAR_CLIENTE;}
		if (opcion==2) {return Opcion.BUSCAR_CLIENTE;}
		if (opcion==3) {return Opcion.BORRAR_CLIENTE;}
		if (opcion==4) {return Opcion.MOSTRAR_CLIENTES;}
		if (opcion==5) {return Opcion.MOSTRAR_CLIENTES_FECHA;}
		if (opcion==6) {return Opcion.SALIR;}
		else return null;
	
	}
	
	public static Cliente leerCliente() {
		
		Cliente cliente=null;
		
		try {
		
		System.out.println(" Introduce el nombre del cliente");
		String nombre=Entrada.cadena();
		
		
		System.out.println(" Introduce el dni del cliente");
		String dni= Entrada.cadena();
		
		System.out.println(" Introduce el correo del cliente");
		String correo= Entrada.cadena();
		
		System.out.println(" Introduce el fecha nacimiento del cliente");
		String fechaNacimiento= Entrada.cadena();
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(Cliente.FORMATO_FECHA);
		LocalDate fechaConvertida=LocalDate.parse(fechaNacimiento, formatoFecha);
		
		System.out.println(" Introduce el telefono del cliente");
		String telefono= Entrada.cadena();
		

		cliente= new Cliente (nombre, dni, correo, telefono, fechaConvertida);}
		
		catch (IllegalArgumentException | NullPointerException e) {
			
			System.out.print("ERROR: Faltan datos obligatorios para el alta");
		}
		return cliente;}
		 
		
	
	public Cliente leerClienteDni () {
		Cliente cliente=null;
		System.out.println(" INTRODUCIR NIF CLIENTE");
		String nifCliente=Entrada.cadena();
		boolean existe=false;
		
		for (int i=0;i<MainApp.clientes.getTamano();i++) {
			
			if (nifCliente.equals(MainApp.clientes.get()[i].getDni())){
				cliente= MainApp.clientes.get()[i]; existe=true; }}
			if (existe==false) {throw new NullPointerException (" error en los datos de entrada");}
		
		return cliente;
	}
	
	public LocalDate leerFechaNacimiento() {
		
		String fechaIntroducida="";
		LocalDate fechaConvertida=null;
		
		do {System.out.println("Introduce una fecha");
		fechaIntroducida= Entrada.cadena();
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(Cliente.FORMATO_FECHA);
		fechaConvertida=LocalDate.parse(fechaIntroducida, formatoFecha);
		}while (fechaIntroducida.isEmpty());
		
		return fechaConvertida;
	}
	
}
	
	
		
		
		
	
