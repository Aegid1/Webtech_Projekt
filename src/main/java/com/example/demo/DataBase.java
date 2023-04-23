package com.example.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    public static void main(String[] a) throws Exception {
        Class.forName("org.h2.Driver");
        readDB();
    }

    public static void readDB() {
        String tab = "TESTTABELLE";
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/.javabeginners/h2Test", "", "")) {
            DatabaseMetaData md = conn.getMetaData();

            String[] types = { "TABLE", "SYSTEM TABLE" };
            ResultSet metaRS = md.getTables(null, null, "%", null);
            while (metaRS.next()) {

                String tableCatalog = metaRS.getString(1);
                System.out.println("Catalog: " + tableCatalog);

                String tableSchema = metaRS.getString(2);
                System.out.println("Tabellen-Schema: " + tableSchema);

                String tableName = metaRS.getString(3);
                System.out.println("Tabellen-Name: " + tableName);

                String tableType = metaRS.getString(4);
                System.out.println("Tabellen-Typ: " + tableType + "\n");
            }
            Statement stmt = conn.createStatement();

            String dropQ = "DROP TABLE IF EXISTS " + tab;
            stmt.executeUpdate(dropQ);

            String createQ = "CREATE TABLE IF NOT EXISTS " + tab
                    + "(ID INT PRIMARY KEY AUTO_INCREMENT(1,1) NOT NULL, NAME VARCHAR(255))";
            stmt.executeUpdate(createQ);

            String insertQ = "INSERT INTO " + tab + " VALUES(TRANSACTION_ID(),'Hello World!')";
            stmt.executeUpdate(insertQ);

            ResultSet selectRS = stmt.executeQuery("SELECT * FROM " + tab);
            while (selectRS.next()) {
                System.out.printf("%s, %s\n", selectRS.getString(1), selectRS.getString(2));
            }

            System.out.println("Liste Tabellen...");
            String tablesQ = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC'";
            ResultSet tablesRS = stmt.executeQuery(tablesQ);
            while (tablesRS.next()) {
                System.out.printf("Tabelle %s vorhanden \n", tablesRS.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}