package com.megatravel.mainbackend.converters;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.mainbackend.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.megatravel.mainbackend.dto.UserDto;

@Component
public class UserToUserDto implements Converter<User,UserDto> {

	@Override
	public UserDto convert(User source) {
		// TODO Auto-generated method stub
		if(source == null) {
			return null;
		}
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(source,UserDto.class);
		
		return userDto;
	}
	
	public List<UserDto> convert(List<User> source){
		
		List<UserDto> usersDTO = new ArrayList<UserDto>();
		for (User user : source) {
			usersDTO.add(convert(user));
		}
		
		return usersDTO;
	}
	

}
