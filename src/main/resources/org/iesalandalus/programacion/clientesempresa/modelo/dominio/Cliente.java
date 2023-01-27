package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Cliente {
	
	
	private static final String ER_CORREO="[A-Za-z._]+@[A-Za-z]+\\.[A-Za-z]{2,3}"; 
	private static final String ER_DNI= "([0-9]{8})([a-zA-Z])";
	private static String ER_TELEFONO= "[0-9]{9}";
	public  static String FORMATO_FECHA="DD/MM/YYYY";
	
	private String nombre;
	private String dni;
	private String correo;
	private String telefono;
	private LocalDate fechaNacimiento;
	

	
	public Cliente (Cliente cliente) {
		
		setNombre(cliente.getNombre());
		setDni (cliente.getDni());
		setCorreo (cliente.getCorreo());
		setTelefono (cliente.getTelefono());
		setFechaNacimiento (cliente.getFechaNacimiento());}
	
	public  Cliente (String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
		
		setNombre(nombre);
		setDni (dni);
		setCorreo (correo);
		setTelefono (telefono);
		setFechaNacimiento (fechaNacimiento);}
	
	public boolean comoprobarLetraDni(String dni){
		int resto=0;
		char letra = 0;
		String letrasDni="TRWAGMYFPDXBNJZSQVHLCKE";
		String numerado=dni.substring(0, 8);
		String dni2=dni.substring(0,8)+dni.substring(8).toUpperCase();
		int numeracion= Integer.parseInt(numerado);
		resto=numeracion % 23;
		letra=letrasDni.charAt(resto);
	
		if (letra==dni2.charAt(8)) { return true;}
		else {return false;}}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);}

	
	private void formatoNombre () {
	
	    String formatoNombre=nombre.substring(0, 1).toUpperCase()+nombre.substring(1).toLowerCase();
	    System.out.println( "El nombre es: "+ formatoNombre);}	
	
	
	public String getCorreo() {
		return correo;}
	
	
	public String getDni() {
		return dni;}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;}
	
	
	
	public String getIniciales() {
		String c = "";
		String[] palabras=nombre.split("\\s");
		
		for (int i = 0; i < palabras.length; i++) {
			if (!palabras[i].equals(""))
				c = c + palabras[i].charAt(0);
		}
		System.out.println("Iniciales: " + c.toUpperCase());
		return c;
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);}
	
	public void setCorreo(String correo) {
		if (correo == null) { throw new NullPointerException("ERROR: El correo de un cliente no puede ser nulo.");}
		if (correo.equals("")) { throw new IllegalArgumentException("ERROR: El correo del cliente no tiene un formato válido.");}
		else if (!correo.matches(ER_CORREO)) { throw new IllegalArgumentException("ERROR: El correo del cliente no tiene un formato válido.");}
		else {this.correo = correo;}}
	
	public void setDni(String dni) {
		if (dni == null) { throw new NullPointerException("ERROR: El dni de un cliente no puede ser nulo.");}
		if (dni.equals("")) { throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");}
		else if (!dni.matches(ER_DNI)) { throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");}
		else {this.dni = dni;};}
	
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento==null) { throw new IllegalArgumentException ("ERROR: Debe introducir una fecha de nacimiento");}
		if (fechaNacimiento.equals("")) { throw new IllegalArgumentException("ERROR: La fecha de nacimiento del cliente no tiene un formato válido.");}
		else {this.fechaNacimiento = fechaNacimiento;}}

	
	public void setNombre(String nombre){
		
		nombre = nombre.trim().replaceAll("\\s{2,}"," ");
		boolean caracteres=true;
		boolean espacio = false;
		String nombreConvertido = "";
		
		if (nombre==null) { throw new IllegalArgumentException ("ERROR: Debe introducir el nombre");}
		if (nombre.equals("")) { throw new IllegalArgumentException("ERROR: El nombre del cliente no tiene un formato válido.");}
		else {		
			do { for (int i=0;i<nombre.length();i++) {
			if ((nombre.charAt(i)<='Z' && nombre.charAt(i)>='A')||nombre.charAt(i)==' '
				||(nombre.charAt(i)>='a' && nombre.charAt(i)<='z')
				||(nombre.charAt(i) == 'á')||(nombre.charAt(i) == 'é')||(nombre.charAt(i) == 'í')
				||(nombre.charAt(i) == 'ó')||(nombre.charAt(i) == 'ú'))
				{
				caracteres=true;
				
				if (i == 0 || espacio == true) {
					nombreConvertido = nombreConvertido + Character.toUpperCase(nombre.charAt(i));
					espacio = false;
				}
				else {
					nombreConvertido = nombreConvertido + Character.toLowerCase(nombre.charAt(i));
				}
				
				
				if (nombre.charAt(i) == ' ') {
					espacio = true;
				}
				}
				else {
				caracteres=false; System.out.println("nombre erroneo");
				}}} while (!caracteres);
		
	
			if (caracteres == true) {
			this.nombre=nombreConvertido;
		}}
	}
		


	public void setTelefono(String telefono) {
		if (telefono == null) { throw new NullPointerException ("ERROR: El teléfono de un cliente no puede ser nulo.");}
		if (telefono.equals("")) { throw new IllegalArgumentException ("ERROR: El teléfono del cliente no tiene un formato válido.");}
		else if (!telefono.matches(ER_TELEFONO)) {throw new IllegalArgumentException ("ERROR: El teléfono del cliente no tiene un formato válido.");}
		else {this.telefono = telefono;}}

	@Override
	public String toString() {
		
		
		return "nombre=" + nombre + "(" + getIniciales() + "), DNI=" + dni + ", correo=" + correo + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento;
	}
}
















	

	
	


