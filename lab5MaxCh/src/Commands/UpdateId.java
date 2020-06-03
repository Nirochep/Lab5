package Commands;

import Stuff.*;
import Utility.CreateWorker;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * The type Update id.
 */
public class UpdateId implements Commandable {
    /**
     * The Name.
     */
    String name = "update";
    /**
     * The Create worker.
     */
    CreateWorker CreateWorker = new CreateWorker();
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();

    /**
     * Check boolean.
     *
     * @param arg the arg
     * @return the boolean
     */
    public boolean check(Object arg) {
        return !collection.isKeyFree((Long) arg);
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
    public void execute(Object arg) throws FileNotFoundException {
        try {
            long id = Long.parseLong((String) arg);
            if (this.check(id)) {
                Worker Worker = this.getNewWorker(null);
                if (Worker != null) {
                    Worker.setId(id);
                    collection.update( id, Worker);
                    System.out.println("Работник с id[" + arg + "] успешно обновлен.");
                }
            } else System.out.println("Работник с указанным id не найден.");
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
