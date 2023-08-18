import java.util.Scanner;
public class Main {
    // Actividad 1: Invertir cadena de texto
    public static String invertir_cadena(String cadena){
        String cadena_invertida="";
        int ultimo_indice=cadena.length()-1;
        for(int i=ultimo_indice;i>=0;i--){
            cadena_invertida+=cadena.charAt(i); // Se le suma el carácter de la posición i
        }
        return cadena_invertida;
    }

    // Actividad 2: Suma de todos los números pares
    public static void sumar_pares(){
        int[] arreglo={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int acumulador=0;
        for(int i=0;i<arreglo.length;i++){
            if(arreglo[i]%2==0){ // Si es divisible por 2, es número es par y su valor se acumulará
                acumulador+=arreglo[i];
            }
        }
        System.out.println("La suma de todos los números pares del arreglo es " + acumulador);
    }

    // Actividad 3: Calcular promedio
    public static double sum(double[] notas){
        double suma=0.0;
        for(double nota: notas){ // Se suma cada nota dentro del arreglo notas
            suma+=nota;
        }
        return suma; // Se retorna el valor de la suma
    }

    public static double calcular_promedio(double[] notas){
        int cantidad_notas=notas.length;
        double suma_notas=sum(notas);
        double promedio=suma_notas/cantidad_notas;
        return promedio; // Se calcula y retorna el promedio de las notas ingresadas
    }

    public static void mostrar_resultados(double promedio) { // Muestra los resultados del estudiante según su promedio
        if (promedio >= 4.0) {
            System.out.println("¡Felicitaciones, aprobaste!");
        } else if (promedio < 3.6) {
            System.out.println("Lo siento, reprobaste.");
        } else {
            System.out.println("Vas a examen.");
        }
    }

    // Actividad 4: Simulación banco de Temuco
    public static void obtener_resultados_simulacion(int[] informacion){
        int credito=informacion[0];
        int cuotas=informacion[1];
        double credito_total=calcular_credito_total(credito, cuotas);
        double cuota_mensual=calcular_cuota_mensual(credito_total, cuotas);
        System.out.println("Monto total a pagar: " + credito_total);
        System.out.println("Cuota mensual: " + cuota_mensual);
    }

    public static double calcular_credito_total(double credito, int cuotas){
        double credito_total=0;
        if(credito<=1000000){
            if(1<=cuotas && cuotas<=12){
                credito_total = credito + credito*0.25;
            } else if(cuotas<=23){
                credito_total = credito + credito*0.30;
            } else{
                credito_total = credito + credito*0.35;
            }
        } else if(credito>1000000){
            if(1<=cuotas && cuotas<=12){
                credito_total = credito + credito*0.15;
            } else if(cuotas<=23){
                credito_total = credito + credito*0.20;
            } else{
                credito_total = credito + credito*0.25;
            }
        }
        return credito_total;
    }

    public static double calcular_cuota_mensual(double credito_total, int cuotas){
        double cuota_mensual=0.0;
        cuota_mensual=credito_total/cuotas;
        return cuota_mensual;
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Actividad 1: Invertir cadenas");
            System.out.println("2. Actividad 2: Suma de números pares");
            System.out.println("3. Actividad 3: Promedio de notas");
            System.out.println("4. Actividad 4: Simulación de banco");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            if (opcion == 1) {
                System.out.println("Ingrese una cadena de texto: ");
                String cadena=scanner.next();
                System.out.println(invertir_cadena(cadena));

            } else if (opcion == 2) {
                System.out.println("Suma de números pares: ");
                sumar_pares();

            } else if (opcion == 3) {
                System.out.println("Ingrese el número de notas que desea promediar: ");
                int cantidad_notas = scanner.nextInt();
                double[] notas = new double[cantidad_notas];
                System.out.println("Ingrese las notas: ");
                for (int i = 0; i < cantidad_notas; i++) {
                    notas[i] = scanner.nextDouble();
                }
                double promedio = calcular_promedio(notas);
                System.out.println("Su promedio es " + promedio);
                mostrar_resultados(promedio);

            } else if (opcion == 4) {
                System.out.println("Ingrese el crédito a pedir: ");
                int credito = scanner.nextInt();
                System.out.println("Ingrese la cantidad de cuotas: ");
                int cuotas = scanner.nextInt();
                int[] informacion = {credito, cuotas};
                obtener_resultados_simulacion(informacion);

            } else if (opcion == 0) {
                break;

            } else {
                System.out.println("Opción inválida");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
