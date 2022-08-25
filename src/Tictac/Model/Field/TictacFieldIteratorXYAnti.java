package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;

import java.util.Iterator;

public class TictacFieldIteratorXYAnti implements Iterator<Actor> {
    private final TictacField field;
    private int xPos;
    private int yPos;

    public TictacFieldIteratorXYAnti(TictacField field, int xPos, int yPos) {
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