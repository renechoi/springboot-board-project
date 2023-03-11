package kosta.springjspblog.domain.service;

import java.util.List;

import kosta.springjspblog.domain.dto.Article;
import kosta.springjspblog.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

	private final ArticleRepository articleRepository;

	public Article Write(Article article) {
		return articleRepository.save(article);
	}

	public List<Article> getArticles(String userId, int categoryNo) {
		return articleRepository.findAll(userId, categoryNo);
	}

	public Article getArticle(int articleNo) {
		return articleRepository.findById(String.valueOf(articleNo));
	}
}
