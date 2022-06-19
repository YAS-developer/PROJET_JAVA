import java.awt.*;
import javax.swing.*;

public class VueColor extends JComponent{
    Color coul; 
    
    public VueColor(Color c){
        if(c==Color.blue || c.equals(new Color(0,0,255))){c=new Color(0,0,255);}
		else if(c==Color.green || c.equals(new Color(0,255,0))){c=new Color(0,255,0);}
		else if(c==Color.magenta || c.equals(new Color(255,0,255))){c=new Color(255,0,255);}
		else if(c==Color.orange || c.equals(new Color(255,200,0))){c=new Color(255,200,0);}
		else if(c==Color.red || c.equals(new Color(255,0,0))){c=new Color(255,0,0);}
		else if(c==Color.pink || c.equals(new Color(255,175,175))){c=new Color(255,175,175);}
		else if(c==Color.yellow || c.equals(new Color(255,255,0))){c=new Color(255,255,0);}
		else if(c==Color.darkGray || c.equals(new Color(64,64,64))){c=new Color(64,64,64);}
        else{
			System.out.println("Couleur non compris dans le jeu");
			System.exit(0);
		}

        this.coul = c;
    }

    public Color getColor(){
        return this.coul;
    }

    @Override
    protected void 	paintComponent (Graphics g){
        Graphics secondPinceau = g.create();

        secondPinceau.setColor(getColor());
        secondPinceau.fillOval(20, 10, 50, 50);
    }

}