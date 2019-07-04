package com.joyner.common.db.test;

import com.joyner.common.db.BasicDataSourceUtil;
import oracle.jdbc.proxy.annotation.Pre;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBTest {

    private DataSource getDataSource() {
        //注意service_name使用/，而sid使用冒号
        /*String url = "jdbc:oracle:thin:@10.10.15.76:1521:XE";
        String user = "sys as SYSDBA";
        String password = "oracle";*/
        String url = "jdbc:oracle:thin:@10.10.0.61:1521/hzgswsbstest";
        String user = "DZDZ2";
        String password = "dzdz2";
        DataSource dataSource = BasicDataSourceUtil.setupDataSource(url, user, password);
        return dataSource;
    }

    @Test
    public void testWithCommonDBUtil() throws Exception {

        String sql = "SELECT FPDM, FPHM, KPRQ, KPYF, FPZT_DM, FPZT_YWSJ, FPZT_WHSJ\n" +
                "  FROM DZDZ_FPXX_ZZSFP fp\n" +
                " WHERE fp.KPYF IN (201805, 201806)\n" +
                "   AND fp.GFSBH = '9.14101831705556GH'\n" +
                "   AND (fp.FPZT_WHSJ BETWEEN to_date('2018-06-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss') AND\n" +
                "       to_date('2018-06-30 23:59:59', 'yyyy-MM-dd hh24:mi:ss') OR\n" +
                "       (fp.FPZT_WHSJ IS NULL AND fp.KPRQ >= to_date('2018-05-25', 'yyyy-MM-dd')))\n";

        QueryRunner run = new QueryRunner(getDataSource());

        run.query(sql, new ResultSetHandler<Object>() {
            @Override
            public Object handle(ResultSet resultSet) {


                try {
                    if (!resultSet.next()) {
                        return null;
                    }
                    Object o = resultSet.getObject("GFMC");
                    System.out.println(o);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        });
    }

    @Test
    public void testOriginalJDBC() throws Exception {

        Connection connection = getDataSource().getConnection();
        //System.out.println("connection1:" + connection.hashCode());
        try {

            PreparedStatement statement = connection.prepareStatement("SELECT FPDM, FPHM, KPRQ, KPYF, FPZT_DM, FPZT_YWSJ, FPZT_WHSJ\n" +
                    "  FROM DZDZ_FPXX_ZZSFP fp\n" +
                    " WHERE fp.KPYF IN (201805, 201806)\n" +
                    "   AND fp.GFSBH = '9.14101831705556GH'\n" +
                    "   AND (fp.FPZT_WHSJ BETWEEN to_date('2018-06-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss') AND\n" +
                    "       to_date('2018-06-30 23:59:59', 'yyyy-MM-dd hh24:mi:ss') OR\n" +
                    "       (fp.FPZT_WHSJ IS NULL AND fp.KPRQ >= to_date('2018-05-25', 'yyyy-MM-dd')))\n");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                //获取执行计划信息
                System.out.println(rs.getObject("DESCRIPTION"));
            }
            rs.close();
            statement.close();
        } catch (Exception ex) {

        } finally {
            connection.close();
        }


    }



}
