package Download;

/**
 * Created by weiyg on 2017/9/29.
 */
public class MultiThreadDown {
    public static void main(String[] args) throws Exception {

        final long startTime =System.currentTimeMillis();
        final DownUtil downUtil = new DownUtil("http://sw.bos.baidu.com/sw-search-sp/software/d4e97ccd4bd9f/jdk-8u144-windows-i586_8.0.1440.1.exe", "ios.png", 4);
        downUtil.download();

        System.out.println("-----------------------------------" );
        downUtil.setDownloadListener(new DownloadListener() {
            @Override
            public void onProgress(double progress, long fileSize) {
                System.out.println("progress+= " + progress+"   fileSize:"+fileSize);

                if(progress == 1.0){
                    long costTime = System.currentTimeMillis() - startTime;
                    System.out.println("cost time :" +costTime);
                }
            }
        });

        //3353

        //downUtil.getCompleteRate();
//        new Thread(()->{
//            while (downUtil.getCompleteRate() < 1) {
//                System.out.println("已完成：" + downUtil.getCompleteRate());
////                try {
////                    Thread.sleep(1000);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//            }
//        }).start();
    }
}
