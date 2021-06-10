
public class Tic {

  public String emptyBoard(int rows, int cols) {
    String board = "";
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (j == 0) {
          board += "_";
        } else {
                 board += "|_";
        }
      }
      if (rows > 1 && i != rows - 1) {
        board += "\n";
      }
    }
    return board;
  }

   public int size() {
    return rows*cols;
  }

}


public String showPositions() {
    String board = "";
    int x = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (j == 0) {
          board += x++;
        } else {
          board += "|" + x++;
        }
      }
      if (rows > 1 && i != rows - 1) {
        board += "\n";
      }
    }
    return board;
  }

}
