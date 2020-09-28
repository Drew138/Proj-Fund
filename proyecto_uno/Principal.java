import java.util.Scanner;
public class Principal{
    public static void main(String[] args) {

    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);

        int cantEspacios = scan.nextInt();

        Vehiculo.vehiculos;
        Sensor.sensores;

        int accion = scan.nextInt();
        while (accion !=0){
            switch (accion){
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;

                case 2:
                    String lugar = scan.next();
                    if(Sensor.sensorLibre().indexOf(lugar) != -1){
                        String placa = scan.next();
                        String marca = scan.next();
                        String color = scan.next();

                        Vehiculo vehiculo = new Vehiculo(placa, marca, color);
                        
                    }else {
                        System.out.println("Lo sentimos, esta ocupado");
                    }
                    break;
                    }

            }
        }
    }

}