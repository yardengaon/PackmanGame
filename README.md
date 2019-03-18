# PacKmanGame

## Descreption

The project represents a game called PacmanGame, the game is performed on img of Google Earth. 
The goal of the game is to eat much more fruits and run away from the ghosts

There are two game options:
- play with the help of the mouse.
- play automaticly with dijkstra algorithm.

### Gui 
Gui package has the:
- Map: singeltone object, represent the map that we want .
- MainWindow : showing all packmans, fruits, gohsts, geoboxses, and the player.

### Algorithem 
Algorithem package has the:
- algorithem: Calculates when running what fruit you should eat.
### GeomObjects 
GeomObjects package has the:
- player: represent a single player in the game 
- fruit: represent a single fruit in the game 
- packman: represent a single packman in the game 
- ghost: represent a single ghost in the game 
- line: represent a single line in the game 
- geoBox: represent a single geoBox in the game
- game: represent a single game 
  ..
### Coords 
The Coords package has the:
 #### mycoords class
  Represents a Class that allows us to perform calculations between GPS points such as:
  - Move a point with a vector
  - Calculates a vector between two points
  - Azimuth calculation, Elevation
  - Distance between two points
  ..
 
### File format 
The File format package has:
  - CsvToGame: The class create a game from csv file
  - replaceObjects: Updating the game from the server

### ExampleGameMap
![exampleMap](https://user-images.githubusercontent.com/45077625/54526122-72aa9680-497e-11e9-8679-18b3b7a66ae0.png)
### ExampleBeforeRun
![mapBeforRun](https://user-images.githubusercontent.com/45077625/54526146-91a92880-497e-11e9-9f12-b1df82584e2c.png)
### ExampleMiddelRun
![mapInRunTime](https://user-images.githubusercontent.com/45077625/54526275-eba9ee00-497e-11e9-8570-30366b99963a.png)
### ExampleAfterRun
![mapAfterRun](https://user-images.githubusercontent.com/45077625/54526301-05e3cc00-497f-11e9-8f01-76d7894bfec3.png)

### Sorces
- the idea of Azimuth : https://en.wikipedia.org/wiki/Azimuth
