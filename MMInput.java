
import java.util.*;
import java.io.*;


public class MMInput {

	private static ArrayList<String> letters = new ArrayList<String>(); // usable letters
	private String letter="1"; // last letter that can be used
	private static String code;
	private static String guess;
	private static int rounds=-1;
	private Scanner reader = new Scanner(System.in);





	// to be called at start of game, sets letters, rounds, and code 
	public void start(){

		setLetters();
		setRounds();
		setCode();

	}






	// sets the usable letters
	private void setLetters(){


		while(letter.compareToIgnoreCase("A")<0 || letter.compareToIgnoreCase("Z")>0){

			System.out.println("Enter the last letter you would like to play with(A-_):");
			letter = reader.next();
			letter = Character.toString(letter.charAt(0));
			letter = letter.toUpperCase();

		}

		for(char a='A';a<=letter.charAt(0);a++){

			letters.add(Character.toString(a));

		}



	}

	// returns an array list of the usable letters
	public ArrayList<String> getLetters(){

		return letters;

	}


	// sets the number of rounds to be played
	private void setRounds(){


		while(rounds<=0){
			System.out.println("How many rounds would you like to play?");
			String temp = reader.next();
			Scanner t = new Scanner(temp);
			if(t.hasNextInt())
				rounds = t.nextInt();


		}

	}


	// returns number of rounds remaining
	public int getRemaining(){

		return rounds;

	}


	// gets code from user, makes sure its the right length and letters
	private void setCode(){

		boolean suitable = false;


		while(!suitable){

			code = readCode();
			//System.out.println("Enter Code:");
			code= reader.next();
			if(code.length()>=4)
			{	
				code = code.substring(0,4);
				code = code.toUpperCase();
				for(int i=0; i<=3;i++){
					if((letters.contains(Character.toString(code.charAt(i))))){
						suitable=true;	
					}
					else{
						suitable = false;
						break;
					}
				}

			}


		}




	}


	// returns inputed code
	public String getCode(){


		return code;

	}



	private static String readCode() {

		Console console = System.console( );
		System.out.println("Enter code:");

		return new String(console.readPassword());
		

	}


	// gets guess from user, makes sure its the correct length and letters
	// also decrements number of rounds
	public void setGuess(){

		boolean suitable = false;
		rounds--;

		while(!suitable){

			System.out.println("Enter Guess:");
			guess= reader.next();
			if(guess.length()>=4)
			{	
				guess = guess.substring(0,4);
				guess = guess.toUpperCase();
				for(int i=0; i<=3;i++){

					if((letters.contains(Character.toString(guess.charAt(i))))){
						suitable=true;	
					}
					else{
						suitable = false;
						break;
					}
				}

			}


		}




	}

	// returns inputed guess
	public String getGuess(){


		return guess;

	}




	public void test(){

		setLetters();
		System.out.println("Letters:");
		System.out.println(getLetters());
		setRounds();
		System.out.println(getRemaining());
		setCode();
		System.out.println(getCode());
		setGuess();
		System.out.println(getGuess());


	}





}
