package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;
import org.junit.Test;
import static org.junit.Assert.*;

public class TictacFieldSimpleTest {
    private final Actor aX = new Actor("X");
    private final Actor aO = new Actor("O");

    @Test
    public void getSizeXAndY() {
        TictacField field = new TictacFieldSimple(3,5);

        assertEquals(3, field.getSizeX());
        assertEquals(5, field.getSizeY());
    }

    @Test
    public void getAndSetCell() {
        TictacField field = new TictacFieldSimple(3, 5);

        field.setCell(0, 0, aX);
        field.setCell(2, 4, aO);

        assertEquals(aX, field.getCell(0, 0));
        assertEquals(aO, field.getCell(2, 4));
    }
}