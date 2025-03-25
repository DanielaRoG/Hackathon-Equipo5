package com.miagenda.main;

import com.miagenda.model.Contacto;
import com.miagenda.service.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Verificar si la agenda está llena");
            System.out.println("7. Ver espacio disponible");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine().trim();
                    System.out.print("Teléfono (10 dígitos): ");
                    String telefono = scanner.nextLine().trim();

                    try {
                        // Intentamos añadir el contacto
                        boolean añadidoExitoso = agenda.añadirContacto(new Contacto(nombre, apellido, telefono));

                        // Si se añadió correctamente, mostramos el mensaje de éxito
                        if (añadidoExitoso) {
                            System.out.println("Contacto añadido exitosamente.");
                        }
                    } catch (IllegalArgumentException e) {
                        // Si hay un error (por ejemplo, si el teléfono no es válido), mostramos el mensaje de error
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    agenda.listarContactos();
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String buscarNombre = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String buscarApellido = scanner.nextLine().trim();
                    agenda.buscarContacto(buscarNombre, buscarApellido);
                    break;

                case 4:
                    System.out.print("Nombre: ");
                    String eliminarNombre = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String eliminarApellido = scanner.nextLine().trim();
                    Contacto contactoEliminar = new Contacto(eliminarNombre, eliminarApellido, "");

                    if (agenda.eliminarContacto(contactoEliminar)) {
                        System.out.println("Contacto eliminado correctamente.");
                    } else {
                        System.out.println("El contacto no se encontró en la agenda.");
                    }
                    break;

                case 5:
                    System.out.print("Nombre: ");
                    String modNombre = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String modApellido = scanner.nextLine().trim();
                    System.out.print("Nuevo teléfono (10 dígitos): ");
                    String nuevoTelefono = scanner.nextLine().trim();

                    try {
                        agenda.modificarTelefono(modNombre, modApellido, nuevoTelefono);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "Aún hay espacio.");
                    break;

                case 7:
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
