import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JTextField textFieldNombre;
    private JTextField textFieldCedula;
    private JTextField textFieldSueldo;
    private JTextField textFieldDia;
    private JTextField textFieldMes;
    private JTextField textFieldAnio;
    private JButton ingresarButton;
    private JList list1;
    private JPanel Ventana;
    private JTextField textFieldCedula2;
    private JTextField textFieldNombre2;
    private JTextField textFieldSueldo2;
    private JButton buscarButton;
    private JButton guardarCambiosButton;

    Cola colaEmpleado = new Cola();
    DefaultListModel dlm =new DefaultListModel();
    public Ventana() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fecha fecha= new Fecha(Integer.parseInt((textFieldDia.getText())), Integer.parseInt(textFieldMes.getText()), Integer.parseInt(textFieldAnio.getText()));
                Empleado empleado= new Empleado(textFieldCedula.getText().toString(), textFieldNombre.getText().toString(),Integer.parseInt( textFieldSueldo.getText().toString()), fecha);
                empleado.calcularAporte();
                empleado.calculaImpuesto(empleado);
                empleado.calcularAniosTrabajando();
                colaEmpleado.encolar(empleado);
                llenarJList();
                System.out.println(empleado);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   Empleado empleado1 =  colaEmpleado.buscar(textFieldCedula2.getText().toString());
                     textFieldNombre2.setText(empleado1.getNombre());
                     textFieldSueldo2.setText(String.valueOf(empleado1.getSueldo()));
                    llenarJList();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        guardarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    colaEmpleado.cambiar(colaEmpleado.buscar(textFieldCedula2.getText().toString()),textFieldNombre2.getText().toString(),Double.parseDouble(textFieldSueldo2.getText().toString()));
                    llenarJList();
                    JOptionPane.showMessageDialog(null,"Se ha modificado el empleado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }


    public void llenarJList(){
        dlm.removeAllElements();
        List<Empleado> empleado= colaEmpleado.listarEmpleado();
        Collections.sort(empleado);
        for (Empleado p:empleado){
            dlm.addElement(p);
        }
        list1.setModel(dlm);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
