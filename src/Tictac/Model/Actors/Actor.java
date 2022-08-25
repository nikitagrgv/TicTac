package Tictac.Model.Actors;

public class Actor {
    private final String name;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
