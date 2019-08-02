package com.ttsx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttsx.pojo.Item;

public interface ItemMapper extends BaseMapper<Item>{
	
	@Select("select * from tt_item order by updated desc limit #{startIndex},#{rows}")
	List<Item> findItemByPage(@Param("startIndex")Integer startIndex, @Param("rows")Integer rows);

}
