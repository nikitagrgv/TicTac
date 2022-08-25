package Tictac.Model.Field;

import java.util.Iterator;

public class TictacFieldIteratorXYAnti implements Iterator<String> {
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
    public String next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();

        return field.getCell(xPos++, yPos--);
    }
}