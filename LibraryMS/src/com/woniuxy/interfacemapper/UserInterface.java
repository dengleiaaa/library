package com.woniuxy.interfacemapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.woniuxy.pojo.regiestUserVo;
import com.woniuxy.pojo.userVo;

public interface UserInterface {
    @Select("select uacc username,upass password from user where uacc=#{username} and upass=#{password}")
	public userVo loginmapper(userVo userVo);

    @Select("select uacc acc from user where uacc=#{acc}")
    public regiestUserVo regiestmapper(regiestUserVo regiestUserVo);

    @Insert("insert into user(uacc,upass) values(#{acc},#{pass})")
	public int insertUser(regiestUserVo regiestUserVo);

	@Select("select uid from user where uacc=#{username}")
    public int selidByAcc(String username);
}
