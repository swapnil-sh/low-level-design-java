public class TicTacToeGame implements BoardGames {
    Board board;
    Player playerX;
    Player playerO;
    Player currentPlayer;
    GameContext gameContext;

    public TicTacToeGame(PlayerStrategy playerXStrategy, PlayerStrategy playerOStrategy, int row, int col) {
        this.board = new Board(row, col);
        this.playerX = new Player(Symbol.X, playerXStrategy);
        this.playerO = new Player(Symbol.O, playerOStrategy);
        this.currentPlayer = this.playerX;
        this.gameContext = new GameContext();
    }

    @Override
    // Loop continues until the game state indicates that the game is over.
    public void play() {
        do {
            // print the current state of the game
            board.printBoard();
            // current player makes the move
            Position move = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            // checks game state for win/draw
            board.checkGameState(currentPlayer, gameContext);
            switchPlayer();
        } while (!gameContext.isGameOver());
        announceResult();
    }
    // Alternates the current player after each move.
    // Ensures both players take turns
    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
    // Displays the outcome of the game based on the final game state.
    private void announceResult() {
        GameState state = gameContext.getCurrentState();
        if (state instanceof XWonState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
