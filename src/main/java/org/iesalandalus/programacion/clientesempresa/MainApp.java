package org.iesalandalus.programacion.clientesempresa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.clientesempresa.modelo.negocio.Clientes;
import org.iesalandalus.programacion.clientesempresa.vista.Consola;
import org.iesalandalus.programacion.clientesempresa.vista.Opcion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	private final int NUM_MAX_CLIENTES=5;
	public static Clientes clientes;
	
	private void borrarCliente() throws OperationNotSupportedException {
		
		System.out.println(" Introducir el DNI");
		String clienteIntroducido=Entrada.cadena();
		boolean existe=false;
		for (int i=0;i<clientes.getTamano();i++) {
			if(clienteIntroducido.equals(clientes.get()[i].getDni())) {
				clientes.borrar(clientes.get()[i]);
				existe=true;}}
		if(existe==false) {System.out.println("El cliente no existe con dni y no se puede borrar");}
		}
	
	private void insertarCliente() throws OperationNotSupportedException{
		Cliente nuevoCliente=Consola.leerCliente();
		boolean existe=false;
		for (int i=0;i<clientes.getTamano() && existe==false;i++) {
			if(nuevoCliente.getDni().equals(clientes.get()[i].getDni())) {
				existe=true;}}
		if (existe==false) { clientes.insertar(nuevoCliente);}
		else {System.out.println("Ya existe el cliente con dni y no se puede insertar");
		}}
		
		
	private void buscarCliente() {
		
		System.out.println(" Introducir el DNI");
		String clienteIntroducido=Entrada.cadena();
		boolean existe=false;
		for (int i=0;i<clientes.getTamano();i++) {
			if(clienteIntroducido.equals(clientes.get()[i].getDni())) {
				System.out.println(clientes.get()[i].toString());
				existe=true;}}
		if(existe==false) {System.out.println("El cliente no existe con dni y no se puede buscar");}
			
	}
	
	private void mostrarClientes() {
		
		if (clientes.getTamano()>0) {
			for(int i=0; i<clientes.getTamano();i++) {
				System.out.println(clientes.get()[i].toString());} 
		} else { System.out.println("No hay clientes en la lista");	}
	}
	
	private void mostrarClientesFecha (){
		System.out.println(" Introduce la fecha de nacimiento del cliente");
		String fechaIntroducida=Entrada.cadena();
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(Cliente.FORMATO_FECHA);
		LocalDate fechaConvertida=LocalDate.parse(fechaIntroducida, formatoFecha);
		boolean existe=false;
		
		for(int i=0; i<clientes.getTamano();i++) {
			if (fechaConvertida.equals(clientes.get()[i].getFechaNacimiento())) {
				System.out.println(clientes.get()[i].toString());
				existe=true;}}
		
			if (existe==false) {System.out.println("No existen clientes con esa fecha de nacimiento");}
	}
	
	private void ejecutarOpcion(Opcion opcion) throws OperationNotSupportedException {
		
		switch (opcion) {
		
		case BORRAR_CLIENTE:borrarCliente();break;
		case BUSCAR_CLIENTE:buscarCliente();break;
		case INSERTAR_CLIENTE:insertarCliente();break;
		case MOSTRAR_CLIENTES:mostrarClientes();break;
		case MOSTRAR_CLIENTES_FECHA:mostrarClientesFecha();break;
		case SALIR:break;
		}
	}
		
	
	public static void main(String[] args) {
		
		
		
		
	}

}