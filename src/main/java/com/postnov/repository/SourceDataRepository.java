package com.postnov.repository;

import com.postnov.entity.SourceData;

import java.sql.SQLException;
import java.util.List;

public interface SourceDataRepository {

    List<SourceData> getPivotDataFromDb(String row, String col, String nameTable) throws SQLException;

}
