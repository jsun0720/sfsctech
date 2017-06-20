package com.sfsctech.website.jsp.controller;

import com.sfsctech.base.model.PagingInfo;
import com.sfsctech.base.result.ActionResult;
import com.sfsctech.cache.redis.RedisProxy;
import com.sfsctech.framework.model.dto.SysAccountDto;
import com.sfsctech.website.jsp.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Class IndexController
 *
 * @author 张麒 2017/5/12.
 * @version Description:
 */
@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisProxy redis;

    @GetMapping("index.html")
    public String index() {
        logger.info("IndexController.index()");
        redis.put("test_key", IndexController.class);

        logger.info(String.valueOf(redis.get("test_key")));
        return "index";
    }

    @PostMapping("getData.ajax")
    @ResponseBody
    public ActionResult<PagingInfo<SysAccountDto>> getData(@RequestBody PagingInfo<SysAccountDto> pagingInfo) {
        System.out.println(pagingInfo.getCondition());
        ActionResult<PagingInfo<SysAccountDto>> result = accountService.findByPage(pagingInfo);
        System.out.println(result.getResult());
        result.getResult().getData().forEach(System.out::println);
        return result;
    }

    @PostMapping("saveData.ajax")
    @ResponseBody
    public ActionResult<SysAccountDto> save(SysAccountDto model) {
        return accountService.save(model);
    }
}
