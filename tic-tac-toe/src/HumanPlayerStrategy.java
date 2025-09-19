import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {

    private Scanner scanner;
    private String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.scanner = new Scanner(System.in);
        this.playerName = playerName;
    }

    @Override
    public Position makeMove(Board board) {
        while (true) {
            System.out.printf("%s, enter your move (row [0-2] and column [0-2]): ", playerName);
            try {
                // Prompts the human player to enter their move.
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position move = new Position(row, col);
                // Validates the player's input.
                // If the move is valid, returns the position.
                if (board.isValidMove(move)) {
                    return move;
                }
                System.out.println("Invalid move. Try again.");
            } catch (Exception e) {
                System.out.println(
                        "Invalid input. Please enter row and column as numbers.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }
}
