package Tictac.Model.Logic;

import Tictac.Model.Field.TictacField;
import Tictac.Model.Field.TictacFieldImpl;
import Tictac.Model.Logic.TictacLogic;
import Tictac.Model.Logic.TictacLogicSimple;
import org.junit.Test;
import static org.junit.Assert.*;

public class TictacLogicSimpleTest {

    @Test
    public void noWinners() {
        TictacField field = new TictacFieldImpl(5, 3);
        TictacLogic logic = new TictacLogicSimple(field);

        // XXXXO
        // XXO.O
        // OOOOX
        field.setCell(0, 0, "X"); assertNoWinners(field, logic);
        field.setCell(1, 0, "X"); assertNoWinners(field, logic);
        field.setCell(2, 0, "X"); assertNoWinners(field, logic);
        field.setCell(3, 0, "X"); assertNoWinners(field, logic);
        field.setCell(4, 0, "O"); assertNoWinners(field, logic);

        field.setCell(0, 1, "X"); assertNoWinners(field, logic);
        field.setCell(1, 1, "X"); assertNoWinners(field, logic);
        field.setCell(2, 1, "O"); assertNoWinners(field, logic);
        field.setCell(4, 1, "O"); assertNoWinners(field, logic);

        field.setCell(0, 2, "O"); assertNoWinners(field, logic);
        field.setCell(1, 2, "O"); assertNoWinners(field, logic);
        field.setCell(2, 2, "O"); assertNoWinners(field, logic);
        field.setCell(3, 2, "O"); assertNoWinners(field, logic);
        field.setCell(4, 2, "X"); assertNoWinners(field, logic);
    }

    private void assertNoWinners(TictacField field, TictacLogic logic) {
        assertFalse(logic.hasWinner());
        assertEquals(field.getEmptyDesignator(), logic.getWinner());
    }

    @Test
    public void horizontalWinner() {
        TictacField field = new TictacFieldImpl(5, 3);
        TictacLogic logic = new TictacLogicSimple(field);

        field.setCell(0, 0, "X");
        field.setCell(1, 0, "X");
        field.setCell(2, 0, "X");
        field.setCell(3, 0, "X");
        field.setCell(4, 0, "X");

        assertEquals("X", logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void verticalWinner() {
        TictacField field = new TictacFieldImpl(5, 3);
        TictacLogic logic = new TictacLogicSimple(field);

        field.setCell(0, 0, "X");
        field.setCell(0, 1, "X");
        field.setCell(0, 2, "X");

        assertEquals("X", logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerMain1() {
        TictacField field = new TictacFieldImpl(5, 3);
        TictacLogic logic = new TictacLogicSimple(field);

        // .X...
        // ..X..
        // ...X.
        field.setCell(1, 0, "X");
        field.setCell(2, 1, "X");
        field.setCell(3, 2, "X");

        assertEquals("X", logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerAnti1() {
        TictacField field = new TictacFieldImpl(5, 3);
        TictacLogic logic = new TictacLogicSimple(field);

        // ...X.
        // ..X..
        // .X...
        field.setCell(1, 2, "X");
        field.setCell(2, 1, "X");
        field.setCell(3, 0, "X");

        assertEquals("X", logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerMain2() {
        TictacField field = new TictacFieldImpl(3, 5);
        TictacLogic logic = new TictacLogicSimple(field);

        // ...
        // X..
        // .X.
        // ..X
        // ...

        field.setCell(0, 1, "X");
        field.setCell(1, 2, "X");
        field.setCell(2, 3, "X");

        assertEquals("X", logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerAnti2() {
        TictacField field = new TictacFieldImpl(3, 5);
        TictacLogic logic = new TictacLogicSimple(field);

        // ...
        // ..X
        // .X.
        // X..
        // ...

        field.setCell(0, 3, "X");
        field.setCell(1, 2, "X");
        field.setCell(2, 1, "X");

        assertTrue(logic.hasWinner());
        assertEquals("X", logic.getWinner());
    }



}