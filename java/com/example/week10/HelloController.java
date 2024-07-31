package com.example.week10;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label mPlot;
    @FXML
    private Label mDirector;
    @FXML
    private BorderPane anchorPane;
    @FXML
    private HBox borderPane;
    @FXML
    private Button btnSearch;
    @FXML
    private Label errMsgLabel;
    @FXML
    private Label label_id;
    @FXML
    private Label mTitle;
    @FXML
    private Label mYear;
    @FXML
    private ImageView posterImageView;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label imdbID;

    public void getSearchResults() {
        OMDBAPIService omdbService = new OMDBAPIService();
        try {
            // Example search parameter
            String searchTerm = searchTextField.getText();
            String searchParam = searchTerm;
            System.out.println(searchParam);
            // Make the API call
            String jsonInput = omdbService.searchMovies(searchParam);
            // Print the response
            System.out.println(jsonInput);
            System.out.println(jsonInput.getClass());

            Gson gson = new Gson();
            // Parse JSON string to SearchResult object
            SearchResult searchResult = new Gson().fromJson(jsonInput, SearchResult.class);

            // Print the response
            System.out.println(searchResult);
            System.out.println(searchResult.getClass());

            int i = 0;
            // Access individual movie elements and print
            for (Movie movie : searchResult.getSearch()){
                if (i == 0) {
                    System.out.println("Title: " + movie.getTitle());
                    System.out.println("Year: " + movie.getYear());
                    System.out.println("imdbID: " + movie.getImdbID());
                    System.out.println("Type: " + movie.getType());
                    System.out.println("Poster: " + movie.getPoster());
                    System.out.println("");
                    i++;

                    // Title
                    mTitle.setText(movie.getTitle());

                    // Year
                    mYear.setText(movie.getYear());

                    // Director
                    mDirector.setText(movie.getDirector());

                    // Plot
                    imdbID.setText(movie.getImdbID());


                    errMsgLabel.setText(movie.getType());

                    // Image
                    String imageUrl = movie.getPoster();
                    this.setPosterImage(imageUrl);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Method to set image for posterImageView
    public void setPosterImage(String imageUrl) {
        Image image = new Image(imageUrl);
        posterImageView.setImage(image);
    }
}
