import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTest {
  Tic tic = new Tic();
  

   void test_emptyBoard_1x1() {
    assertEquals("_", tic.emptyBoard(1,1));
  }

  @Test
  void test_1xn() {
    String e1, e2, e3;
    e1 = "_|_";
    e2 = "_|_|_";
    e3 = "_|_|_|_|_|_|_";
    assertEquals(e1, tic.emptyBoard(1,2));
    assertEquals(e2, tic.emptyBoard(1,3));
    assertEquals(e3, tic.emptyBoard(1,7));
  }

  @Test
  void test_nx1() {
    String e1, e2, e3;
    e1 = "_\n_";
    e2 = "_\n_\n_";
    e3 = "_\n_\n_\n_\n_\n_\n_";
    assertEquals(e1, tic.emptyBoard(2,1));
    assertEquals(e2, tic.emptyBoard(3,1));
    assertEquals(e3, tic.emptyBoard(7,1));
  }

  @Test
  void test_nxm() {
    String e1, e2, e3;
    e1 = "_|_|_|_\n_|_|_|_\n_|_|_|_";
    e2 = "_|_|_\n_|_|_\n_|_|_\n_|_|_";
    assertEquals(e1, tic.emptyBoard(3,4));
    assertEquals(e2, tic.emptyBoard(4,3));
  }
}