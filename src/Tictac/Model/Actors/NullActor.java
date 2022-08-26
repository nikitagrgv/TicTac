package Tictac.Model.Actors;

public class NullActor extends Actor {
    private static final NullActor instance = new NullActor();

    private NullActor() {
        super(".");
    }

    public static NullActor getInstance() {
        return instance;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
}
