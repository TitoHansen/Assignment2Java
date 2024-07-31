package com.example.week10;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OMDBAPIService {
    private static final String API_KEY = "3dc94f1";
    private static final String SEARCH_URL = "https://omdbapi.com/?apikey=" + API_KEY + "&s=";

    public String searchMovies(String searchParam) throws IOException, InterruptedException {
        // Encode the search parameter
        String encodedSearchParam = URLEncoder.encode(searchParam, StandardCharsets.UTF_8);

        // Construct the URL for the API call
        String apiUrl = SEARCH_URL + encodedSearchParam;

        // Create a HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

        // Send the request and handle the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body
        return response.body();
    }

    public static void main(String[] args) {
        OMDBAPIService omdbapiService = new OMDBAPIService();
        try {
            // Example search parameter
            String searchParam = "";
            // Make the API call
            String response = omdbapiService.searchMovies(searchParam);
            // Print the response
            System.out.println(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

