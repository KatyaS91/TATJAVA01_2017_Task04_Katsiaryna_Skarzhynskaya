package com.epam.task4.controller;

import com.epam.task4.bean.News;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public final class Controller {
    private final CommandProvider provider = new CommandProvider();
    News news;
    public void setNews(News news){
        this.news = news;
    }

    public String executeTask(String request, News news){
        String commandName;
        Command executionCommand;

        commandName = request;
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(news);
        return response;
    }
}
