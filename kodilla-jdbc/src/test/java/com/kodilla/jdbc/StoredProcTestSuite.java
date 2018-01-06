package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //when
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        //then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }

        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = NULL";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //when
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        //then
        String sqlCheckHowManyNotNull = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER IS NOT NULL";
        ResultSet rs = statement.executeQuery(sqlCheckHowManyNotNull);
        int howManyNotNull = 0;
        if (rs.next()) {
            howManyNotNull = rs.getInt("HOW_MANY");
        }

        String sqlCheckHowManyBorrowedTitles = "SELECT COUNT(*) AS HOW_MANY FROM " +
                                                "(SELECT * FROM RENTS GROUP BY BOOK_ID) AS BORROWED_TITLES;";
        rs = statement.executeQuery(sqlCheckHowManyBorrowedTitles);
        int howManyBorrowedTitles = 0;
        if (rs.next()) {
            howManyBorrowedTitles = rs.getInt("HOW_MANY");
        }

        assertEquals(howManyNotNull, howManyBorrowedTitles);
    }

}

