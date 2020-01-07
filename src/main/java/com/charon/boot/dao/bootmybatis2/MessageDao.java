package com.charon.boot.dao.bootmybatis2;

import com.charon.boot.model.bootmybatis2.Message;
import com.charon.boot.model.bootmybatis2.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageDao {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}