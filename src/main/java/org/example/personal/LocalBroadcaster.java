package org.example.personal;

public class LocalBroadcaster extends Broadcaster {
    public LocalBroadcaster(String name) {
        super(name);
    }
    int experience;

    @Override
    public String toString() {
        return "LocalBroadcaster{" +
                "name='" + name + '\'' +
                ", Streams of this broadcaster on this radio=" + streams + '\'' +
                ", experience on radio=" + experience + " years" +
                '}';
    }

    public LocalBroadcaster(String name, int experience) {
        super(name);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
