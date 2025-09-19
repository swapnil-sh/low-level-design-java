public class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Optional: Override toString for better debugging or printing
    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }

}
