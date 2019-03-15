package perpustakaan.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.KeyCode;
import static perpustakaan.Format.DateFormat;
import perpustakaan.models.Anggota;

import static perpustakaan.models.Anggota.anggota;
import static perpustakaan.models.Buku.buku;
import perpustakaan.models.Peminjaman;
import static perpustakaan.models.Peminjaman.peminjamanNotReturnList;

public class PengembalianController implements Initializable{

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton back;

    @FXML
    private JFXTreeTableView<Peminjaman> peminjamanTableView;

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

    private final ObservableList<Peminjaman> peminjamanList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeTableColumn<Peminjaman, String> judulCol = new TreeTableColumn<>("Judul Buku");
        
        judulCol.setCellValueFactory(param -> buku(param.getValue().getValue()).judul_bukuProperty());
        
        judulCol.prefWidthProperty().bind(peminjamanTableView.prefWidthProperty());
        
        peminjamanTableView.getColumns().add(judulCol);
        
        TreeItem<Peminjaman> peminjamanRoot = new RecursiveTreeItem<>(peminjamanList, RecursiveTreeObject::getChildren);
        
        peminjamanTableView.setRoot(peminjamanRoot);
        peminjamanTableView.setShowRoot(false);
        
        rusakCheckbox.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue == true) {
                hilangCheckbox.setSelected(false);
            }
        });
        
        hilangCheckbox.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue == true) {
                rusakCheckbox.setSelected(false);
            }
        });
    }
    
    private Peminjaman peminjaman() {
        return peminjamanList.get(peminjamanTableView.getSelectionModel().getSelectedIndex());
    }
    
    private void pilihPeminjaman() {
        idPeminjamanLabel.setText(String.valueOf(peminjaman().getId_peminjaman()));
        nomorBukuLabel.setText(peminjaman().getNomor_buku());
        judulBukuLabel.setText(buku(peminjaman()).getJudul_buku());
        tglPeminjamanLabel.setText(DateFormat(peminjaman().getTgl_peminjaman()));
        tkrPengembalianLabel.setText(DateFormat(peminjaman().getExpired()));
        
        if (peminjaman().keterlambatan() > 0) {
            keterlambatanLabel.setText(peminjaman().keterlambatan()+" Hari");
            telatCheckbox.setSelected(true);
        } else {
            keterlambatanLabel.setText("-");
            telatCheckbox.setSelected(false);
        }
    }
    
    private void resetForm() {
        peminjamanList.clear();
        idAnggotaField.setText("");
        namaAnggotaLabel.setText("-");
        idPeminjamanLabel.setText("-");
        nomorBukuLabel.setText("-");
        judulBukuLabel.setText("-");
        tglPeminjamanLabel.setText("-");
        tkrPengembalianLabel.setText("-");
        keterlambatanLabel.setText("-");
        telatCheckbox.setSelected(false);
        rusakCheckbox.setSelected(false);
        hilangCheckbox.setSelected(false);
        totalBayarLabel.setText("-");
    }
    
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
        if (event.getCode() == KeyCode.ENTER) {
            Anggota anggota = anggota(Integer.parseInt(idAnggotaField.getText()));
            
            resetForm();
            
            if (anggota != null) {
                peminjamanList.setAll(peminjamanNotReturnList(anggota));
                namaAnggotaLabel.setText(anggota.getNama_anggota());
            }
        }
    }

    @FXML
    void mousePressedHandle(MouseEvent event) {
        if (event.getClickCount() == 1) {
            pilihPeminjaman();
        }
    }


}
