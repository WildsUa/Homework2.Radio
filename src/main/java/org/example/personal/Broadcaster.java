package org.example.personal;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Broadcaster implements Serializable {
    static final long serialVersionUID = 2;
    String name;
    ArrayList<Integer> streams;

    public void addStream(int i){
        streams.add(i);
    }

    public void printStreams(){
        System.out.println(streams);
    }

    public int sizeStreams(){
        return streams.size();
    }

    public int getStream(int i){
        return streams.get(i);
    }

    public Broadcaster(String name) {
        this.name = name;
        streams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
