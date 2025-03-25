package employee;

public class EmployeeMain {
    public static void main(String[] args) {
// Vamos a instanciar lo que hicimos en la Classe "Employee"
Employee andrea = new Employee("andrea", "esc", 26, 50000, "frontend");

Employee dani = new Employee("dani", "maldonado", 38, 100000d, "developer");


// probando metodos
        andrea.getFullName();
        System.out.println(andrea.getFullName());

        System.out.println("hola " + andrea.getFullName() + ", tienes : " + andrea.getAge() + "años y te faltan: " + andrea.getYearsForRetirement() + " años para el retiro laboral");

        System.out.println(dani.increaseSalary(10d));
        System.out.println(andrea.getPositionEmployee());

        //Imprimir toda la instancia
        System.out.println(andrea);


    }
}
