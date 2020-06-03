package Commands;

import Stuff.CommandWithoutArg;
import Stuff.*;
import java.util.ArrayList;

/**
 * The type History.
 */
public class History implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "history";

    @Override
    public void execute(Object o) {
        ArrayList<String> history = Commands.getHistory();
        if (history.size() == 0) System.out.println("История пустая.");
        else {
            int numOfCommands = history.size();
            System.out.println("Последние выполненные команды:");
            try{
                for(int i=numOfCommands;i > numOfCommands-12;i--) {
                    System.out.println(history.get(i-1));

                }
            }
            catch(IndexOutOfBoundsException e) {
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }
}