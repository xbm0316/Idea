package cn.gdpi.bookmall.controller.client;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.service.ICollectService;
import cn.gdpi.bookmall.util.Return;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:18
 ***/
@CrossOrigin
@RestController
@RequestMapping("/client/collect")
public class ClientCollectController {
    @Resource
    private ICollectService iCollectService;

    /**
     * 收藏书籍
     * @param isbn
     * @return
     */
    @Intercept
    @RequestMapping("/collectBook/{isbn}")
    public Return collectBook(@PathVariable String isbn, @RequestHeader(value = "Authorization",required = false) String token){
        return iCollectService.collectBook(isbn,token);
    }

    /**
     * 用户收藏书籍列表
     * @param token
     * @return
     */
    @Intercept
    @RequestMapping("/collectBookList/{page}/{limit}")
    public Return collectBookList(@RequestHeader(value = "Authorization",required = false) String token,@PathVariable int page, @PathVariable int limit) {
        return iCollectService.collectBookList(token,page,limit);
    }

    /**
     * 是否收藏书籍
     * @param isbn
     * @param token
     * @return
     */
    @GetMapping("/isCollect/{isbn}")
    @Intercept
    public Return isCollect(@PathVariable String isbn,@RequestHeader(value = "Authorization",required = false) String token){
        return iCollectService.isCollectBook(isbn,token);
    }

    /**
     * 取消收藏
     * @param isbn
     * @param token
     * @return
     */
    @Intercept
    @GetMapping("/cancelCollect/{isbn}")
    public Return cancelCollect(@PathVariable String isbn,@RequestHeader(value = "Authorization",required = false) String token){
        return iCollectService.cancelCollect(isbn,token);
    }



}
