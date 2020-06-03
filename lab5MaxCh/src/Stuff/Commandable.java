package Stuff;


import java.io.FileNotFoundException;

/**
 * The interface Commandable.
 */
public interface Commandable {
    /**
     * Execute.
     *
     * @param o the o
     * @throws FileNotFoundException the file not found exception
     */
    public void execute(Object o) throws FileNotFoundException;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName();
}