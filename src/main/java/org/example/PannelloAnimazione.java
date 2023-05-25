package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloAnimazione extends JPanel implements ActionListener {
    private BenoliPallinaServer finestra;
    private Dimension dimensioni;
    private Image bufferVirtuale;
    private Graphics offScreen;
    private Timer tim;
    private int xPallina=0;
    private int yPallina=0;
    private int diametroPallina=40;
    private int spostamento=3;
    private int timerDelay=10;
    private boolean destra,basso,pallinaPresente,arrivoComunicato;

    public PannelloAnimazione(BenoliPallinaServer finestra, Dimension dimensioni) {
        super();
        this.finestra = finestra;
        this.setSize(dimensioni);
        this.destra=true;
        this.basso=true;
        this.pallinaPresente=true;
        this.arrivoComunicato=false;
        tim=new Timer(timerDelay,this);
        tim.start();

    }
    @Override
    public void update(Graphics g){
        paint(g);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.bufferVirtuale=createImage(this.getWidth(),this.getHeight());
        this.offScreen=bufferVirtuale.getGraphics();
        Graphics2D screen = (Graphics2D) g;
        offScreen.setColor(new Color(254,138,22));
        if(pallinaPresente){
            offScreen.fillOval(xPallina,yPallina,diametroPallina,diametroPallina);
        }
        screen.drawImage(bufferVirtuale,0,0,this);
        offScreen.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(pallinaPresente){
            //direzione in Verticale
            if(basso){
                if(yPallina>(this.getHeight()-this.diametroPallina)){
                    //fino qua!!
                }
            }
        }
    }
}
