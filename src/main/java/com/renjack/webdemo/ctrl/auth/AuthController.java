//package com.renjack.webdemo.ctrl.auth;
//
//import com.alibaba.fastjson.JSON;
//import com.introtec.cfp.base.controller.SuperController;
//import com.introtec.cfp.constant.StatusEnum;
//import com.introtec.cfp.constant.SysConst;
//import com.introtec.cfp.container.JsonResult;
//import com.introtec.cfp.context.UserContextHandler;
//import com.introtec.cfp.utils.RedisUtil;
//import com.introtec.manager.core.log.OptLog;
//import com.introtec.manager.core.log.constant.OptType;
//import com.introtec.manager.core.model.AuthModel;
//import com.renjack.webdemo.config.redis.RedisService;
//import com.renjack.webdemo.entity.auth.RsUser;
//import com.renjack.webdemo.service.auth.RsUserService;
//import common.enums.BackstageTypeEnum;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import pojo.SysUser;
//import pojo.merchant.TripMerchant;
//import service.SysUserService;
//import service.merchant.MerchantService;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@Api(tags = "鉴权管理")
//@Slf4j
//public class AuthController extends SuperController {
//
//    @Resource
//    private RedisService redisService;
//
//    @Autowired
//    private RsUserService rsUserService;
//
//
//    @ApiOperation(value = "鉴权")
//    @PostMapping("/auth")
//    public JsonResult auth(@RequestBody @Valid RsUser rsUser) {
//
//        SysUser sysUser =new SysUser();
//        sysUser.setUserName(rsUser.getUserName());
//        sysUser = sysUserService.get(sysUser);
//        log.info("sysUser:{}", JSON.toJSONString(sysUser));
//
//        String pwd = UserContextHandler.genPwd(rsUser.getUserPwd(),sysUser.getSalt());
//        if(!sysUser.getUserPwd().equals(pwd)) {
//            return JsonResult.fail("用户名或密码错误");
//        }
//
//        //构建token对象
//        Map<String,Object> tkMap=new HashMap<>();
//        tkMap.put("userId", sysUser.getId());
//        tkMap.put("userName", sysUser());
//        tkMap.put("userType", sysUser.getUserType());
//        //业务用户
//        if(BackstageTypeEnum.MERCHANT_SYSTEM.getVal().equals(sysUser.getUserType())) {
//            TripMerchant merchant = new TripMerchant();
//            merchant.setSysUserId(sysUser.getId());
//            merchant = merchantService.get(merchant);
//            if(merchant.getId()!=null) {
//                tkMap.put("mchId",merchant.getId());
//            }
//        }
//        String token = UserContextHandler.genToken(tkMap);
//        String key = SysConst.SYS_USER_KEY+sysUser.getId();
//        UserContextHandler.saveUserToReis(redisUtil,key,token,SysConst.USER_ONLINE_EXPIRE_TIME);
//        return JsonResult.success(token,"登录成功");
//    }
//
//    @ApiOperation(value = "注销")
//    @PostMapping("/logout")
//    @OptLog(type = OptType.DELETE,module = "鉴权",note = "登录注销")
//    public JsonResult logout() {
//        String token = request.getHeader(SysConst.SYS_ACCESS_TOKEN);
//        if(StringUtils.isEmpty(token)) {
//            return JsonResult.authFail("token empty");
//        }
//        String key = SysConst.SYS_USER_KEY+UserContextHandler.getUserId(token);
//        UserContextHandler.delUserFromRedis(redisUtil,key);
//        return JsonResult.success();
//    }
//}
