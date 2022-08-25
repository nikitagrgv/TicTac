package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class TictacFieldIteratorsTest {
    private final TictacFieldFactory factory = new TictacFieldSimpleFactory();

    private final Actor aX = new Actor("X");
    private final Actor aO = new Actor("O");
    private final Actor aZ = new Actor("Z");
    private final Actor aV = new Actor("V");

    @Test
    public void iteratorX() {
        TictacField field = new TictacFieldSimple(3, 4);

        field.setCell(0, 1, aX);
        field.setCell(1, 1, aO);
        field.setCell(2, 1, aZ);
        var it = factory.getIteratorX(field, 1);

        assertEquals(aX, it.next());
        assertTrue(it.hasNext());
        assertEquals(aO, it.next());
        assertTrue(it.hasNext());
        assertEquals(aZ, it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }

    @Test
    public void iteratorY() {
        TictacField field = new TictacFieldSimple(3, 4);

        field.setCell(1, 0, aX);
        field.setCell(1, 1, aO);
        field.setCell(1, 2, aZ);
        field.setCell(1, 3, aV);
        var it = factory.getIteratorY(field, 1);

        assertEquals(aX, it.next());
        assertTrue(it.hasNext());
        assertEquals(aO, it.next());
        assertTrue(it.hasNext());
        assertEquals(aZ, it.next());
        assertTrue(it.hasNext());
        assertEquals(aV, it.next());
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

        field.setCell(1, 0, aX);
        field.setCell(2, 1, aO);
        var it = factory.getIteratorXYMain(field, 1, 0);

        assertEquals(aX, it.next());
        assertTrue(it.hasNext());
        assertEquals(aO, it.next());
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

        field.setCell(0, 2, aX);
        field.setCell(1, 3, aO);
        var it = factory.getIteratorXYMain(field, 0, 2);

        assertEquals(aX, it.next());
        assertTrue(it.hasNext());
        assertEquals(aO, it.next());
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

        field.setCell(1, 3, aX);
        field.setCell(2, 2, aO);
        var it = factory.getIteratorXYAnti(field, 1, 3);

        assertEquals(aX, it.next());
        assertTrue(it.hasNext());
        assertEquals(aO, it.next());
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

        field.setCell(0, 1, aX);
        field.setCell(1, 0, aO);
        var it = factory.getIteratorXYAnti(field, 0, 1);

        assertEquals(aX, it.next());
        assertTrue(it.hasNext());
        assertEquals(aO, it.next());
        assertFalse(it.hasNext());

        try {
            it.next();
            fail();
        } catch (java.util.NoSuchElementException e) { }
    }
}