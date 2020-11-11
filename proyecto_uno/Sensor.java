package proyecto_uno;
import java.time.LocalDataTime;

public class Sensor {
    public static Sensor[] sensores;
    private int estado;
    private LocalDataTime informacionEntrada;

    public Sensor() {

    }

    public Sensor(int e) {

        this.estado = e;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public static void setSensores(int numero) {
        Sensor.sensores = new Sensor[numero];
        for (int i = 0; i < numero; i++) {
            Sensor.sensores[i] = new Sensor(0);
        }
    }

    public String toString() {
        if (this.estado > 0) {
            return "Ocupado";
        } else {
            return "Libre";
        }
    }

    public static String sensorLibre() {
        String infoSensores = "";
        for (int i = 0; i < Sensor.sensores.length; i++) {
            if ((Sensor.sensores[i].getEstado() == 0) && (i != Sensor.sensores.length - 1)) {
                infoSensores += i + " - ";
            } else if (Sensor.sensores[i].getEstado() == 0) {
                infoSensores += i;
            }
        }
        return infoSensores;
    }

    public static String sensoresEstado() {
        String infoSensores = "";
        for (int i = 0; i < Sensor.sensores.length; i++) {
            infoSensores += Sensor.sensores[i].getEstado();
        }
        return infoSensores;
    }
}
