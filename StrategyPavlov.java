/**
 * Class containing the tit-for-tat strategy.
 * @author	081028AW
 */

public class StrategyPavlov extends Strategy
   {
  /**
   * Encoding for tit-for-tat strategy.
   */



  // 0 = defect, 1 = cooperate

   public StrategyPavlov()
      {
          name = "Pavlov";


      }

   public int nextMove()
      {
          if (opponentLastMove == 1 && myLastMove == 0)     return 0;
          else if(opponentLastMove == 0 && myLastMove == 1) return 1;
          else if(opponentLastMove == 1 && myLastMove == 1) return 1;
          else if(opponentLastMove == 0 && myLastMove == 0) return 0;
          else return 0;


      }

   }
