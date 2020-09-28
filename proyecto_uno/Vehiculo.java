public class Vehiculo{
    public static Vehiculo[] vehiculos;
    public static int cantidad = 0
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;

    public Vehiculo(){

    }

    public Vehiculo(String p, String m, String c){
        this(p,m,c,30000000);
    }

    public Vehiculo(String p, String m, String c, int v){
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


    public String toString(){
        return this.placa + this.marca + this.color + this.valorComercial;
    }

    public static String toStringVehiculos(){
        String infoVehiculo = "";
        for (int i=0; i<Vehiculo.vehiculos.length; i++ ) {
            if (Vehiculo.vehiculos[i] != null) {
                infoVehiculo += Vehiculo.vehiculos[i].toString();
            }
        }
        return infoVehiculo;
    }

    public int cantidadVehiculos(){
        return Vehiculo.cantidad;
    }

}