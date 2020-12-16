package demo;

import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;

public class test {
    public static void main(String[] args) throws Exception {
        Connection con= DBUtil.getConnection();
        String  sql="CALL proc_transfer_money(?,?,?)";
        CallableStatement cs=con.prepareCall(sql);
        cs.setString(1,"Yaa");
        cs.setString(2,"KING");
        cs.setBigDecimal(3,new BigDecimal(400));
        cs.executeQuery();
        DBUtil.close(null,cs,con);
    }
}
