/**
 * This centerAlign class contains the method to align text to the center.
 * It also is an inheriting class for the abstract class AlignmentFormatter.
 */
public class rightAlign extends AlignmentFormatter {

    /**
    * Aligns the given paragraph to the right.
    * @param paragraphs The input text.
    * @param maxLineLength The maximum line length before wrapping.
    */
    public rightAlign(String[] paragraphs, int maxLineLength) {
        super(paragraphs, maxLineLength);

    }

    /**
     * This method is the logic behind the right alignment text format.
     * @return a string.
     */
    @Override
    public String display() {
        StringBuilder alignedresult = new StringBuilder();
        StringBuilder currentline = new StringBuilder();

        for (String paragraph : paragraphs) {
            String[] words = paragraph.split(" ");

            for (String word : words) {
                if (word.length() > maxLineLength) {
                    if (currentline.length() > 0) {
                        String trimmedCurrentLine = currentline.toString().trim();
                        int padding = maxLineLength - trimmedCurrentLine.length();
                        alignedresult.append(" ".repeat(padding));
                        alignedresult.append(trimmedCurrentLine).append("\n");
                        currentline.setLength(0);
                    }
                    alignedresult.append(word).append("\n");
                    continue;
                }

                if (currentline.length() + word.length() == maxLineLength) {
                    currentline.append(word);
                    alignedresult.append(currentline).append("\n");
                    currentline.setLength(0);
                    continue;
                }

                if (currentline.length() + word.length() + 1 > maxLineLength) {
                    if (currentline.length() > 0) {
                        String trimmedCurrentLine = currentline.toString().trim();
                        int padding = maxLineLength - trimmedCurrentLine.length();
                        alignedresult.append(" ".repeat(padding));
                        alignedresult.append(trimmedCurrentLine).append("\n");
                        currentline.setLength(0);
                    }
                    currentline.append(word).append(" ");
                } else {
                    currentline.append(word).append(" ");
                }
            }
            currentline.append("\n");
            if (currentline.length() > 0) {
                String trimmedCurrentLine = currentline.toString().trim();
                int padding = maxLineLength - trimmedCurrentLine.length();
                alignedresult.append(" ".repeat(padding));
                alignedresult.append(trimmedCurrentLine).append("\n");
                currentline.setLength(0);
            }
        }
      return alignedresult.toString();
    }
}
