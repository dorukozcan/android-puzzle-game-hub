# Puzzle Game Hub — Android

A native Android game hub bundling **ten self-contained mini-games** behind a single launcher screen. Written in Java with the Android SDK, one `Activity` per game.

Built as a university mobile development team project.

---

## The games

| # | Game | What you do |
|---|---|---|
| 1 | **Guess the Number** | Narrow down a secret number from feedback |
| 2 | **Rock, Paper, Scissors** | Play a round against the CPU |
| 3 | **Reflex Test** | React as fast as you can; your reaction time is measured |
| 4 | **Word Scramble** | Unscramble a shuffled word |
| 5 | **Whack-a-Mole** | Tap the moles before they disappear |
| 6 | **Hangman** | Guess the word one letter at a time |
| 7 | **Roll Dice** | Dice roller with re-roll |
| 8 | **Arithmetic Challenge** | Solve arithmetic problems against the clock |
| 9 | **Match the Numbers** | Memory-style card matching |
| 10 | **Tic-Tac-Toe** | Two-player local match with draw detection |

## Tech

- **Language:** Java
- **Build:** Gradle
- **Min SDK:** 21 (Android 5.0 Lollipop) · **Target SDK:** 33
- **UI:** Android Views with XML layouts, Material Components theming (light + dark)

## Project structure

```
app/src/main/
├── java/com/example/project3/
│   ├── MainActivity.java     Launcher — routes to each game
│   └── Game1.java … Game10.java
└── res/
    ├── layout/               One layout per game screen
    ├── drawable/             Game art (cards, mole, RPS icons, result images)
    └── values/               Strings, colors, light and dark themes
```

## Building and running

```bash
git clone https://github.com/dorukozcan/android-puzzle-game-hub.git
```

Then either open the project in **Android Studio** and run it on an emulator or device, or build from the command line:

```bash
./gradlew assembleDebug        # Windows: gradlew.bat assembleDebug
```

`local.properties` is not committed — Android Studio regenerates it with your local SDK path on first open.

## Notes

- This was a university team project; it is published here as a coursework portfolio piece.
- The application ID is still the scaffold default (`com.example.project3`) and the games use the default Android theme rather than a custom design system.
