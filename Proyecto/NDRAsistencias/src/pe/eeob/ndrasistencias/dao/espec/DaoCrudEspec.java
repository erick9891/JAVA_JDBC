package pe.eeob.ndrasistencias.dao.espec;

import java.util.List;

/**
 *
 * @author ErickOre
 */
public interface DaoCrudEspec<T> {
  
  T readForId(String codigo);
  
  List<T> readAll();
  
  List<T> readForCriteria(T bean);
  
  void insert(T bean);
  
  void update(T bean);
  
  void delete(String codigo);
  
}