package com.anothernode.gameoflife.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GameTests {

  @Test
  public void gameWithStartConfigurationIsCreatedCorrectly() {
    var cells = Set.of(new Cell(0, 0), new Cell(2, 2));
    var game = new Game(cells);

    assertThat(game.getCellsInFirstRound().size()).isEqualTo(2);
    assertThat(game.getCellsInFirstRound()).contains(new Cell(0, 0), new Cell(2, 2));
  }

  @Test
  public void iteratingGameAddRoundToGame() {
    var game = new Game();
    game.iterate();

    assertThat(game.getRounds().size()).isEqualTo(2);
  }

  @Test
  public void cellWithoutNeighborDies() {

    var round = new Round();
    round.add(new Cell(0, 0));
    var game = new Game(round);

    game.iterate();

    assertThat(game.getRound(1).cellCount()).isEqualTo(0);
  }

  @Test
  public void cellWithJustOneNeighborDies() {

    var board = new Round();
    board.add(new Cell(0, 0));
    board.add(new Cell(1, 0));
    var game = new Game(board);

    game.iterate();

    assertThat(game.getRound(1).cellCount()).isEqualTo(0);
  }

  @Disabled // TODO
  @Test
  public void cellWithTwoNeighborsSurvives() {

    var board = new Round();
    board.add(new Cell(0, 0));
    board.add(new Cell(1, 0));
    board.add(new Cell(0, 1));
    var game = new Game(board);

    game.iterate();

    assertThat(game.getRound(0).cellCount()).isEqualTo(3);
  }
}
