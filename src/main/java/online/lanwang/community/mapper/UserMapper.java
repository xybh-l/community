package online.lanwang.community.mapper;

import online.lanwang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xybh on 2019/7/19
 */
@Mapper
public interface UserMapper{
    @Insert("Insert into user (name,account_id,token,gmt_Create,gmt_Modified) value (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}