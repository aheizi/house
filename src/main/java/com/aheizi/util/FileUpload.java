package com.aheizi.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.multipart.MultipartFile;
/**
 * 上传素材
 * @author aheizi
 *
 */
public class FileUpload {
	
	private static String imagesPath = "/upload/images";  
	
	/**
	* 模拟form表单的形式 ，上传文件 以输出流的形式把文件写入到url中，然后用输入流来获取url的响应
	* 
	* @param url 请求地址 form表单url地址
	* @param filePath 文件在服务器保存路径
	* @return String url的响应信息返回值
	* @throws IOException
	*/
	public static String upload(String url, String filePath) throws IOException {
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			/**
			 * 第一部分
			 */
			URL urlObj = new URL(url);
			// 连接
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			
			/**
			 * 设置关键值
			 */
			con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false); // post方式不能使用缓存
			// 设置请求头信息
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			// 设置边界
			String BOUNDARY = "----------" + System.currentTimeMillis();
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+ BOUNDARY);
			// 请求正文信息
			
			// 第一部分：
			StringBuilder sb = new StringBuilder();
			sb.append("--"); // 必须多两道线
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
					+ filePath.substring(filePath.lastIndexOf("/")+1, filePath.length()) + "\"\r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");
			
			byte[] head = sb.toString().getBytes("utf-8");
			// 获得输出流
			OutputStream out = new DataOutputStream(con.getOutputStream());
			// 输出表头
			out.write(head);
			
			// 文件正文部分
			// 把文件已流文件的方式 推入到url中
			DataInputStream in = new DataInputStream(new URL(filePath).openStream());
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			in.close();
			
			// 结尾部分
			byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
			
			out.write(foot);
			out.flush();
			out.close();
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if(result==null){
				result = buffer.toString();
			}
		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
			throw new IOException("数据读取异常");
		} finally {
			if(reader!=null){
				reader.close();
			}
		}
		return result;
	}

	public static String filePath(MultipartFile file, String agencyCode) throws Exception {
		String fileDir = FileUtil.getWebAppDirectory().getPath() + "/" + imagesPath + "/" + agencyCode;
		String fullPath = null;
		fullPath = doMkdir(null, fileDir);
		// 对文件重命名，中文文件名不能保存
		String fileName = file.getOriginalFilename();
		fileName = fileName.indexOf("/") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("/"));
		fileName = fileName.indexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\"));
		int dotIndex = fileName.lastIndexOf(".");
		if (dotIndex > 0) {
			fileName = agencyCode + System.currentTimeMillis() + fileName.substring(dotIndex);
		} else {
			// 强制转换成图片格式
			fileName = agencyCode + System.currentTimeMillis()  + ".JPEG";
		}
		File dest = new File(fullPath, fileName);
		if (dest.exists()) {
			dotIndex = fileName.lastIndexOf(".");
			fileName = agencyCode  + System.currentTimeMillis() + fileName.substring(dotIndex);
			dest = new File(fullPath, fileName);
			if (dest.exists()) {
				throw new Exception();
			}
		}

		try {
			file.transferTo(dest);
		} catch (Exception e) {
			throw new Exception();
		}
		return imagesPath + "/" + agencyCode + "/" + fileName;

}

	private static String doMkdir(String path, String folder) {

		if (folder == null || folder.trim().length() == 0) {
			return path;
		}
		File tmp;
		if (path == null || path.trim().length() == 0) {
			tmp = new File(folder);
		} else {
			tmp = new File(path, folder);
		}
		if (tmp.exists()) {
			return tmp.getAbsolutePath();
		} else if (tmp.mkdirs()) {
			return tmp.getAbsolutePath();
		} else {
			return null;
		}

	}
	
	public static void main(String[] args) throws IOException {
		String filePath = "http://127.0.0.1/house/temp/2.jpg";
		String sendUrl = "D:\1.jpg";
		String result = null;
		result = FileUpload.upload(sendUrl, filePath);
		System.out.println(result);
	} 
}