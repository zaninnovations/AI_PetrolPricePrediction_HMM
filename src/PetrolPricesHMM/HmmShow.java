/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetrolPricesHMM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 * @author Zan Innovations
 */
public class HmmShow {
    
   String str_data = "";
    int h ;
    private HiddenSeqGenerator.State state;
   double[][] matrix = new double[100][100];
      double[][] matrix1 = new double[100][100];

    String z="";
        String s1;
         
    
         public int printstate() {
                 int x=0, 
		 y=0;
                 int lnum = 0;

		try
        {
		BufferedReader in = new BufferedReader(new FileReader("B:\\STEProbab.txt"));	//reading files in specified directory
			String line;
                        LineNumberReader lnr = new LineNumberReader(in);
                        z=in.readLine();
        }catch( IOException ioException ) {}
                
            h=Integer.parseInt(z);
                        System.out.println(h);

            return h;
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
    
    
    
    public void printtransitionProbab() {
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
                      System.out.print(" "+matrix[x][y]);

      
     y=y+1;     
   }
                         System.out.print("\n");

   y=0;
     x=1+x;
     i++;
}
                                     
       	in.close();
                       
        }catch( IOException ioException ) {}
              
              
   }
    
    
    public void PrintmissionProbab() {
         
         int x=0, y=0;
                 int lnum = 0;

		readstate();
                
                
		try
        {
		BufferedReader in = new BufferedReader(new FileReader("B:\\STEProbab.txt"));	//reading files in specified directory
	
                String line;
             int k;
                for(k=0;k<h+1;k++){
                        in.readLine();
                }
                        int i=0;

			while (((line = in.readLine()) !=null)&&(i<h))	//file reading
                        {

   String[] values = line.split(",");
   for (String str : values)
   {
      double str_double = Double.parseDouble(str);
      matrix1[x][y]=str_double;
      System.out.print(" "+matrix1[x][y]);
     y=y+1;     
   }
    System.out.print("\n");     

   y=0;
   
     x=x+1;
     i++;

}
                           
       	in.close();
                       
        }catch( IOException ioException ) {}
              
              
   }
    
    
    
}
