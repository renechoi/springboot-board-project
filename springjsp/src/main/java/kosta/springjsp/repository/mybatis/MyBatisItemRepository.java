package kosta.springjsp.repository.mybatis;


import kosta.springjsp.domain.email.Email;
import kosta.springjsp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisItemRepository implements ItemRepository {

    private final ItemMapper itemMapper;

    @Override
    public Email save(Email email) {
        itemMapper.save(email);
        return email;
    }

    @Override
    public List<Email> findAll() {
        return itemMapper.findAll();
    }
}
