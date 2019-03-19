package perpustakaan.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTreeTableView;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import perpustakaan.Report;
import perpustakaan.models.Anggota;
import perpustakaan.models.Buku;
import perpustakaan.models.Peminjaman;

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
        Task <Report> reportTask = new Task <Report>() {
            @Override
            protected Report call() throws Exception {
                Report report = new Report();
                report.addAnggota(Anggota.getAnggotaList());
                report.addBuku(Buku.getBukuList());
                report.addPeminjaman(Peminjaman.peminjamanList());
                return report;
            }
        };
        
        reportTask.setOnSucceeded(evt->{
            Document document = new Document(PageSize.A4);
            try {
                PdfWriter.getInstance(document, new FileOutputStream("out/report.pdf"));
            } catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            document.open();
                
            try {
                document.add(reportTask.get().getLayout());
            } catch (InterruptedException | ExecutionException | DocumentException ex) {
                Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            document.close();
            
            File file = new File ("out/report.pdf");
            
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (IOException ex) {
                Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        reportTask.setOnFailed(evt -> reportTask.getException().printStackTrace());
        
        Thread thread = new Thread(reportTask);
        thread.setDaemon(true);
        thread.start();  
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        anchor.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent parent = loader.load();
        anchor.getChildren().add(parent);
    }

}
