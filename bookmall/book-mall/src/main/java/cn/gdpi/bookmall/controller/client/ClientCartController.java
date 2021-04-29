package cn.gdpi.bookmall.controller.client;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.service.ICartService;
import cn.gdpi.bookmall.util.Return;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:22
 ***/
@RestController
@RequestMapping("/client/cart")
public class ClientCartController {

    @Resource
    private ICartService iCartService;

    /**
     * 书籍列表
     * @param token
     * @return
     */
    @Intercept
    @GetMapping("/list")
    public Return list(@RequestHeader(value = "Authorization",required = false) String token){
        return iCartService.cartItemList(token);
    }

    /**
     * 添加书籍
     * @param isbn
     * @param count
     * @param token
     * @return
     */
    @Intercept
    @GetMapping("/addBook/{isbn}/{count}")
    public Return addBook(@PathVariable String isbn,@PathVariable Integer count, @RequestHeader(value = "Authorization",required = false) String token){
        return iCartService.addBook(token,isbn,count);
    }

    /**
     * 删除书籍
     * @param isbn
     * @param token
     * @return
     */
    @Intercept
    @GetMapping("/delBook/{isbn}")
    public Return delBook(@PathVariable String isbn, @RequestHeader(value = "Authorization",required = false) String token){

        return iCartService.delBook(token,isbn);
    }

    /**
     * 更新书籍数量
     * @param isbn
     * @param count
     * @param token
     * @return
     */
    @Intercept
    @GetMapping("/updateCount/{isbn}/{count}")
    public Return updateCount(@PathVariable String isbn,@PathVariable Integer count, @RequestHeader(value = "Authorization",required = false) String token){

        return iCartService.updateCount(token,isbn,count);
    }




}
