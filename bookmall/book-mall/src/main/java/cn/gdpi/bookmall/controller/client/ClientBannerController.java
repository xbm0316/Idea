package cn.gdpi.bookmall.controller.client;

import cn.gdpi.bookmall.service.IBannerService;
import cn.gdpi.bookmall.util.Return;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-23 14:45
 ***/
@RestController
@RequestMapping("/client/banner")
public class ClientBannerController {

    @Resource
    private IBannerService iBannerService;

    @GetMapping("/list")
    public Return list(){
        return iBannerService.banners();
    }

}
