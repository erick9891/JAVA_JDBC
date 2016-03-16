package pe.eeob.ndrasistencias.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gustavo Coronel
 */
public final class Memoria {

    static String s1;

    public static String getS1() {
        return s1;
    }

    public static void setS1(String s1) {
        Memoria.s1 = s1;
    }
    
  private Memoria() {
  }
  
  private static final Map<String,Object> datos;
  
  static {
    datos = new HashMap<>();
  }
  
  public static void put(String key, Object value){
    datos.put(key, value);
  }
  
  
  public static Object get(String key){
    return datos.get(key);
  }
  
}
