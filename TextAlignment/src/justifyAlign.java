/**
 * This justifyAlign class contains the method to align text to the left but
 * with hyphens instead of putting words on the next line or allowing them to go
 * over if they dont fit on the line.
 * It also is an inheriting class for the abstract class AlignmentFormatter.
 */
public class justifyAlign extends AlignmentFormatter {
    /**
     * * This method initializes a formatter.
     * @param paragraphs the input text from the file.
     * @param maxLineLength the maximun characters allowed in a line.
     */
    public justifyAlign(String[] paragraphs, int maxLineLength) {
        super(paragraphs, maxLineLength);
    }

    /**
     * This method is the logic behind the justify alignment text format.
     * @return a string.
     */
    @Override
    public String display() {
        StringBuilder alignresult = new StringBuilder();

        for (String paragraph : paragraphs) {
            String[] words = paragraph.split(" ");
            StringBuilder currentline = new StringBuilder();

            for (String word : words) {
                if ((currentline.length() + word.length() + 1 <= maxLineLength) || (currentline.length() == 0)) {
                    if (currentline.length() > 0) {
                        currentline.append(" ");
                    }
                    currentline.append(word);
                }
                else {
                    int spaceLeft = maxLineLength - currentline.length() - 1;
                    if (spaceLeft >= 2) {
                        currentline.append(" ").append(word, 0, spaceLeft - 1).append("-");
                        alignresult.append(currentline).append("\n");
                        word = word.substring(spaceLeft - 1);
                        currentline.setLength(0);
                    } else {
                        alignresult.append(currentline).append("\n");
                        currentline.setLength(0);
                    }
                    while (word.length() > maxLineLength) {
                        currentline.append(word, 0, maxLineLength - 1).append("-");
                        alignresult.append(currentline).append("\n");
                        word = word.substring(maxLineLength - 1);
                        currentline.setLength(0);
                    }
                    if (word.length() > 0) {
                        currentline.append(word);
                    }
                }
            }
            if (currentline.length() > 0) {
                alignresult.append(currentline).append("\n");
            }
        }
      return alignresult.toString().trim();
    }
}
