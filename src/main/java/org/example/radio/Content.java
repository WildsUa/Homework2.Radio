package org.example.radio;

import java.io.Serializable;

public abstract class Content implements Serializable {
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String findTime(){
        //return time in MM:SS format
        int minutes = getMinutes();
        int seconds;

        seconds = time - minutes*60;
        if (seconds>=10){
            return minutes + ":" + seconds;
        } else{
            return minutes + ":0" + seconds;
        }
    }
    public int getMinutes(){
        return time/60;
    }

    public abstract int getCost();
    //Return cost of current content
}
