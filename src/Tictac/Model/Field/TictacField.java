package Tictac.Model.Field;

import Tictac.Model.Actors.Actor;

public interface TictacField {
    int getSizeX();
    int getSizeY();

    Actor getCell(int x, int y);
    void setCell(int x, int y, Actor cell);
}
