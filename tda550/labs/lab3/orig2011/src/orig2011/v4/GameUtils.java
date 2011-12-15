package orig2011.v4;

public enum GameUtils {
	;
	
	public static <T> T[][] newBoard(	final int width, 
										final int height, 
										final T tile){
		
		@SuppressWarnings("unchecked")
		T[][] board = (T[][]) java.lang.reflect.Array.newInstance(tile.getClass(), width, height);
		fillBoard(board, tile);
		
		return board;
	}
	
	public static <T> void fillBoard(final T[][] board, final T tile){
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = tile;
			}
		}
	}
	
	
}
