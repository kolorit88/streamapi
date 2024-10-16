import lombok.*;

@ToString
public class Sms {
    String phoneNumber;
    String message;
    public Sms(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}