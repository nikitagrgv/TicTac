package Tictac.Model.Field;

public class FieldSimpleFactory implements FieldFactory {
    @Override
    public Field getTictacField(int sizeX, int sizeY)
    {
        return new FieldSimple(sizeX, sizeY);
    }
}