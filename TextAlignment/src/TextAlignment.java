import java.io.File;
/**
 * This TextAlignment class contains the method to align text based on the file
 * name, alignment type, and max line length.
 */
public class TextAlignment {
       /**
        * Aligns the given paragraphs to the specified alignment and line length.
        * Prints the aligned paragraphs to standard output.
        * @param args are the arguments passed in to the command line:
            - file name
            - alignment type
            - max line length
        *
        */
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("usage: java TextAlignment <filename> <alignmentType> <lineLength>");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File not found: " + args[0] + " (No such file or directory)");
            return;
        }

        int maxLineLength;
        try {
            maxLineLength = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("usage: java TextAlignment <filename> <alignmentType> <lineLength>");
            return;
        }

        if (maxLineLength <= 0) {
            System.out.println("usage: java TextAlignment <filename> <alignmentType> <lineLength>");
            return;
        }

        String alignmentType = args[1].toLowerCase();
        if (!(alignmentType.equals("left")
            || alignmentType.equals("right")
            || alignmentType.equals("centre")
            || alignmentType.equals("justify")
            || alignmentType.equals("triangle"))) {
                System.out.println("usage: java TextAlignment <filename> <alignmentType> <lineLength>");
                return;
        }

        String[] file_paragraphs = FileUtil.readFile(args[0]);

        AlignmentFormatter aligner;

        switch(alignmentType) {
            case "left":
            aligner = new leftAlign(file_paragraphs, maxLineLength);
                break;

            case "right":
            aligner = new rightAlign(file_paragraphs, maxLineLength);
                break;

            case "centre":
            aligner = new centerAlign(file_paragraphs, maxLineLength);
                break;

            case "justify":
            aligner = new justifyAlign(file_paragraphs, maxLineLength);
                break;

            case "triangle":
            aligner = new triangleAlign(file_paragraphs, maxLineLength);
                break;

            default:
            aligner = null;
                System.out.println("usage: java TextAlignment <filename> <alignmentType> <lineLength>");
                return;
            }
      String alignedtext = aligner.display();
      System.out.println(alignedtext);
    }
}
