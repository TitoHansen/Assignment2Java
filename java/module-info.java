module com.example.week10 {
    // Required for JavaFX applications
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Required for HTTP client functionalities
    requires java.net.http;

    // Required for JSON parsing
    requires com.google.gson;

    // Additional libraries used
    requires org.controlsfx.controls; // For additional JavaFX controls
    requires org.kordamp.bootstrapfx.core; // For BootstrapFX styling

    // Opening package for reflection, needed by JavaFX and Gson
    opens com.example.week10 to javafx.fxml, javafx.graphics, com.google.gson;

    // Exporting the package for other modules to use
    exports com.example.week10;
}
