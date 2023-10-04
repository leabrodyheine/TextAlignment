/**
 * This leftAlign class contains the method to align text to the left.
 * It also is an inheriting class for the abstract class AlignmentFormatter.
 */
public class leftAlign extends AlignmentFormatter {
    /**
    * Aligns the given paragraph to the left.
    * @param paragraphs The input text.
    * @param maxLineLength The maximum line length before wrapping.
    */
    public leftAlign(String[] paragraphs, int maxLineLength) {
        super(paragraphs, maxLineLength);

    }

    /**
     * This method is the logic behind the left alignment text format.
     * @return a string.
     */
    @Override
    public String display() {
        StringBuilder alignresult = new StringBuilder();

        for (String paragraph : paragraphs) {
            String[] words = paragraph.split(" ");
            StringBuilder currentline = new StringBuilder();

            for (String word : words) {
                if (currentline.length() + word.length() + 1 > maxLineLength || word.length() > maxLineLength) {
                    if (currentline.length() > 0) {
                        alignresult.append(currentline).append("\n");
                        currentline.setLength(0);
                    }
                    if (word.length() > maxLineLength) {
                        alignresult.append(word).append("\n");
                    } else {
                        currentline.append(word);
                    }
                } else if (currentline.length() == 0) {
                    currentline.append(word);
                } else {
                    currentline.append(" ").append(word);
                }
            }
            if (currentline.length() > 0) {
                alignresult.append(currentline).append("\n");
            }
        }
      return alignresult.toString().trim();
    }
}
