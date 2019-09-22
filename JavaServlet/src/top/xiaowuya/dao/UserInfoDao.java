package top.xiaowuya.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import top.xiaowuya.domain.UserInfo;
import top.xiaowuya.util.JDBCUtil;

/**
 * 操作数据库中UserInfo表的类
 */
public class UserInfoDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());


    public int setUserInfo(UserInfo userInfo){

        String sql = "INSERT INTO userinfo (id,nickName,gender,avatarUrl,language,country,provice,city) VALUES (?,?,?,?,?,?,?,?)";

        int update = template.update(sql, userInfo.getId(),userInfo.getNickName(), userInfo.getGender(), userInfo.getAvatarUrl(),
                userInfo.getLanguage(), userInfo.getCountry(), userInfo.getProvince(), userInfo.getCity());

        return update;

    }



}
