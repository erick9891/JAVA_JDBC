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
import pe.eeob.ndrasistencias.dao.espec.DaoAulaEspec;
import pe.eeob.ndrasistencias.db.AccesoDB;
import pe.eeob.ndrasistencias.domain.Aula;
import pe.eeob.ndrasistencias.domain.Sede;

/**
 *
 * @author ErickOre
 */
public class DaoAulaImpl implements DaoAulaEspec{

    @Override
    public Aula readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aula> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aula> readForCriteria(Aula bean) {
        List<Aula> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_AULACODIGO, VCH_AULADESCRIPCION " +
                  "FROM AULA " +
                  "WHERE VCH_AULADESCRIPCION LIKE ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getDescripcion()+ "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Aula aula = getBean(rs);
                lista.add(aula);
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
    public void insert(Aula bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Aula bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Aula getBean(ResultSet rs) throws SQLException {
        Aula bean = new Aula();
        bean.setCodigo(rs.getString("CHR_AULACODIGO"));
        bean.setDescripcion(rs.getString("VCH_AULADESCRIPCION"));
        return bean;
    }
    
}
