package ehu.isad.controllers.ui;
import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Mezuak;
import ehu.isad.controllers.db.MezuakDBkudeatzaile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MainKud {

    @FXML
    private TableView<Mezuak> tabla;

    @FXML
    private TableColumn<?, ?> nork;

    @FXML
    private TableColumn<?, ?> nori;

    @FXML
    private TableColumn<?, ?> mezua;

    @FXML
    private Button btn_gorde;

    @FXML
    void onClick(ActionEvent event) {

    }

    private static MainKud instance=new MainKud();

    private MainKud() {}

    public static MainKud getInstance() {
        return instance;
    }
   //private final ObservableList<Mezuak> model = FXCollections.observableArrayList(MezuakDBkudeatzaile.getInstance().getFromDB());

    @FXML
    void initialize() {
       // nork.setCellValueFactory(new PropertyValueFactory<>("fromUser"));
       // nori.setCellValueFactory(new PropertyValueFactory<>("toUser"));
       // mezua.setCellValueFactory(new PropertyValueFactory<>("message"));
       // tabla.setItems(model);



    }
}
