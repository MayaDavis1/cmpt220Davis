//Class for 9.13
public class Location {
  public int row;
  public int column;
  public double maxValue;
  
  public Location(int row, int column, double maxValue) {
	this.row = row;
	this.column = column;
	this.maxValue = maxValue;
  }
	
  public static Location locateLargest(double[][] a) {
    int row = 0;
    int column = 0;
    double maxValue = a[row][column];
    int i = 0;
	int j = 0;
	
    for (i = 0; i < a.length; i++) {
      for (j = 0; j < a[i].length; j++) {
        if (maxValue < a[i][j]) {
  		  maxValue = a[i][j];   // store the largest so far
		  row = i;              // save row number
		  column = j;           // save column number
	    }
      }
    }			  
	 
 	return new Location(row,column,maxValue);
  }

}