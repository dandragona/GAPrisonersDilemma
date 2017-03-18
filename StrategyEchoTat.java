/**
 * Class containing the tit-for-tat strategy.
 * @author	081028AW
 */
public class StrategyEchoTat extends Strategy
   {
  /**
   * Encoding for tit-for-tat strategy.
   */

  // 0 = defect, 1 = cooperate

   public StrategyEchoTat()
      {
      name = "Echo Tat";
      opponentLastMove = 1;
      }  /* StrategyTitForTat */

   public int nextMove()
      {
        if (opponentLastMove == 1 && Math.random() < .1)
          return 0;
      
        else
          return opponentLastMove;
      }  /* nextMove */

   }  /* class StrategyTitForTat */

