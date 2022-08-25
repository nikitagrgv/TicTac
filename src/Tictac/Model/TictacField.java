package Tictac.Model;

public interface TictacField {
    int getSizeX();
    int getSizeY();

    String getCell(int x, int y);
    void setCell(int x, int y, String cell);
}
