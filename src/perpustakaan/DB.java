package perpustakaan;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o;
    
    static {
        sql2o = new Sql2o("jdbc:mysql://localhost/perpustakaan","root","");
    }
}
