package Tictac.Model.Logic;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Actors.NullActor;
import Tictac.Model.Field.TictacField;
import Tictac.Model.Field.TictacFieldFactory;
import Tictac.Model.Field.TictacFieldSimple;
import Tictac.Model.Field.TictacFieldSimpleFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class TictacLogicSimpleTest {
    TictacFieldFactory factory = new TictacFieldSimpleFactory();
    private final Actor aX = new Actor("xx");
    private final Actor aO = new Actor("oo");

    @Test
    public void noWinners() {
        TictacField field = factory.getTictacField(5, 3);
        TictacLogic logic = new TictacLogicSimple(field, factory);

        // XXXXO
        // XXO.O
        // OOOOX
        field.setCell(0, 0, aX); assertNoWinners(field, logic);
        field.setCell(1, 0, aX); assertNoWinners(field, logic);
        field.setCell(2, 0, aX); assertNoWinners(field, logic);
        field.setCell(3, 0, aX); assertNoWinners(field, logic);
        field.setCell(4, 0, aO); assertNoWinners(field, logic);

        field.setCell(0, 1, aX); assertNoWinners(field, logic);
        field.setCell(1, 1, aX); assertNoWinners(field, logic);
        field.setCell(2, 1, aO); assertNoWinners(field, logic);
        field.setCell(4, 1, aO); assertNoWinners(field, logic);

        field.setCell(0, 2, aO); assertNoWinners(field, logic);
        field.setCell(1, 2, aO); assertNoWinners(field, logic);
        field.setCell(2, 2, aO); assertNoWinners(field, logic);
        field.setCell(3, 2, aO); assertNoWinners(field, logic);
        field.setCell(4, 2, aX); assertNoWinners(field, logic);
    }

    private void assertNoWinners(TictacField field, TictacLogic logic) {
        assertFalse(logic.hasWinner());
        assertEquals(NullActor.getInstance(), logic.getWinner());
    }

    @Test
    public void horizontalWinner() {
        TictacField field = factory.getTictacField(5, 3);
        TictacLogic logic = new TictacLogicSimple(field, factory);

        field.setCell(0, 0, aX);
        field.setCell(1, 0, aX);
        field.setCell(2, 0, aX);
        field.setCell(3, 0, aX);
        field.setCell(4, 0, aX);

        assertEquals(aX, logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void verticalWinner() {
        TictacField field = factory.getTictacField(5, 3);
        TictacLogic logic = new TictacLogicSimple(field, factory);

        field.setCell(0, 0, aX);
        field.setCell(0, 1, aX);
        field.setCell(0, 2, aX);

        assertEquals(aX, logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerMain1() {
        TictacField field = factory.getTictacField(5, 3);
        TictacLogic logic = new TictacLogicSimple(field, factory);

        // .X...
        // ..X..
        // ...X.
        field.setCell(1, 0, aX);
        field.setCell(2, 1, aX);
        field.setCell(3, 2, aX);

        assertEquals(aX, logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerAnti1() {
        TictacField field = factory.getTictacField(5, 3);
        TictacLogic logic = new TictacLogicSimple(field, factory);

        // ...X.
        // ..X..
        // .X...
        field.setCell(1, 2, aX);
        field.setCell(2, 1, aX);
        field.setCell(3, 0, aX);

        assertEquals(aX, logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerMain2() {
        TictacField field = factory.getTictacField(3, 5);
        TictacLogic logic = new TictacLogicSimple(field, factory);

        // ...
        // X..
        // .X.
        // ..X
        // ...

        field.setCell(0, 1, aX);
        field.setCell(1, 2, aX);
        field.setCell(2, 3, aX);

        assertEquals(aX, logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerAnti2() {
        TictacField field = factory.getTictacField(3, 5);
        TictacLogic logic = new TictacLogicSimple(field, factory);

        // ...
        // ..X
        // .X.
        // X..
        // ...

        field.setCell(0, 3, aX);
        field.setCell(1, 2, aX);
        field.setCell(2, 1, aX);

        assertTrue(logic.hasWinner());
        assertEquals(aX, logic.getWinner());
    }



}