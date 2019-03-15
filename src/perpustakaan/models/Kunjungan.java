package perpustakaan.models;

import java.util.Date;
import org.sql2o.Connection;
import perpustakaan.DB;

public class Kunjungan {
    private int id_kunjungan;
    private Date tgl_kunjungan;
    private int id_anggota;
    
    public Kunjungan(Date tanggal, int anggotaid){
        this.tgl_kunjungan = tanggal;
        this.id_anggota = anggotaid;
    }
            
    public int insertkunjungan(){
        try (Connection connection = DB.sql2o.open()){
            final String query ="INSERT INTO kunjungan (tgl_kunjungan,id_anggota) VALUES (:tgl_kunjungan, :id_anggota)";
            connection.createQuery(query).bind(this).executeUpdate();
            return connection.getResult();
        }
    }

    public int getId_kunjungan() {
        return id_kunjungan;
    }

    public Date getTgl_kunjungan() {
        return tgl_kunjungan;
    }

    public int getId_anggota() {
        return id_anggota;
    }
    
}


