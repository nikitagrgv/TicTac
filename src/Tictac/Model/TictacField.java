package Tictac.Model;

import java.util.Iterator;

public interface TictacField {
    int getSizeX();
    int getSizeY();

    String getCell(int x, int y);
    void setCell(int x, int y, String cell);

    Iterator<String> iteratorX(int yPos);
    Iterator<String> iteratorY(int xPos);
}
