
import java.io.*;
import java.util.*;
import java.text.*;

public class IPD extends FitnessFunction{

/*******************************************************************************
*                            INSTANCE VARIABLES                                *
*******************************************************************************/


/*******************************************************************************
*                            STATIC VARIABLES                                  *
*******************************************************************************/


/*******************************************************************************
*                              CONSTRUCTORS                                    *
*******************************************************************************/

	public IPD(){
		name = "IPD problem";
	}

/*******************************************************************************
*                                MEMBER METHODS                                *
*******************************************************************************/

//  COMPUTE A CHROMOSOME'S RAW FITNESS *************************************

	public void doRawFitness(Chromo X)
	{
		IteratedPD ipd;
		Strategy player1, downing, titForTat, titForTwoTats, alwaysRandom, alwaysDefect, alwaysCooperate, obsTat;

		player1 = new StrategyBestTat(X.coopeRate);
      	alwaysRandom = new StrategyRandom();
      	alwaysDefect = new StrategyAlwaysDefect();
      	alwaysCooperate = new StrategyAlwaysCooperate();
      	titForTat = new StrategyTitForTat();
      	titForTwoTats = new StrategyTitForTwoTats();
      	obsTat = new StrategyObsTat();
            downing = new StrategyDowning();
      	
      	ipd = new IteratedPD(player1, titForTat);
      	ipd.runSteps(100);
      	X.rawFitness += ipd.player1Score();

      	ipd = new IteratedPD(player1, titForTwoTats);
      	ipd.runSteps(100);
      	X.rawFitness += ipd.player1Score();

      	ipd = new IteratedPD(player1, alwaysRandom);
      	ipd.runSteps(100);
      	X.rawFitness += ipd.player1Score();

      	ipd = new IteratedPD(player1, alwaysDefect);
      	ipd.runSteps(100);
      	X.rawFitness += ipd.player1Score();

      	ipd = new IteratedPD(player1, alwaysCooperate);
      	ipd.runSteps(100);
      	X.rawFitness += ipd.player1Score();

      	// ipd = new IteratedPD(player1, obsTat);
      	// ipd.runSteps(100);
      	// X.rawFitness += ipd.player1Score();

            ipd = new IteratedPD(player1, downing);
            ipd.runSteps(100);
            X.rawFitness += ipd.player1Score();
		
	}

//  PRINT OUT AN INDIVIDUAL GENE TO THE SUMMARY FILE *********************************

	// public void doPrintGenes(Chromo X, FileWriter output) throws java.io.IOException{

	// 	for (int i=0; i<Parameters.numGenes; i++){
	// 		Hwrite.right(X.getGeneAlpha(i),11,output);
	// 	}
	// 	output.write("   RawFitness");
	// 	output.write("\n        ");
	// 	for (int i=0; i<Parameters.numGenes; i++){
	// 		Hwrite.right(X.getPosIntGeneValue(i),11,output);
	// 	}
	// 	Hwrite.right((int) X.rawFitness,13,output);
	// 	output.write("\n\n");
	// 	return;
	// }

/*******************************************************************************
*                             STATIC METHODS                                   *
*******************************************************************************/

}   // End of OneMax.java ******************************************************

