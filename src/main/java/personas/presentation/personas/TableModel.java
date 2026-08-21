package personas.presentation.personas;
import personas.logic.Persona;
import personas.presentation.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel<Persona> implements javax.swing.table.TableModel {
    public TableModel(int[] cols, List<Persona> rows) {
        super(cols, rows);
    }

    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int SEXO = 2;
    public static final int ESTADO = 3;
    public static final int DEPARTAMENTO = 4;

    @Override
    protected void initColNames() {
        colNames = new String[5];
        colNames[ID] = "Id";
        colNames[NOMBRE] = "Nombre";
        colNames[SEXO] = "Sexo";
        colNames[ESTADO] = "Estado";
        colNames[DEPARTAMENTO] = "Departamento";
    }
    @Override
    protected Object getPropetyAt(Persona e, int col) {
        switch (cols[col]) {
            case ID:
                return e.getId();
            case NOMBRE:
                return e.getNombre();
            case SEXO:
                switch (e.getSexo()) {
                    case Persona.MASCULINO:
                        return "Masculino";
                    case Persona.FEMENINO:
                        return "Femenino";
                    default:
                        return "";
                }
            case ESTADO:
                return e.getEstadoCivil();
            case DEPARTAMENTO:
                return e.getDepartamento().getNombre();
            default:
                return "";
        }
    }

}
