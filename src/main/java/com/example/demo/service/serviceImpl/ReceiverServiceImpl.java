package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Receiver;
import com.example.demo.exceptionHandling.ReceiverAlreadyRegisteredException;
import com.example.demo.repository.ReceiverRepository;
import com.example.demo.service.ReceiverService;
import com.example.demo.service.dto.ReceiverDTO;
import com.example.demo.service.mapper.ReceiverMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class ReceiverServiceImpl implements ReceiverService {

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private ReceiverRepository receiverRepository;

	@Autowired
	private ReceiverMapper receiverMapper;

	@Autowired
	private MessageSource messageSource;

	@Override
	public List<ReceiverDTO> getAllReceiver() {
		List<Receiver> list = receiverRepository.findAll();
		List<ReceiverDTO> l = receiverMapper.toDto(list);
		return l;
	}

	@Override
	public ReceiverDTO save(ReceiverDTO receiverDTO) {
		Receiver receiver = null;
		receiver = receiverRepository.findByEmailAndMobileNumber(receiverDTO.getEmail(), receiverDTO.getMobileNumber());

		if (Objects.nonNull(receiver)) {
			throw new ReceiverAlreadyRegisteredException();
		} else {
			String hashedPassword = passwordEncoder.encode(receiverDTO.getEncryptPassword());
			receiverDTO.setEncryptPassword(hashedPassword);
			receiverDTO.setStatus(Boolean.FALSE);
			receiverRepository.save(receiverMapper.toEntity(receiverDTO));
			return receiverMapper.toDto(receiverMapper.toEntity(receiverDTO));

		}
	}

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

	@Override
	public MappingJacksonValue retrieveSomeBean() {
		ReceiverDTO dto = new ReceiverDTO("ajeet","bal", "ajeet", "9225551254", "ajeet@gmail.com", "Male", "asd",
				true);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("firstName","lastName");
		FilterProvider filters=new SimpleFilterProvider().addFilter("somebean",filter);
		MappingJacksonValue mapping=new MappingJacksonValue(dto);
		mapping.setFilters(filters);
	
		return mapping;
	}

}
