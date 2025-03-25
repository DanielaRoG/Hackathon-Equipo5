package employee;

public class Employee {
    // 1. Atributos (variables de instacia)
    String firstName;
    String lastName;
    int age;
    double salary;
    String position;

// 2. Metodo constructor
    public Employee(String firstName, String lastName, int age, double salary, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

// Al activar estos metodos, se tiene que hacer en orden de como los pusimos, en la parte "public employee" que son los parametros del metodo, si no se hace en ese orden seria error.

        // 3. Metodo de acceso y modificacion
    // Generacion automatica : click derecho -> generate -> getter and setter
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
        this.firstName = firstName;
        }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // 4. Metodo especifico del objeto
    //-- Metodo para obtener el nombre completo
    public String getFullName(){
        return firstName + " " + lastName;

    }

    // Metodo para calcular los años restantes para jubilacion (60)
    public int getYearsForRetirement() {
        return 60 - age;
    }

    // Metodo para calcular salario con un incremento salarial basado en un porcentaje (salario = salario base + 10%) $100000 + 10% =1110000
    public double increaseSalary(double percentage){
       double increase = salary * (percentage / 100);
        return salary += increase;
    }

    // Metodo para mostrar la posicion del empleado
    public String getPositionEmployee() {
        return "Employee: " + getFullName() + " -> Position: " + position;
    }

    //5. Sobreescribir el metodo toString() de object
    @Override
    public String toString() {
        return "FirstName: " + firstName + ", LastName: " + lastName + ", Age: " + age + ", Salary: " + salary + ", Position: " + position;
    }
}
