package org.example;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BenoliPallinaServer extends JFrame {
    private Socket conn;
    private DataOutputStream out;
    private DataInputStream in;
    public BenoliPallinaServer(){
        super("PallaNet - Server");
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ThreadConnessione attemndiConnessione = new ThreadConnessione(this);
        this.setVisible(true);
    }

    public void setConnessione(Socket connessione) {
        this.conn=connessione;
        try{
            out = new DataOutputStream(connessione.getOutputStream());
            in = new DataInputStream(connessione.getInputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.toString(),"errore",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        //inizio l'animazione su un oggetto panneloanimazione
        PannelloAnimazione pan = new PannelloAnimazione(this,this.getSize());
        //lo aggiungo al frame
        this.add(pan);
    }

    public DataOutputStream getOutput() {
        return out;
    }

    public DataInputStream getInput() {
        return in;
    }
}
