package proyecto_uno;

class Carro extends Vehiculo {

    public Carro(String p, String m, String c) {
        super(p, m, c, 30000000);
        this.tipo = "carro";
    }

    public Carro(String p, String m, String c, int v) {
        super(p, m, c, v);
        this.tipo = "carro";
    }

    public void imprimitTipo() {
        System.out.println(this.tipo);
    }
}