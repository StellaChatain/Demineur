import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle taille de tableau voulez-vous?");
		int b = sc.nextInt();
		TableauDeCases labyrinthe = new TableauDeCases(b,b);
		Joueur j1;
		j1=labyrinthe.getJoueur();
		boolean finDePartie = false;
		while(!finDePartie){
			boolean finDeManche = false;
			while(!finDeManche){
				Case[][] a = labyrinthe.getTab();
				for (int i = 0 ; i < a.length ; i++){
					String s = "";
					for (int k = 0 ; k < a.length ; k++){
						s += "__";
					}
					s += "\n";
					for (int j = 0 ; j < a.length ; j++){
						s += "|";
						if(a[i][j].getCache()){
							s+="   ";
						}else if(i==j1.getX() && j==j1.getY()){
							s+="x:";
							s+=labyrinthe.calculNbMinesVoisines(j1); // ...
						}else{
							s+="O:";
							s+=a[i][j].getNbMinesVoisines();
						}
					}
				}
		
				String proposition = " 8 - en haut \n 4 - à gauche \n 6 - droite \n 5 -bas";
		
			//....
			//... int cas = 0;
			//... if (cas=1)     prop=(6,2)
			//...
			//... boolean possible = false;
			//... 	while (!possible){
			
				
				if(labyrinthe.getGagner()){// créer le cookie dans TableauDeCases
					finDeManche=true;
				}
			}
			
			System.out.println("Voulez-vous rejouer? Pour rejouer tapez o, pour terminer le jeu tapez n");
			String mes = sc.nextLine();
			finDePartie=mes.equals("n");
		}
		
			
			
	}
}

