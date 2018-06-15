package com.hiberus.technology.evaluation.core.providers.impl;

import com.hiberus.technology.evaluation.core.db.UserRepository;
import com.hiberus.technology.evaluation.core.db.entity.UserEntity;
import com.hiberus.technology.evaluation.core.providers.UserProvider;
import com.hiberus.technology.evaluation.core.providers.models.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserProviderImpl implements UserProvider{

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private EntityManager em;

    @Autowired
    public UserProviderImpl(UserRepository userRepository, ModelMapper modelMapper, EntityManager em) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.em = em;
    }

    @Override
    public List<UserDto> getUsers(int page, int offset, int limit, String search) {
        List<UserEntity> dbUsers = userRepository.findAll();
        return dbUsers.stream().map(user -> convertToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int page, int offset, int limit, Integer id) {
        return convertToDto(userRepository.findById(id).get());
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<UserEntity> entity = userRepository.findById(id);
//        if (!entity.isPresent())
//            throw new Exception("User not found");
        userRepository.delete(entity.get());
    }

    @Override
    public Boolean createUser(UserDto userForm) { 

        try {
            UserEntity user = convertToEntity(userForm);
            userRepository.save(user);
            return true;
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public Boolean modifyUser(UserDto userForm) {//TODO comprobar los campos que cambian
//        UserEntity newUser = convertToEntity(userForm);
//
//        if(userRepository.exists(newUser.getId_user())){
//            userRepository.save(newUser);
//            return true;
//        }
        return false;
    }

    private UserDto convertToDto(UserEntity user) {
        return modelMapper.map(user, UserDto.class);
    }

    private UserEntity convertToEntity(UserDto user) {//posible solucion de cara a crear y modificar users.
        return modelMapper.map(user, UserEntity.class);
    }

	@Override
	public UserEntity findByEmail(String email) {
		List<UserEntity> dbUsers = userRepository.findAll();
		UserEntity user = new UserEntity();
		for (UserEntity userEntity : dbUsers) {
			if (email.equals(userEntity.getEmail())) {
				return userEntity;
			}
		}
		return user;
	}
	public boolean checkPassword(String email, String passwd) {
    	return passwd.equals(findByEmail(email).getPasswd());
    }

}
