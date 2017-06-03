
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
	
	public TableauDeCases(int lo, int la) {
		nbDeMines = 0;
		tab = new Case[lo][la];
		Joueur j= new Joueur(x,y);
		for( int i=0; i<lo; i++){
			for( int b=0; b<la; b++){
				Case a = new Case();
				tab[i][b]= a;
				if(i==1 && b==1){
					a.setMine(false);
					a.setMur(false);
				}	
				if(a.getMine()){
					nbDeMines++;
				}		
			}	
		}	
	}
	
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

	
	public void deplacer(Joueur j){
		boolean res= false;
		gagner= false;
		int n=0;
		if(n==8){
			Case a= tab[j.getX()-1][j.getY()];
			boolean mur= a.getMur();
			boolean mine= a.getMine();
			if(mur){
				System.out.println("Tu ne peux pas foncer dans un mur!");
			}else if(mine){
					System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
					res= true;
				}else{
					j.setX(j.getX()-1);
					int k= calculNbMinesVoisines(j);
					a= tab[j.getX()][j.getY()];
					a.setNbMinesVoisines(k);
				}		
			}
			else if(n==5){
			Case a= tab[j.getX()+1][j.getY()];
				boolean mur= a.getMur();
				if(mur){
					System.out.println("Tu ne peux pas foncer dans un mur!");
				}else{
					boolean mine= a.getMine();
					if(mine){
						System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
						res= true;
					}else{
						j.setX(j.getX()+1);
						int k= calculNbMinesVoisines(j);
						a= tab[j.getX()][j.getY()];
						a.setNbMinesVoisines(k);
					}	
				}	
		}
		else if (n==4){
			Case a= tab[j.getX()][j.getY()-1];
				boolean mur= a.getMur();
				if(mur){
					System.out.println("Tu ne peux pas foncer dans un mur!");
				}else{
					boolean mine= a.getMine();
					if(mine){
						System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
						res= true;
					}else{
						j.setY(j.getY()-1);
						int k= calculNbMinesVoisines(j);
						a= tab[j.getX()][j.getY()];
						a.setNbMinesVoisines(k);
					}	
				}	
		}
		else if (n==6){
			Case a= tab[j.getX()][j.getY()+1];
				boolean mur= a.getMur();
				if(mur){
					System.out.println("Tu ne peux pas foncer dans un mur!");
				}else{
					boolean mine= a.getMine();
					if(mine){
						System.out.println("BRUH! TU AS PERDU! TU ES NUL!");
						res= true;
					}else{
						j.setY(j.getY()+1);
						int k= calculNbMinesVoisines(j);
						a= tab[j.getX()][j.getY()];
						a.setNbMinesVoisines(k);
					}	
				}
		}
		
	}
	
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
					
			}	
		}
		else if(y== tab[x].length) {
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
		
		if(y==tab[x].length){
			if(x==tab.length){
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
				if (tab[x][y].getMine()){
					res++;
				}
				if (tab[x+1][y-1].getMine()){
					res++;
				}
				if (tab[x+1][y].getMine()){
					res++;
				}	
			}		
			
		}
		if(x==tab.length){
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
		}
		else if(y==0){
			if (tab[x-1][y].getMine()){
				res++;
			}
			if (tab[x-1][y+1].getMine()){
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
		}else{
			for(int i=x-1; i<=x+1; i++){
				for(int b=y-1; b<=y+1; b++){
					if(tab[x][y].getMine()){
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

