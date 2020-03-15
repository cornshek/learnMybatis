package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Category;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //根据配置文件mybatis-config.xml得到sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //根据sqlSessionFactory得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过sqlSession的selectList方法，调用语句listCategory(Category.xml中设置的语句的id)
        List<Category> categories = sqlSession.selectList("listCategory");
        for (Category category : categories) {
            System.out.println(category.getName());
        }
    }
}
