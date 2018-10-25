package demo.dao;

import demo.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
        * Created by 002559 on 2018/8/29.
        */
public interface BlogRepository extends ElasticsearchRepository<Blog, String>{

    /**
     * 分页查询博客(去重)
     * @param title
     * @param tag
     * @param content
     * @return
     */
    Page<Blog> findDistinctBlogByTitleContainingOrTagContainingOrContentContaining(String title, String tag, String content, Pageable pageable);

}
