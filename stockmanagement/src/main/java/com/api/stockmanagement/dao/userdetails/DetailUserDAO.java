package com.api.stockmanagement.dao.userdetails;

import com.api.stockmanagement.provider.userdetails.data.adapter.UserAdapter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailUserDAO {
    UserAdapter inquiryUserByUsername(String userName);
}
