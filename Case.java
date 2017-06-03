


public class Case {
	
	//attributs
	private boolean mine;
	private boolean cachee;
	private boolean mur;
	private String etat;
	int nbMinesVoisines;
	
	public Case(){
		cachee=true;
		int a = (int)(Math.random()*4);
		nbMinesVoisines=0;
		
		if(a==0){
			mine=true;
			mur=false;
			
		}else if(a==1){
			mine=false;
			mur=true;
		}else{
			mine=false;
			mur=false;
		}
		
	}
	
	public boolean getCache(){
		return cachee;
	}
	
	public boolean getMine(){
		return mine;
	}
	
	public boolean getMur(){
		return mur;
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
			
}
	
	
	

	

	

   
		
	
	
	
	
	
		
		



