package com.example.videohosting;

import com.github.kiulian.downloader.YoutubeDownloader;
import com.github.kiulian.downloader.YoutubeException;
import com.github.kiulian.downloader.model.YoutubeVideo;
import com.github.kiulian.downloader.model.formats.AudioVideoFormat;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DownloadYouTubeVideo {

    @Value("${video.path}")
    private String videoPath;


    String videoId;

    public DownloadYouTubeVideo(String videoId){
        this.videoId = videoId;
    }

    public Video download() throws YoutubeException, IOException {
        YoutubeDownloader downloader = new YoutubeDownloader();
        YoutubeVideo video = downloader.getVideo(videoId);
        List<AudioVideoFormat> formats = video.videoWithAudioFormats();
        File outputDirVideo = new File("D:\\архивы\\videohosting\\src\\main\\resources\\static\\video");
        video.downloadAsync(formats.get(0), outputDirVideo, videoId);

        return new Video(""+video.details().title(), videoId);
    }


}
