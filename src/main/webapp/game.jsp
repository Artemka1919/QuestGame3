<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 17.11.2024
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="model.Game" %>
<%@ page import="model.Player" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Игра</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Текущее состояние игры</h1>
<div class="stats">
<p>Персонаж: <span>${game.player.name}</span></p>
<p>Здоровье: <span class="health">${game.player.health}</span></p>
<p>Очки: <span>${game.player.score}</span></p>
<p>Комната: ${game.currentRoom}</p>
</div>

<c:if test="${game.isGameOver()}">
  <h2>Игра завершена. Вы проиграли.</h2>
  <form action="game" method="get">
    <input type="hidden" name="action" value="restart" />
    <button type="submit">Начать заново</button>
  </form>
</c:if>
<!-- Сообщение игры -->






<!-- Действия игрока -->



<c:if test="${not game.isGameOver()}">
  <p>${game.message}</p>
  <form action="game" method="get">
    <input type="hidden" name="action" value="move" />
    <button type="submit" name="room" value="start">В комнату 'начало'</button>
    <button type="submit" name="room" value="forest">В лес</button>
    <button type="submit" name="room" value="cave">В пещеру</button>
  </form>

  <form action="game" method="get">
    <input type="hidden" name="action" value="attack" />
    <button type="submit">Атаковать</button>
  </form>

  <form action="game" method="get">
    <input type="hidden" name="action" value="heal" />
    <button type="submit">Использовать зелье</button>
  </form>

  <form action="game" method="get">
    <input type="hidden" name="action" value="score" />
    <button type="submit">Найти сундук</button>
  </form>
</c:if>
</body>
</html>
