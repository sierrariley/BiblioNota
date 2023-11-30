package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.Format;
import com.example.biblionota.pojo.Genre;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.FormatTable;
import com.example.biblionota.tables.GenreTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;

public class GraphTab extends Tab {
    private static GraphTab instance;

    private final PieChart pieChart;

    private final LineChart<String, Number> lineChart;
    private final BarChart<String, Number> barChart;

    private ScatterChart scatterChart;



    private GraphTab() {
        this.setText("Graphs");
        BorderPane root = new BorderPane();

        //Chart 2
        pieChart = new PieChart();
        pieChart.setTitle("Genres");
        pieChart.setLabelsVisible(true);

        //Chart 1
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("# of Books Read");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Months");
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Books Read Over Months");
        lineChart.setLegendVisible(false);

        //Chart 3
        NumberAxis yAxisBar = new NumberAxis();
        yAxisBar.setLabel("# of Books Read");
        CategoryAxis xAxisBar = new CategoryAxis();
        xAxisBar.setLabel("Formats");
        barChart = new BarChart<>(xAxisBar, yAxisBar);
        barChart.setLegendVisible(false);


        root.setTop(lineChart);
        root.setLeft(barChart);
        root.setCenter(pieChart);
//        root.setRight();

        generateGenreChart();
        generateBooksPerMonthChart();
        generateStylesReadChart();
        generateLengthOfBooksChart();

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
        for (int i = 0; i < months.length; i++) {
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
            double count = book.getGenreCount(genre.getId());
            if (count > 0) {
                data.add(new PieChart.Data(genre.getName(), count));
            }
        }

        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(data);
        pieChart.setData(chartData);
    }

    //Chart 3 - Style of Books (Bar)
    public void generateStylesReadChart() {
        BookTable book = BookTable.getInstance();
        FormatTable formatTable = FormatTable.getInstance();

        ArrayList<Format> formats = formatTable.getAllFormats();

        ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();

        for (Format format: formats) {
            double count = book.getFormatCount(format.getId());
            if (count > 0) {
                data.add(new XYChart.Data<>(format.getType(), count));
            }
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>(data);
        barChart.getData().add(series);
    }

    public static GraphTab getInstance(){
        if (instance == null) {
            instance = new GraphTab();
        }
        return instance;
    }
}
