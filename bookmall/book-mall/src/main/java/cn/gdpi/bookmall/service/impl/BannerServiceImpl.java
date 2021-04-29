package cn.gdpi.bookmall.service.impl;

import cn.gdpi.bookmall.mapper.BannerMapper;
import cn.gdpi.bookmall.pojo.Banner;
import cn.gdpi.bookmall.service.IBannerService;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.Return;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-23 14:46
 ***/
@Service("iBannerService")
public class BannerServiceImpl implements IBannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public Return banners() {
        List<Banner> banners = bannerMapper.selectBanners();
        for (int i=0;i<banners.size();i++){
           banners.get(i).setIndex(i);
        }
        return Return.ok(Code.OK_CODE,banners);
    }
}
