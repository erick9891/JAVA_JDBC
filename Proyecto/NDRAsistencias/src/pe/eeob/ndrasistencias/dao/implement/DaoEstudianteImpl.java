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
import pe.eeob.ndrasistencias.dao.espec.DaoEstudianteEspec;
import pe.eeob.ndrasistencias.db.AccesoDB;
import pe.eeob.ndrasistencias.domain.Estudiante;


public class DaoEstudianteImpl implements DaoEstudianteEspec {

    @Override
    public Estudiante readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> readForCriteria(Estudiante bean) {
        List<Estudiante> lista = new ArrayList<>();        
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "SELECT CHR_ESTUDNI, VCH_ESTUPATERNO, VCH_ESTUMATERNO, VCH_ESTUNOMBRE, VCH_ESTUEDAD, " +
                  "VCH_ESTUDISTRITO, CHR_APODNI " +
                  "FROM ESTUDIANTE " +
                  "WHERE CHR_ESTUDNI LIKE ? AND VCH_ESTUPATERNO LIKE ? AND " + 
                  "VCH_ESTUNOMBRE LIKE ? AND VCH_ESTUEDAD LIKE ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getDni()+ "%");
            pstm.setString(2, bean.getPaterno()+ "%");
            pstm.setString(3, bean.getNombre() + "%");
            pstm.setString(4, bean.getEdad()+ "%");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                Estudiante estudiante = getBean(rs);
                lista.add(estudiante);
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
    public void insert(Estudiante bean) {
        Connection cn = null;
        try {
            // Acceso al objeto Connection
            cn = AccesoDB.getConnection();
            // Inicia Tx
            cn.setAutoCommit(false);
            // Actualizar contador
            String sql = "UPDATE CONTADOR " +
                    "SET INT_CONTITEM = INT_CONTITEM + 1" +
                    "WHERE VCH_CONTTABLA = 'Estudiante' "
                    ;
            PreparedStatement pstm = cn.prepareStatement(sql);
            int filas = pstm.executeUpdate();
            pstm.close();
            if (filas == 0) {
              throw new Exception("Contador cno existe.");
            }            
            // Insertar cliente
            String sql1 = "INSERT INTO ESTUDIANTE VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstm1 = cn.prepareStatement(sql1);
            pstm1.setString(1, bean.getDni());
            pstm1.setString(2, bean.getPaterno());
            pstm1.setString(3, bean.getMaterno());
            pstm1.setString(4, bean.getNombre());
            pstm1.setString(5, bean.getEdad());
            pstm1.setString(6, bean.getDistrito());
            pstm1.setString(7, bean.getDni_apoderado());
            pstm1.executeQuery();
            pstm.close();
            // Confirmar Tx
            cn.commit();
        } catch (Exception e) {
            try {
                  // Cancela Tx
                  cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso, intentelo mas tarde.";
            if(e.getMessage() != null && !e.getMessage().isEmpty()){
                  mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(mensaje);
        } finally {
          try {
                cn.close();
          } catch (Exception e) {
          }
        }

    }

    @Override
    public void update(Estudiante bean) {
        Connection cn = null;
        try {
            // Acceso al objeto Connection
            cn = AccesoDB.getConnection();
            // Inicia Tx
            cn.setAutoCommit(false);      
            // Actualizar
            String sql1 = "UPDATE ESTUDIANTE "
                    + "SET VCH_ESTUPATERNO = ?, "
                        + "VCH_ESTUMATERNO = ?, "
                        + "VCH_ESTUNOMBRE = ?, "
                        + "VCH_ESTUEDAD = ?, "
                        + "VCH_ESTUDISTRITO = ?, "
                        + "CHR_APODNI = ? " 
                        + "WHERE CHR_ESTUDNI = ?";
            PreparedStatement pstm1 = cn.prepareStatement(sql1);

            pstm1.setString(1, bean.getPaterno());
            pstm1.setString(2, bean.getMaterno());
            pstm1.setString(3, bean.getNombre());
            pstm1.setString(4, bean.getEdad());
            pstm1.setString(5, bean.getDistrito());
            pstm1.setString(6, bean.getDni_apoderado());
            pstm1.setString(7, bean.getDni());
            
            pstm1.executeQuery();
            pstm1.close();
            // Confirmar Tx
            cn.commit();
        } catch (Exception e) {
            try {
                  // Cancela Tx
                  cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso, intentelo mas tarde.";
            if(e.getMessage() != null && !e.getMessage().isEmpty()){
                  mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(mensaje);
        } finally {
          try {
                cn.close();
          } catch (Exception e) {
          }
        }

    }

    @Override
    public void delete(String codigo) {
        Connection cn = null;
        try {
            // Acceso al objeto Connection
            cn = AccesoDB.getConnection();
            // Inicia Tx
            cn.setAutoCommit(false);      
            // Actualizar
            String sql1 = "DELETE FROM ESTUDIANTE WHERE CHR_ESTUDNI = ?";
            PreparedStatement pstm = cn.prepareStatement(sql1);
            pstm.setString(1, codigo);
            pstm.executeQuery();
            pstm.close();
            // Confirmar Tx
            cn.commit();
        } catch (Exception e) {
            try {
                  // Cancela Tx
                  cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso, intentelo mas tarde.";
            if(e.getMessage() != null && !e.getMessage().isEmpty()){
                  mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(mensaje);
        } finally {
          try {
                cn.close();
          } catch (Exception e) {
          }
        }

    }
    
    public Estudiante getBean(ResultSet rs) throws SQLException {
        Estudiante bean = new Estudiante();
        bean.setDni(rs.getString("CHR_ESTUDNI"));
        bean.setPaterno(rs.getString("VCH_ESTUPATERNO"));
        bean.setMaterno(rs.getString("VCH_ESTUMATERNO"));
        bean.setNombre(rs.getString("VCH_ESTUNOMBRE"));
        bean.setEdad(rs.getString("VCH_ESTUEDAD"));
        bean.setDistrito(rs.getString("VCH_ESTUDISTRITO"));
        bean.setDni_apoderado(rs.getString("CHR_APODNI"));
        return bean;
    }    

    @Override
    public List<String> getDniApo() {
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
