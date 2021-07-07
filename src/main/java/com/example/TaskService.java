package com.example;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;

@Dependent
public class TaskService {

    private static final Logger LOGGER = Logger.getLogger(TaskService.class.getName());

    @Resource(lookup = "java:jboss/ee/concurrency/executor/simple2")
    private ExecutorService executor2;

    public boolean add() {
        String uuid = UUID.randomUUID().toString();
        long sleep = 30;
        LOGGER.log(Level.INFO, "### enqueue :: {0}", uuid);
        try {
            executor2.submit(new WaitingTask(uuid, sleep));
        } catch (java.util.concurrent.RejectedExecutionException e) {
            LOGGER.log(Level.WARNING, "### Rejected!!");
            return false;
        }
        return true;
    }

}
