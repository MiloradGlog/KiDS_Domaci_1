package com.company.jobQueue;

import com.company.fileScanner.FileScannerPool;
import com.company.fileScanner.FileScannerThread;
import com.company.model.FileScannerJob;

import java.util.concurrent.BlockingQueue;

public class jobDispatcherThread extends Thread {

    private BlockingQueue queue;
    private FileScannerPool pool;

    public jobDispatcherThread(FileScannerPool pool){
        this.queue = JobQueue.getInstance().getQueue();
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true){
            try {
                FileScannerJob job = (FileScannerJob) queue.take();
                System.out.println("Izvadio iz queue-a: "+ job);
                pool.addJob(job);//new FileScannerThread(job).start();
            } catch (Exception e){

            }
        }
    }

}
