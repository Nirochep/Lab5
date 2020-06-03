package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Worker;
import Stuff.WorkerCollection;

import java.util.Hashtable;
import java.util.Map;

/**
 * The type Show.
 */
public class Show implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "show";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();

    @Override
    public void execute(Object o) {
        if (collection.getSize() == 0) System.out.println("Коллекция пустая.");
        else for (Map.Entry<Long, Worker> entry : collection.getCollection().entrySet())
            System.out.println(entry.getValue().getInfo());
            }


    @Override
    public String getName() {
        return name;
    }
}