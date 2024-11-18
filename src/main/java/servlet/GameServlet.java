package servlet;

import model.Game;
import model.Player;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class GameServlet extends HttpServlet {
    private Game game;

    @Override
    public void init() throws ServletException {
        // Инициализируем игрока и состояние игры
        Player player = new Player("Герой");
        game = new Game(player);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("restart".equals(action)) {
            // Перезапуск игры
            Player player = new Player("Герой");
            game = new Game(player);
            request.setAttribute("game", game);
        }

        // Перенаправляем на страницу игры
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String room = request.getParameter("room");

        if ("restart".equals(action)) {
            // Перезапуск игры
            Player player = new Player("Герой");
            game = new Game(player);
        } else if (!game.isGameOver()) {
            // Обработка действий, если игра не завершена
            if ("move".equals(action) && room != null) {
                game.moveToRoom(room);
            } else if ("attack".equals(action)) {
                game.attack();
            } else if ("heal".equals(action)) {
                game.heal();
            } else if ("score".equals(action)) {
                game.addPoints();
            }
        }

        // Передаем объект игры на страницу для отображения
        request.setAttribute("game", game);
        request.getRequestDispatcher("/game.jsp").forward(request, response);

    }
}


