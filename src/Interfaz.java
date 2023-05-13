import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Interfaz extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextArea areaCrear;
    private JTextArea areaRemover;
    private JTextArea areaMostrar;
    private JTextArea areaInsertar;
    private JTextArea areaDireccion;
    private JTextArea areaNumero;
    private JTextArea areaCiudad;
    private JButton CREARButton;
    private JTextField fieldCalleR;
    private JTextField fieldCalleD;
    private JTextField fieldFecha;
    private JTextField fieldCiudadR;
    private JTextField fieldEstadoR;
    private JTextField fieldCodigoR;
    private JTextField fieldCiudadD;
    private JTextField fieldEstadoD;
    private JTextField fieldCodigoD;
    private JTextField fieldSeguimiento;
    private JButton buttonRemover;
    private JTextField fieldRemover;
    private JButton buttonMostrar;

    private TrackingSystem sistema = new TrackingSystem();
    private Package p1;
    private Package p2;
    private Package p3;
    private Package p4;
    private Package p5;
    private Package p6;


    public Interfaz(){
        setContentPane(panel1);

        CREARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sistema.searchByTrackingNumber(fieldSeguimiento.getText())==null){
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String textoFecha = fieldFecha.getText();
                    LocalDate fecha = LocalDate.parse(textoFecha,formato);
                    sistema.addPackage(new Package(fieldSeguimiento.getText(),new Address(fieldCalleR.getText(),fieldCiudadR.getText(),fieldEstadoR.getText(),fieldCodigoR.getText()),
                            new Address(fieldCalleD.getText(),fieldCiudadD.getText(),fieldEstadoD.getText(),fieldCodigoD.getText()),fecha));
                    areaCrear.setText("El paquete se ha creado con éxito.");
                } else {
                    areaCrear.setText("El número de seguimiento ingresado ya existe, ingrese otro!");
                    fieldSeguimiento.setText("");
                }
            }
        });

        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.removePackage(fieldRemover.getText());
                /*if (sistema.searchByTrackingNumber(fieldSeguimiento.getText())==null){
                    areaRemover.setText("No se ha encontrado el paquete ingresado.");
                } else {
                    sistema.removePackage(fieldRemover.getText());
                }*/
            }
        });

        buttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaMostrar.setText(sistema.mostrarPackages());
            }
        });
    }
}