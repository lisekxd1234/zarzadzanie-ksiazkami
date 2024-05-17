import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class DoubleClickAdapter extends MouseAdapter {

    private final Consumer<MouseEvent> callback;

    public DoubleClickAdapter(Consumer<MouseEvent> callback) {
        this.callback = callback;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            this.callback.accept(e);
        }
    }
}
