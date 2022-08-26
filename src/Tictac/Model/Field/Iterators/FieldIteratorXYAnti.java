package Tictac.Model.Field.Iterators;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Field.Field;

import java.util.Iterator;

public class FieldIteratorXYAnti implements Iterator<Actor> {
    private final Field field;
    private int xPos;
    private int yPos;

    public FieldIteratorXYAnti(Field field, int xPos, int yPos) {
        this.field = field;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean hasNext() {
        return xPos < field.getSizeX() && yPos >= 0;
    }

    @Override
    public Actor next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();

        return field.getCell(xPos++, yPos--);
    }
}