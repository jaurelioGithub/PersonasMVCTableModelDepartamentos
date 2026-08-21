package personas.presentation.personas;

import personas.Application;
import personas.logic.Departamento;
import personas.logic.Persona;
import personas.presentation.Highlighter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {
    private JPanel panel;
    private JTextField idFld;
    private JTextField nombreFld;
    private JRadioButton sexoFldMasc;
    private JRadioButton sexoFldFem;
    private JComboBox estadoFld;
    private JCheckBox pasatiempoFldMusica;
    private JCheckBox pasatiempoFldCine;
    private JCheckBox pasatiempoFldDeporte;
    private JCheckBox pasatiempoFldVideoJuegos;
    private JCheckBox pasatiempoFldCocina;
    private JCheckBox pasatiempoFldOtro;
    private JTextField pasatiempoFldOtroDescripcion;
    private JButton guardarFld;
    private JButton cancelarFld;
    private JButton consultarFld;
    private JTable personas;
    private JComboBox departamento;

    public View() {
        guardarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validate()) {
                    Persona n = take();
                    try {
                        controller.create(n);
                        JOptionPane.showMessageDialog(panel, "REGISTRO APLICADO", "", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        cancelarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clear();
            }
        });

        consultarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.read(idFld.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        pasatiempoFldOtro.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (pasatiempoFldOtro.isSelected()) {
                    pasatiempoFldOtroDescripcion.setEnabled(true);
                } else {
                    pasatiempoFldOtroDescripcion.setEnabled(false);
                    pasatiempoFldOtroDescripcion.setText("");
                }
            }
        });

        Highlighter highlighter = new Highlighter(Color.green);
        idFld.addMouseListener(highlighter);
        nombreFld.addMouseListener(highlighter);
        sexoFldMasc.addMouseListener(highlighter);
        sexoFldFem.addMouseListener(highlighter);
        estadoFld.addMouseListener(highlighter);
        pasatiempoFldMusica.addMouseListener(highlighter);
        pasatiempoFldCine.addMouseListener(highlighter);
        pasatiempoFldDeporte.addMouseListener(highlighter);
        pasatiempoFldVideoJuegos.addMouseListener(highlighter);
        pasatiempoFldCocina.addMouseListener(highlighter);
        pasatiempoFldOtro.addMouseListener(highlighter);
        pasatiempoFldOtroDescripcion.addMouseListener(highlighter);
        personas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = personas.getSelectedRow();
                if (row >= 0) {
                    controller.edit(row);
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.DEPARTMENTS:
                departamento.setModel(new DefaultComboBoxModel<>(model.getDepartamentos().toArray(new Departamento[0])));
                break;
            case Model.LIST:
                int[] cols = {TableModel.ID, TableModel.NOMBRE, TableModel.SEXO, TableModel.ESTADO, TableModel.DEPARTAMENTO};
                personas.setModel(new TableModel(cols, model.getList()));
                break;
            case Model.CURRENT:
                idFld.setText(model.getCurrent().getId());
                nombreFld.setText(model.getCurrent().getNombre());
                sexoFldMasc.setSelected(model.getCurrent().getSexo() == Persona.MASCULINO);
                sexoFldFem.setSelected(model.getCurrent().getSexo() == Persona.FEMENINO);
                estadoFld.setSelectedItem(model.getCurrent().getEstadoCivil());
                pasatiempoFldMusica.setSelected(model.getCurrent().isPasatiempoMusica());
                pasatiempoFldCine.setSelected(model.getCurrent().isPasatiempoCine());
                pasatiempoFldDeporte.setSelected(model.getCurrent().isPasatiempoDeporte());
                pasatiempoFldVideoJuegos.setSelected(model.getCurrent().isPasatiempoVideoJuegos());
                pasatiempoFldCocina.setSelected(model.getCurrent().isPasatiempoCocina());
                pasatiempoFldOtro.setSelected(model.getCurrent().isPasatiempoOtro());
                if (model.getCurrent().isPasatiempoOtro()) {
                    pasatiempoFldOtroDescripcion.setEnabled(true);
                } else {
                    pasatiempoFldOtroDescripcion.setEnabled(false);
                }
                pasatiempoFldOtroDescripcion.setText(model.getCurrent().getPasatiempoOtroTexto());
                departamento.setSelectedItem(model.getCurrent().getDepartamento());
                idFld.setBackground(null);
                idFld.setToolTipText(null);
                nombreFld.setBackground(null);
                nombreFld.setToolTipText(null);
                break;
        }
        this.panel.revalidate();
    }

    public Persona take() {
        Persona e = new Persona();
        e.setId(idFld.getText());
        e.setNombre(nombreFld.getText());
        e.setSexo(sexoFldMasc.isSelected() ? Persona.MASCULINO : Persona.FEMENINO);
        e.setEstadoCivil((String) estadoFld.getSelectedItem());
        e.setPasatiempoMusica(pasatiempoFldMusica.isSelected());
        e.setPasatiempoCine(pasatiempoFldCine.isSelected());
        e.setPasatiempoDeporte(pasatiempoFldDeporte.isSelected());
        e.setPasatiempoVideoJuegos(pasatiempoFldVideoJuegos.isSelected());
        e.setPasatiempoCocina(pasatiempoFldCocina.isSelected());
        e.setPasatiempoOtro(pasatiempoFldOtro.isSelected());
        if (pasatiempoFldOtro.isSelected()) {
            e.setPasatiempoOtroTexto(pasatiempoFldOtroDescripcion.getText());
        } else {
            e.setPasatiempoOtroTexto("");
        }
        e.setDepartamento((Departamento) departamento.getSelectedItem());
        return e;
    }

    private boolean validate() {
        boolean valid = true;
        if (idFld.getText().isEmpty()) {
            valid = false;
            idFld.setBackground(Application.BACKGROUND_ERROR);
            idFld.setToolTipText("id requerido");
        } else {
            idFld.setBackground(null);
            idFld.setToolTipText(null);
        }

        if (nombreFld.getText().isEmpty()) {
            valid = false;
            nombreFld.setBackground(Application.BACKGROUND_ERROR);
            nombreFld.setToolTipText("Nombre requerido");
        } else {
            nombreFld.setBackground(null);
            nombreFld.setToolTipText(null);
        }

        if(!sexoFldMasc.isSelected() && !sexoFldFem.isSelected()) {
            valid = false;
            sexoFldMasc.setBackground(Application.BACKGROUND_ERROR);
            sexoFldFem.setBackground(Application.BACKGROUND_ERROR);
            sexoFldMasc.setToolTipText("Sexo requerido");
            sexoFldFem.setToolTipText("Sexo requerido");
        } else {
            sexoFldMasc.setBackground(null);
            sexoFldFem.setBackground(null);
            sexoFldMasc.setToolTipText(null);
            sexoFldFem.setToolTipText(null);
        }

        if(departamento.getSelectedItem() == null) {
            valid = false;
            departamento.setBackground(Application.BACKGROUND_ERROR);
            departamento.setToolTipText("Departamento requerido");
        } else {
            departamento.setBackground(null);
            departamento.setToolTipText(null);
        }
        return valid;
    }

}
