/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ErickOre
 */
public class Dialogo {
  private Dialogo() {
  }
  
  public static void error(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA ERROR", JOptionPane.ERROR_MESSAGE);
  }
  
  public static void info(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA INFO", JOptionPane.INFORMATION_MESSAGE);
  }    
}
