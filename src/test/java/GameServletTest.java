

import model.Game;
import model.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.GameServlet;

import java.io.IOException;

import static org.mockito.Mockito.*;

class GameServletTest {

    private GameServlet gameServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() throws ServletException {
        MockitoAnnotations.openMocks(this);
        gameServlet = new GameServlet();
        gameServlet.init(); // Инициализация сервлета
    }

    @Test
    void testDoGetBasicFlow() throws ServletException, IOException {
        // Настраиваем имитацию параметров запроса
        when(request.getParameter("action")).thenReturn("move");
        when(request.getParameter("room")).thenReturn("forest");
        when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);

        // Вызываем метод doGet
        gameServlet.doGet(request, response);

        // Проверяем, что объект игры передан на страницу
        verify(request).setAttribute(eq("game"), any(Game.class));

        // Проверяем, что был вызван forward на game.jsp
        verify(dispatcher).forward(request, response);
    }
}
