import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class WordSearch {
    private final String[] board;
    private final String word1;
    private final int rows;

    public WordSearch(String[] board, String word1, int rows) {
        this.board = board;
        this.word1 = word1;
        this.rows = rows;
    }

    public String[] run() {
        for (int i = 0; i < rows; i++) {
            board[i] = match(board[i]);
        }
        return board;
}

    private String match(String line) {
        StringBuilder result = new StringBuilder("");
        StringBuilder helper = new StringBuilder("");

        int i = 0;
        int j = 0;

        while (i < line.length()) {
            if (line.charAt(i) != word1.charAt(j)) {
                result.append(line.charAt(i));
                i++;
            }

            else {
                if (helper.length() == 0) helper.append(toUpperCase(line.charAt(i)));
                else if (helper.charAt(helper.length() -1) != line.charAt(i)) {
                    helper.append(toUpperCase(line.charAt(i)));

                }
                if (helper.length() == word1.length()) result.append(helper);
                i++;
                if (j < word1.length() - 1) j++;
            }
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordSearch that = (WordSearch) o;
        return Arrays.equals(board, that.board);
    }
}