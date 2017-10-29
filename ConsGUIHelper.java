import java.util.*;

public class ConsGUIHelper{
	
	private static final String alphabet = "ABCDEFG";
	private String hat = " ||0||1||2||3||4||5||6||7\n   ________________________";
	private String[][] mas = new String[7][8];
	private ArrayList<Point> points = new ArrayList<>();
	private String userGuess;
	private String result;
	private String SymbolByResult;
	
	public void addPoint(String userGuess, String checkResult){
		this.userGuess = userGuess;
		result = checkResult.toLowerCase();
		setPoint();
	}
	
	public void drowConsGui(){
		System.out.println(hat);
		for(int i = 0; i < mas.length; i++){
			System.out.print(alphabet.charAt(i) + "|");
			for(int j = 0; j < mas[i].length; j++){
				int buf = points.indexOf(new Point(i, j));
				System.out.print("|");
				if (buf >= 0) 
					System.out.print(points.get(buf).getSymbol());
				else 
					System.out.print(" ");
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public void setPoint(){
		Point point = new Point(parseRow(), parseColumn());
		point.setSymbol(chooseSymbolByResult());
		points.add(point);
	}
	
	private int parseRow(){
		String letter = ((Character) userGuess.charAt(0)).toString();
		int row = 0;
		try{
		row = (RowsForDesk.valueOf(letter)).ordinal();
		} catch (IllegalArgumentException e){
			System.out.println("Couldn't parse row in this point: " + userGuess);
		}
		return row;
	}
	
	private int parseColumn(){
		int column = 0;
		try{
			column = Integer.parseInt(((Character) userGuess.charAt(1)).toString());
		} catch (NumberFormatException e){
			System.out.println("Couldn't parse column in this point: " + userGuess);
		}
		return column;
	}
	
	private String chooseSymbolByResult(){
		if(result.equals("hit") || result.equals("kill")) 
			return "X";
		else 
			return ".";
	}
	
}