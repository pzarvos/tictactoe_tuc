package model;

public class Board {
	private static char playerX = 'X';
	private static char playerO = 'Y';
	
	public Board() { 
	}
	
	static class Move { 
		int row,col;
	};
	
	//Function that return true if any moves left else returns false	
	public static  boolean movesLeft(char[][] board) { 
		for(int i=0; i<3; i++) { 
			for(int j=0; j<3; j++) { 
				if(board[i][j] == ' ') { 
					return true;	
				}
			}
		}
		return false;
	}
	
	//check for row victories 
	public static  int checkWinner(char b[][]) {  
	  for(int  row = 0; row < 3; row++) { 
		  for(int col = 0; col < 3; col++) { 
			  if(b[row][0] == b[row][1] && b[row][1] == b[row][2]) { 
				  if(b[row][0] == playerX )
					  return +10;
				  else if(b[row][0] == playerO) 
					  return -10;
			  }
				  
		  }
	  }
	  //chech for col victories
	for(int col = 0; col < 3; col++) { 
		if (b[0][col] == b[1][col] && b[1][col] == b[2][col]) {
			if(b[0][col] == playerX)
				return +10;
			else if(b[0][col] == playerO)
				return -10;
		}
	}
	//check for diagonal victories 
	if(b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
		if(b[0][0] == playerX) 
			return +10;
		else if(b[0][0] == playerO)
			return -10;
	}
		if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
			if (b[0][2] == playerX)
            return +10;
        else if (b[0][2] == playerO)
            return -10;
		}
		return 0;
	}
	//The minimax fuction caclulates all the ways the game can go and returns the value of the board 
	public static int minimax(char board[][],int depth,boolean max) { 
		int score = checkWinner(board);
		//if playerX won the game return score
		if(score == 10)  
			return score;
		//if playerO won the game return score
		if(score == -10)  
			return score;
		//if there are no moves left and no winner then its a draw
		if(movesLeft(board) == false)
			return 0;
		//if is playersX turn
		if(max) { 
			int best = -1000;
			 for(int i=0; i<3 ; i++) { 
				 for(int j=0; j<3 ; j++) { 
					 //if cell is empty
					 if(board[i][j] == ' ') { 
						// Make the move
						 board[i][j] = playerX;
						// Call minimax recursively and choose the maximum value
						 best = Math.max(best,minimax(board,depth + 1, !max));
						 //undo the move 
						 board[i][j] = ' ';
					 }
				 }
			 }
			 return best;
		}
		else { 
			int best = 1000;
			for(int i=0; i<3 ; i++) { 
				 for(int j=0; j<3 ; j++) { 
					 if(board[i][j] == ' ') { 
						 board[i][j] = playerO;
						 
						 best = Math.max(best, minimax(board,depth+1,!max));
						 
						 board[i][j] = ' ';
					 }
				 }
			}
			return best;
		}
		
	}
	
	static Move findBestMove(char board[][]) { 
		int bestVal = -1000;
		Move bestMove = new Move() ; 
		bestMove.row = -1;
		bestMove.col = -1;
		
		for (int i = 0; i < 3; i++)
	    {
	        for (int j = 0; j < 3; j++)
	        {
	            // Check if cell is empty
	            if (board[i][j] == ' ')
	            {
	                // Make the move
	                board[i][j] = playerX;
	 
	                // compute evaluation function for this
	                // move.
	                int moveVal = minimax(board, 0, false);
	 
	                // Undo the move
	                board[i][j] = ' ';
	 
	                // If the value of the current move is
	                // more than the best value, then update
	                // best/
	                if (moveVal > bestVal)
	                {
	                    bestMove.row = i;
	                    bestMove.col = j;
	                    bestVal = moveVal;
	                }
	            }
	        }
	    }	 
	    return bestMove;
	}
		
	}
	


			
		
	
	
	
		
	

