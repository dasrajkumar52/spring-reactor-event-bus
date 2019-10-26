import reactor.bus.Event;
import reactor.bus.EventBus;

public class NotificationController {

    //@Autowired
    private EventBus eventBus;

    //@GetMapping("/startNotification/{param}")
    public void startNotification(/*@PathVariable*/ Integer param) {
        for (int i = 0; i < param; i++) {
            NotificationData data = new NotificationData();
            data.setId(i);

            eventBus.notify("notificationConsumer", Event.wrap(data));

            System.out.println(
                    "Notification " + i + ": notification task submitted successfully");
        }
    }
}
