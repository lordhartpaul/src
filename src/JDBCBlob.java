

import java.sql.*;

import java.io.*;
public class JDBCBlob {
    public JDBCBlob() {
        super();
    }

    public static void readBlob() throws Exception {
        byte[] buffer = new byte[102400];
        int bytesRead = 0;
        FileOutputStream outstream = new FileOutputStream("C:\\JDBC_OUT.zip");
        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        Connection conn =
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                        "test", "password");
        PreparedStatement pst =
            conn.prepareStatement("select CONTENT from FILE_TABLE where ID = 5");
        ResultSet rset = pst.executeQuery();
        rset.next();
        Blob blob = rset.getBlob(1);
        InputStream instream = blob.getBinaryStream();
        while ((bytesRead = instream.read(buffer)) != -1) {
            outstream.write(buffer);
        }
        outstream.close();
        instream.close();
        rset.close();
        pst.close();
        conn.close();

    }

    public static void writeBlob() throws Exception {
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        FileInputStream instream = new FileInputStream("C:\\libs.rar");
        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        Connection conn =
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                        "test", "password");
        conn.setAutoCommit(false);
        Blob blob = conn.createBlob();
        OutputStream outstream = blob.setBinaryStream(0);
        while ((bytesRead = instream.read(buffer)) != -1) {
            outstream.write(buffer);
        }
        outstream.close();
        instream.close();
        PreparedStatement pst =
            conn.prepareStatement("insert into FILE_TABLE values(?,5)");
        pst.setBlob(1, blob);
        int r = pst.executeUpdate();
        System.out.println("Effected Rows Count:" + r);
        conn.commit();
        pst.close();
        conn.close();

    }

}
