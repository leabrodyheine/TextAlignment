The purpose of this project was to showcase my skills in object-oriented programming and Java. The project reads a .txt file and then depending on the command line input, aligns it correctly given the specified maximum line length.
    Alignment types are:
    - left
    - right
    - center
    - justify
    - triangle 
The command line arguments are java TextAlignment '.txt file name' 'alignment type' then 'maximum line length'
This project was completed at the University of St Andrews.


The triangleAlign class contains a 5th alignment type that outputs the text as a right triangle. 
EX:
*
**
***
****
***** etc etc
To implement this feature just type "triangle" instead of left, right, justify, or center. It works with all 4 text files given but the maximum line length input won't be utilized for this to keep the triangle format as stable as possible. You still need to enter a valid 3rd argument in the command line however, it just won't affect the output. It is the same compiling as the other .java files: javac triangleAlign.java.
EX command line: java TextAlignment java.txt triangle 60
(please open the README.txt and not the preview as it is displaying it wrong)
