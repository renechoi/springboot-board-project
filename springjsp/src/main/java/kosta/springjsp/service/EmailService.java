package kosta.springjsp.service;

import kosta.springjsp.domain.email.Email;
import kosta.springjsp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public Email save(Email email) {
        return itemRepository.save(email);
    }

    @Override
    public List<Email> findItems() {
        return itemRepository.findAll();
    }
}
