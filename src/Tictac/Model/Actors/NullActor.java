package Tictac.Model.Actors;

public class NullActor extends Actor {
    NullActor() {
        super(".");
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
}
