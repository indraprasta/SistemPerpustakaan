package perpustakaan.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LaporanController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton back;
	
	@FXML
    private JFXCheckBox cb_Kunjungan;

    @FXML
    private JFXCheckBox cb_Peminjaman;

    @FXML
    private JFXCheckBox cb_Pengembalian;

    @FXML
    private JFXDatePicker date_laporan;

    @FXML
    private JFXButton buttonProses;

    @FXML
    private JFXTreeTableView<?> table_Kunjungan;

    @FXML
    private JFXTreeTableView<?> table_Peminjaman;

    @FXML
    private JFXTreeTableView<?> table_Pengembalian;

    @FXML
    private JFXButton buttonCetak;

    @FXML
    void cetakLaporan(ActionEvent event) {

    }

    @FXML
    void checked_Kunjungan(ActionEvent event) {

    }

    @FXML
    void checked_Peminjaman(ActionEvent event) {

    }

    @FXML
    void checked_Pengembalian(ActionEvent event) {

    }

    @FXML
    void prosesLaporan(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        anchor.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent parent = loader.load();
        anchor.getChildren().add(parent);
    }

}
