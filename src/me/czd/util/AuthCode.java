package me.czd.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * java 中图形的 验证码生成工具类
 * 
 * @author Administrator
 *
 */
public class AuthCode {
	// 验证码长度
	public static final int AUTHCODE_LENGTH = 5;
	// 单个验证码宽度
	public static final int SIGNLECODE_WIDTH = 15;
	// 单个验证码高度
	public static final int SIGNLECODE_HEIGHT = 30;
	// 单个验证码之间的间隔
	public static final int SIGNLECODE_GAP = 4;
	// 图片
	public static final int IMG_WIDTH = AUTHCODE_LENGTH * (SIGNLECODE_WIDTH + SIGNLECODE_GAP);;
	public static final int IMG_HEIGHT = SIGNLECODE_HEIGHT;

	// 获取 验证码
	public static String getAuthCode() {
		StringBuffer authCode = new StringBuffer("");
		for (int i = 0; i < AUTHCODE_LENGTH; i++) {
			authCode.append((new Random()).nextInt(10));
		}
		return authCode.toString();
	}

	//获取 图片验证信息
	public static BufferedImage getAuthImg(String authCode) {
		BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_BGR);
		// 获得一个画笔
		Graphics g = img.getGraphics();
		g.setColor(Color.yellow);
		g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(new Font("宋体", Font.PLAIN, SIGNLECODE_HEIGHT + 5));
		// 输出数字
		char c;
		for (int i = 0; i < authCode.toCharArray().length; i++) {
			c = authCode.charAt(i);
			g.drawString(c + "", i * (SIGNLECODE_WIDTH + SIGNLECODE_GAP) + SIGNLECODE_GAP / 2, IMG_HEIGHT);
		}
		// 干扰
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			int x = random.nextInt(IMG_WIDTH);
			int y = random.nextInt(IMG_HEIGHT);
			int x2 = random.nextInt(IMG_WIDTH);
			int y2 = random.nextInt(IMG_HEIGHT);
			g.drawLine(x, y, x + x2, y + y2);
		}
		return img;
	}

}
