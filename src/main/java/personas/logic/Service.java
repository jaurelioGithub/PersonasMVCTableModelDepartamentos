package personas.logic;

import personas.data.Database;
import personas.data.DepartamentoDao;
import personas.data.EstadoCivilDao;
import personas.data.PersonaDao;
import java.util.List;

public class Service {
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) theInstance = new Service();
        return theInstance;
    }

    private PersonaDao personaDao;
    private DepartamentoDao  departamentoDao;
    private EstadoCivilDao estadoCivilDao;

    private Service(){
        try{
            personaDao=new PersonaDao();
            departamentoDao=new DepartamentoDao();
            estadoCivilDao=new EstadoCivilDao();
        }
        catch(Exception e){
            System.exit(-1);
        }
    }

    public void stop(){
        try {
            Database.instance().close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // =============== PERSONAS ===============
    public void create(Persona e) throws Exception {
        personaDao.create(e);
    }

    public Persona read(Persona e) throws Exception {
        return  personaDao.read(e.getId());
    }

    public List<Persona> findAll(Persona e) {
        return personaDao.findAll();
    }

    public List<Persona> findByNombre(String nombre){
        Persona filtro = new Persona();
        filtro.setNombre(nombre);
        return personaDao.findByNombre(filtro);
    }

        // =============== DEPARTAMENTOS ===============
    public List<Departamento> findAll( Departamento e) {
        return departamentoDao.findAll();
    }

    // =============== ESTADOS CIVILES ===============
    public List<EstadoCivil> findAll( EstadoCivil e) {
        return estadoCivilDao.findAll();
    }
 }
