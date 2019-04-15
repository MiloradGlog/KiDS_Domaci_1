package com.company.jobQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class JobQueue {

    private BlockingQueue<Job> queue;

    public JobQueue() {
        queue = new LinkedBlockingQueue<>();
    }

    public BlockingQueue<Job> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Job> queue) {
        this.queue = queue;
    }
}
