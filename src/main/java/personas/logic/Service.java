package personas.logic;

import personas.data.Data;
import personas.data.XmlPersister;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) theInstance = new Service();
        return theInstance;
    }

    private Data data;

    private Service() {
        try {
            data = XmlPersister.instance().load();
        } catch (Exception e) {
            data = new Data();
        }
    }

    public void stop() {
        try {
            XmlPersister.instance().store(data);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // =============== PERSONAS ===============
    public void create(Persona e) throws Exception {
         Persona result = data.getPersonas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getPersonas().add(e);
        } else {
            throw new Exception("Persona ya existe");
        }
    }

    public Persona read(Persona e) throws Exception {
        Persona result = data.getPersonas().stream()
                .filter(i -> i.getId().equals(e.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Persona no existe");
        }
    }

    public List<Persona> findAll() {
        return data.getPersonas();
    }

    // =============== DEPARTAMENTOS ===============
    public List<Departamento> search( Departamento e) {
        return data.getDepartamentos().stream()
                .filter(i -> i.getNombre().toLowerCase().contains(e.getNombre().toLowerCase()))
                .sorted(Comparator.comparing(Departamento::getNombre))
                .collect(Collectors.toList());
    }
 }
