abstract public class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessboard, int startLine, int startColumn, int endLine, int endColumn);
    public abstract String getSymbol();

    public boolean checkPos(int pos) {
        return (pos >= 0 && pos <= 7);
    }
}
