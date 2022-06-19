import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Controleur extends JPanel implements MouseListener,  ActionListener{
        private Defenseur vrai = new Defenseur();
        private Combinaison reponse_def = new Combinaison();


        private Combinaison prop1 = new Combinaison();
        private Combinaison prop2 = new Combinaison();
        private Combinaison prop3 = new Combinaison();
        private Combinaison prop4 = new Combinaison();
        private Combinaison prop5 = new Combinaison();
        private Combinaison prop6 = new Combinaison();
        private Combinaison prop7 = new Combinaison();
        private Combinaison prop8 = new Combinaison();
        private Combinaison prop9 = new Combinaison();
        private Combinaison prop10 = new Combinaison();

        private VueJoueur rond = new VueJoueur(this);
        private Combinaison[] prop = new Combinaison[10];
	private Combinaison[] rep = new Combinaison[10];
                  
        private VuePlateau plateau;

        private JFrame frame = new JFrame();


        private int index = 0;



	public Controleur(){
                this.prop[0] = this.prop1;
                this.prop[1] = this.prop2;
                this.prop[2] = this.prop3;
                this.prop[3] = this.prop4;
                this.prop[4] = this.prop5;
                this.prop[5] = this.prop6;
                this.prop[6] = this.prop7;
                this.prop[7] = this.prop8;
                this.prop[8] = this.prop9;
                this.prop[9] = this.prop10;

                
                for (int i = 0; i < 10 ; i++){
                        this.rep[i] = this.reponse_def;
                }              

                this.plateau = new VuePlateau(this.prop,this.rep);
                
                
                GridLayout grid_controle = new GridLayout(1,2);
                this.setLayout(grid_controle);
                this.add(rond);
                this.add(plateau);

                
                this.frame.setSize(1920, 700);
                this.frame.setLocationRelativeTo(null);
                this.frame.add(this);
                this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                this.frame.setVisible(true);     
        }
                


	//proposer s'appelle quand on valide une combinaison, elle la teste et affiche la réponse.
	 
	private  void proposer(Combinaison essaie){
                
                // renvoie la comparaison entre le defenseur et la proposition dans reponse_def.
                this.reponse_def = this.vrai.comparer(essaie);
                this.rep[this.index] = this.reponse_def;
                this.plateau.repaint();
                
                // si tout les cases de reponse_def sont noir. On gagne.
                if(this.reponse_def.choix[0].equals(Color.black) && reponse_def.choix[1].equals(Color.black) && reponse_def.choix[2].equals(Color.black) && reponse_def.choix[3].equals(Color.black) && reponse_def.choix[4].equals(Color.black)){
                        this.reponse_def.gagner();
                        JOptionPane.showMessageDialog(this.frame, "Bravo, vous avez gagner !");
                        System.exit(0);
                }
                // Sinon si l'index atteint 9 on arrive a la limite du nombre d'essaie, et on perd
                else{
                        if(this.index == 9){
                                JOptionPane.showMessageDialog(this.frame, "Vous avez perdu :(");
                                System.exit(0);
                        }
                        System.out.println(this.reponse_def);
                
                }
        }


        public void actionPerformed(ActionEvent e){
                if(e.getActionCommand()== "Valider"){
                        // appelle proposer a la proposition .
                        this.proposer(this.prop[this.index]);
                        System.out.println("Valider"); 
                        // incrémente l'index pour passer a une autre proposition
                        this.index++;
                }
                if(e.getActionCommand()== "Effacer"){
                        // L'index permet d'effacer a la bonne proposition, en fesant une nouvelle combinaison a la proposition           
                        switch(this.index){
                                case 0 : this.prop1= new Combinaison();
                                prop[this.index] =this.prop1;
                                this.plateau.repaint();
                                break;

                                case 1 : this.prop2= new Combinaison();
                                prop[this.index] =this.prop2;
                                this.plateau.repaint();
                                break;

                                case 2 : this.prop3= new Combinaison();
                                prop[this.index] =this.prop3;
                                this.plateau.repaint();
                                break;

                                case 3 : this.prop4= new Combinaison();
                                prop[this.index] =this.prop4;
                                this.plateau.repaint();
                                break;

                                case 4 : this.prop5= new Combinaison();
                                prop[this.index] =this.prop5;
                                this.plateau.repaint();
                                break;

                                case 5 : this.prop6= new Combinaison();
                                prop[this.index] =this.prop6;
                                this.plateau.repaint();
                                break;

                                case 6 : this.prop7= new Combinaison();
                                prop[this.index] =this.prop7;
                                this.plateau.repaint();
                                break;

                                case 7 : this.prop8= new Combinaison();
                                prop[this.index] =this.prop8;
                                this.plateau.repaint();
                                break;

                                case 8 : this.prop9= new Combinaison();
                                prop[this.index] =this.prop9;
                                this.plateau.repaint();
                                break;

                                case 9 : this.prop10= new Combinaison();
                                prop[this.index] =this.prop10;
                                this.plateau.repaint();
                                break;

                                default : break;
                        }

                }
                        if(e.getActionCommand()== "Aleatoire"){
                                Combinaison Aleatoire = new Combinaison();

                                Aleatoire.add(Aleatoire.getRandom());
                                Aleatoire.add(Aleatoire.getRandom());
                                Aleatoire.add(Aleatoire.getRandom());
                                Aleatoire.add(Aleatoire.getRandom());
                                Aleatoire.add(Aleatoire.getRandom());
                                // ajoute la combinaison Aleatoire au tableau de proposition
                                this.prop[this.index]= Aleatoire;
                                this.plateau.repaint();
                                System.out.println("Aleatoire");
                        }
        }


        // On fait un Controleur dans le main
        public static void main(String[] args) {Controleur controle = new Controleur();}

        // evenement sur les VueColor crée dans VueJoueur
        public void mouseClicked(MouseEvent e){
                // Pour chaque VueColor, on ajoute a la proposition la Couleur de Vuecolor
                if(e.getComponent().equals(rond.getRond(1))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.blue);
                                        this.plateau.repaint();

                                        break;

                                case 2 : this.prop3.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.blue);
                                        this.plateau.repaint();
                                        break;

                                default : break;
                        }
                }
                if(e.getComponent().equals(rond.getRond(2))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 2 : this.prop3.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.green);
                                        this.plateau.repaint();
                                        break;

                                default : break;

                        }
                }
                if(e.getComponent().equals(rond.getRond(3))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 2 : this.prop3.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.magenta);
                                        this.plateau.repaint();
                                        break;

                                default : break;

                        }
                }
                if(e.getComponent().equals(rond.getRond(4))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 2 : this.prop3.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.orange);
                                        this.plateau.repaint();
                                        break;

                                default : break;

                        }
                }
                if(e.getComponent().equals(rond.getRond(5))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 2 : this.prop3.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.red);
                                        this.plateau.repaint();
                                        break;

                                default : break;

                        }
                }
                if(e.getComponent().equals(rond.getRond(6))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 2 : this.prop3.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.pink);
                                        this.plateau.repaint();
                                        break;

                                default : break;

                        }
                }
                if(e.getComponent().equals(rond.getRond(7))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 2 : this.prop3.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.yellow);
                                        this.plateau.repaint();
                                        break;

                                default : break;

                        }
                }
                if(e.getComponent().equals(rond.getRond(0))){
                        // L'index permet d'ajouter la couleur a la bonne proposition.
                        switch(this.index){
                                case 0 : this.prop1.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 1 : this.prop2.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 2 : this.prop3.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 3 : this.prop4.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 4 : this.prop5.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 5 : this.prop6.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 6 : this.prop7.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 7 : this.prop8.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 8 : this.prop9.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                case 9 : this.prop10.add(Color.darkGray);
                                        this.plateau.repaint();
                                        break;

                                default : break;

                        }
                }
        }       



        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
}
