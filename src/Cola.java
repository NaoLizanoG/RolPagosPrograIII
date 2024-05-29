import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Cola {

    private PriorityQueue<Empleado> listaEmpleados;
    public Cola(){
        listaEmpleados=new PriorityQueue<Empleado>();
    }
public  void encolar (Empleado empleado){
        listaEmpleados.add(empleado);
}

public Empleado buscar(String cedula)throws Exception{
        for(Empleado e:listaEmpleados){
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        throw new Exception("No se encontro el empleado");
}

public void cambiar(Empleado empleado, String nombre, double sueldo){
        empleado.setNombre(nombre);
        empleado.setSueldo(sueldo);
        empleado.calculaImpuesto(empleado);
        empleado.calcularAporte();

}

    public List<Empleado> listarEmpleado(){
        List<Empleado> lista = new LinkedList<>();
        for (Empleado e:listaEmpleados){
            lista.add(e);
        }
        return lista;

    }


}
