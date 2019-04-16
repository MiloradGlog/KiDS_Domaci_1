package com.company.jobQueue;

import com.company.model.ScannerJob;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class JobQueue {

    private BlockingQueue<ScannerJob> queue;

    private static JobQueue instance;

    private JobQueue() {
        queue = new LinkedBlockingQueue<>();
    }

    public static JobQueue getInstance(){
        if (instance == null){
            instance = new JobQueue();
        }
        return instance;
    }

    public BlockingQueue<ScannerJob> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<ScannerJob> queue) {
        this.queue = queue;
    }
}
