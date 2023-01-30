package org.example.menu;

import org.example.personal.Broadcaster;
import org.example.personal.GuestBroadcaster;
import org.example.personal.LocalBroadcaster;
import org.example.radio.Advertisement;
import org.example.radio.Interview;
import org.example.radio.Song;
import org.example.radio.Stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeScreen {
    static ArrayList<Stream> history;
    static ArrayList<Broadcaster> personal;
    static Scanner scanner;
    static Scanner scanner2;

    public static void saveHistory(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("streams.txt"))){
        oos.writeObject(history);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readHistory(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("streams.txt"))){
         history = (ArrayList<Stream>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void savePersonal() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("broadcasters.txt"))) {
            oos.writeObject(personal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readPersonal(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("broadcasters.txt"))){
            personal = (ArrayList<Broadcaster>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void run(){
        history = new ArrayList<>();
        personal = new ArrayList<>();
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        readHistory();
        readPersonal();
        mainMenu();

    }

    public static void mainMenu(){
        System.out.println("Please select an action: \n 1. Work with streams \n 2. Work with broadcasters \n 3. Save and exit");

        //Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1){
            streamsMenu();
        } else if (input == 2) {
            broadcastersMenu();
        } else if (input == 3) {
            exit();
        } else {
            mainMenu();
        }
        //scanner.close();
    }
    public static void streamsMenu(){
        System.out.println("Please select an action: \n 1. Create new stream \n 2. View specific stream \n 3. View all streams \n 4. Display profit from provided stream ");

        //Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1){
            addStreamMenu();
        } else if (input == 2) {
            printStreamMenu();
        } else if (input == 3) {
            printStreamsMenu();
        } else if (input == 4) {
            printStreamProfit();
        } else {
            mainMenu();
        }
        //scanner.close();
    }

    public static void addStreamMenu(){
        //Scanner scanner = new Scanner(System.in);
        //Scanner scanner2 = new Scanner(System.in);
        Stream newline;
        boolean adding = true;

        System.out.println("Please enter stream duration in minutes");

        int input = scanner.nextInt();
        newline = new Stream(input);

        while (adding){
            System.out.println("Do you want to add additional ether content for this stream? \n 1. Add new content \n 2. Save stream");
            input = scanner.nextInt();
            if (input == 1){
                //add content to new stream
                System.out.println("Please enter content type: \n 1. Song \n 2. Advertisement \n 3. Interview");
                input = scanner.nextInt();

                if (input == 1){
                    String songName;
                    String authorName;
                    int duration;

                    System.out.println("Please enter Song name:");
                    songName = scanner2.nextLine();
                    System.out.println("Please enter Singer name:");
                    authorName = scanner2.nextLine();
                    System.out.println("Please enter song duration in seconds:");
                    duration = scanner.nextInt();
                    Song newSong = new Song(songName, authorName, duration);

                    if (newline.addContent(newSong)){
                        System.out.println("Song was added");
                        if (newline.checkFreeDuration()){
                            System.out.println("Currently pay content is less that 50%");
                        } else{
                            System.out.println("Currently pay content is more that 50%");
                        }
                    } else {
                        System.out.println("This song can't be added, because free stream duration is less that song duration.");
                    }

                } else if (input == 2) {
                    String product;
                    int duration;

                    System.out.println("Please enter product name:");
                    product = scanner2.nextLine();
                    System.out.println("Please enter advertisement duration in seconds:");
                    duration = scanner.nextInt();
                    Advertisement newAdvertisement = new Advertisement(product, duration);

                    if (newline.addContent(newAdvertisement)){
                        System.out.println("Advertisement was added");

                        if (newline.checkFreeDuration()){
                            System.out.println("Currently pay content is less that 50%");
                        } else{
                            System.out.println("Currently pay content is more that 50%");
                        }
                    } else {
                        System.out.println("This advertisement can't be added, because free stream duration is less that advertisement duration.");
                    }

                } else if (input == 3) {
                    String interviewee;
                    int duration;

                    System.out.println("Please enter interviewee name:");
                    interviewee = scanner2.nextLine();
                    System.out.println("Please enter interview duration in seconds:");
                    duration = scanner.nextInt();
                    Interview newInterview = new Interview(interviewee,duration);

                    if (newline.addContent(newInterview)){
                        System.out.println("Interview was added");
                        if (newline.checkFreeDuration()){
                            System.out.println("Currently pay content is less that 50%");
                        } else{
                            System.out.println("Currently pay content is more that 50%");
                        }
                    } else {
                        System.out.println("This interview can't be added, because free stream duration is less that interview duration.");
                    }
                }


            } else if (input == 2){
                adding = false;
            }
        }

        if (newline.checkFreeDuration()){
            history.add(newline);
            System.out.println("Stream was saved successful under #" + history.size());
        } else {
            System.out.println("Current stream cant be saved, because of pay content is more than 50%");
        }
        //scanner.close();
        //scanner2.close();
        mainMenu();
    }

    public static void printStreamMenu(){
        System.out.println("Please enter stream number: ");

        //Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input<history.size()){
            System.out.println("Stream #" + input);
            System.out.println(history.get(input));
        } else {
            System.out.println("No such stream found");
        }

        //scanner.close();
        mainMenu();
    }

    private static void printStreamProfit() {
        System.out.println("Please enter stream number: ");

        //Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input<history.size()){
            System.out.println("Profit received from stream #" + input + " is:");
            System.out.println(history.get(input).getProfit());
        } else {
            System.out.println("No such stream found");
        }

        //scanner.close();
        mainMenu();
    }


    public static void printStreamsMenu(){
        System.out.println("All available streams list:");
        for(int i=0; i<history.size();i++){
            System.out.print(i + ": ");
            System.out.println(history.get(i));
        }
        mainMenu();
    }


    public static void broadcastersMenu(){
        System.out.println("Please select an action: \n 1. Create new broadcaster \n 2. View all available broadcasters \n 3. Add Stream to broadcaster");

        //Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1){
            addBroadcasterMenu();
        } else if (input == 2) {
            printBroadcasterMenu();
        } else if (input == 3) {
            updateBroadcasterMenu();
        } else {
            mainMenu();
        }
        //scanner.close();
    }



    private static void addBroadcasterMenu() {
        //Scanner scanner = new Scanner(System.in);
        //Scanner scanner2 = new Scanner(System.in);

        System.out.println("Please select broadcaster type\n 1. Local personal \n 2. Guest star");
        int input = scanner.nextInt();
        if (input == 1){
            String name;
            int experience;
            System.out.println("Please enter new broadcaster name");
            name = scanner2.nextLine();
            System.out.println("Please enter experience of this broadcaster in years");
            experience = scanner.nextInt();

            LocalBroadcaster broadcaster = new LocalBroadcaster(name, experience);
            personal.add(broadcaster);

            System.out.println("New broadcaster #" + personal.size()+ " was added");

        } else if (input == 2) {
            String name;
            String resume;
            System.out.println("Please enter new broadcaster name");
            name = scanner2.nextLine();
            System.out.println("Please enter short text resume");
            resume = scanner2.nextLine();

            GuestBroadcaster broadcaster = new GuestBroadcaster(name, resume);
            personal.add(broadcaster);

            System.out.println("New broadcaster #" + personal.size()+ " was added");

        }

        mainMenu();
        //scanner2.close();
        //scanner.close();
    }
    private static void printBroadcasterMenu() {
        System.out.println("All available streams list:");
        for(int i=0; i<personal.size();i++){
            System.out.print(i + ": ");
            System.out.println(personal.get(i));
        }
        mainMenu();
    }

    private static void updateBroadcasterMenu() {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter broadcaster number");
        int broadcasterN = scanner.nextInt();

        if (broadcasterN<personal.size()) {
            System.out.println("Selected broadcaster is:");
            System.out.println(personal.get(broadcasterN));

            System.out.println("Please enter stream number: ");

            int streamN = scanner.nextInt();

            if (streamN < history.size()) {
                System.out.println("Stream #" + streamN);
                System.out.println(history.get(streamN));

                personal.get(broadcasterN).addStream(streamN);
                System.out.println("Stream was added to current broadcaster");
            } else {
                System.out.println("No such stream found");
            }
        } else {
            System.out.println("No such broadcaster found");
        }

        //scanner.close();
        mainMenu();
    }
    public static void exit(){
        savePersonal();
        saveHistory();
        scanner.close();
        scanner2.close();
    }

}
