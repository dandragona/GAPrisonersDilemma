import java.lang.*;

public class StrategyLookupTable extends Strategy {

  String opponentPastMoves;
  String lookupTable;

  public StrategyLookupTable() {
    name = "Lookup Table";
    opponentPastMoves = "11111";
    lookupTable = "00000000000101010010001001010010";
  }

  public void resetPastMoves() {
    opponentPastMoves = "11111";
    saveOpponentMove(1);
  }

  public void setLookupTable(String lookupTable) {
    this.lookupTable = lookupTable;
  }

  public int binaryToDecimal(String binary) {

    int result = 0;

    int len = binary.length();
    for(int digit = len - 1; digit >= 0; digit--) {
      result += Character.getNumericValue(binary.charAt(len - digit - 1)) *
        Math.pow(2, digit);
    }

    return result;
  }

  public int nextMove() {
    return Character.getNumericValue(
      lookupTable.charAt(binaryToDecimal(opponentPastMoves)));
  }

  @Override
  public void saveOpponentMove(int move) {
    opponentLastMove = move;
    opponentPastMoves = opponentPastMoves.substring(1) + move;
  }

}
