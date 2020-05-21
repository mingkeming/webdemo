//package com.renjack.webdemo.tools;
//
//import cn.hutool.crypto.SecureUtil;
//import com.introtec.cfp.constant.SysConst;
//import com.introtec.cfp.utils.JwtHelper;
//import com.introtec.cfp.utils.RedisUtil;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
///**
// * 系统用户管理容器
// * @author liufei
// */
//public class UserContextHandler {
//
//    /**
//     * 生成密码
//     * @param pwd 用户基础密码
//     * @param salt 加密盐
//     * @return
//     */
//    public static String genPwd(String pwd,String salt) {
//        return SecureUtil.sha1(pwd+salt);
//    }
//
//    /**
//     * 获取当前用户token
//     * @return
//     */
//    public static String getToken() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String token=request.getHeader(SysConst.SYS_ACCESS_TOKEN);
//        return token;
//    }
//
//    /**
//     * 创建token
//     * @return
//     */
//    public static String genToken(Map<String,Object> map)
//    {
//        return JwtHelper.sign(map);
//    }
//
//    /**
//     * 验证token
//     * @param token
//     * @return
//     */
//    public static boolean validToken(String token)
//    {
//        return JwtHelper.verity(token);
//    }
//
//    /**
//     * 获取用户ID
//     * @return
//     */
//    public static Integer getUserId() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String token=request.getHeader(SysConst.SYS_ACCESS_TOKEN);
//        Integer userId=JwtHelper.getTokenDataToInt(token,"userId");
//        return userId;
//    }
//
//    /**
//     * 获取用户名
//     * @return
//     */
//    public static String getUserName() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String token=request.getHeader(SysConst.SYS_ACCESS_TOKEN);
//        String userName=JwtHelper.getTokenDataToStr(token,"userName");
//        return userName;
//    }
//
//    /**
//     * 获取商户ID
//     * @return
//     */
//    public static Integer getMchId() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String token=request.getHeader(SysConst.SYS_ACCESS_TOKEN);
//        Integer mchId=JwtHelper.getTokenDataToInt(token,"mchId");
//        return mchId;
//    }
//
//    /**
//     * 获取用户类型
//     * @return
//     */
//    public static Integer getUserType() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String token=request.getHeader(SysConst.SYS_ACCESS_TOKEN);
//        Integer userType=JwtHelper.getTokenDataToInt(token,"userType");
//        return userType;
//    }
//
//    /**
//     * 获取用户ID
//     * @param token
//     * @return
//     */
//    public static Integer getUserId(String token) {
//        Integer userId=JwtHelper.getTokenDataToInt(token,"userId");
//        return userId;
//    }
//
//    /**
//     * 获取用户名
//     * @param token
//     * @return
//     */
//    public static String getUserName(String token) {
//        String userName = JwtHelper.getTokenDataToStr(token,"userName");
//        return userName;
//    }
//
//    /**
//     * 获取商户ID
//     * @param token
//     * @return
//     */
//    public static Integer getMchId(String token) {
//        Integer mchId = JwtHelper.getTokenDataToInt(token,"mchId");
//        return mchId;
//    }
//
//    /**
//     * 获取用户名
//     * @param token
//     * @return
//     */
//    public static Integer getUserType(String token) {
//        Integer userType=JwtHelper.getTokenDataToInt(token,"userType");
//        return userType;
//    }
//
//    /**
//     * 保存用户信息至Redis
//     * @param redisUtil redis工具类
//     * @param key redis key
//     * @param token 令牌
//     */
//    public static void saveUserToReis(RedisUtil redisUtil,String key, String token,Integer expireTime) {
//        if(expireTime!=null)
//        {
//            redisUtil.set(key,token,SysConst.USER_ONLINE_EXPIRE_TIME);
//        }else{
//            redisUtil.set(key,token);
//        }
//    }
//
//    /**
//     * 判断token是否存在
//     * @param redisUtil
//     * @param key 用户存储key
//     * @return
//     */
//    public static boolean isExit(RedisUtil redisUtil, String key)
//    {
//        return redisUtil.hasKey(key);
//    }
//
//    /**
//     * 从redis中删除用户信息
//     * @param redisUtil redis工具类
//     * @param key 用户存储key
//     */
//    public static void delUserFromRedis(RedisUtil redisUtil,String key)
//    {
//        redisUtil.del(key);
//    }
//
//}
