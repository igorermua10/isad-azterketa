package ehu.isad.controllers.ui;
import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.Mezuak;
import ehu.isad.controllers.db.MezuakDBkudeatzaile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class MainKud implements Initializable {

    @FXML
    private TableView<Mezuak> tabla;

    @FXML
    private TableColumn<Mezuak, String> nork;

    @FXML
    private TableColumn<Mezuak, String> nori;

    @FXML
    private TableColumn<Mezuak, String> mezua;

    @FXML
    private Button btn_gorde;

    @FXML
    void onClick(ActionEvent event) {
        MezuakDBkudeatzaile.getInstance().gordeDatuBasean(model);

    }

    private static MainKud instance = new MainKud();

    private MainKud() {
    }

    public static MainKud getInstance() {
        return instance;
    }

    private final ObservableList<Mezuak> model = FXCollections.observableArrayList(MezuakDBkudeatzaile.getInstance().getFromDB());

    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.erakutsiMezuak();
        this.mezuEditagarriak();

        }

    public void erakutsiMezuak() {
        nork.setCellValueFactory(new PropertyValueFactory<>("nork"));
        nori.setCellValueFactory(new PropertyValueFactory<>("nori"));
        mezua.setCellValueFactory(new PropertyValueFactory<>("mezua"));
        tabla.setItems(model);
    }

    public void mezuEditagarriak() {
        tabla.setEditable(true);
        nork.setCellFactory(TextFieldTableCell.forTableColumn());
        nork.setOnEditCommit((TableColumn.CellEditEvent<Mezuak, String> event) -> {
            TablePosition<Mezuak, String> pos = event.getTablePosition();
            int row = pos.getRow();
            Mezuak mezuak = event.getTableView().getItems().get(row);
            String content = event.getNewValue();
            mezuak.setNork(content);
        });
        nori.setCellFactory(TextFieldTableCell.forTableColumn());
        nori.setOnEditCommit((TableColumn.CellEditEvent<Mezuak, String> event) -> {
            TablePosition<Mezuak, String> pos = event.getTablePosition();
            int row = pos.getRow();
            Mezuak mezuak = event.getTableView().getItems().get(row);
            String content = event.getNewValue();
            mezuak.setNori(content);
        });
        mezua.setCellFactory(TextFieldTableCell.forTableColumn());
        mezua.setOnEditCommit((TableColumn.CellEditEvent<Mezuak, String> event) -> {
            TablePosition<Mezuak, String> pos = event.getTablePosition();
            int row = pos.getRow();
            Mezuak mezuak = event.getTableView().getItems().get(row);
            String content = event.getNewValue();
            mezuak.setMezua(content);

        });

    }
}
