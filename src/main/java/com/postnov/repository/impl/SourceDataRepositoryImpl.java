package com.postnov.repository.impl;

import com.postnov.entity.SourceData;
import com.postnov.repository.SourceDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SourceDataRepositoryImpl implements SourceDataRepository {

    private static Logger logger = LoggerFactory.getLogger(SourceDataRepositoryImpl.class);

    public List<SourceData> getPivotDataFromDb(String row, String col, String nameTable) throws SQLException {
        List<SourceData> sourceDataList = new ArrayList<>();
        String query = String.format("SELECT %s, %s, v FROM %s", row, col, nameTable);
        logger.info("[x]   Start connection to database...");
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/xiaomi/IdeaProjects/pivot/data.sqlite");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            logger.info("[x]   Connection to database was successful");
            while (rs.next()) {
                SourceData sourceData = new SourceData();
                sourceData.setRow(rs.getString(row));
                sourceData.setCol(rs.getString(col));
                sourceData.setValue(rs.getString("v"));
                sourceDataList.add(sourceData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return sourceDataList;
    }
}
