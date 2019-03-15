package perpustakaan.models;

import org.sql2o.Connection;
import perpustakaan.DB;

public class BayarDenda {
    private final int id_peminjaman;
    private final int id_denda;
    private final int total_bayar;

    public BayarDenda(int id_peminjaman, Denda denda, int keterlambatan) {
        this.id_peminjaman = id_peminjaman;
        this.id_denda = denda.getId_denda();
        this.total_bayar = denda.getTarif_denda() * keterlambatan;
    }
    
    public BayarDenda(int id_peminjaman, Denda denda) {
        this.id_peminjaman = id_peminjaman;
        this.id_denda = denda.getId_denda();
        this.total_bayar = denda.getTarif_denda();
    }
    
    public int insertBayarDenda() {
        try (Connection connection = DB.sql2o.open()) {
            final String query = "INSERT INTO bayar_denda (id_peminjaman, id_denda, total_bayar) VALUES (:id_peminjaman, :id_denda, :total_bayar)";
            connection.createQuery(query).bind(this).executeUpdate();
            return connection.getResult();
        }
    }

    public int getId_peminjaman() {
        return id_peminjaman;
    }

    public int getId_denda() {
        return id_denda;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }
    
}
