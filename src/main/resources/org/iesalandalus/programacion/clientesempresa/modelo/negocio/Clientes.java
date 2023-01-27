package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;

public class Clientes {

	private int capacidad;
	private int tamano;
	private Cliente [] clientes;
	
	
	public Clientes (int capacidad) {
		
		if (capacidad > 0) {
			this.capacidad=capacidad;
			this.tamano=0;
		    clientes=new Cliente [capacidad];/*EN EL CONSTRUCTOR CLASE CREO EL ARRAY*/
		}
		else {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
	}
	

	
	public  void borrar(Cliente cliente) throws OperationNotSupportedException {
		
		if (cliente != null) {
			int posicion=0;
			boolean encontrado = false;
			
			int busqueda = buscarIndice(cliente);
			
			if (busqueda < tamano) {
				for (int indice=0;indice<tamano;indice++) {
					if (clientes[indice].equals(cliente)) {
						posicion=indice;}}
				desplazarUnaPosicionHaciaIzquierda(posicion);
			}
			else {
				throw new OperationNotSupportedException("ERROR: No existe ningún cliente como el indicado.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
	}
	
	public Cliente buscar(Cliente cliente) {
		for (int indice=0;indice<tamano;indice++) {
			if (clientes[indice].equals(cliente)) {
				return new Cliente(clientes[indice]);}}
		return null;}
	
	private int buscarIndice(Cliente cliente) {
		for (int indice=0;indice<tamano;indice++) {
			if (clientes[indice].equals(cliente)) {
				return indice;}}
		return tamano+1;}
	

	
	private boolean capacidadSuperada(int indice) {
		if (indice>capacidad) { return true;}
		else {return false;}}

	

	
	private Cliente [] copiaProfundaClientes () {
		Cliente [] copiaProfunda=new Cliente[this.tamano]; 
		for (int i=0; i<tamano;i++) {
			copiaProfunda [i]=new Cliente(this.clientes[i]);
		}
		return copiaProfunda;
		
	}

	public void  desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i=indice+1; i<tamano; i++) {
			clientes[i-1]=clientes[i];
		}
		tamano--;
	}

	
	public Cliente[] get() {
		return copiaProfundaClientes();}
	
	public int getCapacidad() {
		return capacidad;}
	
	public int getTamano() {
		return tamano;}
	
	public void insertar (Cliente cliente) throws OperationNotSupportedException {
		if (cliente != null) {
			if (tamano<capacidad) {
				
				int busqueda = buscarIndice(cliente);
				
				if (busqueda > tamano) {
					clientes[tamano]=cliente;
					tamano++;
				}
				else {
					throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese dni.");
				}
			}
			else {
				throw new OperationNotSupportedException("ERROR: No se aceptan más clientes.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
	}
		
	private boolean tamañoSuperado (int indice) {
		if (indice>tamano) { return true;}
		else {return false;}}
	
}
