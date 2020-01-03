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
public class ViterbiAlgo {
     List<String> temp1 = new ArrayList<>();
    List<String> temps = new ArrayList<>();
    double[][] matrix = new double[20][20];
    double[][] matrix1 = new double[100][100];
      double[][] v = new double[100][100];

  int h ;
String z="";
        String s1;
      String str_data = "";
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
     public void valueOfVs() throws FileNotFoundException{
         System.out.println("Value of V's for viterbi:\n");
int o; int I=1;int D=2;int S=0;
   readtransitionProbab();
   reademissionProbab();
   Scanner inFile1 = new Scanner(new File("B:\\obsSeq.txt")).useDelimiter(",");
                            inFile1.nextLine();
                            inFile1.nextLine();
                            String token1 = "";
    while (inFile1.hasNext()) {
     token1 = inFile1.next();
      temp1.add(token1);
    } inFile1.close();    
  
   if("90.24".equals(temp1.get(0))){
                     o=2;      }
  else if("76.98".equals(temp1.get(0))){
 o=1;                          }
  else{
 o=0;}
  v[0][1] = matrix[S][I]*matrix1[I][o];
  v[0][0] = matrix[S][D]*matrix1[D][o];

for(int i=1;i<9;){
   int j=0;
if("90.24".equals(temp1.get(i))){
                     o=2;      }
  else if("76.98".equals(temp1.get(i))){
 o=1;                          }
  else{
 o=0;}

      if(matrix[D][D]*matrix1[D][o]*v[i-1][j]<matrix[I][D]*matrix1[D][o]*v[i-1][j+1]){
     v[i][j]=matrix[I][D]*matrix1[D][o]*v[i-1][j+1];


    }else{v[i][j]=matrix[D][D]*matrix1[D][o]*v[i-1][j];}   
      
    
      if(matrix[I][I]*matrix1[I][o]*v[i-1][j+1]<matrix[D][I]*matrix1[I][o]*v[i-1][j]){
     v[i][j+1]=matrix[D][I]*matrix1[I][o]*v[i-1][j];
    }else{v[i][j+1]=matrix[I][I]*matrix1[I][o]*v[i-1][j+1];}
    
 
 i++;  
 }
 for(int i=0;i<9;){
    for(int j=0;j<2;){

 System.out.println("V"+(i+1)+(j+1)+":"+v[i][j]);
 j++;
 }
    i++;
 }
 
 }
 
     
   public void viterbi() throws FileNotFoundException{
   int o;
   int I=1;
   int D=2;
   int S=0;
   readtransitionProbab();
   reademissionProbab();
     Scanner inFile1 = new Scanner(new File("B:\\obsSeq.txt")).useDelimiter(",");
                            inFile1.nextLine();
                                                        inFile1.nextLine();


         String token1 = "";

    // while loop
    while (inFile1.hasNext()) {
      // find next line
      token1 = inFile1.next();
      temp1.add(token1);
    }
    inFile1.close();   
  
  
   if("90.24".equals(temp1.get(0))){
                     o=2;
                     }else if("76.98".equals(temp1.get(0))){
                     o=1;
                     }
                     else{
                     o=0;
                      }                               
                          
      if(matrix[S][I]*matrix1[I][o]<matrix[S][D]*matrix1[D][o]){
          temps.add("D");
      }
      else{
          temps.add("I");

                  }
      for(int i=1;i<9;i++){
           if("90.24".equals(temp1.get(i))){
                     o=2;
                     }else if("76.98".equals(temp1.get(i))){
                     o=1;
                     }
                     else{
                     o=0;
                     
                     
                     
                      }   
      if(  "H".equals(temps.get(i-1))){
              
         if((matrix[I][I]*matrix1[I][o])<(matrix[I][D]*matrix1[D][o])){
                    temps.add("D");}
           
         else{
  temps.add("H");
       
      }
          }
       else{

              if(matrix[D][I]*matrix1[I][o]<matrix[D][D]*matrix1[D][o]){
                    temps.add("D");
          } else{
                                            temps.add("I");

              }
              
          }
      
      }
      System.out.println("The most likely prices sequence for the given observation is :"); 
       for(int i=0;i<temps.size();i++){
        System.out.print(temps.get(i)+"\n");
    }
      
       
       
       
       
       
   }
}
