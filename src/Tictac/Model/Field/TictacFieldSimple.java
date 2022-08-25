package Tictac.Model.Field;

public class TictacFieldSimple implements TictacField {
    private final String[][] cellArray;

    public TictacFieldSimple(int sizeX, int sizeY) {
        this.cellArray = new String[sizeY][sizeX];
        fillField(getEmptyDesignator());
    }

    private void fillField(String filling) {
        for (int y = 0; y < getSizeY(); y++) {
            for (int x = 0; x < getSizeX(); x++) {
                setCell(x, y, filling);
            }
        }
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
    public String getEmptyDesignator() {
        return ".";
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
