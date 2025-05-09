import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioDenuncia extends JFrame {

    private JTextField campoCorreo, campoNombre, campoCedula, campoFecha;
    private JTextArea areaDescripcion;

    public FormularioDenuncia() {
        setTitle("Sistema de Denuncias al OIJ");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de entrada
        JPanel panelCampos = new JPanel(new GridLayout(5, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        campoCorreo = new JTextField();
        campoNombre = new JTextField();
        campoCedula = new JTextField();
        campoFecha = new JTextField();

        panelCampos.add(new JLabel("Correo electrónico:"));
        panelCampos.add(campoCorreo);
        panelCampos.add(new JLabel("Nombre completo:"));
        panelCampos.add(campoNombre);
        panelCampos.add(new JLabel("Número de cédula:"));
        panelCampos.add(campoCedula);
        panelCampos.add(new JLabel("Fecha de los hechos:"));
        panelCampos.add(campoFecha);

        // Área de descripción
        JPanel panelDescripcion = new JPanel(new BorderLayout());
        panelDescripcion.setBorder(BorderFactory.createTitledBorder("Descripción de los hechos"));
        areaDescripcion = new JTextArea(5, 20);
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setWrapStyleWord(true);
        panelDescripcion.add(new JScrollPane(areaDescripcion), BorderLayout.CENTER);

        // Botón de enviar
        JButton botonEnviar = new JButton("Enviar denuncia");
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDenuncia();
            }
        });

        // Añadir todo al frame
        add(panelCampos, BorderLayout.NORTH);
        add(panelDescripcion, BorderLayout.CENTER);
        add(botonEnviar, BorderLayout.SOUTH);
    }

    private void enviarDenuncia() {
        String correo = campoCorreo.getText().trim();
        String nombre = campoNombre.getText().trim();
        String cedula = campoCedula.getText().trim();
        String fecha = campoFecha.getText().trim();
        String descripcion = areaDescripcion.getText().trim();

        if (correo.isEmpty() || nombre.isEmpty() || cedula.isEmpty() || fecha.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Denuncia denuncia = new Denuncia(correo, nombre, cedula, fecha, descripcion);

        // Simulamos registro de la denuncia (se podría guardar en archivo o base de datos)
        System.out.println(denuncia);

        JOptionPane.showMessageDialog(this, "¡Denuncia enviada con éxito!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
    }

    private void limpiarCampos() {
        campoCorreo.setText("");
        campoNombre.setText("");
        campoCedula.setText("");
        campoFecha.setText("");
        areaDescripcion.setText("");
    }
}
