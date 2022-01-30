package com.estock.api.dao;

import com.estock.api.dto.UserAuthorityDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthorityDAO {
    UserAuthorityDTO loadUserAuthorityByUserName(String userName);
    UserAuthorityDTO loadUserAuthorityByUserID(int userID);
}
