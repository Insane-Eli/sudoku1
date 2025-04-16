import java.util.*;

public class SudokuBoard{
private char[][] board;

  public SudokuBoard(String fileName){
    board = new char[9][9];
    try {
      Scanner file = new Scanner(new File(fileName));

      for (int r = 0; r < grid.length; r++) {
          for (int c = 0; c < board[0].length; c++) {
              board[r][c] = file.nextChar();
          }
      }

  } catch (FileNotFoundException e) {
      System.out.println("Cannot load: " + fileName);
  } catch (InputMismatchException e) {
      System.out.println(fileName + " does not meet format expectations.");
  }
  }

  public String toString(){
    return board;
  }

  public static void main(String[] args){
    SudokuBoard sudokuBoard = new SudokuBoard("data1.sdk");
    System.out.print(sudokuBoard);
  }
}
