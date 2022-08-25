package Tictac.Model;

import java.util.Iterator;

public class TictacFieldImpl implements TictacField {
    private final String[][] cellArray;

    public TictacFieldImpl(int sizeX, int sizeY) {
        this.cellArray = new String[sizeY][sizeX];
    }

    @Override
    public int getSizeX() {
        return cellArray[0].length;
    }

    @Override
    public int getSizeY() {
        return cellArray.length;
    }

    @Override
    public String getCell(int x, int y) {
        return cellArray[y][x];
    }

    @Override
    public void setCell(int x, int y, String cell) {
        cellArray[y][x] = cell;
    }

    @Override
    public Iterator<String> iteratorX(int yPos) {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex != getSizeX();
            }

            @Override
            public String next() {
                if (currentIndex >= getSizeX())
                    throw new java.util.NoSuchElementException();

                return getCell(currentIndex++, yPos);
            }
        };
    }

    @Override
    public Iterator<String> iteratorY(int xPos) {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex != getSizeY();
            }

            @Override
            public String next() {
                if (currentIndex >= getSizeY())
                    throw new java.util.NoSuchElementException();

                return getCell(xPos, currentIndex++);
            }
        };
    }
}
