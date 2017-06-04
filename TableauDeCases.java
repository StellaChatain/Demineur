 import java.util.Scanner;

public class TableauDeCases {
	
	private int nbDeMines;
	private int longueur;
	private int largeur;
	private Case[][] tab;
	private Joueur j;
	private boolean gagner;
	private boolean perdu;
	int x;
	int y;


	//Constructeur
	public TableauDeCases(int lo, int la) {
		int w=0;
		int z=0;
		
		//génère les coordonnées du cookie de sorte qu'il ne soit pas sur la première case 
		while(w ==0 && z == 0){
			w = (int)(Math.random()*lo);
			z = (int)(Math.random()*la);
		}
		nbDeMines = 0;
		tab = new Case[lo][la];
		j= new Joueur(0,0);
		for( int i=0; i<lo; i++){
			for( int b=0; b<la; b++){
				Case a = new Case();
				tab[i][b]= a;
				
				//génère un cookie
				if(i==w && b==z){
					a.setCookie(true);
					a.setCachee(false);
					a.setMine(false);
					a.setMur(false);
				}
				//interdit à une mine et un mur de se générer sur la première case
				if(i==0 && b==0){
					a.setMine(false);
					a.setMur(false);
				}
				//interdit à une mine et un mur de se générer sur une case en dessous de la première case	
				if(i==1 && b==0){
					a.setMine(false);
					a.setMur(false);
				}	
				//Compteur de mine, pas utile sauf si on veut rajouter une option du choix de nombre de mine à l'utilisateur
				if(a.getMine()){
					nbDeMines++;
				}
				a.setX(i);
				a.setY(b);		
			}	
		}
		Case x = tab[0][0];
		x.setCachee(false);
	}
	
	//Getters
	public Case[][] getTab(){
		return tab;
	}	
	
	public Joueur getJoueur(){
		return j;
	}	 
	
	public boolean getGagner(){
		return gagner;
	}
	
	public boolean getPerdu(){
		return perdu;
	}

	//Methode qui gère le déplacement du jouer, ainsi que sa défaite ou victoire
	public boolean deplacer(int n){
		boolean res = false;
		perdu= false;
		gagner= false;
		if(n==8){
			if(j.getX()==0){
				Case a= tab[j.getX()][j.getY()];
			}else{
			Case a= tab[j.getX()-1][j.getY()];
			boolean mur= a.getMur();
			boolean mine= a.getMine();
			boolean cookie= a.getCookie();
				if(mur){
					System.out.println("Tu ne peux pas foncer dans un mur!");
					a= tab[j.getX()][j.getY()];
				}else if(mine){
						System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
						perdu= true;
						res = true;
				}else if(cookie){
					System.out.println("Bravo! Vous avez gagne!");
					gagner= true;
					res = true;
					a.setCachee(false);
				}else{
					j.setX(j.getX()-1);
					int k= calculNbMinesVoisines(j);
					a= tab[j.getX()][j.getY()];
					a.setCachee(false);
					a.setNbMinesVoisines(k);
				}		
			}
		}
		else if(n==5){
			if(j.getX()==tab.length-1){
				Case a= tab[j.getX()][j.getY()];
			}else{
			Case a= tab[j.getX()+1][j.getY()];
				boolean mur= a.getMur();
				boolean cookie= a.getCookie();
				if(mur){
					System.out.println("Tu ne peux pas foncer dans un mur!");
					a= tab[j.getX()][j.getY()];
				}else{
					boolean mine= a.getMine();
					if(mine){
						System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
						perdu= true;
						res = true;
					}else if(cookie){
						System.out.println("Bravo! Vous avez gagne!");
						perdu= true;
						res = true;	
						a.setCachee(false);
					}else{
						j.setX(j.getX()+1);
						int k= calculNbMinesVoisines(j);
						a= tab[j.getX()][j.getY()];
						a.setCachee(false);
						a.setNbMinesVoisines(k);
					}	
				}	
			}
		}
		else if (n==4){
			if(j.getY()==0){
				Case a= tab[j.getX()][j.getY()];
			}else{
			Case a= tab[j.getX()][j.getY()-1];
				boolean mur= a.getMur();
				boolean cookie= a.getCookie();
				if(mur){
					System.out.println("Tu ne peux pas foncer dans un mur!");
					a= tab[j.getX()][j.getY()];
				}else{
					boolean mine= a.getMine();
					if(mine){
						System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
						perdu= true;
						res = true;
					}else if(cookie){
						System.out.println("Bravo! Vous avez gagne!");
						gagner= true;
						res = true;
						a.setCachee(false);
					}else{
						j.setY(j.getY()-1);
						int k= calculNbMinesVoisines(j);
						a= tab[j.getX()][j.getY()];
						a.setNbMinesVoisines(k);
						a.setCachee(false);
					}	
				}	
			}
		}
		else if (n==6){
			if(j.getY()==tab[x].length-1){
				Case a= tab[j.getX()][j.getY()];
			}else{
			Case a= tab[j.getX()][j.getY()+1];
				boolean mur= a.getMur();
				boolean cookie= a.getCookie();
				if(mur){
					System.out.println("Tu ne peux pas foncer dans un mur!");
					a= tab[j.getX()][j.getY()];
				}else{
					boolean mine= a.getMine();
					if(mine){
						System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
						perdu= true;
						res = true;
					}else if(cookie){
						System.out.println("Bravo! Vous avez gagne!");
						gagner= true;
						res = true;
						a.setCachee(false);	
					}else{
						j.setY(j.getY()+1);
						int k= calculNbMinesVoisines(j);
						a= tab[j.getX()][j.getY()];
						a.setNbMinesVoisines(k);
						a.setCachee(false);
					}	
				}
			}
		}
		return res;
		
	}
	
	//Calcul le nombre de mine autour de chaque case
	public int calculNbMinesVoisines(Case j){
		x= j.getX();
		y= j.getY();
		int res= 0;
		if(x== 0){
			if(y== 0){
				if (tab[x+1][y].getMine()){
					res++;
				}
				if (tab[x][y+1].getMine()){
					res++;
				}	
				if (tab[x+1][y+1].getMine()){
					res++;
				}	
					
			} else {
			if(y== tab[x].length-1) {
				if (tab[x+1][y].getMine()){
					res++;
				}
				if (tab[x][y-1].getMine()){
					res++;
				}	
				if (tab[x+1][y-1].getMine()){
					res++;
				}
			}else{
				if (tab[x][y-1].getMine()){
					res++;
				}
				if (tab[x][y+1].getMine()){
					res++;
				}	
				if (tab[x+1][y+1].getMine()){
					res++;
				}
				if (tab[x+1][y].getMine()){
					res++;
				}
				if (tab[x+1][y-1].getMine()){
					res++;
				}
			}
		}		
		}else if(y==tab[x].length-1){
			if(x==tab.length-1){
				if (tab[x-1][y].getMine()){
				res++;
				}
				if (tab[x][y-1].getMine()){
				res++;
				}	
				if (tab[x-1][y-1].getMine()){
				res++;
				}
			}else{
				if (tab[x-1][y].getMine()){
				res++;
				}
				if (tab[x-1][y-1].getMine()){
					res++;
				}	
				if (tab[x][y-1].getMine()){
					res++;
				}
				if (tab[x+1][y-1].getMine()){
					res++;
				}
				if (tab[x+1][y].getMine()){
					res++;
				}	
			}		
			
		}else if(x==tab.length-1){
			if(y==0){
				if (tab[x-1][y].getMine()){
				res++;
				}
				if (tab[x-1][y+1].getMine()){
				res++;
				}	
				if (tab[x][y+1].getMine()){
				res++;
				}
			}else{
				if (tab[x][y-1].getMine()){
					res++;
				}
				if (tab[x-1][y-1].getMine()){
					res++;
					}	
				if (tab[x-1][y].getMine()){
					res++;
				}
				if (tab[x-1][y+1].getMine()){
					res++;
				}
				if (tab[x][y+1].getMine()){
					res++;
				}
			}
		}else if(y==0){
			if(tab[x-1][y].getMine()){
				res++;
			}
			if(tab[x-1][y+1].getMine()){
				res++;
			}
			if(tab[x][y+1].getMine()){
				res++;
			}
			if(tab[x+1][y].getMine()){
				res++;
			}
			if(tab[x+1][y+1].getMine()){
				res++;
			}		
		}else{
			for(int i=x-1; i<=x+1; i++){
				for(int b=y-1; b<=y+1; b++){
					if(tab[i][b].getMine()){
						res++;
					}	
				}	
			}
			if(tab[x][y].getMine()){
				res-= 1;
			}					
			
		}
		return res;
	}								
	
	//Calcul le nombre de mine autour du joueur
	public int calculNbMinesVoisines(Joueur j){
		x= j.getX();
		y= j.getY();
		int res= 0;
		if(x== 0){
			if(y== 0){
				if (tab[x+1][y].getMine()){
					res++;
				}
				if (tab[x][y+1].getMine()){
					res++;
				}	
				if (tab[x+1][y+1].getMine()){
					res++;
				}	
					
			} else {
				
			if(y== tab[x].length-1) {
				if (tab[x+1][y].getMine()){
					res++;
				}
				if (tab[x][y-1].getMine()){
					res++;
				}	
				if (tab[x+1][y-1].getMine()){
					res++;
				}
			}else{
				if (tab[x][y-1].getMine()){
					res++;
				}
				if (tab[x][y+1].getMine()){
					res++;
				}	
				if (tab[x+1][y+1].getMine()){
					res++;
				}
				if (tab[x+1][y].getMine()){
					res++;
				}
				if (tab[x+1][y-1].getMine()){
					res++;
				}
			}
		}		
		}else if(y==tab[x].length-1){
			if(x==tab.length-1){
				if (tab[x-1][y].getMine()){
				res++;
				}
				if (tab[x][y-1].getMine()){
				res++;
				}	
				if (tab[x-1][y-1].getMine()){
				res++;
				}
			}else{
				if (tab[x-1][y].getMine()){
				res++;
				}
				if (tab[x-1][y-1].getMine()){
					res++;
				}	
				if (tab[x][y-1].getMine()){
					res++;
				}
				if (tab[x+1][y-1].getMine()){
					res++;
				}
				if (tab[x+1][y].getMine()){
					res++;
				}	
			}		
			
		}else if(x==tab.length-1){
			if(y==0){
				if (tab[x-1][y].getMine()){
				res++;
				}
				if (tab[x-1][y+1].getMine()){
				res++;
				}	
				if (tab[x][y+1].getMine()){
				res++;
				}
			}else{
				if (tab[x][y-1].getMine()){
					res++;
				}
				if (tab[x-1][y-1].getMine()){
					res++;
					}	
				if (tab[x-1][y].getMine()){
					res++;
				}
				if (tab[x-1][y+1].getMine()){
					res++;
				}
				if (tab[x][y+1].getMine()){
					res++;
				}
			}		
		}else if(y==0){
			if(tab[x-1][y].getMine()){
				res++;
			}
			if(tab[x-1][y+1].getMine()){
				res++;
			}
			if(tab[x][y+1].getMine()){
				res++;
			}
			if(tab[x+1][y].getMine()){
				res++;
			}
			if(tab[x+1][y+1].getMine()){
				res++;
			}
		}else{
			for(int i=x-1; i<=x+1; i++){
				for(int b=y-1; b<=y+1; b++){
					if(tab[i][b].getMine()){
						res++;
					}	
				}	
			}
			if(tab[x][y].getMine()){
				res-= 1;
			}					
			
		}
		return res;
	}								
}

