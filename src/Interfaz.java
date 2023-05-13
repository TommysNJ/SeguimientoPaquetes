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
    private JButton INSERTARPAQUETESButton;
    private JButton BUSCARButton;
    private JTextField fieldCalleB;
    private JTextField fieldCiudadB;
    private JTextField fieldEstadoB;
    private JTextField fieldCodigoB;
    private JButton BUSCARButton1;
    private JTextField fieldBuscarS;

    private TrackingSystem sistema = new TrackingSystem();

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
                    areaCrear.setText("El paquete se ha creado con éxito, vaya a la sección Mostrar Datos para verificar.");

                    fieldSeguimiento.setText("");
                    fieldCalleR.setText("");
                    fieldCiudadR.setText("");
                    fieldEstadoR.setText("");
                    fieldCodigoR.setText("");
                    fieldCalleD.setText("");
                    fieldCiudadD.setText("");
                    fieldEstadoD.setText("");
                    fieldCodigoD.setText("");
                    fieldFecha.setText("");

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
                areaRemover.setText("Se ha removido con éxito el paquete, vaya a la sección Mostrar Datos para verificar.");
                fieldRemover.setText("");
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
        INSERTARPAQUETESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INSERTARPAQUETESButton.setEnabled(false);

                Package p1 = new Package("AS001", new Address("Logreñas", "Quito", "Ecuador", "10003"),
                        new Address("Gaspar", "Quito", "Ecuador", "13420"),LocalDate.now().plusDays(20));
                Package p2 = new Package("AS002", new Address("Yasa", "Ambato", "Ecuador", "12004"),
                        new Address("Manuel", "Ambato", "Ecuador", "12850"),LocalDate.now().plusDays(60));
                Package p3 = new Package("AS003", new Address("Cañar", "Quito", "Ecuador", "11230"),
                        new Address("Gaspar", "Guayaquil", "Ecuador", "12840"),LocalDate.now().plusDays(8));
                Package p4 = new Package("AS004", new Address("Yasa", "Loja", "Ecuador", "60045"),
                        new Address("Villa", "Ambato", "Ecuador", "18045"),LocalDate.now().plusDays(44));
                Package p5 = new Package("AS005", new Address("Loño", "Ambato", "Ecuador", "76485"),
                        new Address("Breila", "Quito", "Ecuador", "12367"),LocalDate.now().plusDays(12));
                Package p6 = new Package("AS006", new Address("Pinta", "Quito", "Ecuador", "97859"),
                        new Address("Gaspar", "Quito", "Ecuador", "65788"),LocalDate.now().plusDays(3));

                sistema.addPackage(p1);
                sistema.addPackage(p2);
                sistema.addPackage(p3);
                sistema.addPackage(p4);
                sistema.addPackage(p5);
                sistema.addPackage(p6);

                areaInsertar.setText("Se ha agregado con éxito los paquetes, vaya a la sección Mostrar Paquetes para verificar.");

            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Address adr = new Address(fieldCalleB.getText(),fieldCiudadB.getText(),fieldEstadoB.getText(),fieldCodigoB.getText());
                if (sistema.searchByRecipientAddress(adr.toString())==null){
                    areaDireccion.setText("Dirección de destinatario no encontrada, ingrese una existente.");
                    fieldCalleB.setText("");
                    fieldCiudadB.setText("");
                    fieldEstadoB.setText("");
                    fieldCodigoB.setText("");
                } else{
                    areaDireccion.setText(sistema.searchByRecipientAddress(adr.toString()).toString());
                    fieldCalleB.setText("");
                    fieldCiudadB.setText("");
                    fieldEstadoB.setText("");
                    fieldCodigoB.setText("");
                }
            }
        });
        BUSCARButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sistema.searchByTrackingNumber(fieldBuscarS.getText())==null){
                    areaNumero.setText("Número de seguimiento no encontrado, ingrese uno existente.");
                    fieldBuscarS.setText("");
                } else{
                    areaNumero.setText(sistema.searchByTrackingNumber(fieldBuscarS.getText()).toString());
                    fieldBuscarS.setText("");
                }
            }
        });
    }
}