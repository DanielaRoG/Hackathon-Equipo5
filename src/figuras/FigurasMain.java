package figuras;

public class FigurasMain {
    public static void main(String[] args) {

        Figuras rectanguloAzul = new Figuras(20d,50d);
        Figuras circuloBlanco = new Figuras(10d);
        Figuras trianguloMorado = new Figuras(50,12);


        System.out.println(rectanguloAzul);
        System.out.println(circuloBlanco);
        System.out.println(trianguloMorado.areaTriangulo()); // output: 300
        System.out.println(rectanguloAzul.areaRectangulo()); //output : 1000
        System.out.println(circuloBlanco.areaCircunferencia()); //output: 314.159
    }
}
