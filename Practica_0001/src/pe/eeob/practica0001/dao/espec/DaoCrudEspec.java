package pe.eeob.practica0001.dao.espec;

import java.util.List;

/**
 *
 * @author ErickOre
 * @param <T>
 */
public interface DaoCrudEspec<T> {
    List<T> readForCriteria(T bean);
}
