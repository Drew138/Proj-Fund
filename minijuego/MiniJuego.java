package minijuego;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

class MiniJuego {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numAleatoreo = ThreadLocalRandom.current().nextInt(2, 6);
        for (int i = 0; i < numAleatoreo; i++) {
            int segundoNumAleatoreo = ThreadLocalRandom.current().nextInt(1, 3);
            switch (i) {
                case 1:
                    Bichos.bichos[0][0] = crearBicho(segundoNumAleatoreo);
                    break;
                case 2:
                    Bichos.bichos[0][1] = crearBicho(segundoNumAleatoreo);
                    break;
                case 3:
                    Bichos.bichos[1][0] = crearBicho(segundoNumAleatoreo);
                    break;
                case 4:
                    Bichos.bichos[1][1] = crearBicho(segundoNumAleatoreo);
                    break;
            }
        }
        Bichos.mostrarTablero();
        while (Bichos.sigueJugando()) {
            System.out.println("Ingrese una posicion: ");
            int posicion = scan.nextInt();
            if ((posicion > 4) || (posicion < 0)) {
                System.out.println("Posicion invalida vuelva a intentarlo");
                Bichos.mostrarTablero();
                continue;
            }
            if (posicion == 1) {
                if (Bichos.bichos[0][0] == null) {
                    System.out.println("Bicho no existente, intente de nuevo");
                    Bichos.mostrarTablero();
                    continue;
                }
                Bichos.bichos[0][0].setSalud(Bichos.bichos[0][0].getSalud() - 5);
                if (Bichos.bichos[0][0].getSalud() <= 0) {
                    Bichos.bichos[0][0] = null;
                }
            } else if (posicion == 2) {
                if (Bichos.bichos[0][1] == null) {
                    System.out.println("Bicho no existente, intente de nuevo");
                    continue;
                }
                Bichos.bichos[0][1].setSalud(Bichos.bichos[0][1].getSalud() - 5);
                if (Bichos.bichos[0][1].getSalud() <= 0) {
                    Bichos.bichos[0][1] = null;
                }
            } else if (posicion == 3) {
                if (Bichos.bichos[1][0] == null) {
                    System.out.println("Bicho no existente, intente de nuevo");
                    continue;
                }
                Bichos.bichos[1][0].setSalud(Bichos.bichos[1][0].getSalud() - 5);
                if (Bichos.bichos[1][0].getSalud() <= 0) {
                    Bichos.bichos[1][0] = null;
                }
            } else if (posicion == 4) {
                if (Bichos.bichos[1][1] == null) {
                    System.out.println("Bicho no existente, intente de nuevo");
                    continue;
                }
                Bichos.bichos[1][1].setSalud(Bichos.bichos[1][1].getSalud() - 5);
                if (Bichos.bichos[1][1].getSalud() <= 0) {
                    Bichos.bichos[1][1] = null;
                }
            }
            Bichos.mostrarTablero();
        }
        System.out.println("Game over");
        scan.close();
    }

    public static Bichos crearBicho(int n) {
        if (n == 1) {
            return new BichosNormales();
        } else {
            return new BichosAliens();
        }
    }
}