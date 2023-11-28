package com.example.biblionota.Tabs;


import com.example.biblionota.pojo.*;
import com.example.biblionota.tables.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class AddBookTab extends Tab {

    private static AddBookTab instance;

    private AddBookTab(){
        this.setText("Add Book");
        GridPane root = new GridPane();
        BorderPane pane = new BorderPane();
        ObservableList<Integer> rating = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ObservableList<String> formatOptions = FXCollections.observableArrayList("Physical", "Audiobook", "Ebook");
        TagTable tagTable = TagTable.getInstance();
        BookTable bookTable = BookTable.getInstance();
        AuthorTable authorTable = AuthorTable.getInstance();
        ReviewTable reviewTable = ReviewTable.getInstance();
        GenreTable genreTable = GenreTable.getInstance();


        Text bookName = new Text("Book Title: ");
        TextField addBookName = new TextField();
        root.add(bookName, 0, 0);
        root.add(addBookName, 1, 0);


        Text isbn = new Text("ISBN: ");
        TextField fillIsbn = new TextField();
        root.add(isbn, 0, 1);
        root.add(fillIsbn, 1, 1);

        Text pages = new Text("Pages:");
        TextField numPages = new TextField();
        root.add(pages, 0, 2);
        root.add(numPages, 1,2);

        Label startDate = new Label("Date Started: ");
        DatePicker dateStarted = new DatePicker();
        root.add(startDate, 0, 3);
        root.add(dateStarted, 1, 3);

        Label finishDate = new Label("Date Finished: ");
        DatePicker dateFinished = new DatePicker();
        root.add(finishDate, 0, 4);
        root.add(dateFinished, 1, 4);

        Label genre = new Label("Genre: ");
//        TextField addGenre = new TextField();
        ComboBox<Genre> addGenre = new ComboBox<>();
        addGenre.setItems(FXCollections.observableArrayList(genreTable.getAllGenres()));
        root.add(genre, 0, 5);
        root.add(addGenre, 1, 5);

        Text format = new Text("Format");
        ComboBox bookFormat = new ComboBox(formatOptions);
        root.add(format, 0, 6);
        root.add(bookFormat, 1, 6);


        Label review = new Label("Review: ");
        TextArea addReview = new TextArea();
        root.add(review, 0, 7);
        root.add(addReview, 1, 7);

        Label starRating = new Label("Star Rating (1-5): ");
        ComboBox bookRating = new ComboBox(rating);
        root.add(starRating, 0, 8);
        root.add(bookRating, 1, 8);

        Label author = new Label("Author: ");
        TextField addAuthor = new TextField();
        root.add(author, 0, 9);
        root.add(addAuthor, 1, 9);


        /**
         * Using Listview that holds all the created tags to populate an empty listview that will add the tags to the new book
         * Created a transfer and remove tag button to toggle between the two views
         */
        Label tag = new Label("Tag: ");
        final ListView<Tag> tagName = new ListView<>(FXCollections.observableArrayList(tagTable.getAllTags()));
        final ListView<Tag> addTag = new ListView<>();
        tagName.prefWidth(100);
        root.add(tag, 0, 10);
        root.add(addTag, 1,10);
        pane.setRight(tagName);

        Button transfer = new Button("<");
        transfer.setOnAction(e ->{
            ObservableList<Tag> selectedTag = tagName.getSelectionModel().getSelectedItems();
            if(!selectedTag.isEmpty()){
                addTag.getItems().addAll(selectedTag);
                //Remove selected tag from list
                tagName.getItems().removeAll(selectedTag);
            }

        });
        Button returnTag = new Button(">");
        returnTag.setOnAction(e ->{
            ObservableList<Tag> selectedTag = addTag.getSelectionModel().getSelectedItems();
           if(!selectedTag.isEmpty()){
               tagName.getItems().addAll(selectedTag);
               //repopulate selected tag into original list
               addTag.getItems().removeAll(selectedTag);
           }

        });
        root.add(returnTag, 20, 10);
        root.add(transfer, 19, 10);
        Label addNewTag = new Label("Create Tag");
        TextField newTag = new TextField();
        root.add(addNewTag, 0, 11);
        root.add(newTag, 1,11);

        /**
         * Allows user to input a new tag name and populate it in the addTag list.
         * It will be added to the tagTable when book is created
         */
        Button createTag = new Button("Add Tag ^");
        createTag.setOnAction(e ->{
            Tag newTagName = new Tag(newTag.getText());
            if(newTag != null){
            addTag.getItems().add(newTagName);

            newTag.clear();
            }
        });
        root.add(createTag, 2,11);


        /**
         * This button actions adds all filled out entries into its respective tables
         */
        Button submit = new Button("Add Book!");
        submit.setOnAction(e ->{
            Book book = new Book(
                    addBookName.getText(),
                    Integer.parseInt(fillIsbn.getText()),
                    Integer.parseInt(numPages.getText()),
                    dateStarted.toString(),
                    dateFinished.toString(),
                    addGenre.getSelectionModel().getSelectedItem().getId(),
                    Integer.parseInt((String) bookFormat.getSelectionModel().getSelectedItem()),
                    Integer.parseInt(addReview.getText()));


            bookTable.createBook(book);
            Author author1 = new Author(addAuthor.getText());
            authorTable.createAuthor(author1);
            Tag tag1 = new Tag(addTag.getItems().toString());
            tagTable.createTag(tag1);
            System.out.println("Book added");
            Review starReview = new Review(Integer.parseInt(bookRating.getItems().toString()));
            reviewTable.createReview(starReview);

        });
        root.add(submit, 0, 12);

        pane.setCenter(root);
        this.setContent(pane);



    }


    public static AddBookTab getInstance(){
        if(instance == null){
            instance = new AddBookTab();
        }
        return instance;
    }
}
