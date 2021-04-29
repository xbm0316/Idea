package cn.gdpi.bookmall.service.impl;

import cn.gdpi.bookmall.dto.AdminProductListBook;
import cn.gdpi.bookmall.dto.ClientIndexBookDTO;
import cn.gdpi.bookmall.dto.RecommendedBookDTO;
import cn.gdpi.bookmall.mapper.BookImageMapper;
import cn.gdpi.bookmall.mapper.BookMapper;
import cn.gdpi.bookmall.pojo.Book;
import cn.gdpi.bookmall.pojo.BookImage;
import cn.gdpi.bookmall.service.IBookService;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.Return;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 19:22
 ***/
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service("iBookService")
public class BookServiceImpl implements IBookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookImageMapper bookImageMapper;

    @Override
    public Return booksBySearch(String searchKey, int page, int limit) {
        if(page<=0){
            page=1;
        }
        if(limit<=0){
            page=5;
        }
        PageHelper.startPage(page,limit);
        List<ClientIndexBookDTO> books = bookMapper.selectBooksLikeKey(searchKey);
        PageInfo<ClientIndexBookDTO> pageInfo=new PageInfo<>(books);
        Collections.shuffle(pageInfo.getList());
        return Return.ok(Code.OK_CODE,pageInfo);
    }

    @Override
    public Return insertBook(Book book, MultipartFile[] files) {
        if (files.length<=0 || files.length>9|| ObjectUtils.isEmpty(book)) {
            return Return.error(Code.ERROR_CODE,"添加书籍失败");
        }
        boolean flag= uploadingFiles(files,book.getIsbn());
        if(!flag){
            return Return.error(Code.ERROR_CODE,"添加书籍失败");
        }
        int bookNum= bookMapper.insertBook(book);
        if(bookNum!=1){
            return Return.error(Code.ERROR_CODE,"添加书籍失败");
        }
        return Return.ok(Code.OK_CODE,"添加书籍成功");
    }

    @Override
    public Return bookInfo(String isbn) {
        if(!StringUtils.hasText(isbn)){
            return Return.ok(Code.ERROR_CODE,"");
        }
        Book book=bookMapper.selectOne(isbn);
        return Return.ok(Code.OK_CODE,book);
    }

    @Override
    public Return bookList(int page, int limit) {
        if(page<=0){
            page=1;
        }
        if(limit<=0){
            page=5;
        }
        PageHelper.startPage(page,limit);
        List<AdminProductListBook> books = bookMapper.selectAdminProductListBooks();
        PageInfo<AdminProductListBook> pageInfo=new PageInfo<>(books);
        Collections.shuffle(pageInfo.getList());
        return Return.ok(Code.OK_CODE,pageInfo);
    }

    @Override
    public Return bookUpdate(Book book) {
      int n= bookMapper.updateBook(book);
      if(n!=1){
          return Return.error(Code.ERROR_CODE,"更新书籍失败");
      }
      return Return.ok(Code.OK_CODE,"更新书籍成功");
    }

    @Override
    public Return recommendedBooks() {

       List<RecommendedBookDTO> list=bookMapper.selectrecommendedBooks();
        return Return.ok(Code.OK_CODE,list);
    }

    private boolean uploadingFiles(MultipartFile[] files,String isbn) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        boolean flag=false;
        for(int i=0;i<files.length;i++){
            String originalFilename = files[i].getOriginalFilename();
            String path= null;
            try {
                path = ResourceUtils.getURL("classpath:").getPath()+"static"+"/images/goods/"+isbn+"/";

                File f = new File(path);
                if(!f.exists()){
                    f.mkdirs();
                }
                files[i].transferTo(new File(f,originalFilename));
                //request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                String fileUrl= request.getContextPath()+"/images/goods/"+isbn+"/"+originalFilename;
                BookImage bookImage = new BookImage();
                bookImage.setBookIsbn(isbn);
                bookImage.setType(i);
                bookImage.setUrl(fileUrl);
                int num=bookImageMapper.insertBookImage(bookImage);
                if(num==1){
                    flag=true;
                }
            } catch (Exception e) {
                e.printStackTrace();
               flag=false;
            }
        }
        return flag;
    }


}
