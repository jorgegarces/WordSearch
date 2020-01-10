import org.junit.Assert;
import org.junit.Test;

public class WordSearchShould {
    @Test
    public void work_with_one_row_and_one_letter_horizontally() {
        int rows = 1;
        int columns = 6;
        int words = 1;

        String word1 = "g";

        String line1 = "zdefgz";
        String[] board = new String[] {line1};

        String expected1 = "zdefGz";
        String[] expected = new String[] {expected1};

        WordSearch wordSearch = new WordSearch(board, word1, rows);
        Assert.assertArrayEquals(expected, wordSearch.run());
        System.out.println(expected.toString());
        System.out.println(wordSearch.run().toString());
    }

    @Test
    public void work_with_one_row_and_a_three_letter_word_horizontally() {
        int rows = 1;
        int columns = 6;
        int words = 1;

        String word1 = "def";

        String line1 = "zdefgz";
        String[] board = new String[] {line1};

        String expected1 = "zDEFgz";
        String[] expected = new String[] {expected1};

        WordSearch wordSearch = new WordSearch(board, word1, rows);
        Assert.assertArrayEquals(expected, wordSearch.run());
    }

    @Test
    public void work_with_multiple_rows_and_one_word_horizontally(){
        int rows = 3;
        int columns = 6;
        int words = 1;

        String word1 = "def";

        String line1 = "zzzzzz";
        String line2 = "zdefgz";
        String line3 = "zzzzzz";

        String[] board = new String[] {line1, line2, line3};

        String expected1 = "zzzzzz";
        String expected2 = "zDEFgz";
        String expected3 = "zzzzzz";

        String[] expected = new String[] {expected1, expected2, expected3};

        WordSearch wordSearch = new WordSearch(board, word1, rows);

    Assert.assertArrayEquals(expected, wordSearch.run());
    }
}