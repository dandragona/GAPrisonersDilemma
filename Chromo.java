/******************************************************************************
*  A Teaching GA					  Developed by Hal Stringer & Annie Wu, UCF
*  Version 2, January 18, 2004
*******************************************************************************/

import java.io.*;
import java.util.*;
import java.text.*;

public class Chromo
{
/*******************************************************************************
*                            INSTANCE VARIABLES                                *
*******************************************************************************/

	public double coopeRate;
	public double rawFitness;
	public double sclFitness;
	public double proFitness;

/*******************************************************************************
*                            INSTANCE VARIABLES                                *
*******************************************************************************/

	private static double randnum;

/*******************************************************************************
*                              CONSTRUCTORS                                    *
*******************************************************************************/

	public Chromo(){

		//  Set gene values to a randum sequence of 1's and 0's
		this.coopeRate = Search.r.nextDouble();

		this.rawFitness = -1;   //  Fitness not yet evaluated
		this.sclFitness = -1;   //  Fitness not yet scaled
		this.proFitness = -1;   //  Fitness not yet proportionalized
	}


/*******************************************************************************
*                                MEMBER METHODS                                *
*******************************************************************************/

	//  Get Alpha Represenation of a Gene **************************************

	// public String getGeneAlpha(int geneID){
	// 	int start = geneID * Parameters.geneSize;
	// 	int end = (geneID+1) * Parameters.geneSize;
	// 	String geneAlpha = this.chromo.substring(start, end);
	// 	return (geneAlpha);
	// }

	// //  Get Integer Value of a Gene (Positive or Negative, 2's Compliment) ****

	// public int getIntGeneValue(int geneID){
	// 	String geneAlpha = "";
	// 	int geneValue;
	// 	char geneSign;
	// 	char geneBit;
	// 	geneValue = 0;
	// 	geneAlpha = getGeneAlpha(geneID);
	// 	for (int i=Parameters.geneSize-1; i>=1; i--){
	// 		geneBit = geneAlpha.charAt(i);
	// 		if (geneBit == '1') geneValue = geneValue + (int) Math.pow(2.0, Parameters.geneSize-i-1);
	// 	}
	// 	geneSign = geneAlpha.charAt(0);
	// 	if (geneSign == '1') geneValue = geneValue - (int)Math.pow(2.0, Parameters.geneSize-1);
	// 	return (geneValue);
	// }

	// //  Get Integer Value of a Gene (Positive only) ****************************

	// public int getPosIntGeneValue(int geneID){
	// 	String geneAlpha = "";
	// 	int geneValue;
	// 	char geneBit;
	// 	geneValue = 0;
	// 	geneAlpha = getGeneAlpha(geneID);
	// 	for (int i=Parameters.geneSize-1; i>=0; i--){
	// 		geneBit = geneAlpha.charAt(i);
	// 		if (geneBit == '1') geneValue = geneValue + (int) Math.pow(2.0, Parameters.geneSize-i-1);
	// 	}
	// 	return (geneValue);
	// }

	//  Mutate a Chromosome Based on Mutation Type *****************************

	public void doMutation(){

		String mutChromo = "";
		char x;

		switch (Parameters.mutationType){

		case 1:     //  Replace with new random number

			if (Search.r.nextDouble() < Parameters.mutationRate)
			{
				randnum = Search.r.nextDouble();
				
				while(randnum > Parameters.mutationRate)
					randnum = Search.r.nextDouble();

				if(Search.r.nextDouble() < .5)
					this.coopeRate = Math.min(1,this.coopeRate + randnum);
				else
					this.coopeRate = Math.max(0, this.coopeRate - randnum);
			}
			break;

		default:
			System.out.println("ERROR - No mutation method selected");
		}
	}

/*******************************************************************************
*                             STATIC METHODS                                   *
*******************************************************************************/

	//  Select a parent for crossover ******************************************

	public static int selectParent(){

		double rWheel = 0;
		int j = 0;
		int k = 0;

		switch (Parameters.selectType){

		case 1:     // Proportional Selection
			randnum = Search.r.nextDouble();
			for (j=0; j<Parameters.popSize; j++){
				rWheel = rWheel + Search.member[j].proFitness;
				if (randnum < rWheel) return(j);
			}
			break;

		case 3:     // Random Selection
			randnum = Search.r.nextDouble();
			j = (int) (randnum * Parameters.popSize);
			return(j);

		case 2:     //  Tournament Selection
			double tourndifficulty = 0.99;
		  
		  	randnum = Search.r.nextDouble();
		  	k = (int) (randnum * Parameters.popSize);
		  	randnum = Search.r.nextDouble();
		  	j = (int) (randnum * Parameters.popSize);

		 	 if (Search.r.nextDouble() < tourndifficulty)
		  		return (Search.member[k].rawFitness > Search.member[j].rawFitness) ? k : j;
		  	else 
		  		return (Search.member[k].rawFitness > Search.member[j].rawFitness) ? j : k;
		
		default:
			System.out.println("ERROR - No selection method selected");
		}
	return(-1);
	}

	//  Produce a new child from two parents  **********************************

	public static void mateParents(int pnum1, int pnum2, Chromo parent1, Chromo parent2, Chromo child1, Chromo child2){

		double xoverPoint1;
		double xoverPoint2;
		double length;

		switch (Parameters.xoverType){

		case 1:     //  Single Point Crossover

			length = parent1.coopeRate - parent2.coopeRate;
			if (length > 0)
			{
				child1.coopeRate = parent1.coopeRate - (length/3);
				child2.coopeRate = parent2.coopeRate + (length/3);
			}
			else
			{
				child1.coopeRate = parent2.coopeRate + (length/3);
				child2.coopeRate = parent1.coopeRate - (length/3);
			}
			break;			

		case 2:     //  Two Point Crossover

		case 3:     //  Uniform Crossover

		default:
			System.out.println("ERROR - Bad crossover method selected");
		}

		//  Set fitness values back to zero
		child1.rawFitness = -1;   //  Fitness not yet evaluated
		child1.sclFitness = -1;   //  Fitness not yet scaled
		child1.proFitness = -1;   //  Fitness not yet proportionalized
		child2.rawFitness = -1;   //  Fitness not yet evaluated
		child2.sclFitness = -1;   //  Fitness not yet scaled
		child2.proFitness = -1;   //  Fitness not yet proportionalized
	}

	//  Produce a new child from a single parent  ******************************

	public static void mateParents(int pnum, Chromo parent, Chromo child){

		//  Create child chromosome from parental material
		child.coopeRate = parent.coopeRate;

		//  Set fitness values back to zero
		child.rawFitness = -1;   //  Fitness not yet evaluated
		child.sclFitness = -1;   //  Fitness not yet scaled
		child.proFitness = -1;   //  Fitness not yet proportionalized
	}

	//  Copy one chromosome to another  ***************************************

	public static void copyB2A (Chromo targetA, Chromo sourceB){

		targetA.coopeRate = sourceB.coopeRate;

		targetA.rawFitness = sourceB.rawFitness;
		targetA.sclFitness = sourceB.sclFitness;
		targetA.proFitness = sourceB.proFitness;
		return;
	}

}   // End of Chromo.java ******************************************************
