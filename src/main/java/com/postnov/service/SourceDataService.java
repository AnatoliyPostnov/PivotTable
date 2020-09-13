package com.postnov.service;

import com.postnov.entity.SourceData;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

public interface SourceDataService {

    ResponseEntity<List<SourceData>> getPivotDataFromDb(String row, String col) throws SQLException;

}
