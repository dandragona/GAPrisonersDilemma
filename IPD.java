
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
		X.rawFitness += Search.player1Score;
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

