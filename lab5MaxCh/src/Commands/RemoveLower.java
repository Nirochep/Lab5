package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Worker;
import Stuff.WorkerCollection;
import Utility.CreateWorker;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;

/**
 * The type Remove lower.
 */
public class RemoveLower implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "remove_lower";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    /**
     * The Create worker.
     */
    Utility.CreateWorker CreateWorker = new CreateWorker();

    /**
     * Check boolean.
     *
     * @param arg the arg
     * @return the boolean
     */
    public boolean check(Object arg) {
        return false;
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
            Worker newWorker = this.getNewWorker(null);
            boolean tumb = false;
            if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
            else {
                Hashtable<Long, Worker> workers = collection.getCollection();
                Enumeration keys = workers.keys();
                while (keys.hasMoreElements()) {
                    Long k = (Long) keys.nextElement();
                    Worker v = workers.get(k);
                    if (v.compareTo(newWorker) < 0 ) {
                        tumb = true;
                        collection.remove(k);
                        System.out.println("Работник с id:[" + k + "] успешно удален.");
                    }
                }
                if (!tumb) System.out.println("Работников,меньше чем заданный не найдено.");
            }
        }
        catch (NumberFormatException | InputMismatchException e) {
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