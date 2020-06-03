package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;

/**
 * The type Info.
 */
public class Info implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "info";
    /**
     * The Worker collection.
     */
    WorkerCollection WorkerCollection = new WorkerCollection();

    @Override
    public void execute(Object o) {
        System.out.println(WorkerCollection.getInfo());
    }

    @Override
    public String getName() {
        return name;
    }
}