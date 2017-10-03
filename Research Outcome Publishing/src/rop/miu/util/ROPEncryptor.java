package rop.miu.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import rop.miu.util.exceptions.ROPCryptographyException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ROPEncryptor {
	/**
	 * Forme courte de l'algorithme de cryptage par défaut
	 */
	public static final String DEFAULT_ENCRYPTION_ALGO_SHORT = "AES";
	
	/**
	 * Forme longue de l'algorithme de cryptage par défaut
	 */
	public static final String DEFAULT_ENCRYPTION_ALGO_LONG = "AES/CBC/PKCS5Padding";
	
	/**
	 * Clé privée de cryptage (<i>ne utiliser qu'en cas de besoin réel</i>)
	 */
	public static final String DEFAULT_ENCRYPTION_SECRET_KEY = "#1_%$M-(>=*/@]{+";
	
	/**
	 * Vecteur d'initialisation de cryptage (<i>ne utiliser qu'en cas de besoin réel</i>) 
	 */
	public static final String DEFAULT_ENCRYPTION_INIT_VECTOR = "<~r2&-I|ç.q[}9s:";

	public String encrypt(String message) throws ROPCryptographyException{
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(DEFAULT_ENCRYPTION_SECRET_KEY.getBytes(), DEFAULT_ENCRYPTION_ALGO_SHORT);
			IvParameterSpec ivParamSpec = new IvParameterSpec(DEFAULT_ENCRYPTION_INIT_VECTOR.getBytes());
	 
			Cipher cipher = Cipher.getInstance(DEFAULT_ENCRYPTION_ALGO_LONG);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParamSpec);
	 
			byte[] messageBytes = message.getBytes("UTF8");
			
			byte[] encryptedMessageBytes = cipher.doFinal(messageBytes);
			BASE64Encoder base64Encoder = new BASE64Encoder();
			
			return base64Encoder.encode(encryptedMessageBytes).replace("=", "b-@").replace("+", "-)-");
			
		} catch (IllegalBlockSizeException e) {
			throw new ROPCryptographyException(e);
		} catch (BadPaddingException e) {
			throw new ROPCryptographyException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new ROPCryptographyException(e);
		} catch (NoSuchPaddingException e) {
			throw new ROPCryptographyException(e);
		} catch (InvalidKeyException e) {
			throw new ROPCryptographyException(e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new ROPCryptographyException(e);
		} catch (UnsupportedEncodingException e) {
			throw new ROPCryptographyException(e);
		}
	}
	
	public String decrypt(String encryptedMessage) throws ROPCryptographyException{
		try {
			encryptedMessage = encryptedMessage.replace("b-@", "=").replace("-)-", "+");
			SecretKeySpec secretKeySpec = new SecretKeySpec(DEFAULT_ENCRYPTION_SECRET_KEY.getBytes(), DEFAULT_ENCRYPTION_ALGO_SHORT);
			IvParameterSpec ivParamSpec = new IvParameterSpec(DEFAULT_ENCRYPTION_INIT_VECTOR.getBytes());
	 
			Cipher cipher = Cipher.getInstance(DEFAULT_ENCRYPTION_ALGO_LONG);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParamSpec);
			
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] encryptedMessageBytes = base64Decoder.decodeBuffer(encryptedMessage);
			byte[] messageBytes = cipher.doFinal(encryptedMessageBytes);
			
			return new String(messageBytes, "UTF8");
		} catch (IllegalBlockSizeException e) {
			throw new ROPCryptographyException(e);
		} catch (BadPaddingException e) {
			throw new ROPCryptographyException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new ROPCryptographyException(e);
		} catch (NoSuchPaddingException e) {
			throw new ROPCryptographyException(e);
		} catch (InvalidKeyException e) {
			throw new ROPCryptographyException(e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new ROPCryptographyException(e);
		} catch (UnsupportedEncodingException e) {
			throw new ROPCryptographyException(e);
		} catch (IOException e) {
			throw new ROPCryptographyException(e);
		}
	}
	
	public static String hex(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i)
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		return sb.toString();
	}
	
	public static String md5Hex (String message) {
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			return hex (md.digest(message.getBytes("CP1252")));
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
	
	public static String md5HexEmail (String email) {
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			return hex (md.digest(email.toLowerCase().trim().getBytes("CP1252")));
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
}
