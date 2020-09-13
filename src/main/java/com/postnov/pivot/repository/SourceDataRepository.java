package com.postnov.pivot.repository;

import com.postnov.pivot.entity.SourceData;

import java.sql.SQLException;
import java.util.List;

public interface SourceDataRepository {

    List<SourceData> getPivotDataFromDb(String row, String col, String nameTable) throws SQLException;

}
