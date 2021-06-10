import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTest {
  Tic tic = new Tic();
  @Test
  void test_emptyBoard() {
    assertEquals(" ", tic.emptyBoard(1,1));
  }
}