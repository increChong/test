package controller;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "codeServlet", urlPatterns = { "/codeServlet.do" })
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证码：动态生成内存中的一张验证图片(图片中显示验证字符)
		String chars ="QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm0123456789";
		String codes = "";
		StringBuilder builder = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < 4; i++) {
			int index = rand.nextInt(61);
			builder.append(chars.charAt(index));
		}
		codes = builder.toString();
		BufferedImage bufferedImage = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 80, 30);
		
		g.setColor(Color.RED);
		g.drawRect(1, 1, 80, 30);
		
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawString(codes, 10, 20);
		
		response.setContentType("image/jpeg");
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		response.getOutputStream().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}