import java.awt.Color;
import java.util.Random;

public class Defenseur extends Combinaison {
            
        public Defenseur(){
            super();

            // On ajoute une 5 couleur aleatoire a notre defenseur
            this.add(this.getRandom());
            this.add(this.getRandom());
            this.add(this.getRandom());
            this.add(this.getRandom());
            this.add(this.getRandom());
        }
}

