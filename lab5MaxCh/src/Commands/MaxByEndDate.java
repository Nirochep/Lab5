package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Stuff.Worker;
import Stuff.WorkerCollection;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Map;

/**
 * The type Max by end date.
 */
public class MaxByEndDate implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "max_by_end_date";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    @Override
    public void execute(Object o) throws FileNotFoundException {
        try {
            if (collection.getSize() == 0) System.out.println("Коллекция  пустая.");
            else {
            LocalDate maxDate = collection.getCollection().entrySet().iterator().next().getValue().getEndDate().toLocalDate();
            Long maxId =  collection.getCollection().entrySet().iterator().next().getKey();
                for (Map.Entry<Long, Worker> entry : collection.getCollection().entrySet()) {
                    if (entry.getValue().getEndDate().toLocalDate().isAfter(maxDate)) {
                        maxId = entry.getKey();
                        maxDate = entry.getValue().getEndDate().toLocalDate();
                    }
                }
                System.out.println("Работник,который будет работать больше всех,аж до этой даты: "+maxDate);
                System.out.println(collection.getCollection().get(maxId).getInfo());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Неверно указан формат даты.Попробуйте ввести команду ещё раз.(Формат даты YYYY-MM-HH");
        }
    }
    @Override
    public String getName() {
        return name;
    }
}
