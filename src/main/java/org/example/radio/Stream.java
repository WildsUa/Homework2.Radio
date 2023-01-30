package org.example.radio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Stream implements Serializable {

    @Override
    public String toString() {
        return "Stream{" +
                "duration=" + duration +
                ", ether=" + ether +
                '}';
    }

    static final long serialVersionUID = 1;
    int duration;
    int durationTaken = 0;

    ArrayList<Content> ether;

    public Stream(int duration) {
        this.duration = duration;
        ether = new ArrayList<>();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean addContent(Content content){
        //Add new content if it is possible, or return false if it is not possible
        if  (duration*60>= durationTaken+content.getTime()){
            ether.add(content);
            durationTaken += content.getTime();
            return true;
        } else {
            return false;
        }
    }

    public int getProfit(){
        //calculate Profit from current stream
        int price = 0;
        Iterator<Content> iterator = ether.iterator();
        while (iterator.hasNext()){
            price += iterator.next().getCost();
        }
        return price;
    }

    public void printEther(){
        System.out.println(ether);
    }


    public boolean checkFreeDuration(){
    //Return that free content duration is same or bigger than pay content duration
        int freeContent = 0;
        int payContent = 0;
        int current;
        for (int i = 0; i < ether.size();i++){
        current = ether.get(i).getCost();
            if (current == 0){
                freeContent += ether.get(i).getTime();
            } else {
                payContent +=  ether.get(i).getTime();
            }
        }

        return freeContent >= payContent;
    }


}
