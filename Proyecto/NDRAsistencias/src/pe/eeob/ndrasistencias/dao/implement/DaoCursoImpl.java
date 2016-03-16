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
import pe.eeob.ndrasistencias.dao.espec.DaoCursoEspec;
import pe.eeob.ndrasistencias.db.AccesoDB;
import pe.eeob.ndrasistencias.domain.Curso;


public class DaoCursoImpl implements DaoCursoEspec {

    @Override
    public Curso readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> readAll() {
        List<Curso> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_CURSOCODIGO, CHR_SEDECODIGO, CHR_AULACODIGO, CHR_MAESDNI, VCH_CURSOPERIODO "
                  + "FROM CURSO ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Curso curso = getBean(rs);
                lista.add(curso);
            }
            rs.close();
            st.close();    
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
    public List<Curso> readForCriteria(Curso bean) {
        List<Curso> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_CURSOCODIGO, CHR_SEDECODIGO, CHR_AULACODIGO, CHR_MAESDNI, VCH_CURSOPERIODO " +
                  "FROM CURSO " +
                  "WHERE CHR_SEDECODIGO LIKE ? AND CHR_AULACODIGO LIKE ? AND " + 
                  "VCH_CURSOPERIODO LIKE ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getCodigo_sede()+ "%");
            pstm.setString(2, bean.getCodigo_aula()+ "%");
            pstm.setString(3, bean.getPeriodo()+ "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Curso curso = getBean(rs);
                lista.add(curso);
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
    public void insert(Curso bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Curso bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }     
    
    @Override
    public List<String> getCursoPeriodo() {
        List<String> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
            cn = AccesoDB.getConnection();
            String sql = "SELECT DISTINCT VCH_CURSOPERIODO "
                  + "FROM CURSO ";
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
    
    public Curso getBean(ResultSet rs) throws SQLException {
        Curso bean = new Curso();
        bean.setCodigo(rs.getString("CHR_CURSOCODIGO"));
        bean.setCodigo_sede(rs.getString("CHR_SEDECODIGO"));
        bean.setCodigo_aula(rs.getString("CHR_AULACODIGO"));
        bean.setDni_maestro(rs.getString("CHR_MAESDNI"));
        bean.setPeriodo(rs.getString("VCH_CURSOPERIODO"));
        return bean;
    }       
}
