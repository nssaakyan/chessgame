public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int startLine, dir;
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                chessBoard.board[line][column] != null) {
            if (column == toColumn) {
                if (color.equals("White")) {
                    startLine = 1;
                    dir = 1;
                } else {
                    startLine = 6;
                    dir = -1;
                }
                if (line + dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null;
                }
                if (line == startLine && line + 2 * dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null;
                }
            } else {
                if ((column + 1 == toColumn || column - 1 == toColumn) &&
                        (line + 1 == toLine || line - 1 == toLine) &&
                        chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return false;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
