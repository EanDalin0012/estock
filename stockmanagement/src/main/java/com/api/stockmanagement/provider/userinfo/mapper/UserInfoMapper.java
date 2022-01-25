package com.api.stockmanagement.provider.userinfo.mapper;

import com.api.stockmanagement.provider.userinfo.data.adapter.UserInfoAdapter;
import com.api.stockmanagement.provider.userinfo.data.request.UserInfoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {
    public static final UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);
//    @Mapping( target = "id", source = "id")
    UserInfoAdapter convert(UserInfoRequest userInfoRequest);
}
