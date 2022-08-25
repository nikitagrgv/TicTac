package Tictac.Model.Field;

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
        return new TictacFieldIteratorX(this, yPos);
    }

    @Override
    public Iterator<String> iteratorY(int xPos) {
        return new TictacFieldIteratorY(this, xPos);
    }

    @Override
    public Iterator<String> iteratorXYMain(int xPos, int yPos) {
        return new TictacFieldIteratorXYMain(this, xPos, yPos);
    }

    @Override
    public Iterator<String> iteratorXYAnti(int xPos, int yPos) {
        return new TictacFieldIteratorXYAnti(this, xPos, yPos);
    }
}
