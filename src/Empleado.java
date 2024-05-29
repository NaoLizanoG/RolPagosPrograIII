public class Empleado implements Comparable<Empleado>{
    private String cedula;
    private String nombre;
    private double sueldo;
    private Fecha fechaIngreso;
    private double aporteSeguro;
    private double impuestoRenta;
    private double fondosReserva;


    public Empleado(String cedula, String nombre, double sueldo, Fecha fechaIngreso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.fechaIngreso = fechaIngreso;
    }

    public void calcularAporte(){
        setAporteSeguro( (getSueldo()*(0.0935)));

    }

    public void calculaImpuesto(Empleado empleado){
        if (empleado.getSueldo()>0 && empleado.getSueldo()<=5000){
            empleado.setImpuestoRenta(0);
        } else if (empleado.getSueldo()>5000&& empleado.getSueldo()<=10000) {
            double exceso= empleado.getSueldo()-5000;
            empleado.setImpuestoRenta(exceso*(0.1));
        } else if (empleado.getSueldo()>10000 && empleado.getSueldo()<=18000) {
            double exceso= empleado.getSueldo()-10000;
            empleado.setImpuestoRenta(exceso*(0.2));
        } else if (empleado.getSueldo()>18000) {
            double exceso= empleado.getSueldo()-18000;
            empleado.setImpuestoRenta(exceso*(0.3));
        }
    }

    public void calcularAniosTrabajando(){

        if (fechaIngreso.fechaEntrada()>=1){
            fondosReserva=fechaIngreso.fechaEntrada()*sueldo;
        }else {
            fondosReserva=0;
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getAporteSeguro() {
        return aporteSeguro;
    }

    public void setAporteSeguro(double aporteSeguro) {
        this.aporteSeguro = aporteSeguro;
    }

    public double getImpuestoRenta() {
        return impuestoRenta;
    }

    public void setImpuestoRenta(double impuestoRenta) {
        this.impuestoRenta = impuestoRenta;
    }

    public double getFondosReserva() {
        return fondosReserva;
    }

    public void setFondosReserva(double fondosReserva) {
        this.fondosReserva = fondosReserva;
    }

    @Override
    public String toString() {
        return "Empleado: " +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", fechaIngreso=" + fechaIngreso +
                ", aporteSeguro=" + aporteSeguro +
                ", impuestoRenta=" + impuestoRenta +
                ", fondosReserva=" + fondosReserva ;
    }

    @Override
    public int compareTo(Empleado o) {
        if (sueldo<o.getSueldo()){
            return 1;
        }
        else if (sueldo>o.getSueldo()){
            return -1;
        }
        else
            return 0;
    }
}
