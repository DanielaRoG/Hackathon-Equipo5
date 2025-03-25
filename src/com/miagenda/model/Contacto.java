package com.miagenda.model;

import java.util.Objects;

public class Contacto implements Comparable<Contacto> {
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor principal
    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y apellido no pueden estar vacíos.");
        }
        if (!esNombreValido(nombre) || !esNombreValido(apellido)) {
            throw new IllegalArgumentException("El nombre y apellido solo pueden contener letras y espacios.");
        }
        if (!esTelefonoValido(telefono)) {
            throw new IllegalArgumentException("El número de teléfono debe tener exactamente 10 dígitos y no debe incluir letras ni caracteres especiales.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    // Método para validar que el nombre y apellido solo contengan letras y espacios
    private boolean esNombreValido(String nombre) {
        return nombre != null && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    // Método para validar el teléfono
    private boolean esTelefonoValido(String telefono) {
        // El teléfono debe ser un número de exactamente 10 dígitos
        return telefono != null && telefono.matches("\\d{10}");
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }


    // Settel para modificar el número de teléfono, con validación
    public void setTelefono(String telefono) {
        if (!esTelefonoValido(telefono)) {
            throw new IllegalArgumentException("El número de teléfono debe tener exactamente 10 dígitos y no debe incluir letras ni caracteres especiales.");
        }
        this.telefono = telefono;
    }

    // Sobrescritura de equals para comparar objetos Contacto
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return nombre.equalsIgnoreCase(contacto.nombre) && apellido.equalsIgnoreCase(contacto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    // Método compareTo para ordenar los Contactos por nombre y apellido
    @Override
    public int compareTo(Contacto otro) {
        int comparacion = this.nombre.compareToIgnoreCase(otro.nombre);
        return comparacion != 0 ? comparacion : this.apellido.compareToIgnoreCase(otro.apellido);
    }

    // Método toString para representar el contacto en formato cadena
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}
