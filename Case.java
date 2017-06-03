


public class Case {
	
	//attributs
	private boolean mine;
	private boolean cachee;
	private boolean mur;
	private boolean cookie;
	private String etat;
	int nbMinesVoisines;
	
	public Case(){
		cachee=true;
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
	
	public boolean getCache(){
		return cachee;
	}
	
	public void setCachee(boolean f){
		cachee= f;
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
	
	public int getNbMinesVoisines(){
		return nbMinesVoisines;
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
	
	
	

	

	

   
		
	
	
	
	
	
		
		



