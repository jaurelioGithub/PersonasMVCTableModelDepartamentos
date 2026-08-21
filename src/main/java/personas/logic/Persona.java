package personas.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    @XmlID
    private String id;
    private String nombre;
    private char sexo;
    private String estadoCivil;
    private boolean pasatiempoMusica;
    private boolean pasatiempoCine;
    private boolean pasatiempoDeporte;
    private boolean pasatiempoVideoJuegos;
    private boolean pasatiempoCocina;
    private boolean pasatiempoOtro;
    private String pasatiempoOtroTexto;
    @XmlIDREF
    Departamento departamento;

    public static final char MASCULINO = 'M';
    public static final char FEMENINO = 'F';

    public Persona(String id, String nombre, char sexo, String estadoCivil, boolean pasatiempoMusica, boolean pasatiempoCine, boolean pasatiempoDeporte, boolean pasatiempoVideoJuegos, boolean pasatiempoCocina, boolean pasatiempoOtro, String pasatiempoOtroTexto) {
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
    }

    public Persona(String id, String nombre, char sexo, String estadoCivil) {
        this(id, nombre,sexo, estadoCivil, false, false, false, false, false, false, "");
    }
     public Persona(){
        this("", "", MASCULINO, "", false, false, false, false, false, false, "");
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
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
