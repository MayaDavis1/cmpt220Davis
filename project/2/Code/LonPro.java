//LonProFinal

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.Scanner;


public class LonPro extends JPanel {
	
	public LonPro() { }
    
	// Java graphics basic   https://www.youtube.com/watch?v=llMIT6No7N8
	// and here   https://stackoverflow.com/questions/10628492/dynamic-graphics-object-painting	
	
	// needs following line to make the graphics work. 
	public void paintComponent(Graphics g) { super.paintComponent(g);  }	

	
	
	
	
	
	
	
	
	
	
	
	// ################ OBJECT gameBoard ######################################################
	
	public static class gameBoard extends JFrame {  // needs JFrame in order to display as graphics 

		public int[][] colorSeries = new int[12][3];
		public char[] symbol = new char[12];
		
		public boolean[] onBoard = { false,false,false,false,false,false,false,false,false,false,false,false};
		public int howManyOnBoard = 0;
		public int [] widthOfRow = new int[16];   // LonPro has a triangular board, this will be used to shorten the process of TryFitIn
		public int [][] results = new int[16][64]; // 14x20 should be enough to cover everything, including the movable Quadrillion board.
		public int gameBoardHeight = 0;

		
		// Graphics slow things down too much. Halt graphics in order to actually reach the final solution.
		public boolean keepDrawing = false; // Show the game solving process in graphics. Use mouse clicked event to toggle.
		
		private JFrame frame = new JFrame();
		private JPanel gamePanel = new JPanel();
		// private JLabel statusbar;
		private JLabel label = new JLabel();;
		Graphics2D g2d;
				
		// 7 basic mouse events. I've only used mouse in/out of "gamePanel" events so far, but need to leave all 7 in or get an error.
		// Mouse event tutorial:  https://www.youtube.com/watch?v=hsHqhX0s7Rs
		public class Handlerclass implements MouseListener, MouseMotionListener {  			 
			public void mouseClicked(MouseEvent event) { keepDrawing = !keepDrawing; }	// ex: statusbar.setText(String.format("Clicked at %d, %d", event.getX(), event.getY()));
			public void mousePressed(MouseEvent event) { } // ex. statusbar.setText("you pressed down the mouse");						 
			public void mouseReleased(MouseEvent event) { } // ex. statusbar.setText("You released the button");
			public void mouseEntered(MouseEvent event) { } // ex. statusbar.setBackground(Color.RED);
			public void mouseExited(MouseEvent event){ }  // ex. statusbar.setBackground(Color.GRAY);
			public void mouseDragged(MouseEvent event) { } // ex. statusbar.setText("You are dragging the mouse");
			public void mouseMoved(MouseEvent event) { }  // ex. statusbar.setText("You moved the mouse");	 
		}	
		Handlerclass handler = new Handlerclass();

		
		
		

		
		// =================== start of the gameBoard constructor =======================
		gameBoard() {
							
			gamePanel.addMouseListener(handler);
			gamePanel.addMouseMotionListener(handler);					
			gamePanel.setBackground(Color.BLACK);
		 
	        frame.setSize(640,480);	    
	        
	        // int vertexes = 20;  
	        // int canvasSize = vertexes * vertexes ;  // This in the example, but that gives a square graphic panel. 
	        // in the example: BufferedImage bImage = new BufferedImage(canvasSize, canvasSize, BufferedImage.TYPE_INT_ARGB);
	        BufferedImage bImage = new BufferedImage(500, 300, BufferedImage.TYPE_INT_ARGB);
	        
	        g2d = bImage.createGraphics();
	        
	        ImageIcon iIcon = new ImageIcon(bImage); 
	        label.setIcon(iIcon);
	        gamePanel.add(label);
	        frame.add(gamePanel);  // frame.add(gamePanel, BorderLayout.CENTER);     
	            
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		    
	        
	        // Graphics initialization is done.  Now, set the whole matrix results [][] with value 12 (means not part of the gameBoard at all.)        
	        for(int i=0; i<results.length; i++) { for(int j=0; j<results[0].length; j++) { results[i][j] = 12; } }   
	        
	        for(int i=0; i< widthOfRow.length; i++) { widthOfRow[i] =0; } // The actual game board dimension will be set in the setBoard method.       
		} // =================== end of gameBoard constructor ================================================
		
		
		
		
		// ===== Set initial values.  -1:empty pit, 12:outside of the board, 0 to 11 occupied by a piece
		
		public void setBoard(String[][] inputData, String inputGameTitle) {

			
			frame.setTitle(inputGameTitle); // Use the 1st line in the input file as the window title.
			for(int i=0; i<inputData.length; i++) {
				for(int j=0; j<inputData[0].length; j++) {
					inputData[i][j] = inputData[i][j].trim();
					if( inputData[i][j].length() != 1 ) { results[i][j] = 12;   }
					else if( inputData[i][j].charAt(0) == '_') { results[i][j] = -1;  }
					else {
						for(int k=0; k<12; k++) {
							if( inputData[i][j].charAt(0) == symbol[k] ) { results[i][j] = k;  }
						}
					}				
				}
			}
			
			// calculating the actual game board dimension. 
			for(int i=0; i<results.length; i++) {
				for(int j=results[0].length-1; j>=0; j--) {
					if(results[i][j] < 12)  { widthOfRow[i] = j+1; break; }
				}
				if(widthOfRow[i] > 0) { gameBoardHeight = i+1; }			 
			}		 
			
			// Record those "give" ones. (Those given in the problem.)
	        for(int i=0; i<results.length; i++) {
				for(int j=0; j<results[0].length; j++) {
					if(results[i][j]>=0 && results[i][j]<=11) { onBoard[results[i][j]]=true; }
				}
	        }     
	        for(int i=0;i<12; i++) { if(onBoard[i]) { howManyOnBoard ++; } }
		} // =================== end of setBoard method ===========================================

		
		
		
		// ======= set symbol and color of each piece --- L
		public void setColorSymbol(int[][] specifiedColorSeries, char[] specifiedSymbol) {
			for(int i=0; i<12; i++) {
				symbol[i] = specifiedSymbol[i];
				for(int j=0;j<3;j++) { colorSeries[i][j] = specifiedColorSeries[i][j]; }
			}
		} // ====== end of setColorSymbol method ==========================================
		
		
		
		
		
		
		// ================== drawBoard: has graphic output in addition to the terminal text output  ================
		
		public void drawBoard(boolean solid, boolean outputTextToo) {			
							
			for(int i=0;i< gameBoardHeight;i++) {						
				for(int j=0;j< widthOfRow[i];j++)  { 
					
					int temp = results[i][j];	
					if(temp >= 0 && temp<12 ) {
						int xLoc = ( j *20) + 50; // column #  x  20 shift 50 pixels to the right
				        int yLoc = (i*20) + 50; // row # x 20, shift down 50 pixels			            
				            
				        g2d.setColor(new Color( colorSeries[temp][0], colorSeries[temp][1], colorSeries[temp][2] ));
				            
				        if(solid) g2d.fillOval(xLoc, yLoc, 12, 12);  
				        g2d.drawOval(xLoc, yLoc, 12, 12);
					}
						
					else if(temp == -1 ) {  // means it's still an unoccupied pit/hole
						int xLoc = ( j * 20) + 50; // column #  x  20 shift 50 pixels to the right
				    	int yLoc = (i*20) + 50; // row # x 20, shift down 50 pixels
				            
				    	g2d.setColor( Color.BLACK );
				            
				        if(solid) g2d.fillOval(xLoc, yLoc, 12, 12);  
				        g2d.drawOval(xLoc, yLoc, 12, 12);
					}	
				}
			} 
			label.repaint();
			// Time delay... so it's easier to see how it goes! 	
			try { Thread.sleep(100); } 
			catch(InterruptedException ex)  { Thread.currentThread().interrupt(); }					
			
			// Output the board as text to terminal 
			if( outputTextToo) {
				for(int i=0;i< gameBoardHeight;i++) {
					for(int j=0;j< widthOfRow[i];j++)  { 
						if( results[i][j]>=12) System.out.print(" ");
						else if( results[i][j]<0) System.out.print("_");
						else System.out.print( this.symbol[ results[i][j] ]);
					}
				System.out.print("\n");
				}
			}
		}  // ============= end of drawBoard method
		
   


    

	}   // ####################### end of OBJECT gameBoard ######################
    
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	// Static data of 12 game pieces' basic forms used by LonPro
	// These will be feed into object gamePiece's constructor to create a full set (that has all possible unique orientations).
	public static int[][] p_D = { {0,0}, {0,1}, {1,1}, {1,0}        }; // square 2x2
	public static int[][] p_x = { {0,1}, {1,0}, {1,1}, {1,2}, {2,1} }; // little cross 
	public static int[][] p_I = { {0,0}, {0,1}, {0,2}, {0,3}        }; // straight 1x4
	public static int[][] p_v = { {0,1}, {0,0}, {1,0}               }; // little angled
	public static int[][] p_W = { {0,2}, {0,1}, {1,1}, {1,0}, {2,0} }; // stair 
	public static int[][] p_V = { {0,2}, {0,1}, {0,0}, {1,0}, {2,0} }; // big angled
	public static int[][] p_U = { {0,0}, {1,0}, {1,1}, {1,2}, {0,2} }; // U shaped
	public static int[][] p_y = { {0,0}, {1,0}, {1,1}, {2,0}, {3,0} }; // little y or asymmetrical t
	public static int[][] p_L = { {0,0}, {1,0}, {2,0}, {3,0}, {3,1} }; // big L 4x2
	public static int[][] p_j = { {0,0}, {1,0}, {2,0}, {2,1}        }; // little L, or j   2x3
	public static int[][] p_h = { {0,0}, {1,0}, {2,0}, {1,1}, {0,1} }; // a wedge? 
	public static int[][] p_z = { {0,0}, {0,1}, {1,1}, {1,2}, {1,3} }; // little z with a long tail
	
	
	
	
	
	
	
	
    // ##################### start of OBJECT gamePiece ##########################
	public static class gamePiece {   
		     
		// A game piece's maximum "unique" orientations is 8.  
        public boolean [] unique = new boolean[8];
        public int howManyUnique = 1;
        
        // These store Vertical and Horizontal coordinates (on the board) that each piece at each orientation need to go thru
        // maximum is 55, actual numbers are far less.
        public int trackH[][] = new int[8][64];
        public int trackV[][] = new int[8][64];  
        public int howManySteps[] = new int[8];
        // each piece can have between 3 and 5 balls.  So 16 is more than enough
        public int footPrintH[][] = new int[8][16]; 
        public int footPrintV[][] = new int[8][16];
        public int howManyToes = 0;
        char symbol = ' ';
        
        
        
        
        // ======================  constructor of gamePiece ====================
        gamePiece(char theSymbol, int[][] initialShape) {
        	 
        	// set initial values.
        	this.symbol = theSymbol;
        	for(int n=0; n<footPrintH.length; n++) {  // 8
         		this.unique[n] = false;
        		for(int i=0; i<footPrintH[0].length; i++) { // 16
        			this.footPrintH[n][i]=99; 
        			this.footPrintV[n][i]=99; 
        		}
        		for(int i=0; i<trackH[0].length; i++) { // 64
        			this.trackH[n][i] = 0;
        			this.trackV[n][i] = 0;
        		}
        	}      	
        	this.howManyToes = initialShape.length;  
        	
        	// determine overall size of the original (it happens to be maximum of original v and h)
        	
         	int maxH=-1; int maxV=-1;
        	for(int n=0; n< this.howManyToes; n++) { 
        		if( initialShape[n][0] > maxV) maxV = initialShape[n][0];
        		if( initialShape[n][1] > maxH) maxH = initialShape[n][1];        	
        	}
       	
        	// creating footPrintV[#_][steps], footPrintH[#_][steps] by
        	for(int n=0; n < this.howManyToes; n++) {
        		int v = initialShape[n][0];
        		int h = initialShape[n][1];
        		
        		footPrintV[0][n] = v;         footPrintH[0][n] = h;          // #0: copy of the original shape
        				
        		footPrintV[1][n] = h;         footPrintH[1][n] = maxV - v;   // #1: 90-degree rotation from original      		
        		footPrintV[2][n] = maxV - v;  footPrintH[2][n] = maxH - h;   // #2: 180-degree rotation from original
        		footPrintV[3][n] = maxH - h;  footPrintH[3][n] = v;          // #3: 270-degree rotation from original
       		
        		// #4 to #7 are flip (around a horizontal axis right at the middle) of #0 to #3
        		footPrintV[4][n] = maxV - v;  footPrintH[4][n] = h;          // #4: flip of original
        		footPrintV[5][n] = maxH - h;  footPrintH[5][n] = maxV - v;   // #5: flip of #1 (original -> rotate 90 --> flip)
        		footPrintV[6][n] = v;         footPrintH[6][n] = maxH - h;   // #6: flip of #2 (original -> rotate 180 --> flip)
        		footPrintV[7][n] = h;         footPrintH[7][n] = v;          // #7: flip of #3 (original -> rotate 270 --> flip)
        	}        	
        	
        	// Use function sequenceUnique to (1) determine if an orientation is unique or not; 
        	// (2) remove duplicate, and move unique orientations into a continuous sequence.
        	this.howManyUnique = sequenceUnique(8);  // 8 is what just been created.  howManyUnique will be the consolidated number.

        } // ================= end of gamePiece constructor ====================
 
        
        
        
        
        
        
        
        // ========================= build a track with stops where the game piece (in a particular orientation) can actually fit in.  
        
        public int buildTrack(gameBoard theGameBoard, int whichOrientation) {
        	int tempHowManySteps = 0;
        	this.trackH[whichOrientation][0] = 0;
        	this.trackV[whichOrientation][0] = 0; // start from origin (0,0). Note: this may not turn out to be a feasible stop.
        	
        	for(int i=0; i<= theGameBoard.gameBoardHeight; i++) {   
        		for(int j=0; j<= theGameBoard.widthOfRow[i]; j++) {  
        			
        			boolean possibleStop = true;        			
        			for(int tt = 0; tt< this.howManyToes; tt++ ) {
        				int tempH = footPrintH[whichOrientation][tt];
        				int tempV = footPrintV[whichOrientation][tt];
        				if(  theGameBoard.results[i+tempV][j+tempH] >= 0) { possibleStop=false; break; }	 
        			}
        			
        			if(possibleStop) { 
        				trackV[whichOrientation][tempHowManySteps] = i; 
        				trackH[whichOrientation][tempHowManySteps] = j;   
        				tempHowManySteps ++ ;
        			}
        		}
        	}    
         	
            this.howManySteps[whichOrientation] = tempHowManySteps;         
            
        	return tempHowManySteps;
        }
        
 
        
        
        
        
        
        
        // ========== Compare two footPrints to see if they are identical. 
        // =========== This function is only used by function: sequenceUnique right below ============== 
        
        private boolean footPrintEqual( int[] footPrintV1, int[] footPrintH1, int[] footPrintV2, int[] footPrintH2) {
        	boolean isUnique = true;
        	int[][] workSpace = new int[4][4];  // 4 x 4 is enough for any game piece, 
        	for(int i=0; i<workSpace.length; i++) { for(int j=0; j<workSpace[0].length;j++) { workSpace[i][j] = 0; }} // set them 0 first
        	
        	for(int k=0; k<this.howManyToes; k++) {
        		workSpace[ footPrintV1[k] ][ footPrintH1[k] ] ++;        		
        		workSpace[ footPrintV2[k] ][ footPrintH2[k] ] ++;      	
        	}
        	
        	for(int i=0; i<workSpace.length; i++) { 
        		for(int j=0; j<workSpace[0].length;j++) { 
        			if( workSpace[i][j] ==1 ) { isUnique = false; break; }
        		}
        		if( !isUnique ) break;
        	}
         	return isUnique;
       	
        }
        


        
        // ======= A simple function to determine if an orientation is unique then rearrange unique orientations into a continues sequence. 
        // Notes: symmetrical pieces (e.g., v W V U s t) don't have full set (8) of unique orientations. 
        //
        // Rearrange: before: (#0)Unique, (1)Unique, (2)Duplicated, (3)Duplicated, (4)Unique, (5)Unique, (6)Duplicated, (7)Duplicated 
        // after the process: (#0)Unique, (1)Unique, (4)Unique, (5)Unique, (2)Duplicated, (3)Duplicated, (6)Duplicated, (7)Duplicated
        // It will return the number of truly unique orientations.
        
        private int sequenceUnique(int howManyToInvestigate ) {
        	unique[0] = true; // At least the first one (original) must be unique.
        	
        	// First, it examines and marks each orientation's uniqueness.
        	for(int KK=1; KK< howManyToInvestigate; KK++) { // can have up to 8 unique orientations 
        		
        		unique[KK] = true; // First, assume it's unique.  
        		
        		for(int k=0; k<KK; k++) {
        			if( footPrintEqual(this.footPrintV[ k ], this.footPrintH[ k ], this.footPrintV[ KK ], this.footPrintH[ KK ]) ) { 
        				// found [k] and [KK] are identical. So the latter (KK) is unnecessary.
        				unique[KK]=false; 
        				break; 
        			}  
        		}
        	} // Done marking each orientation's uniqueness  	
        	
         	
        	// Sorting: when a NOT-unique is found, keep looking till a Unique is found, then swap them.
        	for(int k=0; k<footPrintV.length-1; k++) {
        		if(!unique[k]) {
        			for(int kk=k+1; kk<footPrintV.length;kk++) {
        				if(unique[kk]) {
        					for(int i=0; i<footPrintV[0].length;i++) {        						 
        						footPrintV[k][i] = footPrintV[kk][i];
        						footPrintH[k][i] = footPrintH[kk][i];
        					}  					
        					this.unique[kk] = false; 
        					this.unique[k] = true;
        					break;
        				}
        			}        			
        		}
        	}
         	int howManyUniqueOrientations = 0;
         	for(int k=footPrintV.length-1; k>=0; k--) {
        		howManyUniqueOrientations = k+1;
        		if(unique[k]) break;
        	} 
        	return howManyUniqueOrientations;      	
        }
        
 
        
 

		
	}   
    // ##################### OBJECT gamePiece ends ##########################

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 	
 
	   
	// ############################ Below is main() #################################################
	
	public static void main(String[] args) {
				
		String [][] inputData = new String [16][32]; // maximum 16x16 for now
		for(int i=0; i<16; i++) for(int j=0; j<32; j++) inputData[i][j] = "#";
		
		Scanner input = new Scanner(System.in);
		System.out.println("Name of your input file (examples: LP282.txt  LP324.txt):");
		String inputFileName = input.nextLine();
		System.out.println("You entered: " + inputFileName );
		    
               
        // This will reference one line at a time
        String line = null;
        String line1 = null;  // First line contains type of game and ref to question # in the booklet.
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(inputFileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line1 = bufferedReader.readLine();
            System.out.println("first line: "+ line1);
            
            int ii=0;
            while( (line = bufferedReader.readLine()) != null )  {   
            	String[] strings = line.split(",");          	
            	int jj=0;
            	for(String str : strings) { 
              		inputData[ii][jj] = str.trim();
            		jj++;
            	}
            	ii++;
            }
            bufferedReader.close();    
        }
        catch(FileNotFoundException ex) { System.out.println("Unable to open file '" + inputFileName + "'");  }
        catch(IOException ex) { System.out.println("Error reading file '" + inputFileName + "'"); }
				
        
		gamePiece[] myGamePiece = new gamePiece[12];
		gameBoard myGameBoard = new gameBoard();

		// Order that pieces are put in.
    	int aSeries[][][] = { p_D, p_x, p_I, p_v, p_W, p_V, p_U, p_y, p_L, p_j, p_h, p_z} ;   		
    	char[] symbol = {'D','x','I','v','W','V','U','y','L','j','h','z'};
    	int[][] LonProColorSeries = {{168, 237, 89},{145, 192, 171},{103,83,168},{180,158,158},{196,74,125},{120,240,240},
    					{255,226,37},{248,180,216},{9,72,149},{255,140,0},{214,34,0},{0,144,80}};   
    		
    	for(int i=0; i<12; i++) { myGamePiece[i] = new gamePiece(symbol[i], aSeries[i]  ); }
    	
    	myGameBoard.setColorSymbol( LonProColorSeries,symbol); 
    	myGameBoard.setBoard(inputData, line1);
        
		System.out.println("\n\nThe Quest:"+"\n" );
		myGameBoard.drawBoard(true, true); // first "true" means solid dot (hollow circles if false); second true means "do text output too."

		
		
		// Establish a "track" for each game piece, each orientation.  It contains all pit stops that piece, at an orientation, 
		// can fit in. (staying in bound, not overlapping with pieces that are part of the problem/challenge). 
		
		
		int totalsteps=0;
		int totalOrientation=0;
		for(int whichPiece=0; whichPiece<12; whichPiece++) {
			for(int whichOrientation=0; whichOrientation < myGamePiece[whichPiece].howManyUnique; whichOrientation++) {
				int temp = myGamePiece[whichPiece].buildTrack(myGameBoard, whichOrientation);
				totalsteps += temp ;
				totalOrientation ++;
			}
		}
		float averageSteps=(float) totalsteps / (float)totalOrientation;
		float averageOrientation = (float) totalOrientation / (float) 12;
		System.out.println("Averaging "+averageSteps + " steps for each (game piece * orientation)");
		
		
		int startingPiece = 12;
		for(int i=0; i< 12; i++) {
			if(!myGameBoard.onBoard[i]) { startingPiece = i; break; }
		}

		// https://stackoverflow.com/questions/5204051/how-to-calculate-the-running-time-of-my-program
		long startTime = System.currentTimeMillis();

		tryPutIn(startingPiece, myGamePiece, myGameBoard) ;


		long endTime   = System.currentTimeMillis();
		long totalTime = (endTime - startTime);		
		
		System.out.println("\n\nFinished! Time span: " + totalTime  + " milliseconds\n");				
		myGameBoard.drawBoard(true, true);
		
		
		 
		// Output to a file, use this: 
		
		String fileName2;
		if( inputFileName.contains("../") ) {
			fileName2 = "../Result_of_" + inputFileName.replace("../", "") ;
		}
		else fileName2 = "Result_of_"+ inputFileName;

        try {
            FileWriter fileWriter = new FileWriter(fileName2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line1); bufferedWriter.newLine();
            
            for(int i=0; i<myGameBoard.results.length; i++) {
            	for(int j=0; j < myGameBoard.results[0].length; j++) {
            		int temp = myGameBoard.results[i][j];
            		if(temp == 12) bufferedWriter.write(" ");
            		else if(temp ==-1) bufferedWriter.write("_");
            		else bufferedWriter.write( myGameBoard.symbol[temp]); 
            	}
            	bufferedWriter.newLine();
            }           
            bufferedWriter.write("Finished! Time span: " + totalTime  + " milliseconds");
            bufferedWriter.newLine();
           
            bufferedWriter.close();  // Always close files.
        }
        catch(IOException ex) { System.out.println("Error writing to file '" + fileName2 + "'");  }
        

	}
	
	// ############################ Above is main() #################################################


	
	
	
	
	
	
	
	
	
	
	
	
	
	



	// ############################ Below is tryPutIn() #################################################	
	public static boolean tryPutIn(int whichPiece, gamePiece[] myGamePiece, gameBoard myGameBoard ) {
			
		for(int nOrientation=0; nOrientation< myGamePiece[whichPiece].howManyUnique; nOrientation++) {  // Outer loop - try different orientation of the same piece
	
			for(int k=0; k<myGamePiece[whichPiece].howManySteps[nOrientation];k++) { // middle loop - travel along a track
				int whereV = myGamePiece[whichPiece].trackV[nOrientation][k];
				int whereH = myGamePiece[whichPiece].trackH[nOrientation][k];
					
					boolean possible = true; 
					// Assume it's "possible" to fit the piece into this hole, until find otherwise. 
					// (in that case, it just breaks and moves on)
					
					for(int nToes=0; nToes<myGamePiece[whichPiece].howManyToes; nToes++) {  // inner loop - check every toe
						int tempV = myGamePiece[whichPiece].footPrintV[ nOrientation ][ nToes ] + whereV;
						int tempH = myGamePiece[whichPiece].footPrintH[ nOrientation ][ nToes ] + whereH;
						if( myGameBoard.results[tempV][tempH] >=0 ) { possible=false; break; }					
					} 
					if(possible) {  
						// record it in the result matrix then work on next one 			
						for(int nToes=0; nToes<myGamePiece[whichPiece].howManyToes; nToes++) {
							int tempV = myGamePiece[whichPiece].footPrintV[ nOrientation ][ nToes ] + whereV;
							int tempH = myGamePiece[whichPiece].footPrintH[ nOrientation ][ nToes ] + whereH;
							myGameBoard.results[tempV][tempH] = whichPiece;  					
						}
						
						// Drawing is optional (controlled by click mouse event).
						if( myGameBoard.keepDrawing) myGameBoard.drawBoard(false,false);   
						myGameBoard.onBoard[whichPiece]=true;
						myGameBoard.howManyOnBoard++;
						
						// choose the next piece to try. 
						int nextPiece = 12;
						for(int i=0; i< 12; i++) {
							if(!myGameBoard.onBoard[i]) { nextPiece = i; break;  }
						}
						
						if( nextPiece == 12) { return true; } // Have no more game pieces! (Game pieces are indexed as 0 to 11)
						
						// ************** Recursion happens here *********************************
						if(tryPutIn(nextPiece, myGamePiece, myGameBoard)) { return true; }
						else {
							myGameBoard.onBoard[nextPiece] = false;
							myGameBoard.howManyOnBoard--;

							// Reach a dead end, turn back!  (Remove the last piece in, then try something else.)

							for(int nToes=0; nToes<myGamePiece[whichPiece].howManyToes; nToes++) {
								int tempV = myGamePiece[whichPiece].footPrintV[ nOrientation ][ nToes ] + whereV;
								int tempH = myGamePiece[whichPiece].footPrintH[ nOrientation ][ nToes ] + whereH;
								myGameBoard.results[tempV][tempH] = -1;  					
							}							
						}				
					} // end of if-possible						
				} // end of the middle loop (track loop) 

		}  // end of outer loop (orientation by orientation)
		// ################## the triple-loop ends above

		return false;
	}		
	// ############################ Above is tryPutIn() #################################################	
	

}
