public class Sensor{
    public static Sensor[] sensores;
    private int estado;

    public Sensor () {

    }

    public Sensor (int e){

        this.estado = e;
    }

    public int getEstado() {

        return estado;
    }

    public void setEstado(int estado) {

        this.estado = estado;
    }


    public String toString(){
        if (this.estado>0){
            return "Ocupado";
        }else {
            return "Libre";
        }
    }

    public static String sensorLibre(){
        String infoSensores = "";
        for (int i=0; i<Sensor.sensores.length; i++ ) {
            if (Sensor.sensores[i] == null) {
                infoSensores += i;
            }
        }
        return infoSensores;
    }

    public static String sensoresEstado(){
        String infoSensores = "";
        for (int i=0; i<Sensor.sensores.length; i++ ){
            infoSensores += Sensor.sensores[i].getEstado();
        }
        return infoSensores;
    }
}


