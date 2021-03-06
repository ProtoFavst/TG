package com.gbep.botapi.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

@Service
public class MainService {
    @Autowired
    private RestTemplate restTemplate;

   public String getStatistic(Long chatId){
       String  level = restTemplate.getForObject("http://MASTER/", String.class);
       String numberOfGames = restTemplate.getForObject("http://MASTER/", String.class);

       String answer = "level: " + level +"\n"+ "numberOfGames: " + numberOfGames;
       return answer;
   }

    public String startPlay(){
        return  "Введите номер игры, в которую хотите сыграть:\n" +
                "1. Определения\n" +
                "2. Викторина\n" +
                "3. Пропущенные слова\n";}

    public String getGameDataset(String gameID){
        List<String> datasets = restTemplate.getForObject("http://MASTER/", List.class);
        return  "Введите название игры, в которую хотите сыграть: " + datasets.toString();
    }

    public String getGame(String gameID){
        Boolean isExsisting = restTemplate.getForObject("http://MASTER/", Boolean.class);
        if(isExsisting){
            return "Игра сформирована. Начнём? ";

       }
        return "Ошибка";
   }

    public String getQuestion(String gameID){
        String question = restTemplate.getForObject("http://MASTER/", String.class);
        return  question;
    }


    //sendMess
        //Полуаем номер от юзера


        //sendMess
        //Полуаем имя от юзера

            //sendMess
            //Полуаем согласие от юзера


        //return "Game win!";




   public String makeNewGame(Long chatID){
       return "Загрузка успешна!";

   }

    public String getHelp(){
        return "Помощь!";

    }

}
