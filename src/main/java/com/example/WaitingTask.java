package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WaitingTask implements Callable<String> {

    private static final Logger LOGGER = Logger.getLogger(WaitingTask.class.getName());

    private String uuid;
    private long sleep;

    public WaitingTask(String uuid, long sleep) {
        this.uuid = uuid;
        this.sleep = sleep;
    }

    @Override
    public String call() throws Exception {
        LOGGER.log(Level.INFO, "### call :: {0}", uuid);
        TimeUnit.SECONDS.sleep(sleep);
        LOGGER.log(Level.INFO, "### done :: {0}", uuid);
        return uuid;
    }

}
