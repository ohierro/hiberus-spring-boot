package com.hiberus.technology.evaluation.core.providers;

import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import com.hiberus.technology.evaluation.core.providers.models.UserDto;


import java.util.List;

public interface UserProvider {

    List<UserDto> getUsers(int page, int offset, int limit, String search);
    UserDto getUserById(int page, int offset, int limit, Integer id);
    void deleteUser(Integer id);
    Boolean createUser(UserDto user);
    Boolean modifyUser(UserDto user);

    // TODO: esto debería ser un UserDto
    UserEntity findByEmail(String email);
    public boolean checkPassword(String email, String passwd);

}
