module com.espol.ed.tresenrayaedg5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.espol.ed.tresenrayaedg5 to javafx.fxml;
    exports com.espol.ed.tresenrayaedg5;
}
