package minijuego;

class BichosNormales extends Bichos {
    public BichosNormales() {
        super(10);
    }

    public String toString() {
        return "BN-" + this.getSalud();
    }
}