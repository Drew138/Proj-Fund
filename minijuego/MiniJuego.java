import java.util.concurrent.ThreatLocalRandom;
import java.util.Scanner;
class MiniJuego{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int numAleatoreo = ThreatLocalRandom.current().nextInt(1, 5);
        Bicho bicho;

        for(int i = 0; i<numAleatoreo; i++){
            numAleatoreo = ThreatLocalRandom.current().nextInt(1, 3);
            switch (i){
                case 1:
                    Bichos.bichos[0][0] = this.crearBicho(numAleatoreo);
                    break;
                case 2:
                    Bichos.bichos[0][1] = this.crearBicho(numAleatoreo);
                    break;
                case 3:
                    Bichos.bichos[1][0] = this.crearBicho(numAleatoreo);
                    break;
                case 4:
                    Bichos.bichos[1][1] = this.crearBicho(numAleatoreo);
                    break;
            }
        }

        while (Bichos.sigueJugando()){
            int posicion = scan.nextInt();
            if ((posicion>4) && (posicion<0)){
                System.out.println("Posicion invalida vuelva a intentarlo");
                continue;
            }
            Bichos bicho;
            switch (posicion){
                case 1:
                    bicho = Bichos.bichos[0][0];
                    break;
                case 2:
                    bicho = Bichos.bichos[0][1];
                    break;
                case 3:
                    bicho = Bichos.bichos[1][0];
                    break;
                case 4:
                    bicho = Bichos.bichos[1][1];
                    break;
            }
            if(bicho==null){
                System.out.println("Bicho no existente, intente de nuevo");
            }
            bicho.setSalud(bicho.getSalud()-5);

            if (bicho.getSalud()<=0){
                switch (posicion){
                    case 1:
                        Bichos.bichos[0][0] = null;
                        break;
                    case 2:
                        Bichos.bichos[0][1] = null;
                        break;
                    case 3:
                        Bichos.bichos[1][0] = null;
                        break;
                    case 4:
                        Bichos.bichos[1][1] = null;
                        break;
                }
            }
        }
    }

    public Bichos crearBicho(int n){
        if(numAleatoreo==1){
            return new BichosNormales();
        }else{
            return new BichosAliens();
        }
    }
}