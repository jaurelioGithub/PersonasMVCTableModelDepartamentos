package personas.data;

import jakarta.xml.bind.annotation.*;
import personas.logic.Departamento;
import personas.logic.Persona;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    @XmlElementWrapper(name = "personas")
    @XmlElement(name = "persona")
    private List<Persona> personas;

    @XmlElementWrapper(name = "departamentos")
    @XmlElement(name = "departamento")
    private List<Departamento> departamentos;

    public Data() {
        personas = new ArrayList<>();
        departamentos = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
