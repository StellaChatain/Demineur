import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Cookie-Lanta");
		System.out.println("Bienvenue dans Cookie-Lanta, le demineur/labyrinthe");
		System.out.println("Quelle taille de tableau de jeu voulez-vous?");
		int b = sc.nextInt();
		boolean finDePartie = false;
		
		//Boucle qui fait tourner le programme tant que le joueur le veut
		while(!finDePartie){
		TableauDeCases labyrinthe = new TableauDeCases(b,b);
		Joueur j1;
		j1=labyrinthe.getJoueur();
			boolean finDeManche = false;

			//Boucle qui fait tourner le jeu tant que le joueur le veut
			while(!finDeManche){
				Case[][] a = labyrinthe.getTab();
				String s = "";

				//Affichage du tableau de case, des mines, des murs, du joueur et du nombre de mines voisines à chaque case
				for (int i = 0 ; i < a.length ; i++){
					
					for (int k = 0 ; k < a[i].length ; k++){
						s += "____";
					}
					s += "\n";
					for (int j = 0 ; j < a[i].length ; j++){
						s += "|";
						if(a[i][j].getCache()){
							s+="   ";
						}else{
							 if(i==j1.getX() && j==j1.getY()){
								s+="x:";
								s+=labyrinthe.calculNbMinesVoisines(j1);
							}else if(a[i][j].getCookie()){
								s+="CK ";
							}else{
								if(a[i][j].getMur()){
									s+="//";
								} else {
									s +="_:";
								}
								s+=labyrinthe.calculNbMinesVoisines(a[i][j]);

							}
						}
					}
					s+="\n";		
				}		
						
				System.out.println(s);
				String proposition = " 8 - haut \n 4 - gauche \n 6 - droite \n 5 - bas";
				System.out.println(proposition);
				Scanner p = new Scanner(System.in);
				int n = p.nextInt();
				finDeManche = labyrinthe.deplacer(n);
				
				//Finit la manche si le joueur a gagné ou perdu
				if (labyrinthe.getPerdu()){
					finDeManche=true;
				}else if(labyrinthe.getGagner()){
					finDeManche=true;
				}
			}
			
			System.out.println("Voulez-vous rejouer? Pour rejouer tapez la lettre o, pour terminer le jeu tapez la lettre n");
			String mes="";
			while(mes.length() < 1){
				mes = sc.nextLine();
			}
			finDePartie=mes.equals("n");
		}
		
			
			
	}
}

