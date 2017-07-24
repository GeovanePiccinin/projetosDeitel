/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicbrowser.jbb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
        
/**
 *
 * @author xyz
 */
public class JavaBasicBrowserJBB extends JFrame{

    
    private JTextField enterField; //onde inserir o nome do website
    private JEditorPane contentsArea; //exibir o website
    
    //configura a interface grafica no construtor dessa classe
    public JavaBasicBrowserJBB()
    {
        super("Simple Web Browser"); //chama o construtor de Jframe que recebe o titulo da janela
        
        //cria o campo de texto e registra o ouvinte para o evento dele
        enterField = new JTextField("Website URL");
        enterField.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getThePage(e.getActionCommand());
            }
        }
        );
        
        add(enterField, BorderLayout.NORTH);
        
        contentsArea = new JEditorPane();//cria o editor pane para mostrar o website
        contentsArea.setEditable(false);
        contentsArea.addHyperlinkListener(
                new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
                    getThePage(e.getURL().toString());
            }
        }
        );
        add(new JScrollPane(contentsArea), BorderLayout.CENTER);
        setSize(400, 300);//tamanho da janela
        setVisible(true);//mostra a janela
        
    }
    
    private void getThePage(String location)
    {
        try {
            contentsArea.setPage(location);
            enterField.setText(location);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error retrieving specified URL", "Bad URL",
                    JOptionPane.ERROR_MESSAGE
                    );
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaBasicBrowserJBB jbb = new JavaBasicBrowserJBB();
        jbb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
