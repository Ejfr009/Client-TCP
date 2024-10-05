/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.tcp;

import Libreria.EstructuraDatos;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;


/**
 *
 * @author Leo
 */
public class ActualizadorTexto extends Thread {

    private Socket socket2;
    private EstructuraDatos datos;
    private ObjectOutputStream out2; 
    private ObjectInputStream in2; 
    private boolean respuesta;
    public Logout logoutAuxiliar;
    
    public ActualizadorTexto(Logout logoutAuxiliar) {
        super("TCPServerHilo");
        this.logoutAuxiliar = logoutAuxiliar;
        
        
    }
    @Override
    public void run() {
        
        Timer timer;
        timer = new Timer(1000, (ActionEvent e) -> {
            
            String enLinea= new String();
            try {
                enLinea=(String) logoutAuxiliar.in.readObject();
            } catch (IOException ex) {
                Logger.getLogger(ActualizadorTexto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActualizadorTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            logoutAuxiliar.jTextArea2.setText(enLinea);
        
        });
        timer.setRepeats(true); // Para que solo se ejecute una vez
        timer.start();
        
    }    
        
    
    
}
