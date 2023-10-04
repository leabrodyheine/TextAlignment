import java.util.*;
/**
 * This triangleAlign class contains the method to align text in a triangle.
 * It also is an inheriting class for the abstract class AlignmentFormatter.
 */
public class triangleAlign extends AlignmentFormatter {
    /**
    * Aligns the given paragraph into a triangle.
    * @param paragraphs The input text.
    * @param maxLineLength The maximum line length before wrapping.
    */

    public triangleAlign(String[] paragraphs, int maxLineLength) {
        super(paragraphs, maxLineLength);
    }

    /**
     * This method is the logic behind the triangle alignment text format.
     * @return a string.
     */
    @Override
    public String display() {
        List<String> words = new ArrayList<>();
        StringBuilder alignresult = new StringBuilder();

        for (String line : paragraphs) {
            for (String word : line.split("\\s+")) {
                words.add(word);
            }
        }

        int wordIndex = 0;
        int currentLineLength = 2;

        while (wordIndex < words.size()) {
            StringBuilder currentLine = new StringBuilder();
            int remainingSpace = currentLineLength;

            while (wordIndex < words.size() && remainingSpace > 0) {
                String currentWord = words.get(wordIndex);

                if (currentWord.length() <= remainingSpace) {
                    currentLine.append(currentWord).append(" ");
                    remainingSpace -= (currentWord.length() + 1);
                    wordIndex++;
                } else {
                    String partOfWord = currentWord.substring(0, remainingSpace);
                    currentLine.append(partOfWord);
                    words.set(wordIndex, currentWord.substring(remainingSpace));
                    remainingSpace = 0;
                }
            }
            String trimmedLine = currentLine.toString().trim();
            alignresult.append(trimmedLine).append("\n");

            currentLineLength += 4;
        }
      return alignresult.toString();
    }
}
