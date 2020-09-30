import java.util.Scanner;
public class Principal{
    public static void main(String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);

        int cantEspacios = scan.nextInt();
        int lugar;
        String vehiculos;

       // Vehiculo.vehiculos;
        // Sensor.sensores;

        int accion = scan.nextInt();
        while (accion !=0){
            switch (accion){
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;

                case 2:
                     lugar = scan.nextInt();
                    if(Sensor.sensorLibre().indexOf(lugar) != -1){
                        String placa = scan.next();
                        String marca = scan.next();
                        String color = scan.next();
                        Vehiculo vehiculo = new Vehiculo(placa, marca, color);

                        Sensor.sensores[lugar].setEstado(1);

                        System.out.println(vehiculo.toString());

                    }else {
                        System.out.println("Lo sentimos, esta ocupado");
                    }
                    break;
                case 3:
                    lugar = scan.nextInt();

                    if(Sensor.sensorLibre().indexOf(lugar) != -1){
                        String placa = scan.next();
                        String marca = scan.next();
                        String color = scan.next();
                        int valorComercial = scan.nextInt();

                        Vehiculo vehiculo = new Vehiculo(placa, marca, color, valorComercial);

                        Sensor.sensores[lugar].setEstado(1);

                        System.out.println(vehiculo.toString());

                    }else {
                        System.out.println("Lo sentimos, esta ocupado");
                    }
                    break;

                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;

                case 5:
                    System.out.println(Vehiculo.getCantidad());
                    break;

                case 6:
                    lugar = scan.nextInt();

                    System.out.println(Sensor.sensores[lugar].getEstado());
                    break;

                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break;

                case 8:
                    String color = scan.next();
                    vehiculos = Vehiculo.listaValor(Vehiculo.sortearPorColor(color));
                    System.out.println(vehiculos);
                    break;

                case 9:
                    vehiculos = Vehiculo.listaValor(Vehiculo.vehiculos);
                    System.out.println(vehiculos);

                    break;


                    default:
                        System.out.println("Comando incorrecto");

                        break;

                    }

             accion = scan.nextInt();
        }
        }
    }

