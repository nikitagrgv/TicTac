package Tictac.Model.Logic;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Field.TictacField;

public interface TictacLogic {
    void setField(TictacField field);

    boolean hasWinner();
    Actor getWinner();
}
