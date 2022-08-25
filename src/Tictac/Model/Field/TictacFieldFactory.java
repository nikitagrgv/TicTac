package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;

import java.util.Iterator;

public interface TictacFieldFactory {
    TictacField getTictacField(int sizeX, int sizeY);
    Iterator<Actor> getIteratorX(TictacField field, int yPos);

    Iterator<Actor> getIteratorY(TictacField field, int xPos);

    Iterator<Actor> getIteratorXYMain(TictacField field, int xPos, int yPos);

    Iterator<Actor> getIteratorXYAnti(TictacField field, int xPos, int yPos);
}
