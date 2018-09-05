package com.kz.kzsys;

import com.kz.kzsys.model.KzUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by mr.chan on 2018/9/4.
 */
public class PasswordHelper {
    //随机数生成器
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    //指定散列算法为md5
    private String algorithmName = "MD5";
    //散列迭代次数
    private final int hashIterations = 2;

    /**
     * 生成随机盐值对密码进行加密
     * @param userLogin  登录识别串（用户名）
     * @return
     */
    public  KzUser encrypt(KzUser userLogin) {
        userLogin.setSalt(randomNumberGenerator.nextBytes().
                toHex());
        String newPassword =
                new SimpleHash(algorithmName,userLogin.getPassword(),
        ByteSource.Util.bytes(userLogin.getCredentialsSalt()),hashIterations).toHex();


        userLogin.setPassword(newPassword);
        System.out.println("password:"+newPassword+"\tsalt:==="+userLogin.getCredentialsSalt());
        return userLogin;

    }

    public static void main(String[] args) {
        KzUser kzUser = new KzUser();
        kzUser.setUsername("二狗子");
        kzUser.setPassword("123456");
        new PasswordHelper().encrypt(kzUser);
    }
}
