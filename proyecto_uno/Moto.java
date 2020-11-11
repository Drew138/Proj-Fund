package proyecto_uno

class Moto extends Vehiculo {

    public Moto(String p, String m, String c) {
        super(p, m, c, 30000000);
        this.tipo = "moto";
    }

    public Moto(String p, String m, String c, int v) {
        super(p, m, c, v);
        this.tipo = "moto";
    }

    public void imprimitTipo() {
        System.out.println(this.tipo);
    }
}