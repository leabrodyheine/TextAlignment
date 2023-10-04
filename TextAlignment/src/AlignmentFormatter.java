/**
 * This is an abstract class that defines the functionality of a text aligner.
 * It also stores the attributes for all the inheriting classes.
 * 
 */
public abstract class AlignmentFormatter {
    protected String[] paragraphs;
    protected int maxLineLength;

    /**
     * This method initializes a formatter.
     * @param paragraphs the input text from the file.
     * @param maxLineLength the maximun characters allowed in a line.
     */

    public AlignmentFormatter(String[] paragraphs, int maxLineLength) {
        this.paragraphs = paragraphs;
        this.maxLineLength = maxLineLength;
    }

    /**
     * This defines a behavior for all inheriting classes.
     * @return a string.
     */
    public abstract String display();
}
