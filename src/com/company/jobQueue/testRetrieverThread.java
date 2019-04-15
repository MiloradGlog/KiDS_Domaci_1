package com.company.jobQueue;

import java.util.concurrent.BlockingQueue;

public class testRetrieverThread extends Thread {

    private BlockingQueue queue;

    public testRetrieverThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Izvadio iz queue-a: "+ queue.take());
            } catch (Exception e){

            }
        }
    }

}
