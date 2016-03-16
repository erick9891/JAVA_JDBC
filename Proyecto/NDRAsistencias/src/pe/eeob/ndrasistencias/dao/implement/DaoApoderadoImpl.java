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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.eeob.ndrasistencias.dao.espec.DaoApoderadoEspec;
import pe.eeob.ndrasistencias.db.AccesoDB;
import pe.eeob.ndrasistencias.domain.Apoderado;


public class DaoApoderadoImpl implements DaoApoderadoEspec {

    @Override
    public Apoderado readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apoderado> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apoderado> readForCriteria(Apoderado bean) {
        List<Apoderado> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_APODNI, VCH_APOPATERNO, VCH_APOMATERNO, VCH_APONOMBRE, CHR_ESCUCODIGO " +
                  "FROM APODERADO " +
                  "WHERE CHR_APODNI LIKE ? AND VCH_APOPATERNO LIKE ? AND " + 
                  "VCH_APONOMBRE LIKE ? AND CHR_ESCUCODIGO LIKE ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getDni()+ "%");
            pstm.setString(2, bean.getPaterno()+ "%");
            pstm.setString(3, bean.getNombre() + "%");
            pstm.setString(4, bean.getCodigo_escuela()+ "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Apoderado apoderado = getBean(rs);
                lista.add(apoderado);
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
    public void insert(Apoderado bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Apoderado bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Apoderado getBean(ResultSet rs) throws SQLException {
        Apoderado bean = new Apoderado();
        bean.setDni(rs.getString("CHR_APODNI"));
        bean.setPaterno(rs.getString("VCH_APOPATERNO"));
        bean.setMaterno(rs.getString("VCH_APOMATERNO"));
        bean.setNombre(rs.getString("VCH_APONOMBRE"));
        bean.setCodigo_escuela(rs.getString("CHR_ESCUCODIGO"));
        return bean;
    }    

    @Override
    public List<String> getDniApos() {
        List<String> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
            cn = AccesoDB.getConnection();
            String sql = "SELECT CHR_APODNI "
                  + "FROM APODERADO ";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                lista.add(rs.getString(1));
            }
            rs.close();
            stm.close();    
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
}
