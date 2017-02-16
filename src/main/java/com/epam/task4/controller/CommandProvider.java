package com.epam.task4.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();

    CommandProvider(){
        repository.put(CommandName.ADD_BOOK_NEWS, new AddBookNews());
        repository.put(CommandName.FIND_BOOK_NEWS, new FindBookNews());
        repository.put(CommandName.FIND_BOOK_NEWS_BY_TITLE, new FindBookNewsByTitle());
        repository.put(CommandName.ADD_MOVIE_NEWS, new AddMovieNews());
        repository.put(CommandName.FIND_MOVIE_NEWS, new FindMovieNews());
        repository.put(CommandName.FIND_MOVIE_NEWS_BY_TITLE, new FindMovieNewsByTitle());
        repository.put(CommandName.ADD_DISK_NEWS, new AddDiskNews());
        repository.put(CommandName.FIND_DISK_NEWS, new FindDiskNews());
        repository.put(CommandName.FIND_DISK_NEWS_BY_TITLE, new FindDiskByTitle());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
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
