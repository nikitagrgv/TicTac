package Tictac.Model.Logic;

import Tictac.Model.Actors.Actor;
import Tictac.Model.Actors.NullActor;
import Tictac.Model.Field.Field;
import Tictac.Model.Field.FieldFactory;

import java.util.*;

public class LogicSimple implements Logic {
    private final FieldFactory factory;
    private final NullActor nullActor = NullActor.getInstance();
    private Field field;

    public LogicSimple(Field field, FieldFactory factory) {
        this.field = field;
        this.factory = factory;
    }

    @Override
    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public boolean hasWinner() {
        return !getWinner().equals(nullActor);
    }

    @Override
    public Actor getWinner() {
        List<Iterator<Actor>> linesIterators = new ArrayList<>();

        addHorizontalLines(linesIterators);
        addVerticalLines(linesIterators);
        addDiagonalLines(linesIterators);

        for (var line : linesIterators) {
            Actor winner = getLineWinner(line);

            if (!winner.equals(nullActor)) {
                return winner;
            }
        }

        return nullActor;
    }

    private void addHorizontalLines(List<Iterator<Actor>> linesIterators) {
        for (int y = 0; y < field.getSizeY(); y++) {
            linesIterators.add(factory.getIteratorX(field, y));
        }
    }

    private void addVerticalLines(List<Iterator<Actor>> linesIterators) {
        for (int x = 0; x < field.getSizeX(); x++) {
            linesIterators.add(factory.getIteratorY(field, x));
        }
    }

    private void addDiagonalLines(List<Iterator<Actor>> linesIterators) {
        boolean isColumnType = field.getSizeY() > field.getSizeX();

        if (isColumnType) {
            for (int i = 0; i < field.getSizeY() - field.getSizeX(); i++) {
                linesIterators.add(factory.getIteratorXYMain(field, 0, i));
                linesIterators.add(factory.getIteratorXYAnti(field, field.getSizeX() - 1, i));
            }
        } else {
            for (int i = 0; i < field.getSizeX() - field.getSizeY(); i++) {
                linesIterators.add(factory.getIteratorXYMain(field, i, 0));
                linesIterators.add(factory.getIteratorXYAnti(field, i, field.getSizeY() - 1));
            }
        }
    }

    private Actor getLineWinner(Iterator<Actor> it) {
        Set<Actor> cellPlayers = new HashSet<>();
        while (it.hasNext()) {
            cellPlayers.add(it.next());
        }

        if (cellPlayers.size() == 1) {
            return cellPlayers.iterator().next();
        }

        return nullActor;
    }
}
