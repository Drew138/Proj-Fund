package minijuego;

public class Bichos {
    public static Bichos[][] bichos = new Bichos[2][2];
    private int salud;

    public Bichos(int salud) {
        this.salud = salud;
    }

    public int getSalud() {
        return salud;
    }

    public static Bichos[][] getBichos() {
        return bichos;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public static void mostrarTablero() {
        String tablero = "-------------" + "\n" + "|" + mostrarCasilla(bichos[0][0]) + "|"
                + mostrarCasilla(bichos[0][1]) + "|" + "\n" + "-------------" + "\n" + "|"
                + mostrarCasilla(bichos[1][0]) + "|" + mostrarCasilla(bichos[1][1]) + "|" + "\n" + "-------------"
                + "\n";

        System.out.print(tablero);
    }

    public static String mostrarCasilla(Bichos b) {
        if (b == null) {
            return "     ";
        } else {
            return b.toString();
        }
    }

    public static boolean sigueJugando() {
        boolean sigueJugando = false;

        if (Bichos.bichos[0][0] != null) {
            sigueJugando = true;
        }

        if (Bichos.bichos[0][1] != null) {
            sigueJugando = true;
        }

        if (Bichos.bichos[1][0] != null) {
            sigueJugando = true;
        }

        if (Bichos.bichos[1][1] != null) {
            sigueJugando = true;
        }
        return sigueJugando;
    }
}
