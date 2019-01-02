package com.neo.mapper;

import com.neo.entity.Route;
import com.neo.entity.Site;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface SiteRouteMapper {
    //新增站点
    @Insert("INSERT INTO SITE(SITE_ID,SITE_ADDRESS) VALUES(#{SITE_ID},#{SITE_ADDRESS})")
    int addNewSite(Site site);
    //查询站点
    @Select("SELECT * FROM SITE WHERE SITE_ID like '%'||#{KEY}||'%' OR SITE_ADDRESS like '%'||#{KEY}||'%'")
    List<Site> searchSite(@Param(value = "KEY") String KEY);
    //更改站点
    @Update("UPDATE SITE SET SITE_ADDRESS=#{SITE_ADDRESS} WHERE SITE_ID=#{SITE_ID}")
    int changeSite(Site site);
    //删除站点
    @Delete("DELETE FROM SITE WHERE  SITE_ID=#{SITE_ID}")
    int deleteSite(@Param(value = "SITE_ID") Long SITE_ID);
    //新增路线
    @Insert("INSERT INTO ROUTE(SITE_1_ID,SITE_2_ID,DISTANCE) VALUES(#{SITE_1_ID},#{SITE_2_ID},#{DISTANCE})")
    int addNewRoute(Route route);
    //删除路线
    @Delete("DELETE FROM ROUTE WHERE SITE_1_ID=#{SITE_1_ID} AND SITE_2_ID=#{SITE_2_ID}")
    int deleteRoute(@Param(value = "SITE_1_ID") Long SITE_1_ID,@Param(value = "SITE_2_ID") Long SITE_2_ID);
}
