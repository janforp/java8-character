package com.janita.bean;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017-05-24 09:57
 */
@Data
@ToString
@EqualsAndHashCode(exclude={"name", "clazzId","score"})
public class StudentTestScore implements Comparable<StudentTestScore>{

    private Long studentId;

    private String name;

    private Long clazzId;

    private Long testId;

    private BigDecimal score;

    @Override
    public int compareTo(StudentTestScore o) {

        return (o.getScore().subtract(score)).intValue();
    }

    public static List<StudentTestScore> getSutdent(){
        StudentTestScore score = new StudentTestScore();
        score.setStudentId(1L);
        score.setName("张三");
        score.setClazzId(238L);
        score.setTestId(1L);
        score.setScore(new BigDecimal(80.8));

        StudentTestScore score1 = new StudentTestScore();
        score1.setStudentId(2L);
        score1.setName("李思思");
        score1.setClazzId(238L);
        score1.setTestId(1L);
        score1.setScore(new BigDecimal(100));

        StudentTestScore score2 = new StudentTestScore();
        score2.setStudentId(3L);
        score2.setName("王五");
        score2.setClazzId(238L);
        score2.setTestId(1L);
        score2.setScore(new BigDecimal(59));

        List<StudentTestScore> scores = new ArrayList<>();
        scores.add(score);
        scores.add(score1);
        scores.add(score2);

        return scores;
    }
}
