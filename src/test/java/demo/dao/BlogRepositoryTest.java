package demo.dao;

import demo.domain.Blog;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 002559 on 2018/8/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @Before
    public void initRepositoryData(){
        blogRepository.deleteAll();

        blogRepository.save(new Blog("行宫", "唐代元稹的行宫",
                "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。"));

        blogRepository.save(new Blog("宫词·故国三千里", "唐代张祜的宫词",
                "故国三千里，深宫二十年。一声何满子，双泪落君前。"));

        blogRepository.save(new Blog("江雪", "唐代柳宗元的江雪",
                "千山鸟飞绝，万径人踪灭。孤舟蓑笠翁，独钓寒江雪。"));
    }

   @Test
   public void testFindDistinctBlogByTitleContainingOrTagContainingOrContentContaining(){
       Pageable pageable = new PageRequest(0, 20);
       String title = "宫";
       String tag = "词";
       String content = "白头";

      Page<Blog> pages =  blogRepository.findDistinctBlogByTitleContainingOrTagContainingOrContentContaining(title, tag, content, pageable);
      Assert.assertEquals(2, pages.getTotalElements());

      System.out.println("-------------start-----------");
      for (Blog blog : pages) {
          System.out.println(blog);
      }
      System.out.println("-------------end-----------");
   }



}
