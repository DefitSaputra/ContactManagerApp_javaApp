package contactmanagerappdb;

import static contactmanagerappdb.Koneksi.setKoneksi;
import static contactmanagerappdb.Koneksi.testQuery;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactManagerAppDB {
    public static void main(String[] args) {
        setKoneksi();
        testQuery();
    }
}
