package kosta.boot.board.domain.repository.mapper;

import kosta.boot.board.domain.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

     int save(Board params);
     Board findByIdx(Long idx);
     int update(Board params);
     int delete(Long idx);
     List<Board> findByAll();
     int getCount();
}