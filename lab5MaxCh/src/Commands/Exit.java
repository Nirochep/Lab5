package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;

/**
 * The type Exit.
 */
public class Exit implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "exit";
    /**
     * The Worker collection.
     */
    WorkerCollection WorkerCollection = new WorkerCollection();

    @Override
    public void execute(Object o) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return name;
    }
}