

public class Joueur {
	
	int x;
	int y;
 
	public Joueur(int x, int y){
        this.x=x;
        this.y=y;
        x=0;
        y=0;
    }
    
    public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int newX) {
		x=newX;
	}
	
	public void setY(int newY) {
		y=newY;
	}
	
		
}

