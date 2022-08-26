package Tictac.Model.Logic;

import Tictac.Model.Actors.Actor;

public interface Logic {

    boolean hasWinner();

    Actor getWinner();
}
