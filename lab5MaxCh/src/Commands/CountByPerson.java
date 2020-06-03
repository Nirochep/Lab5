package Commands;

        import Stuff.CommandWithoutArg;
        import Stuff.Worker;
        import Stuff.WorkerCollection;
        import Utility.CreateWorker;

        import java.io.FileNotFoundException;
        import java.util.Map;

/**
 * The type Count by person.
 */
public class CountByPerson implements CommandWithoutArg {
    String name = "count_by_person";
    WorkerCollection collection = new WorkerCollection();
    CreateWorker CreateWorker = new CreateWorker();

    public boolean check(Object arg) {
        return collection.isKeyFree((Long) arg);
    }


    /**
     * Gets new worker.
     *
     * @param params the params
     * @return the new worker
     */
    public Worker getNewWorker(Object params) {
        if (!CreateWorker.isFromScript) return CreateWorker.createPerson();
        else return CreateWorker.workerFromScript;
    }

    @Override
    public void execute(Object o) throws FileNotFoundException {
        try{
            int i =0;
            Worker Worker = this.getNewWorker(null);
            for (Map.Entry<Long, Worker> entry : collection.getCollection().entrySet()) {
                if (entry.getValue().getPerson().equals(Worker.getPerson())) {
                    i++;
                }

            }
            System.out.println("Указанных вами людей в коллекции: "+i);
        }catch (NullPointerException e){
            System.out.println("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
