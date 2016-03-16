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
import pe.eeob.ndrasistencias.dao.espec.DaoMaestroEspec;
import pe.eeob.ndrasistencias.db.AccesoDB;
import pe.eeob.ndrasistencias.domain.Maestro;


public class DaoMaestroImpl implements DaoMaestroEspec {

    @Override
    public Maestro validar(String usuario, String clave) {
        Maestro maestro = null;
        Connection cn = null;  
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_MAESDNI, VCH_MAESPATERNO, VCH_MAESMATERNO, VCH_MAESNOMBRE, VCH_MAESDISTRITO, "
                  + "VCH_MAESTELEFONO, VCH_MAESEDUCACION, VCH_MAESUSUARIO, CHR_ESCUCODIGO " +
                    "FROM MAESTRO " +
                    "WHERE VCH_MAESUSUARIO = ? AND VCH_MAESCLAVE = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                maestro = getBean(rs);
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
        
        return maestro;
    }

    @Override
    public Maestro readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Maestro> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Maestro> readForCriteria(Maestro bean) {
        List<Maestro> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_MAESDNI, VCH_MAESPATERNO, VCH_MAESMATERNO, VCH_MAESNOMBRE, VCH_MAESDISTRITO, " +
                  "VCH_MAESTELEFONO, VCH_MAESEDUCACION, VCH_MAESUSUARIO, CHR_ESCUCODIGO " +
                  "FROM MAESTRO " +
                  "WHERE CHR_MAESDNI LIKE ? AND VCH_MAESPATERNO LIKE ? AND " + 
                  "VCH_MAESNOMBRE LIKE ? AND CHR_ESCUCODIGO LIKE ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getDni()+ "%");
            pstm.setString(2, bean.getPaterno()+ "%");
            pstm.setString(3, bean.getNombre() + "%");
            pstm.setString(4, bean.getEscuela_codigo()+ "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Maestro maestro = getBean(rs);
                lista.add(maestro);
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
    public void insert(Maestro bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Maestro bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Maestro getBean(ResultSet rs) throws SQLException {
        Maestro bean = new Maestro();
        bean.setDni(rs.getString("CHR_MAESDNI"));
        bean.setPaterno(rs.getString("VCH_MAESPATERNO"));
        bean.setMaterno(rs.getString("VCH_MAESMATERNO"));
        bean.setNombre(rs.getString("VCH_MAESNOMBRE"));
        bean.setDistrito(rs.getString("VCH_MAESDISTRITO"));
        bean.setTelefono(rs.getString("VCH_MAESTELEFONO"));
        bean.setEducacion(rs.getString("VCH_MAESEDUCACION"));
        bean.setUsuario(rs.getString("VCH_MAESUSUARIO"));
        bean.setEscuela_codigo(rs.getString("CHR_ESCUCODIGO"));
        return bean;
    }
}
