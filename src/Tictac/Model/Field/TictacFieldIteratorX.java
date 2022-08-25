package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;

import java.util.Iterator;

public class TictacFieldIteratorX implements Iterator<Actor> {
    private final TictacField field;
    private int currentIndex = 0;
    private final int yPos;

    public TictacFieldIteratorX(TictacField field, int yPos)
    {
        this.field = field;
        this.yPos = yPos;
    }

    @Override
    public boolean hasNext() {
        return currentIndex != field.getSizeX();
    }

    @Override
    public Actor next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();

        return field.getCell(currentIndex++, yPos);
    }
}