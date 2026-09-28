/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.data;

import personas.logic.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDao {
    Database db;

    public DepartamentoDao(){
        db= Database.instance();
    }

    public Departamento read(String codigo) throws Exception{
        String sql="select * from Departamento d where codigo=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, codigo);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            return from(rs,"d");
        }
        else{
            throw new Exception ("Departamento no Existe");
        }
    }

    public List<Departamento> findAll(){
        List<Departamento> ds=new ArrayList<Departamento>();
        try {
            String sql="select * from Departamento d";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs =  db.executeQuery(stm);
            while (rs.next()) {
                ds.add(from(rs,"d"));
            }
        } catch (SQLException ex) { }
        return ds;
    }
    
    public Departamento from(ResultSet rs, String alias){
        try {
            Departamento d= new Departamento();
            d.setCodigo(rs.getString(alias + ".codigo"));
            d.setNombre(rs.getString(alias + ".nombre"));
            return d;
        } catch (SQLException ex) {
            return null;
        }
    }
}
