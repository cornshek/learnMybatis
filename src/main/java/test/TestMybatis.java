package test;

import mapper.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Category;
import pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //根据配置文件mybatis-config.xml得到sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //根据sqlSessionFactory得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        //新增
//        Category categoryNew = new Category();
//        categoryNew.setName("新增的category");
//        sqlSession.insert("addCategory", categoryNew);

        //Mapper方式新增
//        Category category = new Category();
//        category.setName("mapper方式新增的Category");
//        categoryMapper.add(category);

        //删除
//        sqlSession.delete("deleteCategory", 1);

        //Mapper方式删除
//        categoryMapper.delete(5);

        //更新
//        Category categoryUpdate = sqlSession.selectOne("getCategory", 3);
//        categoryUpdate.setName("被修改了名字");
//        sqlSession.update("updateCategory", categoryUpdate);

        //Mapper方式更新
//        Category category = categoryMapper.get(3);
//        category.setName("Mapper方式的更新第二次");
//        categoryMapper.update(category);

        //将查询结果放在List<>中
        List<Category> categories = null;
        List<Product> productList = null;

        //通过sqlSession的selectList方法，调用语句listCategory(Category.xml中设置的语句的id)
//      categories = sqlSession.selectList("listCategory");

        //Mapper方式的查询
        categories = categoryMapper.list();

        //模糊查询ByName
//      categories = sqlSession.selectList("listCategoryByName", "修改");

        //模糊查询ByNameAndId
        //将多个参数放在map中
//        Map<String, Object> param = new HashMap<>();
//        param.put("id", 3);
//        param.put("name", "cat");
//        categories = sqlSession.selectList("listCategoryByIdAndName",param);

        //一对多关联查询
//        categories = sqlSession.selectList("listCategoryDetails");

        //if标签实现一条sql语句应对多种情况
//        productList = sqlSession.selectList("listProduct");
//        Map<String, Object> param = new HashMap<>();
//        param.put("name", "a");
//        param.put("price", 88);
//        productList = sqlSession.selectList("listProduct",param);

        //使用<foreach>标签，多选操作
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(1);
//        integerList.add(3);
//        integerList.add(5);

//        productList = sqlSession.selectList("listProduct",integerList);


        //打印查询结果
        for (Category c : categories) {
            System.out.println(c);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
