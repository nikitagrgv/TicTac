package Tictac.Model.Field;

import java.util.Iterator;

public interface TictacField {
    int getSizeX();
    int getSizeY();

    String getEmptyDesignator();

    String getCell(int x, int y);
    void setCell(int x, int y, String cell);
}
