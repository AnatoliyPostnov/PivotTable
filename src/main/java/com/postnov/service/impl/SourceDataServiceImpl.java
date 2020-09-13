package com.postnov.service.impl;

import com.postnov.entity.SourceData;
import com.postnov.repository.SourceDataRepository;
import com.postnov.service.SourceDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SourceDataServiceImpl implements SourceDataService {

    private final SourceDataRepository sourceDataRepository;

    @Value("${name.table}")
    private String nameTable;

    public SourceDataServiceImpl(SourceDataRepository sourceDataRepository) {
        this.sourceDataRepository = sourceDataRepository;
    }

    @Override
    public ResponseEntity<List<SourceData>> getPivotDataFromDb(String row, String col) throws SQLException {
        List<SourceData> sourceDataList = sourceDataRepository.getPivotDataFromDb(row, col, nameTable);
        return new ResponseEntity<List<SourceData>>(sourceDataList, HttpStatus.OK);
    }
}
