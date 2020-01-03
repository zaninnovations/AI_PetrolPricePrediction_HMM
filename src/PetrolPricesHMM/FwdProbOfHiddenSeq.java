/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetrolPricesHMM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Zan Innovations
 */
public class FwdProbOfHiddenSeq {
    int LengthOfObs;
                  double f=1;
                  int o;

         List<String> temp1 = new ArrayList<>();

      double[][] matrix1 = new double[100][100];
	private Scanner readCodes;

      String str_data = "";
    int h ;
    private HiddenSeqGenerator.State state;
   double[][] matrix = new double[100][100];

    String z="";
        String s1;
        
        
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
    
     public void reademissionProbab() {
       		int x=0, y=0; readstate();                
                
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
     y=y+1;     
   }
   y=0;
     x=1+x;
     i++;

}
                           
       	in.close();
                       
        }catch( IOException ioException ) {}
              
              
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
     
     
  
  
 
       
        
       
      
      
  

  
  public void forwardProbabOfSeq() throws FileNotFoundException{

 Scanner inFile1 = new Scanner(new File("B://obsSeq.txt")).useDelimiter(",");
                            inFile1.nextLine();
                           inFile1.nextLine();


         String token1 ="";

    // while loop
    while (inFile1.hasNext()) {
      // find next line
      token1 = inFile1.next();
      temp1.add(token1);
    }
    inFile1.close();    
 
  
  HiddenSeqGenerator obj = new HiddenSeqGenerator();
         Scanner inFile = new Scanner(new File("B:\\HiddenSeq.txt")).useDelimiter("\n");
         List<String> temps = new ArrayList<String>();

    // while loop
    while (inFile.hasNext()) {
      // find next line
      token1 = inFile.next();
      temps.add(token1);
    }
    inFile.close();

   if("90.24".equals(temp1.get(0))){
                     o=2;
                     }else if("76.98".equals(temp1.get(0))){
                     o=1;
                     }
                     else{
                     o=0;
                      }  
    reademissionProbab();
 readtransitionProbab();
 int x;
int y; 
int S=0; 
if("I".equals(temps.get(0))){
    x=1;
}else{
         x=2;
                      }
double r =matrix[S][x]*matrix1[x][o];
         for(int i=1; i<9;){
             if ("I".equals(temps.get(i-1))){
                 x=1;
                 
             }else{
                 x=2;
             }
             if ("I".equals(temps.get(i))){
                 y=1;
                 
             }else{
                 y=2;
             }

              if("90.24".equals(temp1.get(i))){
                     o=2;
                     }else if("76.98".equals(temp1.get(i))){
                     o=1;
                     }
                     else{
                     o=0;
              
                    }     


               f=matrix[x][y]*matrix1[y][o]*f;

              i++;
              
              
         }

       if("I".equals(temps.get(temps.size()-1))){
           x=1;
       }
       else{
           x=2;
       }
      int E=3; 
double total = f*r*matrix[x][E]; 
                 


     System.out.println("\nProbab of hidd seq");
	  System.out.println(total);
     
     }
}

