package proyecto_dos;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    private static String comandos = "                               Ingrese la accion a realizar                               \n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  0 | ⇒ |  Terminar ejecucion                                                    |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  1 | ⇒ |  Imprimir lugares desocupados                                          |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                               |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                        |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema      |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema             |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  6 | ⇒ |  Verificar el estado de lugar                                          |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  7 | ⇒ |  Mostrar el estado de todos los lugares                                |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  8 | ⇒ |  Mostrar ordenadamente la informacion de vehiculos con el color deseado|\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO  9 | ⇒ |  Mostrar la informacion de vehiculos ordenados por su valor comercial  |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 10 | ⇒ | Desocupar espacio                                                      |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "| COMANDO 11 | ⇒ |  Exportar txt con informacion de los vehiculos ingresados              |\n"
            + "†-----------------------------------------------------------------------------------------†\n"
            + "Accion: ";

    public static void main(String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de lugares que desea tener: ");
        int cantEspacios = scan.nextInt();
        int lugar;
        System.out.print("Ingrese el cobro por carro por hora: ");
        int cobroCarro = scan.nextInt();
        System.out.print("Ingrese el cobro por moto por hora: ");
        int cobroMoto = scan.nextInt();
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
                            System.out.print("Ingrese el tipo de su vehiculo: ");
                            String tipo = scan.next();
                            Vehiculo vehiculo;
                            switch (tipo) {
                                case "carro":
                                    vehiculo = new Carro(placa, marca, color);
                                    break;
                                case "moto":
                                    vehiculo = new Moto(placa, marca, color);
                                    break;

                                default:
                                    throw new TipoVehiculoInvalido();
                            }
                            Vehiculo.vehiculos[lugar] = vehiculo;
                            Sensor.sensores[lugar].setEstado(1);
                            System.out.println(vehiculo.toString());
                        } else {
                            System.out.println("Lo sentimos, esta ocupado");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Esta posicion no existe");
                    } catch (TipoVehiculoInvalido e) {
                        System.out.println("Tipo de vehiculo invalido");
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
                            System.out.print("Ingrese el tipo de su vehiculo: ");
                            String tipo = scan.next();
                            Vehiculo vehiculo;
                            switch (tipo) {
                                case "carro":
                                    vehiculo = new Carro(placa, marca, color, valorComercial);
                                    break;
                                case "moto":
                                    vehiculo = new Moto(placa, marca, color, valorComercial);
                                    break;

                                default:
                                    throw new TipoVehiculoInvalido();
                            }
                            Vehiculo.vehiculos[lugar] = vehiculo;
                            Sensor.sensores[lugar].setEstado(1);
                            System.out.println(vehiculo.toString());
                        } else {
                            System.out.println("Lo sentimos, esta ocupado");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Esta posicion no existe");
                    } catch (TipoVehiculoInvalido e) {
                        System.out.println("Tipo de vehiculo invalido");
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

                case 10:
                    System.out.print("Ingrese el lugar a desocupar: ");
                    lugar = scan.nextInt();
                    try {
                        if (Sensor.sensores[lugar].getEstado() > 0) {
                            Sensor sensor = Sensor.sensores[lugar];
                            Vehiculo vehiculo = Vehiculo.vehiculos[lugar];
                            Sensor.sensores[lugar].setEstado(0);
                            Vehiculo.vehiculos[lugar] = null;

                            LocalDateTime fechaActual = LocalDateTime.now();
                            long diferencia = Duration.between(fechaActual, vehiculo.getFechaEntrada()).toMinutes();
                            String tipoVehiculo = vehiculo.getTipo();
                            int precioHora = tipoVehiculo == "moto" ? cobroMoto : cobroCarro;
                            float cobro = (((float) precioHora) / 60) * diferencia;

                            System.out.println("Su cobro total es de: " + cobro);
                        } else {
                            System.out.println("Este espacio no contiene ningun vehiculo");
                        }

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Esta posicion no existe");
                    }
                    break;
                case 11:
                    try {
                        FileWriter writer = new FileWriter("Vehiculos.txt");
                        for (int i = 0; i < Vehiculo.vehiculos.length; i++) {
                            if (Vehiculo.vehiculos[i] != null) {
                                writer.write(Vehiculo.vehiculos[i].toString());
                            }
                        }
                        writer.close();
                        System.out.println("Archivo guardado correctamente");
                    } catch (IOException e) {
                        System.out.println("Error al escribir el archivo");

                    }

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