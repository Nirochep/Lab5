package Commands;

import Stuff.CommandWithoutArg;
import Stuff.WorkerCollection;
import Utility.CreateWorker;
import Stuff.Worker;
import java.util.InputMismatchException;

/**
 * The type Insert.
 */
public class Insert implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "insert";
    /**
     * The Worker collection.
     */
    WorkerCollection WorkerCollection = new WorkerCollection();
    /**
     * The Create worker.
     */
    CreateWorker CreateWorker = new CreateWorker();

    /**
     * Check boolean.
     *
     * @param arg the arg
     * @return the boolean
     */
    public boolean check(Object arg) {
        return WorkerCollection.isKeyFree((Long) arg);
    }


    /**
     * Gets new worker.
     *
     * @param params the params
     * @return the new worker
     */
    public Worker getNewWorker(Object params) {
        if (!CreateWorker.isFromScript) return CreateWorker.create();
        else return CreateWorker.workerFromScript;
    }

    @Override
    public void execute(Object arg) {
        try {
            Worker Worker = this.getNewWorker(null);
                WorkerCollection.insert(Worker.getId(),Worker);
                System.out.println("Работник добавлен в коллекцию!");

        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Аргумент команды должен быть типа \"long\"");
        }
        catch (NullPointerException e){
            System.out.println("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
