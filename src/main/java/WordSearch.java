public class WordSearch {

    private final String[] wordArray;
    private char[][] board;

    public WordSearch(String[] wordArray, char[][] board) {
        this.wordArray = wordArray;
        this.board = board;
    }

    public char[][] wordSearch() {
        for (String currentWord : wordArray) board = traverseMatrix(currentWord);
        return board;
    }

    private char[][] traverseMatrix(String currentWord) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (Character.toLowerCase(board[i][j]) == currentWord.charAt(0)) {
                    for (Move move : Move.values()) {
                        upperCaseIfFound(currentWord, i, j, move);
                    }
                }
        return board;
    }

    private void upperCaseIfFound(String currentWord, int i, int j, Move move) {
        int counter = 0;
        for (int k = i, l = j; counter < currentWord.length(); k = move.horizontalMove(k), l = move.verticalMove(l), counter++) {
            if (Character.toLowerCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]) != currentWord.charAt(counter))
                break;
            if (counter > 0 && Math.floorMod(k, board.length) == i && Math.floorMod(l, board[0].length) == j) break;
        }

        if (counter == currentWord.length()) {
            counter = 0;
            for (int k = i, l = j; counter < currentWord.length(); k = move.horizontalMove(k), l = move.verticalMove(l), counter++) {
                board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] = Character.toUpperCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]);
            }
        }
    }
}