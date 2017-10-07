//8.11

import java.util.Scanner;

public class HeadsAndTails {
public static void main(String[] args) {

// Get input from user
Scanner input = new Scanner(System.in);
System.out.println("Enter a number between 0 and 511: ");

int theNumber = input.nextInt();
int[][] matrix = new int[3][3];  

// convert a decimal number to binary, put them in a 3 x 3 matrix
for( int i=2; i>=0; i--) {
    for( int j=2; j>=0; j--) {
        matrix[i][j] = theNumber % 2;      
        theNumber = theNumber - matrix[i][j] ;
        theNumber = theNumber / 2;
    }
}
 
// Output
for( int i=0; i<3; i++) {
    for( int j=0; j<3; j++) {
        if ( matrix[i][j] == 1) System.out.print(" T ");
        else System.out.print(" H ");    
    }
    System.out.print("\n");    
}
}
}