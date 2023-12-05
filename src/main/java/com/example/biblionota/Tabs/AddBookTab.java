package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.*;
import com.example.biblionota.tables.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


/**
 * AddBookTab Class extends Tab
 */
public class AddBookTab extends Tab {

    private static AddBookTab instance;

    private AddBookTab(){
        this.setText("Add Book");
        GridPane root = new GridPane();
        BorderPane pane = new BorderPane();

        ObservableList<Integer> rating = FXCollections.observableArrayList(1, 2, 3, 4, 5);

        TagTable tagTable = TagTable.getInstance();
        BookTable bookTable = BookTable.getInstance();
        AuthorTable authorTable = AuthorTable.getInstance();
        ReviewTable reviewTable = ReviewTable.getInstance();
        GenreTable genreTable = GenreTable.getInstance();
        FormatTable formatTable = FormatTable.getInstance();
        BookTagTable bookTagTable = BookTagTable.getInstance();
        BookAuthorTable bookAuthorTable = BookAuthorTable.getInstance();

        Text bookTxt = new Text("Book Title: ");
        TextField bookTxtField = new TextField("Book name");
        root.add(bookTxt, 0, 0);
        root.add(bookTxtField, 1, 0);

        Text isbnTxt = new Text("ISBN: ");
        TextField isbnTxtField = new TextField("136932506");
        root.add(isbnTxt, 0, 1);
        root.add(isbnTxtField, 1, 1);

        Text pagesTxt = new Text("Pages:");
        TextField pagesTxtField = new TextField("100");
        root.add(pagesTxt, 0, 2);
        root.add(pagesTxtField, 1,2);

        Label startDateLbl = new Label("Date Started: ");
        DatePicker dateStartedPicker = new DatePicker();
        root.add(startDateLbl, 0, 3);
        root.add(dateStartedPicker, 1, 3);


        Label finishDateLbl = new Label("Date Finished: ");
        DatePicker dateFinishedPicker = new DatePicker();
        root.add(finishDateLbl, 0, 4);
        root.add(dateFinishedPicker, 1, 4);

        Label genreLbl = new Label("Genre: ");
        ComboBox<Genre> addGenreCombo = new ComboBox<>();
        addGenreCombo.setItems(FXCollections.observableArrayList(genreTable.getAllGenres().get(1)));
        root.add(genreLbl, 0, 5);
        root.add(addGenreCombo, 1, 5);

        Text formatTxt = new Text("Format");
        ComboBox bookFormatCombo = new ComboBox(FXCollections.observableArrayList(formatTable.getAllFormats().get(1)));
        root.add(formatTxt, 0, 6);
        root.add(bookFormatCombo, 1, 6);

        Text isbn = new Text("ISBN: ");
        TextField fillIsbn = new TextField("136932506");
        root.add(isbn, 0, 1);
        root.add(fillIsbn, 1, 1);

        Label reviewLbl = new Label("Review: ");
        TextArea reviewTxtArea = new TextArea("This is a review");
        root.add(reviewLbl, 0, 7);
        root.add(reviewTxtArea, 1, 7);

        Label starRatingLbl = new Label("Star Rating (1-5): ");
        ComboBox bookRating = new ComboBox(rating);
        root.add(starRatingLbl, 0, 8);
        root.add(bookRating, 1, 8);

        Label authorLbl = new Label("Author: ");
        TextField authorTxtField = new TextField("Author name");
        root.add(authorLbl, 0, 9);
        root.add(authorTxtField, 1, 9);


        //Using Listview that holds all the created tags to populate an empty listview that will add the tags to the new book
        //Created a transfer and remove tag button to toggle between the two views
        Label tagLabel = new Label("Tag: ");
        final ListView<Tag> tagNames = new ListView<>(FXCollections.observableArrayList(tagTable.getAllTags()));
        final ListView<Tag> addTagListView = new ListView<>();
        tagNames.prefWidth(100);
        root.add(tagLabel, 0, 10);
        root.add(addTagListView, 1,10);
        pane.setRight(tagNames);

        Button transfer = new Button("<");
        transfer.setOnAction(e->{
            ObservableList<Tag> selectedTag = tagNames.getSelectionModel().getSelectedItems();
            if(!selectedTag.isEmpty()){
                addTagListView.getItems().addAll(selectedTag);
                //Remove selected tag from list
                tagNames.getItems().removeAll(selectedTag);
            }
        });

        Button returnTag = new Button(">");
        returnTag.setOnAction(e->{
            ObservableList<Tag> selectedTag = addTagListView.getSelectionModel().getSelectedItems();
           if(!selectedTag.isEmpty()){
               tagNames.getItems().addAll(selectedTag);
               //repopulate selected tag into original list
               addTagListView.getItems().removeAll(selectedTag);
           }
        });

        root.add(returnTag, 20, 10);
        root.add(transfer, 19, 10);
        Label addNewTagLbl = new Label("Create Tag");
        TextField newTagTxtField = new TextField();
        root.add(addNewTagLbl, 0, 11);
        root.add(newTagTxtField, 1,11);

        //Allows user to input a new tag name and populate it in the addTag list.
        //It will be added to the tagTable when book is created
        Button createTagBtn = new Button("Add Tag ^");
        createTagBtn.setOnAction(e ->{
            Tag newTagName = new Tag(newTagTxtField.getText());
            if(newTagTxtField != null){
                addTagListView.getItems().add(newTagName);
                newTagTxtField.clear();
            }
        });
        root.add(createTagBtn, 2,11);

        Button submitBtn = new Button("Add Book!");
        //This button actions adds all filled out entries into its respective tables
        /**
         * In the submit button
         * grab the review and insert a review into the review table
         * use last_insert_id to grab the id of that review
         * insert book and use review id
         */
        submitBtn.setOnAction(e ->{

            Review review1 = new Review(
                    reviewTxtArea.getText(),

                    Integer.parseInt(String.valueOf(bookRating.getSelectionModel().getSelectedItem())));
            reviewTable.createReview(review1);

            Book book = new Book(
                    bookTxtField.getText(),
                    Integer.parseInt(isbnTxtField.getText()),
                    Integer.parseInt(pagesTxtField.getText()),
                    dateStartedPicker.getValue().toString(),
                    dateFinishedPicker.getValue().toString(),
                    addGenreCombo.getSelectionModel().getSelectedItem().getId(),
                    ((Format) bookFormatCombo.getSelectionModel().getSelectedItem()).getId(),
                    reviewTable.getLastId());

            bookTable.createBook(book);
            int bookLastId = bookTable.getLastId();

            Author author1 = new Author(authorTxtField.getText());
            authorTable.createAuthor(author1);
            int authorLastId = authorTable.getLastId();

            Tag tag1 = new Tag(addTagListView.getItems().toString());
            tagTable.createTag(tag1);
            int tagLastId = tagTable.getLastId();

            BookTag bookTag = new BookTag(bookLastId, tagLastId);
            bookTagTable.createJunction(bookTag);

            BookAuthor bookAuthor = new BookAuthor(bookLastId, authorLastId);
            bookAuthorTable.createJunction(bookAuthor);
            System.out.println("Book Added");

            MyBooksTab.getInstance().refreshTable();
        });
        root.add(submitBtn, 0, 12);

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
