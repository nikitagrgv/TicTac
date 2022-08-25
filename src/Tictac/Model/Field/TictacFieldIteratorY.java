package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;

import java.util.Iterator;

public class TictacFieldIteratorY implements Iterator<Actor> {
    private final TictacField field;
    private int currentIndex = 0;
    private final int xPos;

    public TictacFieldIteratorY(TictacField field, int xPos)
    {
        this.field = field;
        this.xPos = xPos;
    }

    @Override
    public boolean hasNext() {
        return currentIndex != field.getSizeY();
    }

    @Override
    public Actor next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();

        return field.getCell(xPos, currentIndex++);
    }
}