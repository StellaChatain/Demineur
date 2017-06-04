

public class Joueur {
	
	int x;
	int y;
 
	//Constructeur du joueur
	public Joueur(int x, int y){
        this.x=x;
        this.y=y;
        x=0;
        y=0;
    }
    
    //Getters
    public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	//Setters
	public void setX(int newX) {
		x=newX;
	}
	
	public void setY(int newY) {
		y=newY;
	}
	
		
}

