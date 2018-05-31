package model;

public class Position {
	
	int x;
	int y;
	
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Position(Position position){
		this.x = position.x;
		this.y = position.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
