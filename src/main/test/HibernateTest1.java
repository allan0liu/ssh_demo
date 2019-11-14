import java.util.Arrays;
import java.util.List;

import com.allan.entity.Customer;
import com.allan.entity.Order;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest1 {

    // 保存一个Customer
    @Test
    public void saveCustomerTest() {
        // 创建一个Customer
        Customer c = new Customer();
        c.setName("张三");
        c.setAddress("北京");
        c.setSex("男");
        Order order = new Order();
        order.setC(c);
        order.setMoney(12.0);
        order.setReceiverInfo("aaaa");
        Order order2 = new Order();
        order2.setC(c);
        order2.setMoney(22.0);
        order2.setReceiverInfo("bbbbb");
        // 使用hibernate的api来完成将customer信息保存到mysql中操作
        Configuration config = new Configuration().configure(); // 加载hibernate.cfg.xml

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession(); // 相当于得到一个Connection。
        // 开启事务
        Transaction transaction = session.beginTransaction();
        // 操作
        session.save(c);

        // 事务提交
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    // 根据id查询一个Customer对象
    @Test
    public void findCustomerByIdTest() {

        Configuration config = new Configuration().configure();

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession(); // 相当于得到一个Connection。
        // 开启事务
        session.beginTransaction();

        // 根据业务来编写代码
        // Customer c = session.get(Customer.class, 1);
        Customer c = session.load(Customer.class, 1);

        System.out.println(c.getName());

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    // 修改操作
    @Test
    public void updateCustomerTest() {

        Configuration config = new Configuration().configure();

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession(); // 相当于得到一个Connection。
        // 开启事务
        session.beginTransaction();

        // 根据业务来编写代码
        Customer c = session.get(Customer.class, 1);
        c.setName("李四");

        session.update(c); // 修改操作

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    // 删除操作-----根据id进行删除
    @Test
    public void deleteCustomerTest() {

        Configuration config = new Configuration().configure();

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession(); // 相当于得到一个Connection。
        // 开启事务
        session.beginTransaction();

        // 根据业务来编写代码
        Customer c = session.get(Customer.class, 1);

        session.delete(c); // 删除操作

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    // 查询所有Customer

    @Test
    public void findAllCustomerTest() {

        Configuration config = new Configuration().configure();

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession(); // 相当于得到一个Connection。
        // 开启事务
        session.beginTransaction();

        // 根据业务来编写代码
        Query query = session.createQuery("from Customer"); // HQL 它是类似于sql, from 后边是类名
        List<Customer> list = query.list();
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_customer");
//		List<Customer> list = sqlQuery.list();

        System.out.println(list);

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testRelation(){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection。
        // 开启事务
        session.beginTransaction();
    }

    @Test
    public void TestDouble(){
        double v = Double.parseDouble("2");
        System.out.println(v);
        long v2 = (long)0.2*10;
        System.out.println(v2);
    }
}
