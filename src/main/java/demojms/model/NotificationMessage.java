package demojms.model;

import java.io.Serializable;



public class NotificationMessage implements Serializable {

    public String message;

    public NotificationMessage(String message) {
        this.message = message;
    }

    public NotificationMessage() {
    }

    public String getGetMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
