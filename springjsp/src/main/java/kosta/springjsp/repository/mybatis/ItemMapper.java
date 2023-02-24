package kosta.springjsp.repository.mybatis;


import kosta.springjsp.domain.email.Email;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    void save(Email email);

    List<Email> findAll();

}
