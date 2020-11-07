package com.example.videohosting;

import com.github.kiulian.downloader.YoutubeException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller                 /*Контроллер*/
public class HomeController {

    @GetMapping("/")          /*Обрабатывает запросы корневого пути */
    public String home(Model model) throws IOException, YoutubeException {
        for (File myFile : new File("D:\\архивы\\videohosting\\src\\main\\resources\\static\\video").listFiles())
            if (myFile.isFile()) myFile.delete();
        List<Video> videos = new ArrayList<>();
        videos.add(new DownloadYouTubeVideo("nVXlfKsetg4").download());
        videos.add(new DownloadYouTubeVideo("jSWOSfC13Ow").download());
        videos.add(new DownloadYouTubeVideo("HgEu9ZoJO8k").download());
        videos.add(new DownloadYouTubeVideo("YfpxLOqQVcg&t=4s").download());
        model.addAttribute("videos", videos);
        return "home"; /*Возвращает имя представления*/
    }
}
