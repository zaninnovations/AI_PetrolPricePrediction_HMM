/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetrolPricesHMM;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author Zan Innovations
 */
public class HMMMain {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
    runSimulation(8);
        FwdProbOfHiddenSeq obj1 = new FwdProbOfHiddenSeq();
obj1.reademissionProbab();
        
       
}

		//Getting the output stream of the file for writing
    
    private static void runSimulation(int years) throws FileNotFoundException, IOException{
                 HmmShow obj2 = new HmmShow();
                  System.out.println("State");
                  obj2.printstate();

                  System.out.println("Transition probabilities");
                  obj2.printtransitionProbab();
                  System.out.println("Emission probabilities");
                  obj2.PrintmissionProbab();
                  int t;
                  System.out.println("\nHIDDEN SEQUENCE GENERATED IS:");
                                 HiddenSeqGenerator obj3 = new HiddenSeqGenerator();
                                                  FwdProbOfHiddenSeq obj5 = new FwdProbOfHiddenSeq();
obj3.update();
                                                  obj5.forwardProbabOfSeq();

ForwardAlgo obj4 = new ForwardAlgo();
obj4.CalculateTotalProbabOfobs();
               ViterbiAlgo obj6=new ViterbiAlgo();
               obj6.valueOfVs();
               obj6.viterbi();
               

         
                    

    
    
}
}


    

