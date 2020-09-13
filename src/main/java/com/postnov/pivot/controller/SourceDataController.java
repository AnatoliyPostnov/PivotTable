package com.postnov.pivot.controller;

import com.postnov.pivot.entity.SourceData;
import com.postnov.pivot.service.SourceDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SourceDataController {

    private final SourceDataService sourceDataService;

    public SourceDataController(SourceDataService sourceDataService) {
        this.sourceDataService = sourceDataService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<SourceData>> getPivotDataFromDb(@RequestParam(name = "row") String row, @RequestParam(name = "col") String col) throws SQLException {
        return sourceDataService.getPivotDataFromDb(row, col);
    }
}
