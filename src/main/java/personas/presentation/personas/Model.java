package personas.presentation.personas;

import personas.logic.Departamento;
import personas.logic.EstadoCivil;
import personas.logic.Persona;
import personas.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel {
    Persona current;
    List<Persona> list;
    List<Departamento> departamentos;
    List<EstadoCivil> estadosCiviles;

    public static final String CURRENT = "current";
    public static final String LIST = "list";
    public static final String DEPARTMENTS = "departments";
    public static final String MARITAL_STATUS = "marital_status";

    public Model() {
        current = new Persona();
        list = new ArrayList<Persona>();
        departamentos = new ArrayList<Departamento>();
        estadosCiviles = new ArrayList<EstadoCivil>();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(LIST);
        firePropertyChange(DEPARTMENTS);
        firePropertyChange(MARITAL_STATUS);
    }

    public Persona getCurrent() {
        return current;
    }

    public void setCurrent(Persona current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }

    public List<Persona> getList() {
        return list;
    }

    public void setList(List<Persona> list) {
        this.list = list;
        firePropertyChange(LIST);
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
        firePropertyChange(DEPARTMENTS);
    }

    public List<EstadoCivil> getEstadosCiviles() {
        return estadosCiviles;
    }

    public void setEstadosCiviles(List<EstadoCivil> estadosCiviles) {
        this.estadosCiviles = estadosCiviles;
        firePropertyChange(MARITAL_STATUS);
    }
}
