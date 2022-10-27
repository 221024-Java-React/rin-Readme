import java.util.Scanner;

public class Lab5 {
	private char board[][] = {
			{'_','_','_'},
			{'_','_','_'},
			{'_','_','_'}};
	
	private boolean validMove = false;
	
	public static void main(String[] args) {
		Lab5 l5 = new Lab5();
		int index=1;
		char player1 = 'X';
		char player2 = 'O';
		int [] arrayPosition = new int [2];
		int flag;
		
		Scanner scan = new Scanner(System.in);
		l5.displayBoard();
		
		while(l5.isWin() != true) {
			
			if(l5.currentPlayer(index) == player1) {
				do {
					flag=-1;
				System.out.println("Player1 please enter an index from the TicTacToe board:");
				for(int i=0; i< l5.board.length; i++) {
					for(int j=0; j<l5.board.length; j++) {
						System.out.print(i);
						System.out.print(j + " ");
					}	
					System.out.println();
				}
				String position = scan.next();
				arrayPosition = getPosition(position);
				//System.out.println(arrayPosition[0] + "\n" + arrayPosition[1]);
				
				if(l5.isMoveValid(arrayPosition[0],arrayPosition[1])==true) {
					l5.board[arrayPosition[0]][arrayPosition[1]]= player1;
					flag=0;
				}else if(l5.isMoveValid(arrayPosition[0],arrayPosition[1])==false)
					flag=1;
				
				}while(flag!=0);
				
			}else if(l5.currentPlayer(index) == player2) {
				do {
					flag=-1;
				System.out.println("Player2 please enter an index from the TicTacToe board:");
				for(int i=0; i< l5.board.length; i++) {
					for(int j=0; j<l5.board.length; j++) {
						System.out.print(i);
						System.out.print(j + " ");
					}	
					System.out.println();
				}
				
				String position = scan.next();
				arrayPosition = getPosition(position);
				//System.out.println(arrayPosition[0] + "\n" + arrayPosition[1]);
				if(l5.isMoveValid(arrayPosition[0],arrayPosition[1])==true) {
					l5.board[arrayPosition[0]][arrayPosition[1]]= player2;
					flag=0;
				}else if(l5.isMoveValid(arrayPosition[0],arrayPosition[1])==false)
					flag=1;
				
				}while(flag!=0);
			}
			
			l5.displayBoard();
			
			if(l5.isWin()== true) {
				System.out.println("You won ");
				break;
			}
			index++;
		}
	}
	
	public void displayBoard() {
		for(int i=0; i< this.board.length; i++) {
			for(int j=0; j<this.board.length; j++) {
				System.out.print(this.board[i][j] + " ");
			}	
			System.out.println();
		}
		
	}
	
	public boolean isWin() {
		boolean win=false;
		for(int i=0; i< this.board.length; i++) {
			for(int j=0; j<this.board.length; j++) {
				
				if( ((this.board[i][j]==this.board[0][0])&&(this.board[i][j]=='X')) &&
					((this.board[i][j]==this.board[0][1])&&(this.board[i][j]=='X'))	&&
					((this.board[i][j]==this.board[0][2])&&(this.board[i][j]=='X')) ) {
					win=true;
				}else if( 
						((this.board[i][j]==this.board[1][0])&&(this.board[i][j]=='X')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='X'))	&&
						((this.board[i][j]==this.board[1][2])&&(this.board[i][j]=='X'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[2][0])&&(this.board[i][j]=='X')) &&
						((this.board[i][j]==this.board[2][1])&&(this.board[i][j]=='X'))	&&
						((this.board[i][j]==this.board[2][2])&&(this.board[i][j]=='X'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][0])&&(this.board[i][j]=='X')) &&
						((this.board[i][j]==this.board[1][0])&&(this.board[i][j]=='X'))	&&
						((this.board[i][j]==this.board[2][0])&&(this.board[i][j]=='X'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][1])&&(this.board[i][j]=='X')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='X'))	&&
						((this.board[i][j]==this.board[2][1])&&(this.board[i][j]=='X'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][2])&&(this.board[i][j]=='X')) &&
						((this.board[i][j]==this.board[1][2])&&(this.board[i][j]=='X'))	&&
						((this.board[i][j]==this.board[2][2])&&(this.board[i][j]=='X'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][0])&&(this.board[i][j]=='X')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='X'))	&&
						((this.board[i][j]==this.board[2][2])&&(this.board[i][j]=='X'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][2])&&(this.board[i][j]=='X')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='X'))	&&
						((this.board[i][j]==this.board[2][0])&&(this.board[i][j]=='X'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][0])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[0][1])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[0][2])&&(this.board[i][j]=='O')) ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[1][0])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[1][2])&&(this.board[i][j]=='O'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[2][0])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[2][1])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[2][2])&&(this.board[i][j]=='O'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][0])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[1][0])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[2][0])&&(this.board[i][j]=='O'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][1])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[2][1])&&(this.board[i][j]=='O'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][2])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[1][2])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[2][2])&&(this.board[i][j]=='O'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][0])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[2][2])&&(this.board[i][j]=='O'))  ) {
						win=true;
				}else if( 
						((this.board[i][j]==this.board[0][2])&&(this.board[i][j]=='O')) &&
						((this.board[i][j]==this.board[1][1])&&(this.board[i][j]=='O'))	&&
						((this.board[i][j]==this.board[2][0])&&(this.board[i][j]=='O'))  ) {
						win=true;
				}else {
					win=false;
				}
			}	
		}
		return win;
	}
	
	public boolean isMoveValid(int x, int y) {
		boolean flag=false;
		for(int i=0; i< this.board.length; i++) {
			for(int j=0; j<this.board.length; j++) {
				
				if((this.board[i][j]=='_')&&(i==x)&&(y==j)) {
					flag=true;
				}
			}	
		}
		return flag;
	}
	
	public char currentPlayer(int index) {
		char currPlayer = 0;
		
		if(index%2==0) {
			currPlayer= 'O';
			//System.out.println("Current Player is:  O");
		}else{
			currPlayer = 'X';
			//System.out.println("Current Player is:  X");
		}
		
		return currPlayer;
	}
	
	public static int[] getPosition(String position) {
		int[] array = new int [2];
		switch(position) {
		case "00": 
			array[0]=0;
			array[1]=0;
			break;
		case "01": 
			array[0]=0;
			array[1]=1;
			break;
		case "02": 
			array[0]=0;
			array[1]=2;
			break;
		case "10": 
			array[0]=1;
			array[1]=0;
			break;
		case "11": 
			array[0]=1;
			array[1]=1;
			break;
		case "12": 
			array[0]=1;
			array[1]=2;
			break;
		case "20": 
			array[0]=2;
			array[1]=0;
			break;
		case "21": 
			array[0]=2;
			array[1]=1;
			break;
		case "22": 
			array[0]=2;
			array[1]=2;
			break;
		default:
			break;
		}
		
		return array;
	}
	
}
