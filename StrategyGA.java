/**
 * Class containing the tit-for-tat strategy.
 * @author	081028AW
 */
public class StrategyGA extends Strategy
   {
  /**
   * Encoding for tit-for-tat strategy.
   */
   


  // 0 = defect, 1 = cooperate

   public StrategyGA(Chromo member)
      {
      name = "Strategy GA";
      opponentLastMove = 1;
      numMoves = 0;
      moves = new int[100];

      for (int i=0; i < 100; i++)
        moves[i] = (int)(member.chromo.charAt(i)) - 48;
      
      }  /* StrategyTitForTat */

   public int nextMove()
      {
      return moves[numMoves++];
      }  /* nextMove */

   }  /* class StrategyTitForTat */

