package Tictac.Model.Field.Iterators;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Field.Field;

import java.util.Iterator;

public class FieldIteratorX implements Iterator<Actor> {
    private final Field field;
    private final int yPos;
    private int currentIndex = 0;

    public FieldIteratorX(Field field, int yPos) {
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