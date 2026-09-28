/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.data;

import personas.logic.Departamento;
import personas.logic.EstadoCivil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoCivilDao {
    Database db;

    public EstadoCivilDao(){
        db= Database.instance();
    }

    public EstadoCivil read(String codigo) throws Exception{
        String sql="select * from EstadoCivil e where codigo=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, codigo);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            return from(rs,"e");
        }
        else{
            throw new Exception ("Estado Civil no Existe");
        }
    }

    public List<EstadoCivil> findAll(){
        List<EstadoCivil> ds=new ArrayList<EstadoCivil>();
        try {
            String sql="select * from EstadoCivil e";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs =  db.executeQuery(stm);
            while (rs.next()) {
                ds.add(from(rs,"e"));
            }
        } catch (SQLException ex) { }
        return ds;
    }
    
    public EstadoCivil from(ResultSet rs, String alias){
        try {
            EstadoCivil d= new EstadoCivil();
            d.setCodigo(rs.getString(alias + ".codigo"));
            d.setDescripcion(rs.getString(alias + ".descripcion"));
            return d;
        } catch (SQLException ex) {
            return null;
        }
    }    
}
