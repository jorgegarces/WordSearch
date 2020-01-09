import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class WordSearch {
    private final String line1;
    private final String word1;

    public WordSearch(String line1, String word1) {
        this.line1 = line1;
        this.word1 = word1;
    }

    public String search() {
        String result = new String();
        for(int i = 0; i < line1.length(); i++) {
            if (line1.charAt(i) != word1.charAt(0)) result += line1.charAt(i);
            else result += toUpperCase(line1.charAt(i));
        }
        return result;
    }
}
