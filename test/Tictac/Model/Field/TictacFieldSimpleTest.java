package Tictac.Model.Field;

import org.junit.Test;
import static org.junit.Assert.*;

public class TictacFieldSimpleTest {

    @Test
    public void getSizeXAndY() {
        TictacField field = new TictacFieldSimple(3,5);

        assertEquals(3, field.getSizeX());
        assertEquals(5, field.getSizeY());
    }

    @Test
    public void getAndSetCell() {
        TictacField field = new TictacFieldSimple(3, 5);

        field.setCell(0, 0, "X");
        field.setCell(2, 4, "O");

        assertEquals("X", field.getCell(0, 0));
        assertEquals("O", field.getCell(2, 4));
    }
}