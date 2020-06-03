package Commands;

import Stuff.Commandable;
import Stuff.Commands;
import Stuff.WorkerCollection;
import Utility.CreateWorker;
import Utility.ReaderFromFile;

import java.io.FileNotFoundException;

/**
 * The type Execute script.
 */
public class ExecuteScript implements Commandable {
    /**
     * The Name.
     */
    String name = "execute_script";
    /**
     * The Collection.
     */
    WorkerCollection collection = new WorkerCollection();
    /**
     * The Reader.
     */
    ReaderFromFile reader = new ReaderFromFile();
    /**
     * The Invoker.
     */
    Commands invoker = new Commands();

    @Override
    public void execute(Object arg) {
        try {
            String data = reader.readFromFile((String) arg);
            Commands command = new Commands();
            if (data != null) {
                String[] commands = data.split("\n|\r\n");
                for (int i = 0; i < commands.length; i++) {
                    if (!(commands[i].equals(""))) {
                        if (!(commands[i].equals("execute_script " + arg))) {
                            try {
                                String[] commandAndName = commands[i].split(" ");
                                if (commandAndName[0].equals("count_by_person")||commandAndName[0].equals("")||commandAndName[0].equals("insert")||commandAndName[0].equals("update")||commandAndName[0].equals("remove_greater")||commandAndName[0].equals("remove_lower")) {
                                    String paramData= "";
                                    try {
                                        for (int j = 0; j <12; j++) {
                                            i++;
                                            paramData+=commands[i]+";";
                                        }
                                        System.out.println("\nКоманда \"" + commands[i-12] + "\":");
                                        CreateWorker.isFromScript = true;
                                        CreateWorker creater = new CreateWorker();
                                        creater.createFromExecute(paramData);
                                        command.executeCommand(commands[i-12]);
                                        CreateWorker.isFromScript = false;
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Недостаточно параметров");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Команда \"" + commands[i] + "\":");
                                command.executeCommand(commands[i]);
                                System.out.println();
                            }

                        } else System.out.println("Команда \"" + commands[i] + "\": невыполнима.");
                    }
                }
            } else System.out.println("Указанный файл не найден.");
        } catch (NullPointerException | FileNotFoundException e) {

        }
    }

    @Override
    public String getName() {
        return name;
    }
}