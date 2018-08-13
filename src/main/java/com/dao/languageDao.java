package com.dao;

import com.entity.film;
import com.entity.language;
import com.utils.jdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class languageDao {
    com.utils.jdbcUtil jdbcUtil;
    public languageDao(){
        jdbcUtil = new jdbcUtil();
    }
    public List<language> select(){
        jdbcUtil.getConnection();
        List<Map<String, Object>> list2 = null;
        try {
            list2 = jdbcUtil.findResult("select * from `language`", null);
            List<language> list3 = new ArrayList<>();
            for (Map<String, Object> m : list2) {
                language language = new language();
                language.setLanguage_id(m.get("language_id").toString());
                language.setName(m.get("name").toString());
                language.setLast_update(m.get("last_update").toString());
                list3.add(language);
            }
            return list3;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
