import java.util.*;

public class DotComBust{
	
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	private ConsGUIHelper consHelper = new ConsGUIHelper();
	String userGuess = null;
	
	private void setUpGame(){
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		System.out.println("Your goal is to kill three sites:");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to kill them all in the min number of guesses");
		
		for (DotCom dotComToSet : dotComList){
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying(){
		while(!dotComList.isEmpty()){
			userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess){
		
		numOfGuesses++;
		
		String result = "Miss";
		String resultForGUI = result;
		
		for (DotCom dotComToTest : dotComList){
			result = dotComToTest.checkYourself(userGuess);
			resultForGUI = result;
			if (result.equals("Hit")) {
				result += "\nYou have hitted " + dotComToTest.getName();
				break;
			}
			if (result.equals("Kill")) {
				dotComList.remove(dotComToTest);
				result += "\nYou have killed " + dotComToTest.getName();
				break;
			}
		}
		System.out.println(result);
		consHelper.addPoint(userGuess, resultForGUI);
		consHelper.drowConsGui();
		
	}
	
	private void finishGame() {
		System.out.println("All sites are dead! Your stock is now worthless.");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}
	
	public static void main (String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}