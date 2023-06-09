package kosta.boot.board.domain.repository.mybatis.mapper;

import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.pagination.ArticleSearchCondition;
import kosta.boot.board.domain.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ArticleMapper {

     int save(ArticleDto articleDto);
     int update(@Param("idx") int idx, @Param("updateParam") ArticleDto articleDto);
     int delete(Long idx);
     Optional<ArticleDto> findByIdx(Long idx);
     List<ArticleDto> findAll(Pagination pagination);
     int getCount();

}