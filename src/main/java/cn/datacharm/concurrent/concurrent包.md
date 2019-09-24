### 一、BlockingQueue阻塞队列

1. **核心方法**

   ​    BockingQueue 方法以四种形式出现，对于不能立即满足但可能在将来某一时刻可以满足的操作。
   这四种形式的处理方式不同：

   - add(e)   抛出一个异常
   - offer(e)   返回一个特殊值（null 或 false，具体取决于操作）
   - put(e)   是在操作可以成功前，无限期地阻塞当前线程
   - offer(e, time, unit) 在放弃前只在给定的最大时间限制内阻塞

   | 操作 | 抛出异常  | 返回特殊值 | 阻塞   | 超时                 |
   | ---- | --------- | ---------- | ------ | -------------------- |
   | 插入 | add(e)    | offer(e)   | put(e) | offer(e, time, unit) |
   | 移除 | remove()  | poll()     | take() | poll(time, unit)     |
   | 检查 | element() | peek()     | 不可用 | 不可用               |

2. **ArrayBlockingQueue** 

   ​    基于数组的阻塞队列实现，在ArrayBlockingQueue内部，维护了一个定长数组，以便缓存队列中的数据对象，这是一个常用的阻塞队列，除了一个定长数组外，ArrayBlockingQueue内部还保存着两个整形变量，分别标识着队列的头部和尾部在数组中的位置。在创建ArrayBlockingQueue时，我们还可以控制对象的内部锁是否采用公平锁，默认采用非公平锁。

   ```java
   ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
   ```

   - **因为基于数组实现，必须ArrayBlockingQueue必须初始化一个容量大小**
   - **ArrayBlockingQueue实现的队列中的锁是没有分离的，即生产和消费用的是同一个锁**

   

3. **LinkedBlockingQueue**

   ​    基于链表的阻塞队列，同ArrayListBlockingQueue类似，其内部也维持着一个数据缓冲队列（该队列由一个链表构成），当生产者往队列中放入一个数据时，队列会从生产者手中获取数据，并缓存在队列内部，而生产者立即返回；只有当队列缓冲区达到最大值缓存容量时（LinkedBlockingQueue可以通过构造函数指定该值），才会阻塞生产者队列，直到消费者从队列中消费掉一份数据，生产者线程会被唤醒，反之对于消费者这端的处理也基于同样的原理。

   ```java
   LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
   ```

   - **在使用的时候可以指定容量也可以不指定容量,容量默认为Integer.MAX_VALUE**

   - **如果指定容量，则容量指定之后不可变**

   - **LinkedBlockingQueue实现的队列中的锁是分离的，即生产用的是putLock，消费是takeLock**

   

4. **PriorityBlockingQueue**

   ​    基于优先级的阻塞队列（优先级的判断通过构造函数传入的Compator对象来决定），但需要注意的是PriorityBlockingQueue并不会阻塞数据生产者，而只会在没有可消费的数据时，阻塞数据的消费者。因此使用的时候要特别注意，生产者生产数据的速度绝对不能快于消费者消费数据的速度，否则时间一长，会最终耗尽所有的可用堆内存空间。在实现PriorityBlockingQueue时，内部控制线程同步的锁采用的是公平锁。

   ```java
   PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
   ```

   - **在使用的时候可以指定容量也可以不指定，容量默认为11**
   - **如果指定容量，则容量指定之后不可变**
   - **要求存储的元素对应的类必须实现Comparable接口，存储元素的时候会根据指定的比较规则对元素进行排序**

   

5. **SynchronousQueue**

   ​    一种无缓冲的等待队列，类似于无中介的直接交易，有点像原始社会中的生产者和消费者，生产者拿着产品去集市销售给产品的最终消费者，而消费者必须亲自去集市找到所要商品的直接生产者，如果一方没有找到合适的目标，那么对不起，大家都在集市等待。相对于有缓冲的BlockingQueue来说，少了一个中间经销商的环节（缓冲区），如果有经销商，生产者直接把产品批发给经销商，而无需在意经销商最终会将这些产品卖给那些消费者，由于经销商可以库存一部分商品，因此相对于直接交易模式，总体来说采用中间经销商的模式会吞吐量高一些（可以批量买卖）；但另一方面，又因为经销商的引入，使得产品从生产者到消费者中间增加了额外的交易环节，单个产品的及时响应性能可能会降低。声明一个SynchronousQueue有公平模式和非公平模式。

   ```java
   SynchronousQueue<String> queue = new SynchronousQueue<>();
   ```

   - **SynchronousQueue没有容量，会直接将任务交给消费者，必须等队列中的添加元素被消费后才能继续添加新的元素。**
   - **如果该队列已有一个元素，则试图向队列中新添一个新元素的线程将会阻塞，直到另一个线程将该元素从队列中抽走**。
   - **如果该队列为空，则试图从队列中抽取一个元素的线程将会阻塞，直到另一个线程向队列中添加了一个新的元素**

### 二、ConcurrentMap

​    ConcurrentHashMap从JDK1.5开始随java.util.concurrent包一起引入JDK中，主要为了解决HashMap线程不安全和Hashtable效率不高的问题。众所周知，HashMap在多线程编程中是线程不安全的，而Hashtable由于使用了synchronized修饰方法而导致执行效率不高；因此，在concurrent包中，实现了ConcurrentHashMap以使在多线程编程中可以使用一个高性能的线程安全HashMap方案。

1. **ConcurrentMap新增方法**

```java
V putIfAbsent(K key, V value);
putIfAbsent：与原有put方法不同的是，putIfAbsent方法中如果插入的key相同，则不替换原有的value值；

boolean remove(Object key, Object value);
remove：与原有remove方法不同的是，新remove方法中增加了对value的判断，如果要删除的key--value不能与Map中原有的key--value对应上，则不会删除该元素;

boolean replace(K key, V oldValue, V newValue);
replace(K,V,V)：增加了对value值的判断，如果key--oldValue能与Map中原有的key--value对应上，才进行替换操作；

V replace(K key, V value);
replace(K,V)：与上面的replace不同的是，此replace不会对Map中原有的key--value进行比较，如果key存在则直接替换；
```

2. **ConcurrentHashMap**



### 三、ExecutorService

1. **Callable<T>**

   Callable是创建线程的一种方式。

   > 创建线程方式：1.继承Thread类，2.实现Runnable接口，3.实现Callable接口，4.线程池。

   ```java
   public class CallableDemo implements Callable<String> {
       @Override
       public String call() throws Exception {
           System.out.println("Callable run!");
           return "Success!";
       }
   }
   ```

   - **Callable规定的方法是call()，而Runnable规定的方法是run()。**

   - **Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。运行Callable任务可拿到一个Future对象， Future表示异步计算的结果。**
   - **call()方法可抛出异常，而run()方法是不能抛出异常的（需要用try-catch）。   **
   - **Runnable可以通过Thread和线程池启动，Callable只能通过线程池启动**

2. **线程池创建**

   - 手动创建线程池

   ```java
   public void manual() {
           // 引入：com.google.guava包 创建线程工厂 
           ThreadFactory threadFactory = new ThreadFactoryBuilder()
                   .setNameFormat("manual-pool-%d")
                   .build();
           // 创建通用线程池
           /**
            * 参数含义：
            * corePoolSize : 线程池中常驻的线程数量。核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
            * maximumPoolSize : 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
            * keepAliveTime : 当线程数量多于 corePoolSize 时，空闲线程的存活时长，超过这个时间就会被回收
            * unit : keepAliveTime 的时间单位
            * workQueue : 存放待处理任务的队列，该队列只接收 Runnable 接口
            * threadFactory : 线程创建工厂
            * handler : 当线程池中的资源已经全部耗尽，添加新线程被拒绝时，会调用RejectedExecutionHandler的rejectedExecution方法，参考 ThreadPoolExecutor 类中的内部策略类
            */
           ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 200, 0L,
                   TimeUnit.MILLISECONDS,
                   new LinkedBlockingQueue<>(1024),
                   threadFactory,
                   new ThreadPoolExecutor.AbortPolicy());
           for (int i = 0; i < 1000; i++) {
               threadPoolExecutor.execute(() ->{
                       System.out.println(Thread.currentThread().getName());
               });
           }
           threadPoolExecutor.shutdown();
       }
   ```

   - 使用Executors创建线程池

     **线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors返回的线程池对象的弊端如下：
     1）FixedThreadPool和SingleThreadPool:
       允许的请求队列(LinkedBlockingQueue)长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
     2）CachedThreadPool:
       允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。**

3. **ExecutorService执行**

   ```java
   void execute(Runnable command);
   ```

   ```java
   <T> Future<T> submit(Callable<T> task);
   ```

   - **submit()和execute区别**
     - execute提交的是Runnable类型的任务，而submit提交的是Callable或者Runnable类型的任务
     - execute的提交没有返回值，而submit的提交会返回一个Future类型的对象
     - execute提交的时候，如果有异常，就会直接抛出异常，而submit在遇到异常的时候，通常不会立马抛出异常，而是会将异常暂时存储起来，等待你调用Future.get()方法的时候，才会抛出异常

4. **ForkJoinPool**

   ​     ForkJoinPool是ExecutorService的实现类，因此是一种特殊的线程池。支持将一个任务拆分成多个“小任务”并行计算，再把多个“小任务”的结果合并成总的计算结果。

   ```java
   //实现大量数据累加
   public class ForkJoinPoolDemo {
       public static void main(String[] args) throws ExecutionException, InterruptedException {
           ForkJoinPool pool = new ForkJoinPool();
           long begin = System.currentTimeMillis();
           ForkJoinTask<Long> submit = pool.submit(new Sum(1, 100000000000L));
           System.out.println(submit.get());
           pool.shutdown();
           long end = System.currentTimeMillis();
           System.out.println("使用时间：" + (end - begin));
       }
   
   
       static class Sum extends RecursiveTask<Long> {
           private long start;
           private long end;
   
           public Sum(long start, long end) {
               this.start = start;
               this.end = end;
           }
   
           @Override
           protected Long compute() {
               if (end - start <= 10000) {
                   long sum = 0;
                   for (long i = start; i <= end; i++) {
                       sum += i;
                   }
                   return sum;
               } else {
                   long mid = (start + end) / 2;
                   Sum left = new Sum(start, mid);
                   Sum right = new Sum(mid + 1, end);
                   left.fork();
                   right.fork();
                   return left.join() + right.join();
               }
           }
       }
   
   
   }
   ```

   

### 参考资料

- https://www.cnblogs.com/aspirant/p/8657801.html































