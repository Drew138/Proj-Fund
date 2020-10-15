package proyecto_uno;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;

public class Principal {
    private static String comandos = "                               Ingrese la accion a realizar                               \n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 0 | ⇒ |  Terminar ejecucion                                                    |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 1 | ⇒ |  Imprimir lugares desocupados                                          |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                               |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                        |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema      |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema             |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 6 | ⇒ |  Verificar el estado de lugar                                          |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 7 | ⇒ |  Mostrar el estado de todos los lugares                                |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 8 | ⇒ |  Mostrar ordenadamente la informacion de vehiculos con el color deseado|\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 9 | ⇒ |  Mostrar la informacion de vehiculos ordenados por su valor comercial  |\n"
            + "†----------------------------------------------------------------------------------------†\n"
            + "Accion: ";

    public static void main(String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de lugares que desea tener: ");
        int cantEspacios = scan.nextInt();
        int lugar;
        String vehiculos;
        Vehiculo.setVehiculos(cantEspacios);
        Sensor.setSensores(cantEspacios);
        System.out.print(Principal.comandos);
        int accion = scan.nextInt();
        while (accion != 0) {
            System.out.println("");
            switch (accion) {
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    System.out.print("Ingrese el espacio en el que desea parquear: ");
                    lugar = scan.nextInt();
                    try {
                        if (Sensor.sensores[lugar].getEstado() == 0) {
                            System.out.print("Ingrese la placa del vehiculo: ");
                            String placa = scan.next();
                            System.out.print("Ingrese la marca de su vehiculo: ");
                            String marca = scan.next();
                            System.out.print("Ingrese el color de su vehiculo: ");
                            String color = scan.next();
                            Vehiculo vehiculo = new Vehiculo(placa, marca, color);
                            Vehiculo.vehiculos[lugar] = vehiculo;
                            Sensor.sensores[lugar].setEstado(1);
                            System.out.println(vehiculo.toString());
                        } else {
                            System.out.println("Lo sentimos, esta ocupado");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Esta posicion no existe");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el espacio en el que desea parquear: ");
                    lugar = scan.nextInt();
                    try {
                        if (Sensor.sensores[lugar].getEstado() == 0) {
                            System.out.print("Ingrese la placa del vehiculo: ");
                            String placa = scan.next();
                            System.out.print("Ingrese la marca de su vehiculo: ");
                            String marca = scan.next();
                            System.out.print("Ingrese el color de su vehiculo: ");
                            String color = scan.next();
                            System.out.print("Ingrese el valor comercial de su vehiculo: ");
                            int valorComercial = scan.nextInt();
                            Vehiculo vehiculo = new Vehiculo(placa, marca, color, valorComercial);
                            Vehiculo.vehiculos[lugar] = vehiculo;
                            Sensor.sensores[lugar].setEstado(1);
                            System.out.println(vehiculo.toString());
                        } else {
                            System.out.println("Lo sentimos, esta ocupado");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Esta posicion no existe");
                    }
                    break;
                case 4:
                    System.out.print("INROFRMACION DE TODOS LOS VEHCULOS INGRESADOS HASTA EL MOMENTO: \n"
                            + Vehiculo.toStringVehiculos() + "\n");
                    break;
                case 5:
                    System.out.println("CANTIDAD DE VEHICULOS INGRESADOS: " + Vehiculo.getCantidad());
                    break;
                case 6:
                    System.out.print("Ingrese el lugar del que desea conocer el estado: ");
                    lugar = scan.nextInt();
                    try {
                        String estado = Sensor.sensores[lugar].getEstado() == 0 ? "DESOCUPADO" : "OCUPADO";
                        System.out.println(estado);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Esta posicion no existe");
                    }
                    break;
                case 7:
                    String cuadroPosiciones = "POSICION  ⇒\tESTADO\n";
                    String estados = Sensor.sensoresEstado();
                    for (int i = 0; i < estados.length(); i++) {
                        if (estados.charAt(i) == '0') {
                            cuadroPosiciones += i + "\t" + "  ⇒  " + "\tDESOCUPADO\n";
                        } else {
                            cuadroPosiciones += i + "\t" + "  ⇒  " + "\tOCUPADO\n";
                        }
                    }
                    System.out.println(cuadroPosiciones);
                    break;
                case 8:
                    System.out.print("Ingrese el color de los carros que desea filtrar: ");
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
            System.out.print(Principal.comandos);
            accion = scan.nextInt();
        }
        scan.close();
    }
}
