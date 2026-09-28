package personas.logic;

public class Persona {
    private String id;
    private String nombre;
    private char sexo;
    private EstadoCivil estadoCivil;
    private boolean pasatiempoMusica;
    private boolean pasatiempoCine;
    private boolean pasatiempoDeporte;
    private boolean pasatiempoVideoJuegos;
    private boolean pasatiempoCocina;
    private boolean pasatiempoOtro;
    private String pasatiempoOtroTexto;
    Departamento departamento;

    public static final char MASCULINO = 'M';
    public static final char FEMENINO = 'F';

    public Persona(String id, String nombre, char sexo, EstadoCivil estadoCivil, boolean pasatiempoMusica, boolean pasatiempoCine, boolean pasatiempoDeporte, boolean pasatiempoVideoJuegos, boolean pasatiempoCocina, boolean pasatiempoOtro, String pasatiempoOtroTexto, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.pasatiempoMusica = pasatiempoMusica;
        this.pasatiempoCine = pasatiempoCine;
        this.pasatiempoDeporte = pasatiempoDeporte;
        this.pasatiempoVideoJuegos = pasatiempoVideoJuegos;
        this.pasatiempoCocina = pasatiempoCocina;
        this.pasatiempoOtro = pasatiempoOtro;
        this.pasatiempoOtroTexto = pasatiempoOtroTexto;
        this.departamento = departamento;
    }

    public Persona(String id, String nombre, char sexo, EstadoCivil estadoCivil, Departamento departamento) {
        this(id, nombre,sexo, estadoCivil, false, false, false, false, false, false, "",departamento);
    }
     public Persona(){
        this("", "", MASCULINO, null, null);
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isPasatiempoMusica() {
        return pasatiempoMusica;
    }

    public void setPasatiempoMusica(boolean pasatiempoMusica) {
        this.pasatiempoMusica = pasatiempoMusica;
    }

    public boolean isPasatiempoCine() {
        return pasatiempoCine;
    }

    public void setPasatiempoCine(boolean pasatiempoCine) {
        this.pasatiempoCine = pasatiempoCine;
    }

    public boolean isPasatiempoDeporte() {
        return pasatiempoDeporte;
    }

    public void setPasatiempoDeporte(boolean pasatiempoDeporte) {
        this.pasatiempoDeporte = pasatiempoDeporte;
    }

    public boolean isPasatiempoVideoJuegos() {
        return pasatiempoVideoJuegos;
    }

    public void setPasatiempoVideoJuegos(boolean pasatiempoVideoJuegos) {
        this.pasatiempoVideoJuegos = pasatiempoVideoJuegos;
    }

    public boolean isPasatiempoCocina() {
        return pasatiempoCocina;
    }

    public void setPasatiempoCocina(boolean pasatiempoCocina) {
        this.pasatiempoCocina = pasatiempoCocina;
    }

    public boolean isPasatiempoOtro() {
        return pasatiempoOtro;
    }

    public void setPasatiempoOtro(boolean pasatiempoOtro) {
        this.pasatiempoOtro = pasatiempoOtro;
    }

    public String getPasatiempoOtroTexto() {
        return pasatiempoOtroTexto;
    }

    public void setPasatiempoOtroTexto(String pasatiempoOtroTexto) {
        this.pasatiempoOtroTexto = pasatiempoOtroTexto;
    }


    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
