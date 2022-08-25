package Tictac.Model;

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
}
