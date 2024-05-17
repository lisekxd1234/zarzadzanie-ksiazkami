import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Application {

    private List<Book> books;

    private JComboBox<String> sorting;

    private JTextField search;

    private DefaultListModel<JPanel> bookList;

    public Application() {
        this.loadBooks();
    }

    private void loadBooks() {
        try (var file = new FileInputStream("books.data");
             var in = new ObjectInputStream(file)) {
            this.books = (ArrayList<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException ignored) {
            this.books = new ArrayList<>();
            this.books.add(new Book("Pan Tadeusz", "czyli Ostatni zajazd na Litwie", List.of("Adam Mickiewicz"), 1834, "Drukarnia i Księgarnia J. Zawadzkiego", "1234567890", 340, "Polski", "Epika", "Twarda okładka", "Epika osadzona w XIX-wiecznej Litwie"));
            this.books.add(new Book("Lalka", "", List.of("Bolesław Prus"), 1890, "Gebethner i Wolff", "1234567891", 480, "Polski", "Powieść", "Twarda okładka", "Realistyczna powieść o warszawskim społeczeństwie XIX wieku"));
            this.books.add(new Book("Quo Vadis", "", List.of("Henryk Sienkiewicz"), 1896, "Gebethner i Wolff", "1234567892", 640, "Polski", "Powieść historyczna", "Twarda okładka", "Historia miłości na tle prześladowań pierwszych chrześcijan"));
            this.books.add(new Book("Ferdydurke", "", List.of("Witold Gombrowicz"), 1937, "Rój", "1234567893", 320, "Polski", "Powieść", "Twarda okładka", "Groteskowa powieść o dorastaniu i formowaniu"));
            this.books.add(new Book("Noce i dnie", "", List.of("Maria Dąbrowska"), 1934, "Czytelnik", "1234567894", 760, "Polski", "Powieść", "Twarda okładka", "Saga rodzinna osadzona w okresie zaborów"));
            this.books.add(new Book("Solaris", "", List.of("Stanisław Lem"), 1961, "Wydawnictwo MON", "1234567895", 300, "Polski", "Fantastyka naukowa", "Twarda okładka", "Kontemplacyjna powieść o kontaktach z obcą cywilizacją"));
            this.books.add(new Book("Inna dusza", "", List.of("Łukasz Orbitowski"), 2015, "Od deski do deski", "1234567896", 352, "Polski", "Powieść", "Twarda okładka", "Mroczna historia o dorastaniu w latach 90."));
            this.books.add(new Book("Święto ognia", "", List.of("Jakub Małecki"), 2020, "SQN", "1234567897", 320, "Polski", "Powieść", "Twarda okładka", "Intymna opowieść o rodzinie i przeszłości"));
            this.books.add(new Book("Sydonia. Słowo się rzekło", "", List.of("Magdalena Starzycka"), 2019, "W.A.B.", "1234567898", 400, "Polski", "Powieść historyczna", "Twarda okładka", "Historia ostatniej czarownicy Pomorza"));
            this.books.add(new Book("Matka Królów", "", List.of("Kazimierz Brandys"), 1957, "Czytelnik", "1234567899", 400, "Polski", "Powieść", "Twarda okładka", "Krytyczna powieść o życiu w PRL-u"));
            this.books.add(new Book("Miazga", "", List.of("Jerzy Andrzejewski"), 1981, "Czytelnik", "1234567800", 450, "Polski", "Powieść", "Twarda okładka", "Rozliczenie z okresem stalinizmu"));
            this.books.add(new Book("Moralność pani Dulskiej", "", List.of("Gabriela Zapolska"), 1906, "Gebethner i Wolff", "1234567801", 120, "Polski", "Dramat", "Twarda okładka", "Tragifarsa o mieszczańskiej hipokryzji"));
            this.books.add(new Book("Msza za miasto Arras", "", List.of("Andrzej Szczypiorski"), 1971, "Czytelnik", "1234567802", 160, "Polski", "Powieść", "Twarda okładka", "Parabola o totalitaryzmie"));
            this.books.add(new Book("Mury Hebronu", "", List.of("Andrzej Stasiuk"), 1992, "Wydawnictwo Czarne", "1234567803", 180, "Polski", "Powieść", "Twarda okładka", "Opowieść o życiu w więzieniu"));
            this.books.add(new Book("Myśli nieuczesane", "", List.of("Stanisław Jerzy Lec"), 1957, "Czytelnik", "1234567804", 300, "Polski", "Aforyzmy", "Twarda okładka", "Zbiór aforyzmów"));
            this.books.add(new Book("Pamiętnik z powstania warszawskiego", "", List.of("Miron Białoszewski"), 1970, "PIW", "1234567805", 300, "Polski", "Pamiętnik", "Twarda okładka", "Relacja z powstania warszawskiego"));
            this.books.add(new Book("Piękni dwudziestoletni", "", List.of("Marek Hłasko"), 1966, "Instytut Literacki", "1234567806", 250, "Polski", "Pamiętnik", "Twarda okładka", "Autobiograficzna opowieść o życiu literata"));
            this.books.add(new Book("Pod Mocnym Aniołem", "", List.of("Jerzy Pilch"), 2000, "Wydawnictwo Literackie", "1234567807", 280, "Polski", "Powieść", "Twarda okładka", "Kronika alkoholika"));
            this.books.add(new Book("Popiół i diament", "", List.of("Jerzy Andrzejewski"), 1948, "Czytelnik", "1234567808", 370, "Polski", "Powieść", "Twarda okładka", "Historia Polski w pierwszych dniach po II wojnie światowej"));
            this.books.add(new Book("Sól ziemi", "", List.of("Józef Wittlin"), 1935, "Rój", "1234567809", 280, "Polski", "Powieść", "Twarda okładka", "Powieść antywojenna"));
            this.books.add(new Book("Zdążyć przed Panem Bogiem", "", List.of("Hanna Krall"), 1977, "Czytelnik", "1234567810", 160, "Polski", "Reportaż", "Twarda okładka", "Relacja z powstania w getcie warszawskim"));
            this.books.add(new Book("Ziemia obiecana", "", List.of("Władysław Reymont"), 1899, "Gebethner i Wolff", "1234567811", 720, "Polski", "Powieść", "Twarda okładka", "Obraz industrialnej Łodzi"));
            this.books.add(new Book("Zły", "", List.of("Leopold Tyrmand"), 1955, "Czytelnik", "1234567812", 680, "Polski", "Powieść", "Twarda okładka", "Kryminał osadzony w Warszawie lat 50."));
            this.books.add(new Book("Zniewolony umysł", "", List.of("Czesław Miłosz"), 1953, "Instytut Literacki", "1234567813", 300, "Polski", "Esej", "Twarda okładka", "Analiza mechanizmów zniewolenia intelektualnego w systemach totalitarnych"));
            this.books.add(new Book("Przedwiośnie", "", List.of("Stefan Żeromski"), 1924, "Gebethner i Wolff", "1234567814", 460, "Polski", "Powieść", "Twarda okładka", "Powieść o odrodzeniu Polski"));
        }
    }

    private void saveBooks() {
        try (var file = new FileOutputStream("books.data");
             var out = new ObjectOutputStream(file)) {
            out.writeObject(books);
        } catch (IOException ignored) {
        }
    }

    public void show() {
        var frame = new JFrame("Książki");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        this.bookList = new DefaultListModel<>();

        var bookList = new JList<>(this.bookList);
        bookList.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            value.setBackground(isSelected ? Color.LIGHT_GRAY : list.getBackground());
            value.setOpaque(isSelected);
            return value;
        });

        bookList.addMouseListener(new DoubleClickAdapter((event) -> {
            int index = bookList.locationToIndex(event.getPoint());
            if (index >= 0) {
                showBook(books.get(index));
            }
        }));

        frame.add(new JScrollPane(bookList), BorderLayout.CENTER);

        var addButton = new JButton("Dodaj książkę");
        addButton.addActionListener((event) -> addBook());

        var removeButton = new JButton("Usuń książkę");
        removeButton.addActionListener((event) -> {
            int index = bookList.getSelectedIndex();
            if (index != -1) {
                books.remove(index);
                this.bookList.remove(index);
                this.saveBooks();
            }
        });

        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        this.sorting = new JComboBox<>(new String[]{
                "Sortuj po tytule",
                "Sortuj po podtytule",
                "Sortuj po roku wydania",
                "Sortuj po autorze"
        });
        this.sorting.setSelectedIndex(0);
        this.sorting.addActionListener(e -> this.updateList());

        this.search = new JTextField();
        this.search.getDocument().addDocumentListener(new Search((event) -> this.updateList()));

        var controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(this.search, BorderLayout.CENTER);
        controlPanel.add(this.sorting, BorderLayout.EAST);

        frame.add(controlPanel, BorderLayout.NORTH);

        this.updateList();

        frame.setVisible(true);
    }

    private void updateList() {
        String selectedItem = (String) this.sorting.getSelectedItem();
        Comparator<Book> comparator;

        switch (selectedItem) {
            case "Sortuj po podtytule":
                comparator = Comparator.comparing(Book::subtitle);
                break;
            case "Sortuj po roku wydania":
                comparator = Comparator.comparing(Book::releaseYear);
                break;
            case "Sortuj po autorze":
                comparator = Comparator.comparing(book -> book.authors().get(0));
                break;
            default:
                comparator = Comparator.comparing(Book::title);
        }

        try {
            var searchText = this.search.getText();
            var pattern = Pattern.compile(searchText, Pattern.CASE_INSENSITIVE);
            this.search.setForeground(Color.BLACK);
            this.bookList.clear();

            this.books.sort(comparator);

            books
                    .stream()
                    .filter((book) ->
                            pattern.matcher(book.title()).find() ||
                                    pattern.matcher(book.subtitle()).find() ||
                                    book.authors().stream().anyMatch((author) -> pattern.matcher(author).find())
                    )
                    .forEach((book) -> this.bookList.addElement(this.createBookEntry(book)));
        } catch (PatternSyntaxException e) {
            search.setForeground(Color.RED);
        }
    }

    private JPanel createBookEntry(Book book) {
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        var titleLabel = new JLabel(book.title());
        titleLabel.setFont(new Font("Sans-serif", Font.BOLD, 16));
        panel.add(titleLabel);

        if (!book.subtitle().isEmpty()) {
            var subtitleLabel = new JLabel(book.subtitle());
            subtitleLabel.setFont(new Font("Sans-serif", Font.ITALIC, 15));
            panel.add(subtitleLabel);
        }

        var detailsLabel = new JLabel(String.format(
                "Autor: %s, Rok wydania: %d",
                String.join(",", book.authors()), book.releaseYear()
        ));

        panel.add(detailsLabel);
        return panel;
    }

    private void addBook() {
        var addFrame = new JFrame("Dodawanie książki");
        addFrame.setSize(300, 400);
        addFrame.setLayout(new GridLayout(0, 2));

        var titleField = new JTextField();
        var subtitleField = new JTextField();
        var authorsField = new JTextField();
        var yearField = new JTextField();
        var publisherField = new JTextField();
        var isbnField = new JTextField();
        var pageCountField = new JTextField();
        var languageField = new JTextField();
        var genreField = new JTextField();
        var formatField = new JTextField();
        var descriptionField = new JTextField();

        addFrame.add(new JLabel("Tytuł:"));
        addFrame.add(titleField);
        addFrame.add(new JLabel("Podtytuł:"));
        addFrame.add(subtitleField);
        addFrame.add(new JLabel("Autorzy (po przecinku):"));
        addFrame.add(authorsField);
        addFrame.add(new JLabel("Rok wydania:"));
        addFrame.add(yearField);
        addFrame.add(new JLabel("Wydawca:"));
        addFrame.add(publisherField);
        addFrame.add(new JLabel("ISBN:"));
        addFrame.add(isbnField);
        addFrame.add(new JLabel("Liczba stron:"));
        addFrame.add(pageCountField);
        addFrame.add(new JLabel("Język:"));
        addFrame.add(languageField);
        addFrame.add(new JLabel("Gatunek:"));
        addFrame.add(genreField);
        addFrame.add(new JLabel("Format:"));
        addFrame.add(formatField);
        addFrame.add(new JLabel("Opis:"));
        addFrame.add(descriptionField);

        var saveButton = new JButton("Zapisz");
        saveButton.addActionListener((event) -> {
            try {
                var title = titleField.getText();
                var subtitle = subtitleField.getText();
                var authors = List.of(authorsField.getText().split(","));
                var releaseDate = Integer.parseInt(yearField.getText());
                var publisher = publisherField.getText();
                var isbn = isbnField.getText();
                var pageCount = Integer.parseInt(pageCountField.getText());
                var language = languageField.getText();
                var genre = genreField.getText();
                var format = formatField.getText();
                var description = descriptionField.getText();

                var newBook = new Book(title, subtitle, authors, releaseDate, publisher, isbn, pageCount, language, genre, format, description);

                books.add(newBook);
                this.saveBooks();
                this.updateList();
                addFrame.dispose();
            } catch (NumberFormatException e) {
                JDialog errorDialog = new JDialog();
                errorDialog.setTitle("Niepoprawne dane");
                errorDialog.setSize(300, 100);
                errorDialog.setModal(true);
                errorDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
                errorDialog.add(new JLabel("Wprowadzone dane nie są poprawne"));
                errorDialog.setVisible(true);
            }
        });

        addFrame.add(new JLabel());
        addFrame.add(saveButton);

        addFrame.setVisible(true);
    }

    private static void showBook(Book book) {
        var detailsFrame = new JFrame("Informacje o książce");
        detailsFrame.setSize(300, 400);
        detailsFrame.setLayout(new GridLayout(0, 1));

        detailsFrame.add(new JLabel("Tytuł: " + book.title()));
        detailsFrame.add(new JLabel("Podtytuł: " + book.subtitle()));
        detailsFrame.add(new JLabel("Autorzy: " + String.join(", ", book.authors())));
        detailsFrame.add(new JLabel("Rok publikacji : " + book.releaseYear()));
        detailsFrame.add(new JLabel("Wydawca: " + book.publisher()));
        detailsFrame.add(new JLabel("ISBN: " + book.isbn()));
        detailsFrame.add(new JLabel("Liczba stron: " + book.pageCount()));
        detailsFrame.add(new JLabel("Język: " + book.language()));
        detailsFrame.add(new JLabel("Gatunek: " + book.genre()));
        detailsFrame.add(new JLabel("Format: " + book.format()));
        detailsFrame.add(new JLabel("Opis: " + book.description()));

        detailsFrame.setVisible(true);
    }
}
