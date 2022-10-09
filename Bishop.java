public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                chessBoard.board[line][column] != null &&
                line != toLine && column != toColumn &&
                (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(color)) &&
                Math.max(line, toLine) - Math.min(line, toLine) == Math.max(column, toColumn) - Math.min(column, toColumn)) {
            if ((column == Math.min(column, toColumn) && line == Math.max(line, toLine)) ||
                    (toColumn == Math.min(column, toColumn) && toLine == Math.max(line,toLine))) {
                int startLine = Math.max(line, toLine);
                int startColumn = Math.min(column, toColumn);
                //int finishLine = Math.min(line, toLine);
                int finishColumn = Math.max(column, toColumn);
                int[][] positions = new int[finishColumn - startColumn][1];
                for (int i = 1; i < positions.length; i++) {
                    if (chessBoard.board[startLine - i][startColumn + i] == null) {
                        positions[i - 1] = new int[]{startLine - i,startColumn + i};
                    } else if (!chessBoard.board[startLine - i][startColumn + i].color.equals(this.color)
                                && startLine - i == toLine) {
                        positions[i - 1] = new int[]{startLine - i,startColumn + i};
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                int startLine = Math.min(line, toLine);
                int startColumn = Math.min(column, toColumn);
                //int finishLine = Math.max(line, toLine);
                int finishColumn = Math.max(column, toColumn);
                int[][] positions = new int[finishColumn - startColumn][1];
                for (int i = 1; i < positions.length; i++) {
                    if (chessBoard.board[startLine + i][startColumn + i] == null) {
                        positions[i - 1] = new int[]{startLine + i,startColumn + i};
                    } else if (!chessBoard.board[startLine + i][startColumn + i].color.equals(this.color)
                            && startLine + i == toLine) {
                        positions[i - 1] = new int[]{startLine + i,startColumn + i};
                    } else {
                        return false;
                    }
                }
                return true;
            }
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}