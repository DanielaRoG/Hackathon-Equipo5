package com.miagenda.service;

import com.miagenda.model.Contacto;
import java.util.*;

public class Agenda {
    private Set<Contacto> contactos;
    private int capacidadMaxima;

    // Constructor con capacidad máxima definida
    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new HashSet<>();
    }

    // Constructor con capacidad máxima por defecto (10)
    public Agenda() {
        this(10);
    }

    // Método para añadir un contacto
    public boolean añadirContacto(Contacto c) {
        if (contactos.size() >= capacidadMaxima) {
            System.out.println("La agenda está llena.");
            return false;
        }
        if (contactos.contains(c)) {
            System.out.println("El contacto ya existe en la agenda.");
            return false;
        }
        contactos.add(c);
        return true;
    }

    // Método para verificar si un contacto existe en la agenda
    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    // Método para listar todos los contactos ordenados alfabéticamente
    public void listarContactos() {
        List<Contacto> listaOrdenada = new ArrayList<>(contactos);
        Collections.sort(listaOrdenada);
        listaOrdenada.forEach(System.out::println);
    }

    // Método para buscar un contacto por nombre y apellido
    public void buscarContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Método para eliminar un contacto de la agenda
    public boolean eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado exitosamente.");
            return true;
        }
        System.out.println("El contacto no existe en la agenda.");
        return false;
    }

    // Método para modificar el teléfono de un contacto
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        // Validación: verificar si el teléfono tiene exactamente 10 dígitos y solo números
        if (!esTelefonoValido(nuevoTelefono)) {
            System.out.println("Error: El número de teléfono debe contener exactamente 10 dígitos y no debe incluir letras ni caracteres especiales.");
            return;
        }

        // Verificar si el contacto existe antes de modificar el teléfono
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado.");
                return;
            }
        }
        System.out.println("El contacto no existe.");
    }

    // Método para verificar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    // Método para obtener el número de espacios libres en la agenda
    public int espacioLibres() {
        return capacidadMaxima - contactos.size();
    }

    // Método auxiliar para validar el formato del teléfono
    private boolean esTelefonoValido(String telefono) {
        // El teléfono debe ser un número de exactamente 10 dígitos
        return telefono != null && telefono.matches("\\d{10}");
    }
}
