package com.example.demo.service.mapper;

import com.example.demo.domain.Receiver;
import com.example.demo.service.dto.ReceiverDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-17T15:32:47+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class ReceiverMapperImpl implements ReceiverMapper {

    @Override
    public Receiver toEntity(ReceiverDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Receiver receiver = new Receiver();

        receiver.setFirstName( dto.getFirstName() );
        receiver.setLastName( dto.getLastName() );
        receiver.setUserName( dto.getUserName() );
        receiver.setMobileNumber( dto.getMobileNumber() );
        receiver.setEmail( dto.getEmail() );
        receiver.setGender( dto.getGender() );
        receiver.setEncryptPassword( dto.getEncryptPassword() );

        return receiver;
    }

    @Override
    public ReceiverDTO toDto(Receiver entity) {
        if ( entity == null ) {
            return null;
        }

        ReceiverDTO receiverDTO = new ReceiverDTO();

        receiverDTO.setFirstName( entity.getFirstName() );
        receiverDTO.setLastName( entity.getLastName() );
        receiverDTO.setUserName( entity.getUserName() );
        receiverDTO.setMobileNumber( entity.getMobileNumber() );
        receiverDTO.setEmail( entity.getEmail() );
        receiverDTO.setGender( entity.getGender() );
        receiverDTO.setEncryptPassword( entity.getEncryptPassword() );

        return receiverDTO;
    }

    @Override
    public List<Receiver> toEntity(List<ReceiverDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Receiver> list = new ArrayList<Receiver>( dtoList.size() );
        for ( ReceiverDTO receiverDTO : dtoList ) {
            list.add( toEntity( receiverDTO ) );
        }

        return list;
    }

    @Override
    public List<ReceiverDTO> toDto(List<Receiver> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReceiverDTO> list = new ArrayList<ReceiverDTO>( entityList.size() );
        for ( Receiver receiver : entityList ) {
            list.add( toDto( receiver ) );
        }

        return list;
    }
}
