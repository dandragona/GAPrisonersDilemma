/**
 * Class containing the tit-for-tat strategy.
 * @author	081028AW
 */
import java.*;

public class StrategyObsTat extends Strategy
   {
      
        // 0 = defect, 1 = cooperate

   public StrategyObsTat()
      {
      name = "Observational Tat";
      opponentLastMove = 1;
      forgiveCount = 3;
      numMoves = 0;
      randomRating = .5;
      rEpsilon = .1;
      requiredSteps = 10;
      moves = new int[100];
      }
   
   public int nextMove()
      {
        
        moves[numMoves] = opponentLastMove;
        numMoves ++;

        if (opponentLastMove == 0)
        {
          totalDefects ++;
          prevDefects ++;
        }
        else
          prevDefects = 0;



        if (prevDefects < 0)
        {
          prevDefects = 0;
          return 1;
        }
      
        defectRating = ((double)(totalDefects))/numMoves;
        
        if (prevDefects >= forgiveCount)
        {
          forgiveCount ++;
          prevDefects = -2;
          return 1;
        }
       

        else if (numMoves > requiredSteps && Math.abs(defectRating - randomRating) < rEpsilon)
        {
         return 0;
        }
        
        else
          return opponentLastMove;
      } 

   }  

