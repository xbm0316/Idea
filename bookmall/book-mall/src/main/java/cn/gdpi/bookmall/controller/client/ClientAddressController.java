package cn.gdpi.bookmall.controller.client;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.pojo.Address;
import cn.gdpi.bookmall.service.IAddressService;
import cn.gdpi.bookmall.util.Return;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:25
 ***/
@RequestMapping("/client/address")
@RestController
public class ClientAddressController {
    @Resource
    private IAddressService iAddressService;

    /**
     * 添加地址
     * @param address
     * @param token
     * @return
     */
    @PostMapping("/add")
    @Intercept
    public Return add(@RequestBody Address address, @RequestHeader(value = "Authorization",required = false) String token){
        return iAddressService.addAddress(address,token);
    }

    /**
     * 地址列表
     * @param token
     * @return
     */
    @GetMapping("/list")
    @Intercept
    public Return list(@RequestHeader(value = "Authorization",required = false) String token){
        return iAddressService.addressList(token);
    }

}
