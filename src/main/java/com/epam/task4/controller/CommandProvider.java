package com.epam.task4.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();

    CommandProvider(){
        repository.put(CommandName.ADD_BOOK_NEWS, new AddBookNews());
        repository.put(CommandName.FIND_BOOK_NEWS, new FindBookNews());
        repository.put(CommandName.FIND_BOOK_NEWS_BY_TITLE, new FindBookNewsByTitle());
    }
    Command getCommand(String name){
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name);
            command = repository.get(commandName);
        } catch (IllegalArgumentException e){
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
