import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton buttonQuemarDatos;
    private JTextArea areaQuemarDatos;
    private JTextField fieldNombre;
    private JTextField fieldPaginas;
    private JButton buttonAgregar;
    private JTextArea areaAgregar;
    private JTextField fieldRemoverId;
    private JTextField fieldRemoverNombre;
    private JButton btnEliminar1;
    private JButton btnEliminar2;
    private JTextArea areaRemover;
    private JTextField fieldBuscarID;
    private JButton buttonBuscarID;
    private JTextArea textArea1;
    private JTextField fieldBuscarNombre;
    private JButton buttonBuscarNombre;
    private JTextArea textArea2;
    private JButton buttonSuma;
    private JTextArea textArea3;
    private JButton buttonTodos;
    private Lista lista = new Lista();
    private int indice;

    public Interfaz(){
        setContentPane(panel1);
        areaQuemarDatos.setEnabled(false);

        buttonQuemarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonQuemarDatos.setEnabled(false);

                Libro l1 = new Libro (100,"Caperucita");
                Libro l2 = new Libro (54,"Odisea");
                Libro l3 = new Libro (75,"Los tres chanchitos");
                Libro l4 = new Libro (90,"Harry Potter");

                lista.addLibro(l1);
                lista.addLibro(l2);
                lista.addLibro(l3);
                lista.addLibro(l4);

                areaQuemarDatos.setText(lista.toString());

            }
        });
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Libro libro= new Libro(Integer.parseInt(fieldPaginas.getText()), fieldNombre.getText());
                lista.addLibro(libro);
                areaAgregar.setText(libro.toString());
            }
        });
        btnEliminar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (lista.searchById(fieldRemoverId.getText())==null){
                    areaRemover.setText("No existe ese Id.");
                } else {
                    lista.removeId(fieldRemoverId.getText());
                    areaRemover.setText("Se eliminó con exito.");
                }

            }
        });
        btnEliminar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lista.searchByName(fieldRemoverNombre.getText())==null){
                    areaRemover.setText("No existe ese Nombre.");
                } else {
                    lista.removeNombre(fieldRemoverNombre.getText());
                    areaRemover.setText("Se eliminó con exito.");
                }
            }
        });

        buttonBuscarID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lista.searchById(fieldBuscarID.getText())==null){
                    textArea1.setText("No existe ese Id.");
                } else {
                    textArea1.setText(lista.searchById(fieldBuscarID.getText()).toString());
                }
            }
        });
        buttonBuscarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lista.searchByName(fieldBuscarNombre.getText())==null){
                    textArea2.setText("No existe ese nombre.");
                } else {
                    textArea2.setText(lista.searchByName(fieldBuscarNombre.getText()).toString());
                }
            }
        });
        buttonTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea3.setText(lista.toString());
            }
        });
        buttonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea3.setText("Total páginas: " + String.valueOf(lista.totalPaginas(0,0)));
            }
        });
    }
}