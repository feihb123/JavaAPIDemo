package cn.datacharm.collectionandmap;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * description:
 * hashcode && equal在集合中的使用
 * @author Herb
 * @date 2019/09/2019-09-12
 */
public class HashEqualDemo {
    public static void main(String[] args) {
        Stu stu1 = new Stu(1, "xjj");
        Stu stu2 = new Stu(1, "xbb");
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
        System.out.println(stu1.hashCode() == stu2.hashCode());
        System.out.println(stu1.equals(stu2));

        Map<Stu,Integer> map = new HashMap<>();
        // stu1 stu2 hash值相同 但equals不同 使用HashMap使用链表处理
        map.put(stu1,1);
        map.put(stu2,2);
        map.put(null,null);
        System.out.println(map.size());
    }

}

class Stu{
    private Integer id;
    private String name;

    public Stu(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return Objects.equals(id, stu.id) &&
                Objects.equals(name, stu.name);
    }



    /**
     * 自定义hashCode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

