package com.example.servicehi.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class FileUtil {

    /**
     * 判断父文件夹是否存在，如果不存在则创建
     *
     * @param file
     */
    public static void checkParentFile(File file) {
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public static File downloadFromUrl(String urlStr) throws Exception {
        //获取URL对象
        URL url;
        HttpURLConnection conn = null;
        File file;
        try {
            url = new URL(urlStr);
            //获取连接
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(6000);
            //设置超时时间是3秒
            conn.setReadTimeout(6000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.19 Safari/537.36");
            //得到临时文件
            InputStream is = conn.getInputStream();
            if (is == null || is.available() <= 0) {
                throw new Exception("图片为空");
            }
            file = getTemplateFile(is);
        } catch (MalformedURLException e) {
            log.error("图片下载出现异常={}", e.getMessage());
            throw new Exception("图片下载失败");
        } catch (Exception e) {
            log.error("图片下载出现异常={}", e.getMessage());
            throw new Exception("图片下载失败");
        } finally {
            //关闭连接
            if (conn != null) {
                conn.disconnect();
            }
        }
        return file;
    }

    /**
     * 获取模板文件--获取到的文件为临时文件，用完后需要手动删除
     *
     * @param inputStream
     * @return 模板文件
     * @throws Exception 异常抛出
     */
    public static File getTemplateFile(InputStream inputStream) throws Exception {
        File file = File.createTempFile("temp_image", null);
        inputStreamToFile(inputStream, file);
        if (file.exists() && file.length() <= 0) {
            throw new Exception("临时文件为空");
        }
        return file;
    }

    /**
     * InputStream 转file
     *
     * @param ins  输入流
     * @param file 目标文件
     */
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            try {
                int bytesRead;
                byte[] buffer = new byte[1024];
                while ((bytesRead = ins.read(buffer, 0, 1024)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.flush();
            } finally {
                if (os != null) {
                    os.close();
                }
                if (ins != null) {
                    ins.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}