package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Field.Iterators.FieldIteratorX;
import Tictac.Model.Field.Iterators.FieldIteratorXYAnti;
import Tictac.Model.Field.Iterators.FieldIteratorXYMain;
import Tictac.Model.Field.Iterators.FieldIteratorY;

import java.util.Iterator;

public interface FieldFactory {
    Field getTictacField(int sizeX, int sizeY);

    default Iterator<Actor> getIteratorX(Field field, int yPos) {
        return new FieldIteratorX(field, yPos);
    }

    default Iterator<Actor> getIteratorY(Field field, int xPos) {
        return new FieldIteratorY(field, xPos);
    }

    default Iterator<Actor> getIteratorXYMain(Field field, int xPos, int yPos) {
        return new FieldIteratorXYMain(field, xPos, yPos);
    }

    default Iterator<Actor> getIteratorXYAnti(Field field, int xPos, int yPos) {
        return new FieldIteratorXYAnti(field, xPos, yPos);
    }
}
