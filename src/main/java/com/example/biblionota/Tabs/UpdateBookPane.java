package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.DatabaseBook;
import com.example.biblionota.pojo.Review;
import com.example.biblionota.pojo.Tag;
import com.example.biblionota.tables.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class UpdateBookPane extends GridPane {

    public static UpdateBookPane instance;

    /**
     * This is used to locate the index of  a book in a list
     * @param arrayList  list of books to search
     * @param id the desired id of an item in a list
     * @return
     */
    public int find(ArrayList<?> arrayList, int id){
        ArrayList<DatabaseBook> search = (ArrayList<DatabaseBook>) ((ArrayList<?>) arrayList);
        for(int i = 0; i < search.size(); i++){
            if(search.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }
    public UpdateBookPane(Book book){
        this.setPadding(new Insets(10,10,0,10));
        this.setVgap(10);
        this.setHgap(10);
        ObservableList<Integer> rating = FXCollections.observableArrayList(1, 2, 3, 4, 5);

        /*Tables*/
        BookTable bookTable = BookTable.getInstance();
        TagTable tagTable = TagTable.getInstance();
        ReviewTable reviewTable = ReviewTable.getInstance();

        Text tag = new Text("Tag:");
        ComboBox<Tag> tags = new ComboBox<>();
        this.add(tag, 0,0);
        tags.setItems(FXCollections.observableArrayList(tagTable.getAllTags()));
        this.add(tags, 1,0);

        Text reviewLabel = new Text("Review:");
        TextArea review = new TextArea();
        this.add(reviewLabel,0,1);
        ArrayList<Review> reviewArrayList = reviewTable.getAllReviews();
        if(book.getReview() != 0){
          for(Review bookReview: reviewArrayList){
              review.setText(bookReview.getDescription());
              break;
          }
        }
        this.add(review,1,1);

        Text starLabel = new Text("Star Rating:");
        ComboBox starRating = new ComboBox(rating);
        this.add(starLabel, 0, 2);
        this.add(starRating, 1, 2);



        Button update = new Button("Update Book!");
        update.setOnAction(e->{
            Review updatedReview = new Review(review.getText(), Integer.parseInt(String.valueOf(starRating.getSelectionModel().getSelectedItem())));
            reviewTable.updateReview(updatedReview);
            book.setReview(Integer.parseInt(review.getText()));
            Tag tag1 = new Tag(tags.getItems().toString());
            tagTable.updateTag(tag1);

        });
        this.add(update, 0,3);

    }

}
