import java.util.*;
import java.io.*;

public class MMCompare {
		public void compare( ) {
			MMInput c = new MMInput( );
			String g;
			String code="";
			int exact=0;
			int close=0;
			int rounds;
			boolean winner = false;
			boolean counted[] = new boolean[4];			
			char cL;
			char gL;
			int count[] = new int[4];

			
			// loop that runs the whole game
			while(!winner) {
				c.setGuess( );
				rounds = c.getRemaining( );
				g = c.getGuess( );
				code = c.getCode( );
				exact = 0;
				close = 0;
				// initializes count array and the counted array
				for(int i=0;i<=3;i++){
					counted[i]=false;
					count[i]=9;
				}

				// counts the exact number right
				for(int i=0;i<=3;i++){
					cL = code.charAt(i);
					gL= g.charAt(i);
					if(gL==cL){
						exact++;
						counted[i]=true;
						}
					}
				
					
					

				
				// counts if guess is close
				for(int i = 0; i <= 3; i++) {
					cL = code.charAt(i);
					if(!counted[i]){	
						for(int j = 0; j <= 3; j++) {
							gL = g.charAt(j);
							if( !(j==count[0] || j==count[1] || j==count[2] || j==count[3]) && !counted[j]){
								if(gL==cL)
								{
								count[j]=j;
								close++;
								j=4;
								}
							
							}	
							
			
						

						}
					}
						

				}

	

								
			
				System.out.println("You got " + exact + " exact.");
				System.out.println("You got " + close + " correct letter but wrong position.");
				System.out.println("Rounds left: " + rounds); 
				if(exact == 4 || rounds == 0) {
					winner = true;
					

				}
					



			}
			if(exact == 4) {
				System.out.println("You won!");
			} else {
				System.out.println("You lose!");	
				System.out.println("Correct code: " + code);
			}
	}


}
