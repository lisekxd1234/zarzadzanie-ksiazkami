import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.function.Consumer;

public class Search implements DocumentListener {
    private final Consumer<DocumentEvent> callback;

    public Search(Consumer<DocumentEvent> callback) {
        this.callback = callback;
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        this.callback.accept(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.callback.accept(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.callback.accept(e);
    }
}
