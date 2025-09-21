Pac-Man Game
Overview
Java-based Pac-Man game where a red car player (Bird) collects pellets and power pellets in a 20x20 grid, avoiding blue and cyan police car ghosts (Cat, Dog). Power pellets pause ghosts for 15 seconds. Features score, timer, difficulty settings, and win/loss conditions.
Features

Gameplay: Collect pellets and power pellets to win, avoid ghosts to prevent loss. Ghosts use BFS, pause during power pellet effect.
Grid: 20x20 with walls, pellet cells (orange pellets), power pellet cells (yellow, larger) at (1,1), (1,18), (18,1), (18,18).
UI: Shows score, time, ghost speed, power pellet status, "YOU WIN!" or "GAME OVER!".
Controls:
Arrow keys: Move player.
Dropdown: Set difficulty (easy, medium, hard).


Customizations:
Police car ghosts (Cat, Dog) with body, roof, wheels, lights.
Single PelletCell constructor for collectible/empty cells.
Power pellets pause ghosts.



Design

Inheritance: Cell > PelletCell > PowerPelletCell; Actor > Bird/Cat/Dog/Player. Enables reuse.
Interfaces: Moveable for movement; Collectible for pellets. Supports extensibility.
Generics: List<Polygon>, List<Ghost>, Queue<int[]> ensure type safety.

Contributions

Wall maze
Player control
GUI interface
Pellets
Power pellets (value 50) pause ghosts.
Police car ghosts.
Single PelletCell constructor.

Git
Commits for police car ghosts, single constructor, power pellets.
Future Improvements

Pause/reset button.
Animated ghost lights.
