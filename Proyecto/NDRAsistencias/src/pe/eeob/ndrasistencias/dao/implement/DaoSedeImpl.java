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
import pe.eeob.ndrasistencias.dao.espec.DaoSedeEspec;
import pe.eeob.ndrasistencias.db.AccesoDB;
import pe.eeob.ndrasistencias.domain.Sede;

/**
 *
 * @author ErickOre
 */
public class DaoSedeImpl implements DaoSedeEspec {

    @Override
    public Sede readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sede> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sede> readForCriteria(Sede bean) {
        List<Sede> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_SEDECODIGO, VCH_SEDENOMBRE, VCH_SEDECIUDAD " +
                  "FROM SEDE " +
                  "WHERE VCH_SEDENOMBRE LIKE ? AND VCH_SEDECIUDAD LIKE ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getNombre() + "%");
            pstm.setString(2, bean.getCiudad() + "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Sede sede = getBean(rs);
                lista.add(sede);
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
    public void insert(Sede bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Sede bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Sede getBean(ResultSet rs) throws SQLException {
        Sede bean = new Sede();
        bean.setCodigo(rs.getString("CHR_SEDECODIGO"));
        bean.setNombre(rs.getString("VCH_SEDENOMBRE"));
        bean.setCiudad(rs.getString("VCH_SEDECIUDAD"));
        return bean;
    }
    
}
