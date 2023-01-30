package org.example.radio;

public class Interview extends Content {

    String interviewee;
    private final int price = 30;

    public Interview(String interviewee, int time) {
        this.interviewee = interviewee;
        setTime(time);
    }

    public String getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(String interviewee) {
        this.interviewee = interviewee;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "interviewee='" + interviewee + '\'' +
                ", length='" + findTime() + '\'' +
                '}';
    }

    @Override
    public int getCost(){
        return getMinutes()*price;
    }

}
