package org.example;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

public class ThreadConnessione implements Runnable {
    private BenoliPallinaServer finestra;
    private Thread me;

    public ThreadConnessione(BenoliPallinaServer finestra) {
        this.finestra = finestra;
        me = new Thread(this);
        me.start();
    }

    public void run() {
        try{
            ServerSocket server= new ServerSocket(6789);
            finestra.setConnessione(server.accept());
            server.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.toString(),"errore",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
}
