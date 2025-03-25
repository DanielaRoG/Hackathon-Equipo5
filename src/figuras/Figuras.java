package figuras;

// Objeto base para diferentes figuras y el calculo de propiedades geometricas (area)
public class Figuras {
    // 1. Atributos (Variables de instancia)
    double base;
    double altura;
    double radio;

    // 2  constructores
    // este constructor es para figuras que solo se usa base y altura
    // Overloading, permite que tengan el mismo nombre, pero tendra diferentes firmas que serian diferentes parametros, como 
    public Figuras(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
// este constructor solo recibe el radio
    public Figuras(double radio) {
        this.radio = radio;
    }

    // 3. Getter and Setter
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }


    // 4. Métodos específicos de Figuras
// Calcular área de Rectángulo
    public double areaRectangulo() {
        return base * altura;
    }

    // Calcular área de Triángulo
    public double areaTriangulo() {
        return (base * altura) / 2;
    }

    // Calcula área de Circunferencia
    public double areaCircunferencia(){
        return Math.PI * Math.pow(radio, 2);
    }

// 5 .toString
    @Override
    public String toString() {
        if (radio != 0) {
            return "Radio: " + radio;
        } else {
            return "Base: " + base + "Altura: " + altura;
        }
    }



} // Class
