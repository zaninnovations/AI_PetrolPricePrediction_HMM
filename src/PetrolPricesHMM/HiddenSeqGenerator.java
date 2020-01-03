/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetrolPricesHMM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/**
 *
 * @author Smart
 */
public class HiddenSeqGenerator {
      public enum State {S,I,D,E};
    String str_data = "";
    int h ;
    private State state;
   double[][] matrix = new double[100][100];
      double[][] matrix1 = new double[100][100];
int LengthOfObs;
    String z="";
        String s1;
       HiddenSeqGenerator(){
         
         this.LengthOfObs=9;
         
     }  
 

  public int readstate() {
                 int x=0, y=0;
                 int lnum = 0;

		try
        {
		BufferedReader in = new BufferedReader(new FileReader("B:\\STEProbab.txt"));	//reading files in specified directory
			String line;
                        LineNumberReader lnr = new LineNumberReader(in);
                        z=in.readLine();
         
        }catch( IOException ioException ) {}
                
            h=Integer.parseInt(z);
            return h;
            }
         

        

public void readtransitionProbab() {
		int x=0, y=0;
                readstate();
		try
        {
		BufferedReader in = new BufferedReader(new FileReader("B:\\STEProbab.txt"));	//reading files in specified directory
			String line;
                        in.readLine();
                        int i=0;
			while (((line = in.readLine()) !=null)&&(i<h))	//file reading
{
    
   String[] values = line.split(",");
   for (String str : values)
   {
      double str_double = Double.parseDouble(str);
      matrix[x][y]=str_double;
     y=y+1;     
   }
   y=0;
     x=1+x;
     i++;
}
                                     
       	in.close();
                       
        }catch( IOException ioException ) {}
              
              
   }
      
  
    public void update() throws FileNotFoundException{  
         
                                PrintWriter outputfile = new PrintWriter("B:\\HiddenSeq.txt");
           HiddenSeqGenerator obj = new HiddenSeqGenerator();
int i=0;
           System.out.print("START,");

            for(i=0;i<obj.LengthOfObs;i++){

        readtransitionProbab();
        
        double random = Math.random();
//System.out.print(random);


        if(random<matrix[0][0]){
            state = State.S;
            
        }
        else if ( random<matrix[0][1]){

            state = State.I;
           outputfile.print("I\n");
           System.out.print("Inflation,");

              

                            
        }
        else if(random< matrix[0][1]+matrix[0][2]){
              
            state=State.D;
                       System.out.print("Deflation,");

                         outputfile.print("D\n");
                        String s = "Decrease";
  
        }
        else {

                state=State.E;
                }

            }

            outputfile.close();
                       System.out.print("END");

                                      System.out.print("\n");
 
        
}
    
     public State output(){
-        return state;
-    }
    
   
      
}


