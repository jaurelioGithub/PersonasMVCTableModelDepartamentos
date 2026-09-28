/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.data;

import personas.logic.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {
    Database db;
    
    public PersonaDao(){
        db= Database.instance();
    }
    public void create(Persona p) throws Exception{
        String sql="insert into Persona (id, nombre, sexo, departamento, estadoCivil, pasatiempoMusica,"+
                " pasatiempoCine, pasatiempoDeporte, pasatiempoVideoJuegos, pasatiempoCocina,"+
                "pasatiempoOtro,pasatiempoOtroTexto) "+
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getId());
        stm.setString(2, p.getNombre());
        stm.setString(3, String.valueOf(p.getSexo()));
        stm.setString(4, p.getDepartamento().getCodigo());
        stm.setString(5, p.getEstadoCivil().getCodigo());
        stm.setBoolean(6, p.isPasatiempoMusica());
        stm.setBoolean(7, p.isPasatiempoCine());
        stm.setBoolean(8, p.isPasatiempoDeporte());
        stm.setBoolean(9, p.isPasatiempoVideoJuegos());
        stm.setBoolean(10, p.isPasatiempoCocina());
        stm.setBoolean(11, p.isPasatiempoOtro());
        stm.setString(12, p.getPasatiempoOtroTexto());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Persona ya existe");
        }
    }

    public Persona read(String id) throws Exception{
        String sql="select * from Persona p "+
                "inner join Departamento d on p.departamento=d.codigo "+
                "inner join Estadocivil e on p.estadocivil=e.codigo "+
                "where p.id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        Persona p;
        DepartamentoDao dd= new DepartamentoDao();
        EstadoCivilDao ed= new EstadoCivilDao();
        if (rs.next()) {
            p= from(rs,"p");
            p.setDepartamento(dd.from(rs,"d"));
            p.setEstadoCivil(ed.from(rs,"e"));
            return p;
        }
        else{
            throw new Exception ("Persona no Existe");
        }
    }
    
    public void update(Persona p) throws Exception{
        String sql="update persona set nombre=?,sexo=?,departamento=?,estadoCivil=?,"+
                "pasatiempoMusica=?,pasatiempoCine=?,pasatiempoDeporte=?,"+
                "pasatiempoVideoJuegos=?,pasatiempoCocina=?,pasatiempoOtro=?,"+
                "pasatiempoOtroTexto=? "+
                "where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getNombre());
        stm.setString(2, String.valueOf(p.getSexo()));
        stm.setString(3, p.getDepartamento().getCodigo());
        stm.setString(4, p.getEstadoCivil().getCodigo());
        stm.setBoolean(5, p.isPasatiempoMusica());
        stm.setBoolean(6, p.isPasatiempoCine());
        stm.setBoolean(7, p.isPasatiempoDeporte());
        stm.setBoolean(8, p.isPasatiempoVideoJuegos());
        stm.setBoolean(9, p.isPasatiempoCocina());
        stm.setBoolean(10, p.isPasatiempoOtro());
        stm.setString(11, p.getPasatiempoOtroTexto());
        stm.setString(12, p.getId());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Persona no existe");
        }
    }

    public void delete(Persona o) throws Exception{
        String sql="delete from Persona where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, o.getId());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Persona no existe");
        }
    }

    public List<Persona> findAll(){
        List<Persona> resultado = new ArrayList<Persona>();
        try {
            String sql="select * from Persona p "+
                    "inner join Departamento d on p.departamento=d.codigo "+
                    "inner join Estadocivil e on p.estadocivil=e.codigo";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs =  db.executeQuery(stm);
            Persona p;
            DepartamentoDao dd= new DepartamentoDao();
            EstadoCivilDao ed= new EstadoCivilDao();
            while (rs.next()) {
                p= from(rs,"p");
                p.setDepartamento(dd.from(rs,"d"));
                p.setEstadoCivil(ed.from(rs,"e"));
                resultado.add(p);
            }
        } catch (SQLException ex) {  }
        return resultado;
    }

    public List<Persona> findByNombre(Persona filtro){
        List<Persona> resultado = new ArrayList<Persona>();
        try {
            String sql="select * from Persona p "+
                    "inner join Departamento d on p.departamento=d.codigo "+
                    "inner join Estadocivil e on p.estadocivil=e.codigo "+
                    "where p.nombre like ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, "%"+filtro.getNombre()+"%");
        ResultSet rs =  db.executeQuery(stm);
        Persona p;
        DepartamentoDao dd= new DepartamentoDao();
        EstadoCivilDao ed= new EstadoCivilDao();
        while (rs.next()) {
                p= from(rs,"p");
                p.setDepartamento(dd.from(rs,"d"));
                p.setEstadoCivil(ed.from(rs,"e"));
                resultado.add(p);
            }
        } catch (SQLException ex) {  }
        return resultado;
    }
    
    private Persona from(ResultSet rs, String alias){
        try {
            Persona p= new Persona();
            p.setId(rs.getString(alias + ".id"));
            p.setNombre(rs.getString(alias + ".nombre"));
            p.setSexo(rs.getString(alias + ".sexo").charAt(0));
            p.setPasatiempoCine(rs.getBoolean(alias + ".pasatiempoCine"));
            p.setPasatiempoCocina(rs.getBoolean(alias + ".pasatiempoCocina"));
            p.setPasatiempoDeporte(rs.getBoolean(alias + ".pasatiempoDeporte"));
            p.setPasatiempoMusica(rs.getBoolean(alias + ".pasatiempoMusica"));
            p.setPasatiempoVideoJuegos(rs.getBoolean(alias + ".pasatiempoVideoJuegos"));
            p.setPasatiempoOtro(rs.getBoolean(alias + ".pasatiempoOtro"));
            p.setPasatiempoOtroTexto(rs.getString(alias + ".pasatiempoOtroTexto"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
}
