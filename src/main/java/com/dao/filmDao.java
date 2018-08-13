package com.dao;

import com.entity.film;
import com.utils.jdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class filmDao {
    jdbcUtil jdbcUtil;
    public filmDao(){
        jdbcUtil = new jdbcUtil();
    }
    public boolean add(List<Object> list){
        jdbcUtil.getConnection();
        try {
            jdbcUtil.updateByPreparedStatement("SET FOREIGN_KEY_CHECKS=0;",null);
            return jdbcUtil.updateByPreparedStatement("insert into film(title,description,language_id) values(?,?,?)", list);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(List<Object> list){
        jdbcUtil.getConnection();
        try {
            jdbcUtil.updateByPreparedStatement("set foreign_key_checks = 0", null);
            return jdbcUtil.updateByPreparedStatement("delete from film where film_id = ?", list);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(List<Object> list,int id){
        jdbcUtil.getConnection();
        try {
            return jdbcUtil.updateByPreparedStatement("update film set title = ?,description = ?,language_id = ? where film_id = "+id, list);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<film> select(){
        jdbcUtil.getConnection();
        List<Map<String, Object>> list2 = null;
        try {
            list2 = jdbcUtil.findResult("select f.film_id,f.title,f.description,l.`name` from film f,`language` l where f.language_id = l.language_id", null);
            List<com.entity.film> list3 = new ArrayList<>();
            for (Map<String, Object> m : list2) {
                com.entity.film film = new com.entity.film();
                film.setFilm_id(m.get("film_id").toString());
                film.setTitle(m.get("title").toString());
                film.setDescription(m.get("description").toString());
                film.setLanguage(m.get("name").toString());
                list3.add(film);
            }
            return list3;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
