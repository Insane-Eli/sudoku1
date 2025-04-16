import java.util.*;
import java.io.*;

public class SudokuBoard {

  public static final String RESET   = "\u001B[0m";
  public static final String RED     = "\u001B[91m";
  public static final String ORANGE  = "\u001B[38;5;202m";
  public static final String YELLOW  = "\u001B[93m";
  public static final String GREEN   = "\u001B[92m";
  public static final String CYAN    = "\u001B[96m";
  public static final String BLUE    = "\u001B[94m";
  public static final String INDIGO  = "\u001B[38;5;99m";
  public static final String VIOLET  = "\u001B[95m";
  public static final String PINK    = "\u001B[95;1m";
  public static final String BLACK     = "\u001B[30m";

  private char[][] board;

  public SudokuBoard(String fileName) {
    board = new char[9][9];
    try {
      Scanner file = new Scanner(new File(fileName));

      for (int r = 0; r < board.length; r++) {
        String line = file.nextLine();
        for (int c = 0; c < board[0].length; c++) {
          board[r][c] = line.charAt(c);
        }
      }
      file.close();

    } catch (FileNotFoundException e) {
      System.out.println("Cannot load: " + fileName);
    } catch (InputMismatchException e) {
      System.out.println(fileName + " does not meet format expectations.");
    }
  }
  
  //FOR jGRASP
  
  public String toString() {
    StringBuilder sb = new StringBuilder();

    // top border
    sb.append("+-----------------------+\n");

    for (int r = 0; r < board.length; r++) {
      // left border
      sb.append("| ");

      // add the numbers

      for (int c = 0; c < board[r].length; c++) {

        // then the actual numbers + reset the colors + add space
        sb.append(board[r][c]).append(" ");

        // seperate the numbers into columns three wide
        if (c == 2 || c == 5) {
          sb.append("| ");
        }
      }
      // right border
      sb.append("|");
      
      // row done printing, next line start
      sb.append("\n");

      // seperate the numbers into rows three wide
      if (r == 2 || r == 5) {
        sb.append("|-------+-------+-------|\n");
      }

    }
    // bottom border
    sb.append("+-----------------------+\n");
    return sb.toString();
  }
  


  // SAUCY DISPLAY FOR VISUAL STUDIO CODE
  /*
  public String toString() {
    StringBuilder sb = new StringBuilder();
    //title
    sb.append("\n");
    sb.append("𝗦𝗨𝗗𝗨𝗞𝗢\n");

    // top border
    sb.append("╔═══════════════════════╗\n");

    for (int r = 0; r < board.length; r++) {
      // left border
      sb.append("║ ");

      // add the numbers

      for (int c = 0; c < board[r].length; c++) {

        // first the color codes
        switch(board[r][c]){
          case '.': sb.append(BLACK); break;
          case '1': sb.append(RED); break;
          case '2': sb.append(ORANGE); break;
          case '3': sb.append(YELLOW); break;
          case '4': sb.append(GREEN); break;
          case '5': sb.append(CYAN); break;
          case '6': sb.append(BLUE); break;
          case '7': sb.append(INDIGO); break;
          case '8': sb.append(VIOLET); break;
          case '9': sb.append(PINK); break;
          default: break;
        }

        // then the actual numbers
        if(board[r][c] == '.'){
          sb.append("-");
        } else {
        sb.append(board[r][c]);
        }

        // + reset the colors + add space
        sb.append(RESET).append(" ");

        // seperate the numbers into columns three wide
        if (c == 2 || c == 5) {
          sb.append("│ ");
        }
      }
      // right border
      sb.append("║");
      
      // row done printing, next line start
      sb.append("\n");

      // seperate the numbers into rows three wide
      if (r == 2 || r == 5) {
        sb.append("║───────┼───────┼───────║\n");
      }

    }
    // bottom border
    sb.append("╚═══════════════════════╝\n");
                  
    return sb.toString();
  }
  
  */
  
  public static void main(String[] args) {
    SudokuBoard sudokuBoard = new SudokuBoard("data1.sdk");
    System.out.print(sudokuBoard);
  }
  
}

/*
# PROGRAM OUTPUT

Paste the output from JGrasp here.
Altering output will earn you an automatic zero for the assignment.


 ----jGRASP exec: java SudokuBoard
 +-----------------------+
 | 2 . . | 1 . 5 | . . 3 |
 | . 5 4 | . . . | 7 1 . |
 | . 1 . | 2 . 3 | . 8 . |
 |-------+-------+-------|
 | 6 . 2 | 8 . 7 | 3 . 4 |
 | . . . | . . . | . . . |
 | 1 . 5 | 3 . 9 | 8 . 6 |
 |-------+-------+-------|
 | . 2 . | 7 . 1 | . 6 . |
 | . 8 1 | . . . | 2 4 . |
 | 7 . . | 4 . 2 | . . 1 |
 +-----------------------+
 
  ----jGRASP: Operation complete.
 
*/