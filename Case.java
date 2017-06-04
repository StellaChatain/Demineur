


public class Case {
	
	//attributs
	private boolean mine;
	private boolean cachee;
	private boolean mur;
	private boolean cookie;
	private String etat;
	private int x;
	private int y;
	int nbMinesVoisines;
	
	//Constructeur
	public Case(){
		cachee=true;
		//génère aleatoirement le caractère d'une case (mine, mur, ou rien)
		int a = (int)(Math.random()*8);
		nbMinesVoisines=0;
		
		if(a==0){
			mine=true;
			mur=false;
			
		}else if(a==1){
			mine=false;
			mur=true;
			cachee=false;
		}else{
			mine=false;
			mur=false;
		}
		
	}
	
	//Getters
	public boolean getCache(){
		return cachee;
	}
	
	public boolean getMine(){
		return mine;
	}
	
	public boolean getMur(){
		return mur;
	}	
	
	public boolean getCookie(){
		return cookie;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getNbMinesVoisines(){
		return nbMinesVoisines;
	}
	
	//Setters
	public void setCachee(boolean f){
		cachee= f;
	}	
	
	public void setX(int newX){
		x = newX;
	}
	
	public void setY(int newY){
		y = newY;
	}
	
	public void setNbMinesVoisines(int m){
		nbMinesVoisines=m;
	}
	
	public void setMine(boolean m){
		mine= m;
	}
	
	public void setMur(boolean m){
		mur= m;
	}
	
	public void setCookie(boolean c){
		cookie= c;
	}
			
}
	
	
	

	

	

   
		
	
	
	
	
	
		
		



