package com.abc.dao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    private static DataSource ds = new ComboPooledDataSource("dao_c3p0");

    public static DataSource getDs() {
        return ds;
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return ds.getConnection();
    }

    public static void close(ResultSet rs, PreparedStatement pst, Connection con) throws Exception {
        if (rs != null)
            rs.close();
        if (pst != null)
            pst.close();
        if (con != null)
            con.close();
    }
}
