/**
 * This centerAlign class contains the method to align text to the center.
 * It also is an inheriting class for the abstract class AlignmentFormatter.
 */
public class centerAlign extends AlignmentFormatter {

    /**
     * This method initializes a formatter.
     * @param paragraphs the input text from the file.
     * @param maxLineLength the maximun characters allowed in a line.
     */
    public centerAlign(String[] paragraphs, int maxLineLength) {
        super(paragraphs, maxLineLength);

    }

    /**
     * This method is the actual logic behind aligning text in the center.
     * It takes the maximun line length and subtracts the currentline length to
     * calculate the total extra spaces in the line. It is the divided by 2 and
     * extra spaces are appended to the left of the line by the total extra spaces
     * divded by 2.
     * @return a string
     */
    @Override
    public String display() {
        StringBuilder alignedresult = new StringBuilder();
        for (String paragraph : paragraphs) {
            String[] words = paragraph.split(" ");
            StringBuilder currentline = new StringBuilder();
            for (String word : words) {
                if (currentline.length() + word.length() == maxLineLength) {
                    currentline.append(word);
                    alignedresult.append(currentline).append("\n");
                    currentline.setLength(0);
                }
                else if (currentline.length() + word.length() + 1 > maxLineLength || word.length() > maxLineLength) {
                    if (currentline.length() > 0) {
                        String trimmedCurrentLine = currentline.toString();
                        int totalPadding = maxLineLength - trimmedCurrentLine.length();
                        int leftPadding = totalPadding / 2 + 1;
                        alignedresult.append(" ".repeat(leftPadding));
                        alignedresult.append(trimmedCurrentLine).append("\n");
                        currentline.setLength(0);
                    }
                    if (word.length() >= maxLineLength) {
                        alignedresult.append(word).append("\n");
                    }
                    else {
                        currentline.append(word).append(" ");
                    }
                }
                else {
                    currentline.append(word).append(" ");
                }
            }
            currentline.append("\n");
            if (currentline.length() >= 0) {
                String trimmedCurrentLine = currentline.toString().trim();
                int totalPadding = maxLineLength - trimmedCurrentLine.length();
                int leftPadding = (totalPadding + 1) / 2;
                alignedresult.append(" ".repeat(leftPadding));
                alignedresult.append(trimmedCurrentLine).append("\n");
                currentline.setLength(0);
            }
        }
      return alignedresult.toString();
    }
}
