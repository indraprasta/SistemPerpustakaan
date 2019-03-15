/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.models;

import java.util.Date;
import org.sql2o.Connection;
import perpustakaan.DB;

/**
 *
 * @author asus
 */
public class Pengembalian {
    private int id_peminjaman;
    private Date tgl_pengembalian;
    
    public static Pengembalian pengembalian(Peminjaman peminjaman) {
        try(Connection connection = DB.sql2o.open()) {
            final String query = "SELECT * FROM pengembalian WHERE id_peminjaman = :id_peminjaman";
            return connection.createQuery(query).bind(peminjaman).executeAndFetchFirst(Pengembalian.class);
        }
    }
}
