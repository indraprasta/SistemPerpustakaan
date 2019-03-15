package perpustakaan.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PengembalianController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton back;

    @FXML
    private JFXTreeTableView<?> peminjamanTableView;

    @FXML
    private JFXTextField idAnggotaField;

    @FXML
    private Label idPeminjamanLabel;

    @FXML
    private Label nomorBukuLabel;

    @FXML
    private Label judulBukuLabel;

    @FXML
    private Label tglPeminjamanLabel;

    @FXML
    private Label keterlambatanLabel;

    @FXML
    private Label namaAnggotaLabel;

    @FXML
    private Label tkrPengembalianLabel;

    @FXML
    private JFXCheckBox telatCheckbox;

    @FXML
    private JFXCheckBox rusakCheckbox;

    @FXML
    private JFXCheckBox hilangCheckbox;

    @FXML
    private JFXButton simpanButton;

    @FXML
    private Label totalBayarLabel;

    @FXML
    void actionHandle(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        anchor.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent parent = loader.load();
        anchor.getChildren().add(parent);
    }

    @FXML
    void keyPressedHandle(KeyEvent event) {

    }

    @FXML
    void mousePressedHandle(MouseEvent event) {

    }

}
