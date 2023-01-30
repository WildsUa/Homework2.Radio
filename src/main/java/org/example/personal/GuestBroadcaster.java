package org.example.personal;

public class GuestBroadcaster extends Broadcaster {
    public GuestBroadcaster(String name) {
        super(name);
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public GuestBroadcaster(String name, String resume) {
        super(name);
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "GuestBroadcaster{" +
                "name='" + name + '\'' +
                ", Streams of this broadcaster on this radio=" + streams + '\'' +
                ", resume of guest broadcaster='" + resume +
                '}';
    }

    String resume;
}
