import reactor.bus.Event;
import reactor.fn.Consumer;

public class NotificationConsumer implements Consumer<Event<NotificationData>> {

    private NotificationService notificationService;

    @Override
    public void accept(Event<NotificationData> notificationDataEvent) {
        NotificationData notificationData = notificationDataEvent.getData();

        try {
            notificationService.initiateNotification(notificationData);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}