/**
 * Class containing the tit-for-tat strategy.
 * @author	081028AW
 */
public class StrategyBestTat extends Strategy
   {
  /**
   * Encoding for tit-for-tat strategy.
   */
   


  // 0 = defect, 1 = cooperate

   public StrategyBestTat(Double coopeRate)
      {
      name = "Strategy GA";
      opponentLastMove = 1;
      defectRating = coopeRate;
      }
      
   public int nextMove()
      {
      
      if (opponentLastMove == 1 && Search.r.nextDouble() < defectRating)
        return 1;
      else
        return 0;

      }  

   }  
