package com.example.planvirtual.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CredDao {
    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    private static String getSummaQuery = "select summ from loan_offers where id = ?";

    public static List<Map<String, Object>> getSumma(Long id){
      return jdbcTemplate.queryForList(getSummaQuery, id);
    }

}
