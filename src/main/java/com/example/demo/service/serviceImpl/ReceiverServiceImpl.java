package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Receiver;
import com.example.demo.exceptionHandling.ReceiverAlreadyRegisteredException;
import com.example.demo.repository.ReceiverRepository;
import com.example.demo.service.ReceiverService;
import com.example.demo.service.dto.ReceiverDTO;
import com.example.demo.service.mapper.ReceiverMapper;

@Service
public class ReceiverServiceImpl implements ReceiverService{

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private ReceiverRepository receiverRepository;
	
	@Autowired
	private ReceiverMapper receiverMapper;


	@Override
	public List<ReceiverDTO> getAllReceiver() {
		List<Receiver> list=receiverRepository.findAll();
		List<ReceiverDTO> l=receiverMapper.toDto(list);
		return l;
	}


	@Override
	public ReceiverDTO save(ReceiverDTO receiverDTO) {
		Receiver receiver=null;
		receiver=receiverRepository.findByEmailAndMobileNumber(receiverDTO.getEmail(),receiverDTO.getMobileNumber());
		
		if(Objects.nonNull(receiver)) {
			throw new ReceiverAlreadyRegisteredException();
		}
		else {
			String hashedPassword = passwordEncoder.encode(receiverDTO.getEncryptPassword());
			receiverDTO.setEncryptPassword(hashedPassword);
			receiverRepository.save(receiverMapper.toEntity(receiverDTO));
			return receiverMapper.toDto(receiverMapper.toEntity(receiverDTO));
		}
	}


	
}
