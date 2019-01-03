package snake.framework.common.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密解密帮助类
 *
 * @author sujunxuan
 */
public final class CryptoUtil {

    /**
     * MD5
     */
    public static final String MD5 = "MD5";

    /**
     * SHA-1
     */
    public static final String SHA1 = "SHA1";

    private CryptoUtil() {
    }

    /**
     * 根据加密模式转换为byte数组
     *
     * @param str         待加密字符串
     * @param encryptMode 加密模式
     * @return 加密后的byte数组
     * @throws NoSuchAlgorithmException 当指定的encryptMode不存在时抛出
     */
    public static byte[] convertToEncryptByte(String str, String encryptMode)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(encryptMode);
        md.update(str.getBytes());
        return md.digest();
    }

    /**
     * MD5加密
     *
     * @param str 待加密字符串
     * @return 加密后的16进制全大写字符串
     */
    public static String md5HexBinary(String str) {
        return toEncryptHexBinary(str, MD5);
    }

    /**
     * SHA-1加密
     *
     * @param str 待加密字符串
     * @return 加密后的16进制全大写字符串
     */
    public static String sha1HexBinary(String str) {
        return toEncryptHexBinary(str, SHA1);
    }

    /**
     * 获取加密后的16进制全大写字符串
     *
     * @param str         待加密字符串
     * @param encryptMode 加密模式
     * @return 加密后的16进制全大写字符串
     */
    private static String toEncryptHexBinary(String str, String encryptMode) {
        try {
            byte[] encryptByte = convertToEncryptByte(str, encryptMode);
            if (encryptByte == null || encryptByte.length == 0) {
                return null;
            }

            return DatatypeConverter.printHexBinary(encryptByte);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
