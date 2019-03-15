package perpustakaan.models;

import java.util.Date;
import org.sql2o.Connection;
import perpustakaan.DB;

public class Peminjaman {
    private int id_peminjaman;
    private int id_anggota;
    private int nomor_buku;
    private Date tgl_peminjaman;
    private Date expired;
    
    public Peminjaman(int anggotaid, int bukuid, Date tanggal, Date tglexpired){
        this.id_anggota = anggotaid;
        this.nomor_buku = bukuid;
        this.tgl_peminjaman = tanggal;
        this.expired = tglexpired;
    }
            
    public int insertpeminjaman(){
        try (Connection connection = DB.sql2o.open()){
            final String query ="INSERT INTO peminjaman (id_peminjaman, id_anggota, nomor_buku, tgl_peminjaman, expired) VALUES (:id_peminjaman, :id_anggota, :nomor_buku, :tgl_peminjaman, :expired)";
            connection.createQuery(query).bind(this).executeUpdate();
            return connection.getResult();
        }
    }

    public int getId_peminjaman() {
        return id_peminjaman;
    }
    
    public int getId_anggota() {
        return id_anggota;
    }

    public int getNomor_buku() {
        return nomor_buku;
    }
    
    public Date getTgl_peminjaman() {
        return tgl_peminjaman;
    }
    
    public Date getExpired() {
        return expired;
    }
}


