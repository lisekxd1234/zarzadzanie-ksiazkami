import java.io.Serializable;
import java.util.List;

public record Book(
        String title,
        String subtitle,
        List<String> authors,
        int releaseYear,
        String publisher,
        String isbn,
        int pageCount,
        String language,
        String genre,
        String format,
        String description
) implements Serializable {
}