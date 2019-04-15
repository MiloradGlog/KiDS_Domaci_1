package com.company;

import com.company.cli.CLIThread;
import com.company.dirCrawler.DirCrawlerThread;
import com.company.jobQueue.Job;
import com.company.jobQueue.JobQueue;
import com.company.jobQueue.testRetrieverThread;

public class Main {

    public static void main(String[] args) {
//        String path = "files";
        JobQueue queue = new JobQueue();

        Thread t = new CLIThread(queue);
        t.start();

        new testRetrieverThread(queue.getQueue()).start();

    }
}
