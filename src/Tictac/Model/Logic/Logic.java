package Tictac.Model.Logic;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Field.Field;

public interface Logic {
    void setField(Field field);

    boolean hasWinner();
    Actor getWinner();
}
