package minijuego;

class BichosAliens extends Bichos {
    public BichosAliens() {
        super(20);
    }

    public String toString() {
        return "BA-" + this.getSalud();
    }
}