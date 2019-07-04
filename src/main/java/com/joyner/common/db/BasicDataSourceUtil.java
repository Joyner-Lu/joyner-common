package com.joyner.common.db;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicDataSourceUtil {

    public static DataSource setupDataSource(String connectURI,String username,String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(connectURI);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    public static void shutdownDataSource(DataSource ds) {
        try {
            BasicDataSource bds = (BasicDataSource) ds;
            bds.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) throws Exception {


        String url = "jdbc:oracle:thin:@10.10.15.76:1521:XE";
        String user = "DZFP";
        String password = "DZFP";

/*

        String url = "jdbc:mysql://10.10.15.76:3306/fptb_test";
        String user = "apollo";
        String password = "apollo";
*/

        DataSource dataSource = setupDataSource(url,user,password);
        System.out.println(dataSource);
    }
}
