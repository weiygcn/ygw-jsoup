package Download;

/**
 * Created by weiyg on 2017/9/30.
 */
public interface DownloadListener  {
    void onProgress(double progress,long fileSize);
}
