package baeldung.threadsafety.immutableimplementations_2;

// Message service is immutable, because their state can not be change
public class MessageService {

    private final String message;

    public MessageService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}