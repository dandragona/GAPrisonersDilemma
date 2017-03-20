/**
 * Class containing the tit-for-tat strategy.
 * @author	081028AW
 */
public class StrategyDowning extends Strategy
   {
  /**
   * Encoding for tit-for-tat strategy.
   */

  // 0 = defect, 1 = cooperate

   public StrategyDowning()
      {
      name = "DOWNING";
      moves = new int[100];
      opponentLastMove = 1;
      myTwoLastMove = 1;
      myDefects = 0;
      myCoops = 0; 
      theirDefects = 0;
      theirCoops = 0;
      defectRating=0.0;
      coopeRating =0.0;
      }  /* StrategyTitForTat */

   public int nextMove()
      {
       
       moves[numMoves] = opponentLastMove;
       numMoves ++;

       theirCoops += opponentLastMove;
       theirDefects +=(opponentLastMove+1)%2;

       System.out.println(myTwoLastMove + " " + myLastMove + " " + opponentLastMove);
       if(myTwoLastMove == 1)
       {
          coopeRating = ((double)(theirCoops))/(++myCoops);
       }
       
       else
       {
          defectRating = ((double)(theirDefects))/(++myDefects);
       }

       myTwoLastMove = myLastMove;

       if(Math.abs(coopeRating - defectRating) < .15)
          return 0;

       if(coopeRating > .8 && defectRating > .8)
        return 1;

       else
        return myLastMove;

      }  /* nextMove */

   } 