package cn.datacharm.concurrent.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/19
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>(5);
        queue.put("1");
        queue.put("5");
        queue.put("3");
        queue.put("4");
        queue.put("2");
        //PriorityBlockingQueue有序
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take());

        }

        PriorityBlockingQueue<Student> students = new PriorityBlockingQueue<>(5);
        students.put(new Student("s1",20,100));
        students.put(new Student("s2",21,80));
        students.put(new Student("s3",18,90));
        for (Student student : students) {
            System.out.println(students.take());
        }


    }
    static class Student implements Comparable{
        String name;
        Integer age;
        Integer score;

        public Student(String name, Integer age, Integer score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
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

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }



        @Override
        public int compareTo(Object o) {
            Student s = (Student) o;
            return this.age - s.getAge();
        }
    }
}
