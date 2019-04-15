package com.company.jobQueue;

public class Job {

    private String text;

    public Job(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "[JOB] Text: "+ text;
    }
}
