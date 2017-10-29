import java.io.*;

public class ConsGUIHelperTest{
	
	public static void main(String[] args){
		
		ConsGUIHelperTest test = new ConsGUIHelperTest();
		test.startTesting();
		
	}
	
	public void startTesting(){
		String userGuess;
		String checkResult;
		ConsGUIHelper helper = new ConsGUIHelper();
		try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in))){
		 while(true){
			System.out.println("Enter user guess for test or quit ");
			userGuess = r.readLine();
			
			if(userGuess.equals("quit")) 
				break;
			
			System.out.println("Enter check result for test ");
			checkResult = r.readLine();
			
			
			helper.addPoint(userGuess, checkResult);
			helper.drowConsGui();
			} 
		}
		catch(IOException e){
			System.out.println(e + " exception happens.");
		}
	}
	
}