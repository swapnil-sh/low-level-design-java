public interface GameState {
    void next(GameContext gameContext, Player player, boolean hasWon);
    boolean isGameOver();
}
