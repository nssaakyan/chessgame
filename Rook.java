public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                chessBoard.board[line][column] != null &&
                (line == toLine || column == toColumn) &&
                (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(color))) {
            int flag = 0;
            if (column == toColumn) {
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    return false;
                } else return true;
            }
            if (line == toLine) {
                for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    return false;
                } else return true;
            }
        } return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}