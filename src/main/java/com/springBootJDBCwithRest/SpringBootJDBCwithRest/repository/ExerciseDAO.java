package com.springBootJDBCwithRest.SpringBootJDBCwithRest.repository;

import com.springBootJDBCwithRest.SpringBootJDBCwithRest.model.Exercise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ExerciseDAO {
    
    public final JdbcTemplate jdbcTemplate;

    public ExerciseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Exercise> getAllExercise() {
        String sql="select * from workout";
        return jdbcTemplate.query(sql, new ExerciseRowMapper());
    }

    public int addExercise(Exercise exercise) {
//        if database have uppercase schema then you can face error that why we use \"workoutName\" postgres is case sensitive
//        we should use lowercase in postgres schema
        String sql ="insert into workout (id,\"workoutName\",sets,reps,weight,\"bodyPart\") values (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,exercise.getId(),exercise.getWorkoutName(),
                exercise.getSets(),exercise.getReps(),exercise.getWeight(),
                exercise.getBodyPart());

    }

    public int updateExercise(Exercise exercise) {
        String sql ="update workout SET \"workoutName\"=?, sets=?,  reps=?, weight=?,  \"bodyPart\"=? where id=?";
        return jdbcTemplate.update(sql,exercise.getWorkoutName(),exercise.getSets(),exercise.getReps(),exercise.getWeight(),exercise.getBodyPart(),exercise.getId());
    }

    public int deleteExercise(int id) {
        String sql="delete from workout where id=?";
        return jdbcTemplate.update(sql,id);
    }

    public Exercise findById(int id) {
        String sql="select * from workout where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ExerciseRowMapper());
    }

    public static class ExerciseRowMapper implements RowMapper<Exercise>{

        @Override
        public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Exercise(rs.getInt("id"),
                    rs.getString("workoutName"),
                    rs.getInt("sets"),
                    rs.getInt("reps"),
                    rs.getInt("weight"),
                    rs.getString("bodyPart"));
        }
    }
}
