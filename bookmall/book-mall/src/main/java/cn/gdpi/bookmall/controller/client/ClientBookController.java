package cn.gdpi.bookmall.controller.client;

import cn.gdpi.bookmall.service.IBookService;
import cn.gdpi.bookmall.util.Return;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 19:19
 ***/

@RestController
@RequestMapping("/client/book")
public class ClientBookController {

    private final Logger logger = LoggerFactory.getLogger(ClientBookController.class);

    @Resource
    private IBookService iBookService;



    /**
     * 主页 搜索
     * @return
     */
    @GetMapping("/booksBySearch/{page}/{limit}")
    public Return booksBySearch(@RequestParam(value = "key",required = false) String searchKey, @PathVariable int page, @PathVariable int limit){
        logger.info("主页搜索  第"+page+"页 "+limit+"条数据  key: "+searchKey);
        return iBookService.booksBySearch(searchKey,page,limit);
    }


    /**
     * 书籍详情
     * @param isbn
     * @return
     */
    @GetMapping("/bookInfo/{isbn}")
    public Return bookInfo(@PathVariable String isbn){
        logger.info("书籍详情 isbn: "+isbn);
        return iBookService.bookInfo(isbn);
    }

    /**
     * 推荐书籍列表
     * @return
     */
    @GetMapping("/recommendedBooks")
    public Return recommendedBooks(){
        return iBookService.recommendedBooks();
    }



}
