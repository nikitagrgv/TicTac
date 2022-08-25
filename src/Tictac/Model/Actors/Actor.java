package Tictac.Model.Actors;

public class Actor {
    private final String name;

    Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
