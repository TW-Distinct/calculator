package test1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

class ImagePane extends JPanel {

	Image image;
	BufferedImage bufImage; //用于显示的缓冲区图像
	BufferedImage originalBufImage; //原始缓冲区图像
	Graphics2D bufImageG; //缓冲区图像的图形环境 

	public void loadImage(String fileName) {
		image = this.getToolkit().getImage(fileName); //取得图像
		MediaTracker mt = new MediaTracker(this); //实例化媒体加载器
		mt.addImage(image, 0); //增加图像到加载器中
		try {
			mt.waitForAll(); //等待图片加载
		} catch (Exception ex) {
			ex.printStackTrace(); //输出出错信息
		}
		originalBufImage = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB); //创建原始缓冲区图像
		bufImage = originalBufImage;
		bufImageG = bufImage.createGraphics(); //创建bufImage的图形环境
		bufImageG.drawImage(image, 0, 0, this); //传输源图像数据到缓冲区图像中
		repaint(); //重绘组件
	}
	//过滤图像
	public void ratoteImage(double angle) {
		if (bufImage == null)
			return; //如果bufImage为空则直接返回
		BufferedImage filteredBufImage =new BufferedImage(image.getWidth(this) ,image.getHeight(this),BufferedImage.TYPE_INT_ARGB); //过滤后的图像
		AffineTransform transform = new AffineTransform(); //仿射变换对象
		transform.rotate(angle,image.getWidth(this)/2 ,image.getHeight(this)/2); //旋转图像
		AffineTransformOp imageOp = new AffineTransformOp(transform, null);//创建仿射变换操作对象 
		imageOp.filter(originalBufImage, filteredBufImage);//过滤图像，目标图像在filteredBufImage
		bufImage = filteredBufImage; //让用于显示的缓冲区图像指向过滤后的图像
		repaint(); //重绘组件
	}

	//重载容器的paintComponent()方法
	public void paint(Graphics g) {
		super.paintComponent(g);
		if (bufImage != null) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(bufImage,0,0,this); //绘制图片
		}
	}
}