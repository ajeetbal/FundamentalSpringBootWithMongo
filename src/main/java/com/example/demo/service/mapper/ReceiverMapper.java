package com.example.demo.service.mapper;

import org.mapstruct.Mapper;

import com.example.demo.domain.Receiver;
import com.example.demo.service.dto.ReceiverDTO;


@Mapper(componentModel = "spring", uses = {})
public interface ReceiverMapper extends EntityMapper<ReceiverDTO, Receiver> {

}
