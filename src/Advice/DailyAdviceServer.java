package Advice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

    String[] adviceList = {"Ешьте меньшими порциями", "Купите облегающие джинсы. Нет они не делают вас полнее", "Два слова: не годится "
            , "Будьте честными хотябы сегодня. Скажите своему начальнику все, что *на самом деле о нем думаете*", "Возможно вам стоит выбрать другую прическу"
            , "Налей себе холодненького, ты заслужил", "Скажи начальнику, работа подождет. На горнолыжном курорте как раз выпал снег"
            , "Этот оттенок не слишком идет тебе"};

    public void go(){

        try {
            ServerSocket serverSock = new ServerSocket(4242);

            while (true){
                Socket sock = serverSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice(){
        int rand = (int) (Math.random() * adviceList.length);
        return adviceList[rand];
    }
    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
