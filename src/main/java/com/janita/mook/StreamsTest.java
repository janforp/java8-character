package com.janita.mook;

import com.janita.bean.StudentTestScore;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Janita on 2017-05-24 12:58
 *
 * 一个java.util.Stream代表一个序列的元素在其中的一个或多个可以执行的操作。
 * 流操作是中间或终端。当终端操作返回某一类型的结果时，中间操作返回流，
 * 这样就可以将多个方法调用在一行中。流是一个源产生的，
 * 例如java.util.Collection像列表或设置（不支持map）。
 * 流操作可以被执行的顺序或并行。
 */
public class StreamsTest {

    List<String> stringCollection;

    @Before
    public void get() {
        stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    /**
     * 在Java8中Collections类的功能已经有所增强，
     * 你可用调用Collection.stream()或Collection.parallelStream()。
     */
    @Test
    public void testStreams() {

    }

    /**
     * Filter接受一个predicate来过滤流的所有元素。
     * 这个中间操作能够调用另一个流的操作（Foreach）的结果。
     * ForEach接受一个消费者为每个元素执行过滤流。
     * 它是void，所以我们不能称之为另一个流操作。
     *
     * predicate：传一个对象，返回一个布尔值，一般用于过滤操作
     */
    @Test
    public void testFilter() {
        stringCollection
                .stream()
                //能不能对对象进行针对字段的过滤呢？ TODO
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }


    /**
     * 对对象的集合进行过滤操作
     */
    @Test
    public void testFilterStu() {
        List<StudentTestScore> studentTestScores = StudentTestScore.getSutdent();

        List<StudentTestScore> filterStudentTestScores = new ArrayList<>();

         studentTestScores
                .stream()   //把集合转换成流
                .filter((student) -> student.getStudentId() > 1L) //对流中的每一个元素进行过滤操作
                .forEach(filterStudentTestScores::add); //遍历过滤之后的每一个元素，进行相应的义务操作

         System.out.println("*******" + filterStudentTestScores);
    }

    /**
     * 对对象的集合进行过滤操作
     */
    @Test
    public void testFilterStu2() {
        List<StudentTestScore> studentTestScores = StudentTestScore.getSutdent();
        List<StudentTestScore> filterStudentTestScores =
                    studentTestScores
                            .stream()   //把集合转换成流
                            .filter((student) -> student.getStudentId() > 1L).collect(Collectors.toList());//把满足条件的对象放进新的集合

        System.out.println("*******" + filterStudentTestScores);

    }


    /**
     * Sorted是一个中间操作，
     * 能够返回一个排过序的流对象的视图。
     * 这些元素按自然顺序排序，
     * 除非你经过一个自定义比较器（实现Comparator接口）
     */
    @Test
    public void testSortedString() {

        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("b"))
                .forEach(System.out::println);

        /**
         * 要记住，排序只会创建一个流的排序视图，
         * 而不处理支持集合的排序。
         * 原来string集合中的元素顺序是没有改变的
         */
        System.out.println("*******" + stringCollection);
    }

    @Test
    public void testSortedObject() {
        List<StudentTestScore> filterStudentTestScores = StudentTestScore.getSutdent();

        filterStudentTestScores
                .stream()
                .sorted((o1, o2) -> (o2.getScore().subtract(o1.getScore())).intValue())
                .filter((student) -> student.getStudentId() > 1L) //对流中的每一个元素进行过滤操作
                .forEach(System.out::println);
    }

    /**
     * map是一个对于流对象的中间操作，通过给定的方法，
     * 它能够把流对象中的每一个元素对应到另外一个对象上。
     * 下面的例子将每个字符串转换成一个大写字符串，
     * 但也可以使用map将每个对象转换为另一种类型。
     * 所得到的流的泛型类型取决于您传递给map方法的泛型类型
     */
    @Test
    public void testMapStr() {
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * map在对象集合上的使用
     */
    @Test
    public void testMapObject() {
        List<StudentTestScore> studentTestScoreList = StudentTestScore.getSutdent();
        studentTestScoreList =
                studentTestScoreList
                        .stream()
                        .map(studentTestScore -> {
                            studentTestScore.setName("修改名字");
                            studentTestScore.setClazzId(888L);
                            return studentTestScore;
                        }).collect(Collectors.toList());

        System.out.println("*******" + studentTestScoreList);
    }

    /**
     * 可以使用各种匹配操作来检查某个谓词是否匹配流。
     * 所有这些操作都是终止操作，返回一个布尔结果
     */
    @Test
    public void testMatchStr() {
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true

    }

    /**
     * Count是一个终止操作返回流中的元素的数目，
     * 返回long类型
     *
     * 用于对象集合也是类似的
     */
    @Test
    public void testCount() {
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3
    }

    /**
     * 该终止操作能够通过某一个方法，
     * 对元素进行削减操作。
     * 该操作的结果会放在一个Optional变量里返回。
     */
    @Test
    public void testReduceStr() {
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }


    /**
     * reduce对对象集合的操作
     */
    @Test
    public void testReduceObject() {
        List<StudentTestScore> scoreList = StudentTestScore.getSutdent();
        Optional<StudentTestScore> reduced =
                scoreList
                    .stream()
//                    .sorted()
                    .reduce((scoreA, scoreB) -> {

                        BigDecimal score1 = scoreA.getScore();
                        BigDecimal score2 = scoreB.getScore();

                        StudentTestScore score = new StudentTestScore();
                        score.setClazzId(222L);
                        score.setStudentId(1312313L);
                        score.setName("呵呵呵");
                        score.setTestId(2222L);
                        score.setScore(score1.add(score2));
                        return score;
                    });

        reduced.ifPresent(System.out::println);
    }
}
