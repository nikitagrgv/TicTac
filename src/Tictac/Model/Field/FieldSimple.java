package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Actors.NullActor;

public class FieldSimple implements Field {
    private final Actor[][] cellArray;

    public FieldSimple(int sizeX, int sizeY) {
        this.cellArray = new Actor[sizeY][sizeX];
        fillField(NullActor.getInstance());
    }

    private void fillField(Actor filling) {
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
    public Actor getCell(int x, int y) {
        return cellArray[y][x];
    }

    @Override
    public void setCell(int x, int y, Actor cell) {
        cellArray[y][x] = cell;
    }
}
