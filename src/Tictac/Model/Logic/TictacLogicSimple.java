package Tictac.Model.Logic;

import Tictac.Model.Field.TictacField;
import Tictac.Model.Field.TictacFieldFactory;

import java.util.*;

public class TictacLogicSimple implements TictacLogic {
    private TictacField field;
    private final TictacFieldFactory factory;

    public TictacLogicSimple(TictacField field, TictacFieldFactory factory) {
        this.field = field;
        this.factory = factory;
    }

    @Override
    public void setField(TictacField field) {
        this.field = field;
    }

    @Override
    public boolean hasWinner() {
        return !getWinner().equals(field.getEmptyDesignator());
    }

    @Override
    public String getWinner() {
        List<Iterator<String>> linesIterators = new ArrayList<>();

        // add horizontal lines
        for (int y = 0; y < field.getSizeY(); y++) {
            linesIterators.add(factory.getIteratorX(field, y));
        }

        // add vertical lines
        for (int x = 0; x < field.getSizeX(); x++) {
            linesIterators.add(factory.getIteratorY(field, x));
        }

        // add main diagonal lines
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

        for (var line : linesIterators) {
            String winner = getLineWinner(line);

            if (!winner.equals(field.getEmptyDesignator())) {
                return winner;
            }
        }

        return field.getEmptyDesignator();
    }

    private String getLineWinner(Iterator<String> it) {
        Set<String> cellPlayers = new HashSet<>();
        while (it.hasNext()) {
            cellPlayers.add(it.next());
        }

        if (cellPlayers.size() == 1) {
            return cellPlayers.iterator().next();
        }

        return field.getEmptyDesignator();
    }
}
