import java.lang.String;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }


    public Fecha fechaActual(){
        GregorianCalendar gc = new GregorianCalendar();
        int diaA=gc.get(GregorianCalendar.DAY_OF_MONTH);
        int mesA=gc.get(GregorianCalendar.MONTH)+1;
        int anioA=gc.get(GregorianCalendar.YEAR);

        Fecha fechaActual= new Fecha(diaA,mesA,anioA);
        return fechaActual;
    }
    public int diferenciaFechas(Fecha inicio, Fecha fin){
        int inicioMeses=inicio.getAnio()*12+inicio.getMes();
        int finMeses=fin.getAnio()*12+fin.getMes();
        return finMeses-inicioMeses;
    }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return   dia +
                "-" + mes +
                "-" + anio;
    }
}
