package personas.presentation.personas;

import personas.logic.Departamento;
import personas.logic.Persona;
import personas.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel {
    Persona current;
    List<Persona> list;
    List<Departamento> departamentos;

    public static final String CURRENT = "current";
    public static final String LIST = "list";
    public static final String DEPARTMENTS = "departments";

    public Model() {
        current = new Persona();
        list = new ArrayList<Persona>();
        departamentos = new ArrayList<Departamento>();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(LIST);
        firePropertyChange(DEPARTMENTS);
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
}
