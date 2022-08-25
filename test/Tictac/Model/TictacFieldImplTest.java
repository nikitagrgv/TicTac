package Tictac.Model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Iterator;


public class TictacFieldImplTest {

    @Test
    public void getSizeXAndY() {
        TictacField field = new TictacFieldImpl(3,5);

        assertEquals(3, field.getSizeX());
        assertEquals(5, field.getSizeY());
    }

    @Test
    public void getAndSetCell() {
        TictacField field = new TictacFieldImpl(3, 5);

        field.setCell(0, 0, "X");
        field.setCell(2, 4, "O");

        assertEquals("X", field.getCell(0, 0));
        assertEquals("O", field.getCell(2, 4));
    }

    @Test
    public void iteratorX() {
        TictacField field = new TictacFieldImpl(3, 4);

        field.setCell(0, 1, "X");
        field.setCell(1, 1, "O");
        field.setCell(2, 1, "Z");
        Iterator<String> it = field.iteratorX(1);

        assertEquals("X", it.next());
        assertEquals("O", it.next());
        assertEquals("Z", it.next());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

    @Test
    public void iteratorY() {
        TictacField field = new TictacFieldImpl(3, 4);

        field.setCell(1, 0, "X");
        field.setCell(1, 1, "O");
        field.setCell(1, 2, "Z");
        field.setCell(1, 3, "V");
        Iterator<String> it = field.iteratorY(1);

        assertEquals("X", it.next());
        assertEquals("O", it.next());
        assertEquals("Z", it.next());
        assertEquals("V", it.next());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

}