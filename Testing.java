import java.*;
import java.util.*;
public class Testing
{
	public static double doMutation(double dub)
	{
	    //  Replace with new random number
		double randnum;

		if (Math.random() < .2)
		{
			
			randnum = Math.random();
				
			while(randnum > .2)
				randnum = Math.random();
			

			if(Math.random() < .5)
				dub = Math.min(1,dub + randnum);
			else
				dub = Math.max(0,dub - randnum);
		}
			
		return dub;
		
	}

	public static void xOver(double parent1, double parent2, double child1, double child2)
	{
		double length;

		length = parent1 - parent2;
			if (length > 0)
			{
				child1 = parent1  - (length/3);
				child2 = parent2  + (length/3);
			}
			else
			{
				child1 = parent2 + (length/3);
				child2 = parent1 - (length/3);
			}
			
	}


	public static void main (String args[])
	{
		ArrayList<Double> preGenOps = new ArrayList<Double>();
		ArrayList<Double> postGenOps = new ArrayList<Double>();
		double parent1, parent2, child1=0.0, child2=0.0, randnum, sum=0.0, overAllAvg=0.0;


		for (int r =0; r < 100; r ++)
		{
			for(int i=0; i< 100; i++)
			preGenOps.add(Math.random());
	

			for(int g=0; g < 100; g++)
			{

				postGenOps.clear();
				System.out.println(g);

				for(int i=0; i < 50; i++)
				{	

					parent1 = preGenOps.get((int)(Math.random()*100));
					parent2 = parent1;
					while (parent2 == parent1)
						parent2 = preGenOps.get((int)(Math.random()*100));
				

					randnum = Math.random();
					if (randnum < .4)
						xOver(parent1, parent2, child1, child2);
					else
					{
						child1 = parent1;
						child2 = parent2;
					}
			
					postGenOps.add(child1);
					postGenOps.add(child2);
				}

				preGenOps.clear();
				for (int i=0; i<100; i++)
				{
					postGenOps.set(i, doMutation(postGenOps.get(i)));
					preGenOps.add(postGenOps.get(i));
				}
			}
			for(int i=0; i< 100; i++)
			{
				sum += preGenOps.get(i);
			}

			System.out.println("The avg is: " + (sum/100));
			overAllAvg += (sum/100);
			preGenOps.clear();
			postGenOps.clear();
			sum = 0;
			
		}

		System.out.println("Overall Avg is: " + (overAllAvg/100));
	}
}