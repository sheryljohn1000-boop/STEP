interface Notification {
    void send(String message, String student);
}

class Email implements Notification {
    public void send(String message, String student) {
        System.out.println("Email to " + student + ": " + message);
    }
}

class SMS implements Notification {
    public void send(String message, String student) {
        System.out.println("SMS to " + student + ": " + message);
    }
}

class AppNotification implements Notification {
    public void send(String message, String student) {
        System.out.println("App notification to " + student + ": " + message);
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        Notification email = new Email();
        Notification sms = new SMS();
        Notification app = new AppNotification();

        String notice = "College will remain closed tomorrow.";

        email.send(notice, "Asha");
        sms.send(notice, "Ravi");
        app.send(notice, "Neha");
    }
}