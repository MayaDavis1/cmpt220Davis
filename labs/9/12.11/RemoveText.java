//12.11
import java.util.*;
import java.io.*;

public class RemoveText {

        public static void main(String[] args) throws Exception {

          // Check command line parameter usage 
          if (args.length != 2) {
                System.out.println("Usage: java RemoveText text filename");
                System.exit(1);
          }

          // Check if source file exists 
          File sourceFile = new File(args[1]);
          if (!sourceFile.exists()) {
            System.out.println("Source file " + args[1] + " does not exist");
                System.exit(2);
          }

          // Create input output files
          String s = "";

          try {
                Scanner input = new Scanner(sourceFile);

                while (input.hasNext()) {
                  s += input.nextLine();
                }
          } catch (FileNotFoundException ex) {
                  System.out.println("Source file not found.");
          }
          // Remove the text
          s = s.replaceAll(args[0], "");
          try {
                // Write back to the same file
                PrintWriter output = new PrintWriter(sourceFile);
                System.out.println(s);;
                output.write(s);
                output.close();
          } catch (FileNotFoundException ex) {
                  System.out.println("Target file not found.");
          }
            // Finished processing
            System.out.println("\n");
            System.out.println("File " + sourceFile + " has been processed,");
          }

}
