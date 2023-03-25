module com.example.hooscarclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.hooscarclient to javafx.fxml;
    exports com.example.hooscarclient;
}