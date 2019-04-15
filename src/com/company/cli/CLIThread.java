package com.company.cli;

import com.company.dirCrawler.DirCrawlerThread;
import com.company.jobQueue.Job;
import com.company.jobQueue.JobQueue;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CLIThread extends Thread {

    private Scanner in;
    private JobQueue queue;

    public CLIThread(JobQueue queue){
        in = new Scanner(System.in);
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            String inputString = in.nextLine();
            interpret(inputString);
            try {
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void interpret(String str){
        StringTokenizer tokenizer = new StringTokenizer(str);
        System.out.println("Number of tokens = "+ tokenizer.countTokens());
        String commandString = tokenizer.nextToken();
        String parameterString = getParameterFromTokenizer(tokenizer);
        switch (commandString){
            case ("ad"): {
                new DirCrawlerThread(parameterString).run();
                System.out.println("Komanda je add data");
                break;
            }
            case ("aw"): {
                System.out.println("Komanda je add web");
                break;
            }
            case ("stop"): {
                System.out.println("Komanda je stop");
                break;
            }
            default: {
                System.out.println("Nepoznata komanda");
                break;
            }

        }
    }

    private String getParameterFromTokenizer(StringTokenizer tokenizer){
        if (tokenizer.hasMoreElements())
            return tokenizer.nextToken();
        return null;
    }
}
