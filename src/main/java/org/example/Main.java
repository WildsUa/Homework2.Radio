package org.example;

import org.example.menu.HomeScreen;
import org.example.radio.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
       //Main main = new Main();
       //main.run2();
       //HomeScreen main = new HomeScreen();
       HomeScreen.run();

    }

    private void run2() {
        Content a = new Advertisement("Lenor", 45);
        Content b = new Song("Shibenyk","Harciz",358);
        Content d = new Song("Shibenyk","Harciz",900);
        Content c = new Interview("Zaluzhniy", 628);

        Stream stream = new Stream(20);

        stream.addContent(a);
        stream.addContent(b);
        stream.addContent(c);
        stream.addContent(d);

        System.out.println(stream.getProfit());
        stream.printEther();
        //System.out.println(stream.checkFreeDuration());
        System.out.println(stream);
    }

    public void run1(){
        Content a = new Advertisement("Lenor", 45);
        Content b = new Song("Shibenyk","Harciz",358);
        Content c = new Interview("Zaluzhniy", 628);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        ArrayList<Content> List1 = new ArrayList<>();
        List1.add(a);
        List1.add(b);
        List1.add(c);

        System.out.println(List1);

        int price = 0;
        Iterator<Content> iterator = List1.iterator();
        while (iterator.hasNext()){
            price += iterator.next().getCost();
        }
        System.out.println(price);
    }
}