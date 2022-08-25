package Tictac.Model.Field;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


public class TictacFieldIteratorsTest {
    private final TictacFieldFactory factory = new TictacFieldSimpleFactory();

    @Test
    public void iteratorX() {
        TictacField field = new TictacFieldSimple(3, 4);

        field.setCell(0, 1, "X");
        field.setCell(1, 1, "O");
        field.setCell(2, 1, "Z");
        Iterator<String> it = factory.getIteratorX(field, 1);

        assertEquals("X", it.next());
        assertTrue(it.hasNext());
        assertEquals("O", it.next());
        assertTrue(it.hasNext());
        assertEquals("Z", it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

    @Test
    public void iteratorY() {
        TictacField field = new TictacFieldSimple(3, 4);

        field.setCell(1, 0, "X");
        field.setCell(1, 1, "O");
        field.setCell(1, 2, "Z");
        field.setCell(1, 3, "V");
        Iterator<String> it = factory.getIteratorY(field, 1);

        assertEquals("X", it.next());
        assertTrue(it.hasNext());
        assertEquals("O", it.next());
        assertTrue(it.hasNext());
        assertEquals("Z", it.next());
        assertTrue(it.hasNext());
        assertEquals("V", it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

    @Test
    public void iteratorXYMainBoundedByX() {
        TictacField field = new TictacFieldSimple(3, 4);

        // .X.
        // ..O
        // ...
        // ...

        field.setCell(1, 0, "X");
        field.setCell(2, 1, "O");
        Iterator<String> it = factory.getIteratorXYMain(field, 1, 0);

        assertEquals("X", it.next());
        assertTrue(it.hasNext());
        assertEquals("O", it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

    @Test
    public void iteratorXYMainBoundedByY() {
        TictacField field = new TictacFieldSimple(3, 4);

        // ...
        // ...
        // X..
        // .O.

        field.setCell(0, 2, "X");
        field.setCell(1, 3, "O");
        Iterator<String> it = factory.getIteratorXYMain(field, 0, 2);

        assertEquals("X", it.next());
        assertTrue(it.hasNext());
        assertEquals("O", it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

    @Test
    public void iteratorXYAntiBoundedByX() {
        TictacField field = new TictacFieldSimple(3, 4);

        // ...
        // ...
        // ..O
        // .X.

        field.setCell(1, 3, "X");
        field.setCell(2, 2, "O");
        Iterator<String> it = factory.getIteratorXYAnti(field, 1, 3);

        assertEquals("X", it.next());
        assertTrue(it.hasNext());
        assertEquals("O", it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

    @Test
    public void iteratorXYAntiBoundedByY() {
        TictacField field = new TictacFieldSimple(3, 4);

        // .O.
        // X..
        // ...
        // ...

        field.setCell(0, 1, "X");
        field.setCell(1, 0, "O");
        Iterator<String> it = factory.getIteratorXYAnti(field, 0, 1);

        assertEquals("X", it.next());
        assertTrue(it.hasNext());
        assertEquals("O", it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }
}