//12.13
import java.util.*;
import java.io.*;

public class WordCount {

      
  public static void main(String[] args) throws Exception {

        // Check command line parameter usage 
        if (args.length != 1) {
          System.out.println(
            "Usage: java filename");
          System.exit(1);
        }

        // Check if source file exists 
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
          System.out.println("Source file " + args[0] + " not exist");
          System.exit(2);
        }

        int characterCount = 0;
        int wordCount = 0;
        int lineCount = 0;

    try {
                Scanner input = new Scanner(sourceFile);

            while (input.hasNext()) {
                  String s = input.nextLine();
              characterCount += s.length();    
              lineCount++;                     

              // Count words using split          
              String[]  w = s.split(" ");      
              for (int i = 0; i < w.length; i++); {
              wordCount++;
              }

            }
    } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
    }

    System.out.println("File " + sourceFile + " has");
    System.out.println(characterCount + " characters");
    System.out.println(wordCount + " words");
    System.out.println(lineCount + " lines");

        

  }

}