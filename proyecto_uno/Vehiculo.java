package proyecto_uno;

import java.util.Arrays;

public class Vehiculo {
    public static Vehiculo[] vehiculos;
    public static int cantidad = 0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;

    public Vehiculo() {

    }

    public Vehiculo(String p, String m, String c) {

        this(p, m, c, 30000000);
    }

    public Vehiculo(String p, String m, String c, int v) {
        this.placa = p;
        this.marca = m;
        this.color = c;
        this.valorComercial = v;
        Vehiculo.cantidad++;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public int getValorComercial() {
        return valorComercial;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public static void setCantidad(int cantidad) {
        Vehiculo.cantidad = cantidad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setValorComercial(int valorComercial) {
        this.valorComercial = valorComercial;
    }

    public static void setVehiculos(int num) {
        Vehiculo.vehiculos = new Vehiculo[num];
    }

    public String toString() {
        return "|  PLACA: "+this.placa+"\n" + "|  MARCA: "+this.marca+"\n" + "|  COLOR: "+this.color+"\n" + "|  VALOR COMERCIAL: "+this.valorComercial+"\n";
    }

    public static String toStringVehiculos() {
        String infoVehiculo = "";
        for (int i = 0; i < Vehiculo.vehiculos.length; i++) {
            if (Vehiculo.vehiculos[i] != null) {
                infoVehiculo += Vehiculo.vehiculos[i].toString()+"------------------";
            }
        }
        return infoVehiculo;
    }

    public int cantidadVehiculos() {
        return Vehiculo.cantidad;
    }

    public static Vehiculo[] sortearPorColor(String color) {
        int size = 0;
        for (int i = 0; i < Vehiculo.vehiculos.length; i++) {
            if ((Vehiculo.vehiculos[i] != null) && (Vehiculo.vehiculos[i].getColor().equalsIgnoreCase(color))) {
                size++;
            }
        }
        Vehiculo[] newVehiculos = new Vehiculo[size];
        int index = 0;
        for (int i = 0; i < Vehiculo.vehiculos.length; i++) {
            if ((Vehiculo.vehiculos[i] != null) && (Vehiculo.vehiculos[i].getColor().equalsIgnoreCase(color))) {
                newVehiculos[index] = Vehiculo.vehiculos[i];
                index++;
            }
        }
        return newVehiculos;
    }

    public static int comparator(Vehiculo v1, Vehiculo v2) {
        if (v1.valorComercial > v2.valorComercial) {
            return 1;
        } else if (v1.valorComercial < v2.valorComercial) {
            return -1;
        } else {
            return 0;
        }
    }

    public static String listaValor(Vehiculo[] automoviles) {
        String listaValor = "";
        int cantidadVehiculos = 0;
        int j = 0;

        for (int x = 0; x < automoviles.length; x++) {
            if (automoviles[x] != null) {
                cantidadVehiculos++;
            }
        }
        Vehiculo[] carros = new Vehiculo[cantidadVehiculos];

        for (int y = 0; y < automoviles.length; y++) {
            if (automoviles[y] != null) {
                carros[j] = automoviles[y];
                j++;
            }
        }
        Arrays.sort(carros, (v1, v2) -> Vehiculo.comparator(v1, v2));
        for (int i = 0; i < carros.length; i++) {
            listaValor += carros[i].toString() + " ";
        }
        return listaValor;
    }
}
