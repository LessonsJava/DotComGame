public class Point{
	int x, y;
	String symbol;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(){
	}
	
	public void setSymbol(String symbol){
		this.symbol = symbol;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "(" + x + " : " + y +")";
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		Point p = (Point) o;
		if (x != p.getX() || y != p.getY()) return false;
		return this.hashCode() == o.hashCode();
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result += prime * result + x;
		result += prime * result + y;
		return result;
	}
}