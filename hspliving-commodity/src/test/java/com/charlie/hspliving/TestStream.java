package com.charlie.hspliving;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 演示 stream API / 流式计算
 */
public class TestStream {

    public static void main(String[] args) {
        // 创建Person对象
        Person person1 = new Person(1, "charlie", 23);
        Person person2 = new Person(2, "bill", 83);
        Person person3 = new Person(3, "jack", 18);
        Person person4 = new Person(4, "tom", 62);
        Person person5 = new Person(5, "brown", 53);

        // 放入到List集合
        List<Person> list = Arrays.asList(person1, person2, person3, person4, person5);
        System.out.println("list=>" + list);

        // 2.1 对entities过滤filter，返回1级分类
        // 2.2 进行map映射操作，给每个分类设置对应的子分类（递归）
        // 2.3 进行排序sorted操作
        // 2.4 将处理好的数据进行收集/转换到集合

        // 需求：从list中过滤出person.id % 2 != 0的person对象
        /**
         * 1. list.stream()把list转成流对象，目的是为了使用流的方法，这样就可以处理一些比较复杂的业务
         * 2. filter()：传入的是 Predicate/断言，返回boolean
         * 3. collect()：传入 Collector ，将数据收集到集合list2
         * 4. map操作：希望将过滤得到的person对象，加入cat对象
         * 5. sorted操作：传入 Comparator ，排序
         */
        //List<Person> list2 = list.stream().filter(person -> {
        //    return person.getId() % 2 != 0;
        //}).map(person -> {  // 对过滤得到的person进行映射操作，可以根据自己的业务进行设计
        //    Cat cat = new Cat(person.getId() + 100, "三花", "花色");
        //    person.setCat(cat);
        //    return person;
        //}).sorted((p1, p2) -> {
        //    //return p1.getId() - p2.getId(); // 按照id升序排序
        //    return p2.getAge() - p1.getAge(); // 按照age降序排序
        //}).collect(Collectors.toList());
        //System.out.println("list2=>" + list2);
        //System.out.println("list=>" + list);    // filter操作流后，原list并没有变化。但是map操作会改变原list

        System.out.println("<===========>");
        // 常用的stream API
        // 需求：显示list的前两个数据
        list.stream().limit(2).forEach(person -> {
            System.out.println(person);
        });

        // count使用
        long count = list.stream().count();
        System.out.println("count=" + count);   // count=5

        // 先过滤，在count
        long count1 = list.stream().filter(person -> {
            return person.getAge() > 30;
        }).count();
        System.out.println("count1=" + count1); // count1=3
    }

}

// Person类
class Person {
    private Integer id;
    private String name;
    private Integer age;
    private Cat cat;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cat=" + cat +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}

// Cat类
class Cat {
    private Integer id;
    private String name;
    private String color;

    public Cat(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
