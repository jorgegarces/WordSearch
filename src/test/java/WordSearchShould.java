import org.junit.Assert;
import org.junit.Test;

public class WordSearchShould {
    @Test
    public void work_with_one_row_and_one_letter_horizontally() {
        String line1 = "zdefgz";
        String word1 = "g";
        String expected = "zdefGz";
        WordSearch wordSearch = new WordSearch(line1, word1);
        Assert.assertEquals(expected, wordSearch.search());
    }
}