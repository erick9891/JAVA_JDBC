package pe.eeob.practica0001.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.eeob.practica0001.db.AccesoDB;
import pe.eeob.practica0001.domain.Cliente;
import pe.eeob.practica0001.dao.espec.DaoClienteEspec;

/**
 *
 * @author ErickOre
 */
public class DaoClienteImpl implements DaoClienteEspec{

    @Override
    public List<Cliente> readForCriteria(Cliente bean) {
        List<Cliente> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_CLIECODIGO, VCH_CLIEPATERNO, VCH_CLIEMATERNO, "
                  + "VCH_CLIENOMBRE, CHR_CLIEDNI, VCH_CLIECIUDAD, VCH_CLIEDIRECCION, "
                  + "VCH_CLIETELEFONO, VCH_CLIEEMAIL " +
                  "FROM CLIENTE " +
                  "WHERE VCH_CLIENOMBRE LIKE ? AND "
                  + "VCH_CLIEPATERNO LIKE ? AND "
                  + "CHR_CLIEDNI LIKE ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getNombre() + "%");
            pstm.setString(2, bean.getPaterno() + "%");
            pstm.setString(3, bean.getDni() + "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Cliente cliente = getBean(rs);
                lista.add(cliente);
            }
            rs.close();
            pstm.close();    } catch (SQLException e) {
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
    
    private Cliente getBean(ResultSet rs) throws SQLException {
        Cliente bean = new Cliente();
        bean.setCodigo(rs.getString("CHR_CLIECODIGO"));
        bean.setPaterno(rs.getString("VCH_CLIEPATERNO"));
        bean.setMaterno(rs.getString("VCH_CLIEMATERNO"));
        bean.setNombre(rs.getString("VCH_CLIENOMBRE"));
        bean.setDni(rs.getString("CHR_CLIEDNI"));
        bean.setCiudad(rs.getString("VCH_CLIECIUDAD"));
        bean.setDireccion(rs.getString("VCH_CLIEDIRECCION"));
        bean.setTelefono(rs.getString("VCH_CLIETELEFONO"));
        bean.setEmail(rs.getString("VCH_CLIEEMAIL"));
        return bean;
    }
}
