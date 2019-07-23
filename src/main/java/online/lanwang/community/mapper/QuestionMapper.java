package online.lanwang.community.mapper;

import online.lanwang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(id, title, description, GMT_CREATE, GMT_MODIFIED, creator, tag) values (#{id}, #{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    public void create(Question question);

    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(@Param(value = "offset")Integer offset,@Param(value = "size")Integer size);

    @Select("select count(1) from question")
    Integer count();
}
