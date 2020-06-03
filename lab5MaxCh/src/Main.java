import Stuff.*;
import Utility.*;
import Commands.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.awt.event.WindowFocusListener;
import java.io.FileNotFoundException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashSet;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws FileNotFoundException the file not found exception
     * @author Max
     */
    public static void main (String[] args) throws FileNotFoundException {
            Show show = new Show();
            Exit exit = new Exit();
            Save save = new Save();
            Info info = new Info();
            History history = new History();
            Help help = new Help();
            Clear clear = new Clear();
            Insert insert = new Insert();
            UpdateId updateId = new UpdateId();
            RemoveId removeId = new RemoveId();
            RemoveGreater removeGreater = new RemoveGreater();
            RemoveLower removeLower = new RemoveLower();
            CountByPerson countByPerson = new CountByPerson();
            FilterLessThanEndDate filterLessThanEndDate = new FilterLessThanEndDate();
            MaxByEndDate maxByEndDate = new MaxByEndDate();
            ExecuteScript executeScript = new ExecuteScript();
       Collection collection = new Collection();
       ReaderFromFile readerFromFile = new ReaderFromFile();

        try {
           collection.fillCollection(readerFromFile.readFromFile(args[0]));
           // collection.fillCollection(readerFromFile.readFromFile("collection.txt"));
        } catch (Exception e){
            System.out.println("Возможно аргумент командной строки не указан,попробуйте перезапустить приложение.");
        }

        Commands commands = new Commands();
        commands.regist(show,exit,save,info,history,help,clear,insert,updateId,removeGreater,removeId,removeLower,maxByEndDate,filterLessThanEndDate,countByPerson,executeScript);
        while (true) {
            System.out.println("Введите команду,для справки введите help.");
            String commandName = Console.read();
            if (!commandName.equals(""))
                commands.executeCommand(commandName);
        }
    }
}
