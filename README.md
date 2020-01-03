# PetrolPricesHMM
PROJECT BSSE 3RD YEAR SECTION B

COURSE: AI IN SOFTWARE ENGINEERING 

HIDDEN MARKOV MODEL 

The Hidden Markov Model is a finite set of states, each of which is associated with a (generally multidimensional) probability distribution []. Transitions among the states are governed by a set of probabilities called transition probabilities. In a particular state an outcome or observation can be generated, according to the associated probability distribution. It is only the outcome, not the state visible to an external observer and therefore states are ``hidden'' to the outside; hence the name Hidden Markov Model


RELATION BETWEEN PETROL PRICE AND INFLATION OR DEFLATION:
The price of petrol and inflation are often seen as being connected in a cause-and-effect relationship. As petrol prices move up or down, inflation follows in the same direction. The reason why this happens is that petrol is a major input in the economy – it is used in critical activities such as fueling transportation  – and if input costs rise, so should the cost of end products.



PETROL PRICE HMM INCLUDES 2 STATES:

1)INFLATION

2)DEFLATION


THIS HMM INCLUDES START AND END STATE ALSO.


THE OBSERVATION SEQUENCE IS :

90.24,90.24,59.35,59.35,76.98,90.24,90.24,59.35,76.98


Initial transition probabilities pi are :

1)0.7

2)0.3

emission and transitional probabilty are defined in STEProbab.txt as:

Transition probablities:
///1:start 2:inflation 3:deflation 4:end
     
 || || ||1|| ||2|| ||3|| ||4||
   
||1|| 0.0 0.7 0.3 0.0

||2 ||0.0 0.6 0.3 0.1

||3|| 0.0 0.4 0.5 0.1

4 0.0 0.0 0.0 0.0

EMISSION PROBAB:

 |  | ||O1||O2||O3|| 


||1||0.0, 0.0, 0.0

||2||0.1, 0.4, 0.5

||3||0.6, 0.3, 0.1

||4||0.0, 0.0, 0.0
