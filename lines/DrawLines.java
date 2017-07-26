import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLines extends JPanel
{
    //desenha um X a partir dos cantos do painel
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        
        int width = getWidth();
        int height = getHeight();
        
        int stepSize = height/20;
        int posicaoInicialY = 0;
        int posicaoInicialX = 0;
        
        for(int i=0; i<20; i++)
        {            
            g.drawLine(0, posicaoInicialY, posicaoInicialX, height);
            
            g.drawLine(width, posicaoInicialY, (width - posicaoInicialX), height);
            
            g.drawLine((width - posicaoInicialX) , 0, width , (height-posicaoInicialY));
            
            g.drawLine(posicaoInicialX , 0, 0 , (height-posicaoInicialY));
            
            posicaoInicialY += stepSize;
            posicaoInicialX += stepSize;
            
            
        }
        /* 
        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
        */
    }
    
    public static void main(String args[])
    {
        DrawLines panel = new DrawLines();
        
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        app.add(panel);
        app.setSize(250, 250);
        app.setVisible(true);
    }
}
