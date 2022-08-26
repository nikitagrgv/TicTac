package Tictac.Model.Logic;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Actors.NullActor;
import Tictac.Model.Field.Field;
import Tictac.Model.Field.FieldFactory;
import Tictac.Model.Field.FieldSimpleFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogicSimpleTest {
    FieldFactory factory = new FieldSimpleFactory();
    private final Actor aX = new Actor("X");
    private final Actor aO = new Actor("O");

    @Test
    public void noWinners() {
        Field field = factory.getTictacField(5, 3);
        Logic logic = new LogicSimple(field, factory);

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

    private void assertNoWinners(Field field, Logic logic) {
        assertFalse(logic.hasWinner());
        assertEquals(NullActor.getInstance(), logic.getWinner());
    }

    @Test
    public void horizontalWinner() {
        Field field = factory.getTictacField(5, 3);
        Logic logic = new LogicSimple(field, factory);

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
        Field field = factory.getTictacField(5, 3);
        Logic logic = new LogicSimple(field, factory);

        field.setCell(0, 0, aX);
        field.setCell(0, 1, aX);
        field.setCell(0, 2, aX);

        assertEquals(aX, logic.getWinner());
        assertTrue(logic.hasWinner());
    }

    @Test
    public void diagonalWinnerMain1() {
        Field field = factory.getTictacField(5, 3);
        Logic logic = new LogicSimple(field, factory);

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
        Field field = factory.getTictacField(5, 3);
        Logic logic = new LogicSimple(field, factory);

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
        Field field = factory.getTictacField(3, 5);
        Logic logic = new LogicSimple(field, factory);

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
        Field field = factory.getTictacField(3, 5);
        Logic logic = new LogicSimple(field, factory);

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