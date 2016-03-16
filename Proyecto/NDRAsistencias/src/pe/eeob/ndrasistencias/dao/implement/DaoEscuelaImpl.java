/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoEscuelaEspec;
import pe.eeob.ndrasistencias.db.AccesoDB;
import pe.eeob.ndrasistencias.domain.Escuela;

/**
 *
 * @author ErickOre
 */
public class DaoEscuelaImpl implements DaoEscuelaEspec{

    @Override
    public Escuela readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Escuela> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Escuela> readForCriteria(Escuela bean) {
        List<Escuela> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_ESCUCODIGO, VCH_ESCUNOMBRE, CHR_SEDECODIGO " +
                  "FROM ESCUELA " +
                  "WHERE VCH_ESCUNOMBRE LIKE ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getNombre() + "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Escuela escuela = getBean(rs);
                lista.add(escuela);
            }
            rs.close();
            pstm.close();    
        } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
        String mensaje = "Se ha producido un error, intentelo mas tarde.";
        if (e.getMessage() != null && !e.getMessage().isEmpty()) {
          mensaje += (" " + e.getMessage());
        }
        throw new RuntimeException(mensaje);
      } finally {
        try {
          cn.close();
        } catch (Exception e) {
        }
      }
      return lista;        
}        


    @Override
    public void insert(Escuela bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Escuela bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Escuela getBean(ResultSet rs) throws SQLException {
        Escuela bean = new Escuela();
        bean.setCodigo(rs.getString("CHR_ESCUCODIGO"));
        bean.setNombre(rs.getString("VCH_ESCUNOMBRE"));
        bean.setCodigo_sede(rs.getString("CHR_SEDECODIGO"));
        return bean;
    }    
}
