package mapper;

import org.apache.ibatis.annotations.Select;
import pojo.Product;

import java.util.List;

public interface ProductMapper {

    @Select("select * from product_ where category_id = #{id}")
    public List<Product> listByCategory(int id);
}
