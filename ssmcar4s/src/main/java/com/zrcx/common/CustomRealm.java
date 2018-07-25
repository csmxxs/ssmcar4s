package com.zrcx.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zrcx.Dao.IMenuDao;
import com.zrcx.Dao.IUserDao;
import com.zrcx.entity.Role;
import com.zrcx.entity.User;

public class CustomRealm extends AuthorizingRealm {
 
    // 设置realm的名称    
    @Override    
    public void setName(String name) {    
        super.setName("customRealm");    
    }    
    
    @Autowired    
    private IMenuDao adminUserService; //查找用户的权限信息   
    @Autowired
    private IUserDao iuserdao;
    /***  
     * 认证  
     **/  
    @Override    
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {    
    
        // token中包含用户输入的用户名和密码    
        // 第一步从token中取出用户名    
        String userName = (String) token.getPrincipal();   
        Map<String, Object> map= new HashMap<String, Object>();
        map.put("userName", userName);
        // 第二步：根据用户输入的userCode从数据库查询    
        User adminUser = iuserdao.findUser(map);   
        // 如果查询不到返回null    
        if (adminUser == null) {   
            return null;    
        }    
        // 获取数据库中的密码    
        String password = adminUser.getPassword();    
        /**  
         * 认证的用户,正确的密码 
         * SimpleAuthenticationInfo构造一个用户对象，之后，可通过Subject subject = SecurityUtils.getSubject();中的subject.getPrincipal()获取到此对象 
         */    
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(adminUser, password, this.getName());    
        //MD5 加密+加盐+多次加密 SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(adminUser, password,ByteSource.Util.bytes(salt), this.getName())    
        return authcInfo;    
    }    
    
    /**  
     * 授权,只有成功通过doGetAuthenticationInfo方法的认证后才会执行
     */  
    @Override    
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {    
        // 从 principals获取主身份信息    
        // 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），    
        User activeUser = (User) principals.getPrimaryPrincipal();    
        // 根据身份信息获取权限信息    
        // 从数据库获取到权限数据    
      //  Role adminRoles = adminUserService.getMenusByRoleId(activeUser.getRoleId());    
        // 单独定一个集合对象()    
        List<String> permissions = new ArrayList<String>();    
//        if (adminRoles != null) {    
//            permissions.add(adminRoles.getName());    
//        }    
        // 查到权限数据，返回授权信息(要包括 上边的permissions)    
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();    
        // 将上边查询到授权信息填充到simpleAuthorizationInfo对象中    
        simpleAuthorizationInfo.addStringPermissions(permissions);    
        return simpleAuthorizationInfo;    
    }    
    
    // 清除缓存    
    public void clearCached() {    
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();    
        super.clearCache(principals);    
    }  
} 