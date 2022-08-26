package Tictac.Model.Field.Iterators;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Field.Field;

import java.util.Iterator;

public class FieldIteratorY implements Iterator<Actor> {
    private final Field field;
    private int currentIndex = 0;
    private final int xPos;

    public FieldIteratorY(Field field, int xPos)
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