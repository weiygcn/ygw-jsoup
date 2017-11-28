package Download;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by weiyg on 2017/9/29.
 */
public class DownUtil {
    private String path;
    private String targetFile;
    private int threadNum;
    private DownThread[] threads;
    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.threadNum = threadNum;
        this.threads = new DownThread[threadNum];
        this.targetFile = targetFile;
    }

    public void download() throws Exception {
        System.out.println("path:"+path);
        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(5 * 1000);
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "image/git,image/jpeg,image/pjpeg,image/pjpeg,"
                + "application/x-shockwave-flash,application/xaml+xml,"
                + "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
                + "application/x-ms-application,application/vnd.ms-excel,"
                + "application/vnd.ms-powerpoint,application/msword,*/*");
        con.setRequestProperty("Accept-Language", "zh-CN");
        con.setRequestProperty("Charset", "UTF-8");
        con.setRequestProperty("Connection", "Keep-Alive");
        fileSize = con.getContentLength();
        System.out.println("fileSize:"+fileSize);


        con.disconnect();
        int currentPartSize = fileSize / threadNum + 1 ;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        file.setLength(fileSize);
        file.close();
        for (int i = 0; i < threadNum; i++) {
            int StartPos = i * currentPartSize;
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            currentPart.seek(StartPos);
            threads[i] = new DownThread(StartPos, currentPartSize, currentPart);
            threads[i].start();
        }
    }



    public double getCompleteRate() {




            long sumSize = 0;
            //当前下载的文件的总大小
            for (int i = 0; i < threadNum; i++) {
                sumSize += threads[i].length;
            }
            //System.out.println("下载总大小:"+sumSize+"    fileSize"+fileSize);
            //113743
            //111835


            double progress = sumSize * 1.0 / fileSize;
            mDownloadListener.onProgress(progress,sumSize);

            return progress;






    }

    private class DownThread extends Thread {
        private int startPos;
        private int currentPartSize;
        private RandomAccessFile currentPart;
        public int length;

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }
        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5 * 1000);
                con.setRequestMethod("GET");
                con.setRequestProperty("Accept", "image/git,image/jpeg,image/pjpeg,image/pjpeg,"
                        + "application/x-shockwave-flash,application/xaml+xml,"
                        + "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
                        + "application/x-ms-application,application/vnd.ms-excel,"
                        + "application/vnd.ms-powerpoint,application/msword,*/*");
                con.setRequestProperty("Accept-Language", "zh-CN");
                con.setRequestProperty("Charset", "UTF-8");
                InputStream inStream = con.getInputStream();
                inStream.skip(this.startPos);

                int hasRead = -1;

                // 10000      10240
                while (length < currentPartSize ) {


                    byte[] buffer = null;
                    if(currentPartSize - length < 1024){
                        buffer = new byte[currentPartSize - length];
                    }else{
                        buffer = new byte[1024];
                    }



                    hasRead = inStream.read(buffer);
                    if(hasRead == -1){
                        break;
                    }



                    currentPart.write(buffer, 0, hasRead);
                    length = hasRead + length;


                    getCompleteRate();
//                    int sumSize = 0;
//                    //当前下载的文件的总大小
//                    for (int i = 0; i < threadNum; i++) {
//                        sumSize += threads[i].length;
//                    }
//                    System.out.println(""+startPos+"   下载总大小:"+sumSize+"    fileSize"+fileSize);
//



                   // System.out.println("progress = " + progress+"    length:"+length);
                }
                currentPart.close();
                inStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    DownloadListener mDownloadListener;
    public void setDownloadListener(DownloadListener listener){
        mDownloadListener = listener;
    }
}
