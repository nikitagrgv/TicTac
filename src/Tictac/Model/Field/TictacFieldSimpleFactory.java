package Tictac.Model.Field;

import java.util.Iterator;

public class TictacFieldSimpleFactory implements TictacFieldFactory {
    @Override
    public TictacField getTictacField(int sizeX, int sizeY)
    {
        return new TictacFieldSimple(sizeX, sizeY);
    }

    @Override
    public Iterator<String> getIteratorX(TictacField field, int yPos) {
        return new TictacFieldIteratorX(field, yPos);
    }

    @Override
    public Iterator<String> getIteratorY(TictacField field, int xPos) {
        return new TictacFieldIteratorY(field, xPos);
    }

    @Override
    public Iterator<String> getIteratorXYMain(TictacField field, int xPos, int yPos) {
        return new TictacFieldIteratorXYMain(field, xPos, yPos);
    }

    @Override
    public Iterator<String> getIteratorXYAnti(TictacField field, int xPos, int yPos) {
        return new TictacFieldIteratorXYAnti(field, xPos, yPos);
    }
}