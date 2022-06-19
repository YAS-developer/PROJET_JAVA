import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Combinaison {
	//choix contient les pions de la combinaison
	protected Color[] choix;
	//index contient le nombre de pions ajoutés à la combinaison
	protected int index=0;

	public Combinaison(Color c){
		
		if(c==null){throw new NullPointerException("Veuiller entrer une couleur");}

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
		
		try{
			this.choix=new Color[5];
			this.choix[0] = c;
			this.index++;
		}catch(NullPointerException e){System.out.println("La case du tableau est nulle");}
		
	}

	public Combinaison(){
		this.choix=new Color[5];
		for(int i=0;i<5;i++){
			if(this.choix[i]==null){this.choix[i]=new Color(192,192,192);}
		}
	}

	//add ajoute une couleur à la combinaison
	public void add (Color c){

		if(this.index==5){System.out.println("Vous avez le nombre maximal de pions");this.index=5;}
		else if(this.index==0){
			this.choix[0]=c;this.index++;
		}
		else{
			this.choix[index]=c;
			this.index++;
		}
	}



	// comparer compare la combinaison avec une autre donnée en argument. 
	// Elle renvoie la réponse, càd une combinaison contenant des couleurs noires, blancs ou grisclair. 
	public Combinaison comparer(Combinaison c){
		Combinaison reponse_defenseur = new Combinaison();
		Combinaison def2 = new Combinaison();
		Combinaison choix1= new Combinaison();

		// fait un clone de c
		for(int i = 0; i < 5 ; i++){
			choix1.choix[i] = c.choix[i];
		}
		
		// fait un clone de defenseur
		for(int i = 0; i < 5 ; i++){
			def2.choix[i] = this.choix[i];
		}
		
		
		// met une case gris au clone de defenseur
		for(int i=0 ; i<5; i++){
			if(this.choix[i].equals(c.choix[i])){
				def2.choix[i]= new Color(192,192,192);
			}
		}

		// met une case noir a la reponse
		for(int i = 0; i <5; i++){
			if(def2.choix[i].equals(new Color(192,192,192))){
				def2.choix[i]= new Color(0,0,0);
				reponse_defenseur.choix[i] = new Color(0,0,0);
			}
		}
	
		// met les cases blanches a la reponse
		for(int i=0 ; i<5; i++){
			if(!def2.choix[i].equals(new Color(0,0,0))){
				for(int j=0 ; j <5; j++){
					if(i!=j && def2.choix[j].equals(choix1.choix[i]) && !def2.choix[j].equals(new Color(192,192,192)) && !choix1.choix[i].equals(new Color(192,192,192))){
						// On ajoute une case grise aux doublons de defenseur et de la combinaison.
						def2.choix[j]= new Color(192,192,192);
						choix1.choix[i] = new Color(192,192,192);
						// ajoute
						reponse_defenseur.choix[i]= new Color(255,255,255);

					}
				}
			}
		}

		reponse_defenseur.index=5;
		return reponse_defenseur;
	}


	//TODO gagner test si une combinaison réponse (obtenue via comparer) est gagnante
	public boolean gagner(){
		System.out.println("You win !");
		return true;
	}

	// permet de recuperer couleur aleatoire dans une case du tableau de couleur 
	public Color getRandom() {
		Color[] couleurjeux;
		couleurjeux = new Color[8];
		
		// On ajoute les couleurs du jeu
		couleurjeux[0] = new Color(0,0,255);
		couleurjeux[1] = new Color(0,255,0);
		couleurjeux[2] = new Color(255,0,255);
		couleurjeux[3] = new Color(255,200,0);
		couleurjeux[4] = new Color(255,0,0);
		couleurjeux[5] = new Color(255,175,175);
		couleurjeux[6] = new Color(255,255,0);
		couleurjeux[7] = new Color(64,64,64);
		
		// On génère un int de 0 à la taille du tableau 
		int rnd = new Random().nextInt(couleurjeux.length);
		// on return donc une case aleatoire du tableau de couleur
		return couleurjeux[rnd];
	}



	public String toString(){
		String s="Combinaison : ";
		for(int i=0;i<5;i++){
			if(choix[i].equals(Color.blue)){s+="Bleu, ";}
			if(choix[i].equals(Color.green)){s+="Vert, ";}
			if(choix[i].equals(Color.magenta)){s+="Magenta, ";}
			if(choix[i].equals(Color.orange)){s+="Orange, ";}
			if(choix[i].equals(Color.red)){s+="Rouge, ";}
			if(choix[i].equals(Color.pink)){s+="Rose, ";}
			if(choix[i].equals(Color.yellow)){s+="Jaune, ";}
			if(choix[i].equals(Color.darkGray)){s+="Gris, ";}
			if(choix[i].equals(Color.black)){s+="Bien place, ";}
			if(choix[i].equals(Color.white)){s+="Mal place, ";}
			if(choix[i].equals(Color.lightGray)){s+="Absent, ";}
		}
		return s;
	}
}