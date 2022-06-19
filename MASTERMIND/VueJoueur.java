import javax.swing.*;
import java.awt.*;

public class VueJoueur extends JPanel { 
    
    protected VueColor rond_blue = new VueColor(Color.blue);
    protected VueColor rond_green = new VueColor(Color.green);
    protected VueColor rond_magenta = new VueColor(Color.magenta); 
    protected VueColor rond_orange = new VueColor(Color.orange);
    protected VueColor rond_red = new VueColor(Color.red);
    protected VueColor rond_pink = new VueColor(Color.pink);
    protected VueColor rond_yellow = new VueColor(Color.yellow);
    protected VueColor rond_darkGray = new VueColor(Color.darkGray);    
    
    
    public VueJoueur(Controleur contr) {
        GridLayout panel_grid = new GridLayout(2,1);    
        this.setLayout(panel_grid);

        JPanel rond = new JPanel();
        GridLayout panel_rond = new GridLayout(2,4);
        rond.setLayout(panel_rond);

        this.rond_blue.addMouseListener(contr);
        this.rond_green.addMouseListener(contr);
        this.rond_magenta.addMouseListener(contr);
        this.rond_orange.addMouseListener(contr);
        this.rond_red.addMouseListener(contr);
        this.rond_pink.addMouseListener(contr);
        this.rond_yellow.addMouseListener(contr);
        this.rond_darkGray.addMouseListener(contr);


        rond.add(this.rond_blue);
        rond.add(this.rond_green);
        rond.add(this.rond_magenta);
        rond.add(this.rond_orange);
        rond.add(this.rond_red);
        rond.add(this.rond_pink);
        rond.add(this.rond_yellow);
        rond.add(this.rond_darkGray);

        this.add(rond);

        JButton btn = new JButton("Valider");
        JButton btn2 = new JButton("Effacer");
        JButton btn3 = new JButton("Aleatoire");

        JPanel button = new JPanel();
        

   
        btn.addActionListener(contr);
        btn2.addActionListener(contr);
        btn3.addActionListener(contr);

        button.add(btn);
        button.add(btn2);
        button.add(btn3);

        this.add(button);
    }

    // permet de recuperer un VueColor  
    public JComponent getRond(int indice){
        switch(indice){
            case 1: return this.rond_blue; 
            case 2: return this.rond_green;
            case 3: return this.rond_magenta;
            case 4: return this.rond_orange;
            case 5: return this.rond_red;
            case 6: return this.rond_pink;
            case 7: return this.rond_yellow;
            default : return this.rond_darkGray;
        }
    }
   
}
    

