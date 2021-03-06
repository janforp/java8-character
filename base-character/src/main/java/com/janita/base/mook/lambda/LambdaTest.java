package com.janita.base.mook.lambda;

import com.janita.base.bean.ClazzTestScore;
import com.janita.base.bean.StudentTestScore;
import org.junit.Test;

import java.util.*;

/**
 * Created by Janita on 2017-05-24 09:51
 */
public class LambdaTest {

    @Test
    public void test1() {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println("*******" + names);
    }

    @Test
    public void test2(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        System.out.println("*******" + names);
    }

    @Test
    public void test3(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, Comparator.reverseOrder());

        System.out.println("*******" + names);

        Collections.sort(names, Comparator.naturalOrder());

        System.out.println("*******" + names);

    }

    /**
     * 一行方法的方法体可以跳过{}和参数类型
     */
    @Test
    public void test4() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((a,b) -> b.compareTo(a));

        System.out.println("*******"+ names);
    }


    @Test
    public void testObject() {

        List<StudentTestScore> scores = StudentTestScore.getSutdent();

        Collections.sort(scores, Comparator.naturalOrder());

        System.out.println("*******"+scores);

        Collections.sort(scores,(StudentTestScore::compareTo));

        System.out.println("*******"+scores);

    }

    @Test
    public void testClazz() {
        List<ClazzTestScore> clazzTestScores = ClazzTestScore.getClazz();
        clazzTestScores.sort((ClazzTestScore clazzA, ClazzTestScore clazzB) ->
                (clazzA.getScore().subtract(clazzB.getScore())).intValue());
        System.out.println("*******" + clazzTestScores);

        clazzTestScores.sort((ClazzTestScore clazzA, ClazzTestScore clazzB) ->
                (clazzB.getScore().subtract(clazzA.getScore())).intValue());
        System.out.println("*******" + clazzTestScores);
    }

}
