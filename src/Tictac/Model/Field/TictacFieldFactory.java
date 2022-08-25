package Tictac.Model.Field;

import java.util.Iterator;

public interface TictacFieldFactory {
    TictacField getTictacField(int sizeX, int sizeY);
    Iterator<String> getIteratorX(TictacField field, int yPos);

    Iterator<String> getIteratorY(TictacField field, int xPos);

    Iterator<String> getIteratorXYMain(TictacField field, int xPos, int yPos);

    Iterator<String> getIteratorXYAnti(TictacField field, int xPos, int yPos);
}
