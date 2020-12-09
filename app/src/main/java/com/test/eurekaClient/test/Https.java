package com.test.eurekaClient.test;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.crypto.Cipher;
import com.google.inject.Key;

/**
 * https 公钥和私钥的验证   具体：https://www.jianshu.com/p/f16b1cd8148a
 * @author Administrator
 *
 */
public class Https {

	@org.junit.Test
	public void testCertificate() throws Exception {
	    final String alias = "tomcat";
	    final String keystore_password = "Pass12345";//秘钥库密码
	    final String ca_password = "Pass12345";//证书密码
	    
	    
	    //公钥证书的编码格式是x509  私钥通常是pkcs8
	    /*从keystore.cer中提取公钥*/
	    X509Certificate x509Certificate = null;
	    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
	    FileInputStream fis = new FileInputStream("D://home//keystore.cer");
	    x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fis);
	    fis.close();
	    
	    /*==========使用公钥加密============*/
	    PublicKey key = x509Certificate.getPublicKey();
	    Cipher cipher = Cipher.getInstance("RSA");
	    cipher.init(Cipher.ENCRYPT_MODE, key);
	    byte[] bytes = cipher.doFinal("helloworld".getBytes());
	    System.out.println("加密结果: " + Base64.getEncoder().encodeToString(bytes));


	    /*提取秘钥*/
	    fis = new FileInputStream("D://home//keystore.p12");
	    KeyStore keyStore = KeyStore.getInstance("JKS");
	    keyStore.load(fis, keystore_password.toCharArray());
	    fis.close();

	    PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, ca_password.toCharArray());

	    /*=======使用私钥解密=========*/
	    cipher.init(Cipher.DECRYPT_MODE, privateKey);
	    bytes = cipher.doFinal(bytes);
	    System.out.println("解密： " + new String(bytes));
	}
	
}
