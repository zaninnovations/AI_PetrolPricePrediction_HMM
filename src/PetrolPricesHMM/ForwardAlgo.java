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
public class ForwardAlgo {
int LengthOfObs=9;         List<String> temps = new ArrayList<>();

         float pi[]=new float[10];      float[][] matrix1 = new float[100][100];
-         String p="",p1="";
-         int s;
   
	float[][] matrix = new float[100][100];
   float[][]arr=new float[100][100];
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
      matrix[x][y]=(float) str_double;
     y=y+1;     
   }
   y=0;
     x=1+x;
     i++;
}
                                     
       	in.close();
                       
        }catch( IOException ioException ) {}
              
       
                

                
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
      matrix1[x][y]=(float) str_double;
     y=y+1;     
   }
   y=0;
     x=1+x;
     i++;

}
                           
       	in.close();
                       
        }catch( IOException ioException ) {}
              
              
   }
public void m1() throws FileNotFoundException, IOException{
 reademissionProbab();
          readtransitionProbab(); 
         
                   String token2 = "";

         String token1 = "";
         BufferedReader in = new BufferedReader(new FileReader("B:\\obsSeq.txt"));	//reading files in specified directory
			String line;
                        LineNumberReader lnr = new LineNumberReader(in);
                        p=in.readLine();
                        p1=in.readLine();
                        pi[0]=(float) Double.parseDouble(p);
                            pi[1]=(float) Double.parseDouble(p1);

   // System.out.println(pi[0]);
     //  System.out.println(pi[1]);


    Scanner inFile1 = new Scanner(new File("B:\\obsSeq.txt")).useDelimiter(",");
                            inFile1.nextLine();
                                                        inFile1.nextLine();



    // while loop
    while (inFile1.hasNext()) {
      // find next line
      token1 = inFile1.next();
      temps.add(token1);
    }
    inFile1.close();    
            System.out.println("\nOBSERVATION SEQUENCE IS :");
  for(int i=0;i<temps.size();i++){
        System.out.print(temps.get(i)+" ");
  }






}
      public void Storealphaij() throws FileNotFoundException, IOException{
         
 m1();
 int a=1;
 if("90.24".equals(temps.get(1))){
 s=2;
 }else if("76.98".equals(temps.get(1))){
 s=1;
 }
 else{
         s=0;
         }
 
          int x=2;
          arr[0][1]=pi[0]*matrix1[a][s];
          arr[0][0]=pi[1]*matrix1[x][s];
          
            int n=1;
            int m=0;
            int y=1;
            int w=1;
            int i=1;
                a=1;
            for(int  q=0;q<8;){
                            
                     if("90.24".equals(temps.get(i))){
                     s=2;
                     }else if("76.98".equals(temps.get(i))){
                     s=1;
                     }
                     else{
                     s=0;
                      }                             
                    x=1;         
                     
                    arr[n][m+1]=(arr[n-1][m+w]*(matrix[x][y]*matrix1[y][s]))+(arr[n-1][m]*(matrix[a+1][y]*matrix1[y][s]));
                    
                    y++;
                    a=2;
                    arr[n][m]=(arr[n-1][m+w]*(matrix[x][y]*matrix1[y][s]))+(arr[n-1][m]*(matrix[a][y]*matrix1[y][s])); 
                    y--;
                    i++;n++;q++;a=1;
                    }
      }

public void CalculateTotalProbabOfobs() throws IOException{
    Storealphaij();
    readtransitionProbab();

System.out.println("\nALPHAS OF FORWARD TRELLIS:");
    for (int i=0;i<9;i++){

        for(int j=0;j<2;j++){
    System.out.println("alpha"+(i+1)+(j+1)+": "+arr[i][j]);
}
        
    }
    float Ot;
    Ot =(float) ((arr[8][0]*matrix[2][3])+(arr[8][1]*matrix[2][3]));
        System.out.println("\nTotal probabilitiy of the observation sequence is:");

    System.out.println("Total Probability Ot:"+Ot);
    System.out.println("\n");
    

}
}
    
    

