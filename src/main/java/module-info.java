module org.gennisilv.smartplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens org.gennisilv.smartplanner to javafx.fxml;
    exports org.gennisilv.smartplanner;
    exports org.gennisilv.smartplanner.data;
    opens org.gennisilv.smartplanner.data to javafx.fxml;
    exports org.gennisilv.smartplanner.utils;
    opens org.gennisilv.smartplanner.utils to javafx.fxml;
}