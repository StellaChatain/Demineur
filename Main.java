import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle taille de tableau voulez-vous?");
		int b = sc.nextInt();
		
		//System.out.println("x :" + j1.getX() + " y :" + j1.getY());
		boolean finDePartie = false;
		while(!finDePartie){
			TableauDeCases labyrinthe = new TableauDeCases(b,b);
		Joueur j1;
		j1=labyrinthe.getJoueur();
			boolean finDeManche = false;
			while(!finDeManche){
				Case[][] a = labyrinthe.getTab();
				String s = "";
						//System.out.println("x :" + j1.getX() + " y :" + j1.getY());

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
							//System.out.println("x :" + i + " y :" + j);
							 if(i==j1.getX() && j==j1.getY()){
								s+="x:";
								s+=labyrinthe.calculNbMinesVoisines(j1); // ...
							}else if(a[i][j].getCookie()){
								s+="CK";
							}else{
								s+="O:";
								s+=a[i][j].getNbMinesVoisines();

							}
						}
					}
					s+="\n";		
				}		
						
				System.out.println(s);
				String proposition = " 8 - en haut \n 4 - à gauche \n 6 - droite \n 5 -bas";
				System.out.println(proposition);
				Scanner p = new Scanner(System.in);
				int n = p.nextInt();
				finDeManche = labyrinthe.deplacer(n);
			//....
			//... int cas = 0;
			//... if (cas=1)     prop=(6,2)
			//...
			//... boolean possible = false;
			//... 	while (!possible){
			
				
				if (labyrinthe.getPerdu()){
					finDeManche=true;
				}else if(labyrinthe.getGagner()){// créer le cookie dans TableauDeCases
					finDeManche=true;
				}
			}
			
			System.out.println("Voulez-vous rejouer? Pour rejouer tapez o, pour terminer le jeu tapez n");
			String mes="";
			while(mes.length() < 1){
				mes = sc.nextLine();
			}
			finDePartie=mes.equals("n");
		}
		
			
			
	}
}

