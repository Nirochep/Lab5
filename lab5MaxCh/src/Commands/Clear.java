package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;

import java.io.FileNotFoundException;

/**
 * The type Clear.
 */
public class Clear implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "clear";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();

    @Override
    public void execute(Object o) {
        if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
        else {
            collection.clear();
            System.out.println("Коллекция очищена");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
