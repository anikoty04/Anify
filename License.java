import java.time.LocalDate;
import java.time.Period;

public class License {
    private Period subscriptionDuration; //Time we have the subscription
    private  LocalDate start; //Day we start with the subscription
    private LocalDate end; //Day we end with the subscription
    private boolean active; //Identify if the license is active or not

    //Make the empty constructor
    public License() {
        subscriptionDuration = Period.ZERO; //default subscription be 0
        start = null; //default there's no start date
        end = null; //default there's no end date
        active = false; //default the license is desactivate
    }
    //Make the main constructor with exceptions
    
    public License(Period subscriptionDuration, LocalDate start, LocalDate end, boolean active) {
        if (subscriptionDuration.isNegative()) {
            throw new IllegalArgumentException("Duration can´t be negative");
        }
        if (start == null) {
            throw new IllegalArgumentException("Start date is needed");
        }
        if (end == null) {
            throw new IllegalArgumentException("End date is needed");
        }
        this.subscriptionDuration = subscriptionDuration; //Time we have the subscription
        this.start = start; //Start date of subscription
        this.end = end; //End date of subscription
        this.active = true; //License is active now
    }
    public Period getSubscriptionDuration() { //To get the duration of the license
        return subscriptionDuration;
    }
    public LocalDate getStart() {  //To get the start date
        return start;
    }
    public LocalDate getEnd() { //To get the end date
        return end;
    }
    public boolean active() { //To get if the license is active or not
        return active;
    }
    public void setSubscriptionDuration(Period subscriptionDuration) { //To change the duration of the subscription 
        this.subscriptionDuration = subscriptionDuration;
    }
    public void setStart(LocalDate start) { //To change the start date of the license
        this.start = start;
    }
    public void setEnd(LocalDate end) { //To change the end date of the license
        this.end = end;
    }
    public void setActive(boolean active) { //To change if the license is active or not
        this.active = active;
    }


}
