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
@EqualsAndHashCode(exclude={"name","score"})
public class ClazzTestScore {

    private Long clazzId;

    private String name;

    private Long testId;

    private BigDecimal score;


    public static List<ClazzTestScore> getClazz(){
        ClazzTestScore score = new ClazzTestScore();
        score.setName("238");
        score.setClazzId(238L);
        score.setTestId(1L);
        score.setScore(new BigDecimal(90));

        ClazzTestScore score1 = new ClazzTestScore();
        score1.setName("236");
        score1.setClazzId(236L);
        score1.setTestId(1L);
        score1.setScore(new BigDecimal(60));

        ClazzTestScore score2 = new ClazzTestScore();
        score2.setName("243");
        score2.setClazzId(243L);
        score2.setTestId(1L);
        score2.setScore(new BigDecimal(80));

        List<ClazzTestScore> scores = new ArrayList<>();
        scores.add(score);
        scores.add(score1);
        scores.add(score2);

        return scores;
    }
}
