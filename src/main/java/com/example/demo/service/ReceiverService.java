package com.example.demo.service;

import java.util.List;

import com.example.demo.service.dto.ReceiverDTO;

public interface ReceiverService {

	List<ReceiverDTO> getAllReceiver();

	ReceiverDTO save(ReceiverDTO receiverDTO);

}
