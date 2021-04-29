package cn.gdpi.bookmall.controller.admin;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.pojo.Book;
import cn.gdpi.bookmall.service.IBookService;
import cn.gdpi.bookmall.util.Return;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 21:42
 ***/
@RestController
@RequestMapping("/admin/book")
@CrossOrigin
public class AdminBookController {

    @Resource
    private IBookService iBookService;

    @Intercept(role = 1)
    @PostMapping("/insertBook")
    public Return insertBook(Book book, MultipartFile[] files){
        return iBookService.insertBook(book,files);
    }

    @Intercept(role = 1)
    @GetMapping("/bookInfo/{isbn}")
    public Return bookInfo(@PathVariable String isbn){
        return iBookService.bookInfo(isbn);
    }

    @Intercept(role = 1)
    @GetMapping("/bookList/{page}/{limit}")
    public Return bookList(@PathVariable int page, @PathVariable int limit){
        return iBookService.bookList(page,limit);
    }
    @Intercept(role = 1)
    @PostMapping("/update")
    public Return bookUpdate(@RequestBody Book book){
        return iBookService.bookUpdate(book);
    }



    @PostMapping("/up")
    public String up(MultipartFile file, HttpServletRequest request) throws IOException {
        try {
            File pathRoot = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println("保存的路径pathRoot："+pathRoot.getAbsolutePath());
            if(!pathRoot.exists()) {
                pathRoot = new File("");
            }

            String saveFile = pathRoot.getAbsolutePath().replace("%20"," ").replace('/', '\\')+"\\static\\aaa";
            System.out.println(pathRoot.getAbsolutePath().replace("%20"," "));
            File f = new File(saveFile);
            if(!f.exists()) {
                f.mkdirs();
            }
            FileOutputStream writer = new FileOutputStream(new File(f , file.getOriginalFilename()));
            writer.write(file.getBytes());
            writer.flush();
            writer.close();
            return saveFile;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "sfsd";
        }

    }
}
