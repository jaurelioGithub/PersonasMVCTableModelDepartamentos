package personas.presentation.personas;

import personas.logic.Departamento;
import personas.logic.Persona;
import personas.logic.Service;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
        model.setDepartamentos(Service.instance().search(new Departamento()));
        model.setList(Service.instance().findAll());
    }

    public void create(Persona e) throws  Exception{
        Service.instance().create(e);
        model.setCurrent(new Persona());
        model.setList(Service.instance().findAll());
    }

    public void read(String id) throws Exception {
        Persona e = new Persona();
        e.setId(id);
        try {
            model.setCurrent(Service.instance().read(e));
        } catch (Exception ex) {
            Persona b = new Persona();
            b.setId(id);
            model.setCurrent(b);
            throw ex;
        }
    }

    public void clear() {
        model.setCurrent(new Persona());
    }

    public void edit(int row) {
        Persona e = model.getList().get(row);
        model.setCurrent(e);
    }
}
