package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.Genre;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.GenreTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Locale;

public class GraphTab extends Tab {
    private static GraphTab instance;

    private PieChart pieChart;

    private NumberAxis yAxis;
    private CategoryAxis xAxis;
    private LineChart<String, Number> lineChart;

    private BarChart barChart;
    private ScatterChart scatterChart;



    private GraphTab() {
        this.setText("Graphs");
        BorderPane root = new BorderPane();

        //Chart 1
        pieChart = new PieChart();
        pieChart.setTitle("Genres");
        pieChart.setLabelsVisible(true);

        //Chart 2
        yAxis = new NumberAxis();
        yAxis.setLabel("# of Books Read");
        xAxis = new CategoryAxis();
        xAxis.setLabel("Months");
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Books Read");







        // [] []
        // [] []
        //  btn
        root.setTop(lineChart);
        root.setCenter(pieChart);

        Button refresh = new Button("Refresh");
        refresh.setOnAction(e->{
            generateGenreChart();
            generateBooksPerMonthChart();
            generateStylesReadChart();
            generateLengthOfBooksChart();
        });

        generateGenreChart();
        generateBooksPerMonthChart();
        generateStylesReadChart();
        generateLengthOfBooksChart();

        root.setBottom(refresh);

        this.setContent(root);
    }

    //Chart 1 - Books Read Per Month (Line Chart)
    public void generateBooksPerMonthChart() {
        //Set data for xAxis (Categories aka Months)
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] booksPerMonth = new int[13];

        BookTable bookTable = BookTable.getInstance();
        ArrayList<Book> books = bookTable.getAllBooks();

        //Set data for yAxis (Books Read each month)
        for (Book book: books ) {
            //Take dateFinished of book
            String dateFinished = book.getDate_finished();
            String myMonth = dateFinished.substring(5, 7);
            booksPerMonth[Integer.parseInt(myMonth)] ++;
            //Group based on myMonth and set as yValues
        }

        ObservableList<XYChart.Data<String, Number>> list = FXCollections.observableArrayList();
        for (int i = 0; i < months.length - 1; i++) {
            list.add(new XYChart.Data<>(months[i], booksPerMonth[i + 1]));
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>(list);

        //Set data for lineChart (xAxis, yAxis)
        lineChart.getData().add(series);
    }

    //Chart 2 - Genres of Books Read (Pie)
    public void generateGenreChart(){
        BookTable book = BookTable.getInstance();
        GenreTable genreTable = GenreTable.getInstance();

        //Grab a list of all genres
        ArrayList<Genre> genres = genreTable.getAllGenres();

        ArrayList<PieChart.Data> data = new ArrayList<>();
        for (Genre genre : genres) {
            double count = book.getItemCount(genre.getId());
            if (count > 0) {
                data.add(new PieChart.Data(genre.getName(), count));
            }
        }

        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(data);
        pieChart.setData(chartData);
    }

    //Chart 3 - Style of Books (Bar)
    public void generateStylesReadChart() {

    }

    //Chart 4 - Average Length of Books
    public void generateLengthOfBooksChart() {

    }




    public static GraphTab getInstance(){
        if (instance == null) {
            instance = new GraphTab();
        }
        return instance;
    }
}
