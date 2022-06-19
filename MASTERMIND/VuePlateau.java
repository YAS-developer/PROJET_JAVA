import java.awt.*;
import javax.swing.*;


public class VuePlateau extends JComponent{
	private Combinaison[] prop = new Combinaison[10];
	private Combinaison[] rep = new Combinaison[10];


	public VuePlateau( Combinaison[] prop,Combinaison[] rep){
		super();
		this.prop = prop;
		this.rep = rep;
	}

	@Override
    protected void 	paintComponent (Graphics g){
        Graphics secondPinceau = g.create();
        if (this.isOpaque()) {
            secondPinceau.setColor(this.getBackground());
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
          }
        secondPinceau.setColor(new Color(192,192,192));
		
		// PROPOSITION (prop[])

		int sum = 50;
		int mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[0].choix[i]);
			secondPinceau.fillOval(sum*mult, 55, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;
		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[1].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*2, 50, 50);
			mult++;
		}
		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[2].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*3, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[3].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*4, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[4].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*5, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[5].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*6, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[6].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*7, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[7].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*8, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[8].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*9, 50, 50);
			mult++;
		}

		sum = 50;
		mult =1;

		for(int i = 0; i < 5; i++){
			secondPinceau.setColor(this.prop[9].choix[i]);
			secondPinceau.fillOval(sum*mult, 55*10, 50, 50);
			mult++;
		}
		
		






		// REPONSE (rep[])

		sum = 50;
		mult =1;
		int l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[0].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[1].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*2, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[2].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*3, 30, 30);
			mult++;
		}
		sum = 50;
		mult =1;
		l = 300; 
		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[3].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*4, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[4].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*5, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[5].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*6, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[6].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*7, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[7].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*8, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[8].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*9, 30, 30);
			mult++;
		}

		sum = 50;
		mult =1;
		l = 300; 

		for(int i = 0; i <5 ; i++){
			secondPinceau.setColor(this.rep[9].choix[i]);
			secondPinceau.fillOval(l+(sum*mult), 55*10, 30, 30);
			mult++;
		}

	}	
}

