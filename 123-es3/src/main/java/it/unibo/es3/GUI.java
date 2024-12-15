package it.unibo.es3;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class GUI extends JFrame {
    
    private final Map<JButton, Pair<Integer, Integer>> buttons = new HashMap<>();
    private final JButton go = new JButton(">");
    private final Logics logics;
    
    public GUI(int size) {
        this.logics = new LogicsImpl(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*size, 50*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
          
        go.addActionListener( e -> {

            logics.hit();
            updateMatrix();

            if(logics.toQuit()){
                System.exit(1);
            }

        }
        );
        
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }

        this.getContentPane().add(BorderLayout.SOUTH,go);
        updateMatrix();
        this.setVisible(true);
    }

    private void updateMatrix() {
        Set<Pair<Integer,Integer>> tmp = logics.positions();
        buttons.forEach( (button,pair) -> {if(tmp.contains(pair))button.setText("*"); else button.setText("");}); 
    }
}