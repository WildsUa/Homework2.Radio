package org.example.radio;

public class Song extends Content {
    String name;
    String author;

    public Song(String name, String author, int time) {
        this.name = name;
        this.author = author;
        this.setTime(time);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", length='" + findTime() + '\'' +
                '}';
    }

    @Override
    public int getCost(){
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
