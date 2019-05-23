package com.sixgreg;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Instance of the Guitar class
    private static Guitar guitar = new Guitar();
    private static Scanner scanner = new Scanner(System.in);


    /**
     * Requests input for the brand of the guitar.
     * Sets guitar.brand to the String inputted.
     */
    private static void getUserGuitarBrand() {
        System.out.print("========================================\nWhat brand of guitar do you play? > ");
        guitar.setBrandName(scanner.nextLine().toUpperCase());
    }

    /**
     * Requests input for the name of the guitar.
     * Sets guitar.name to the String inputted.
     */
    private static void getUserGuitarName() {
        System.out.print("\n========================================\nWhat is the name of the guitar do you play? > ");
        guitar.setGuitarName(scanner.nextLine().toUpperCase());
    }

    /**
     * Requests input for the type of guitar the user plays.
     * Sets guitar.guitarType to one of the GuitarType enums
     */
    private static void getUserGuitarType() {
        boolean isValid = false;
        while (!isValid) {
            System.out.println("\n========================================\nWhat type of guitar do you play?");
            System.out.print("[ACOUSTIC]\n[ELECTRIC]\n[BASS]\n> ");
            String in = scanner.nextLine().toUpperCase();
            switch (in) {
                case "ACOUSTIC":
                    isValid = true;
                    guitar.setGuitarType(GuitarType.ACOUSTIC);
                    break;
                case "ELECTRIC":
                    isValid = true;
                    guitar.setGuitarType(GuitarType.ELECTRIC);
                    break;
                case "BASS":
                    isValid = true;
                    guitar.setGuitarType(GuitarType.BASS);
                    break;
            }
        }
    }

    /**
     * Requests input for how the user plays.
     * Sets guitar.playStyle to one of the PlayStyle enums
     */
    private static void getUserPlayStyle() {
        boolean isValid = false;
        while (!isValid) {
            System.out.println("\n========================================\nWhat is your play style?");
            System.out.print("[PICK]\n[FINGER]\n[SLAP]\n[HYBRID]\n> ");
            String in = scanner.nextLine().toUpperCase();
            switch (in) {
                case "PICK":
                    isValid = true;
                    guitar.setPlayStyle(PlayStyle.PICK);
                    break;
                case "FINGER":
                    isValid = true;
                    guitar.setPlayStyle(PlayStyle.FINGER);
                    break;
                case "SLAP":
                    isValid = true;
                    guitar.setPlayStyle(PlayStyle.SLAP);
                    break;
                case "HYBRID":
                    isValid = true;
                    guitar.setPlayStyle(PlayStyle.HYBRID);
                    break;
            }
        }
    }

    /**
     * Requests input for how the user tunes.
     * Sets guitar.tuning to one of the Tuning enums
     */
    private static void getUserTuning() {
        System.out.println("\n========================================\nThe common tunings are:\nSTANDARD - EADG(BE)\n" +
                "RAISED - FGEA(CF)\nDROPPED - DGCF(AD)\nLOW - CFBE(GC)\nRUMBLIES - BEAD(FB)");

        boolean isValid = false;
        while (!isValid) {
            System.out.println("\n========================================\nHow do you tune your guitar?");
            System.out.print("[STANDARD]\n[RAISED]\n[DROPPED]\n[LOW]\n[RUMBLIES]\n> ");
            String in = scanner.nextLine().toUpperCase();
            switch (in) {
                case "STANDARD":
                    isValid = true;
                    guitar.setTuning(Tuning.STANDARD);
                    break;
                case "RAISED":
                    isValid = true;
                    guitar.setTuning(Tuning.RAISED);
                    break;
                case "DROPPED":
                    isValid = true;
                    guitar.setTuning(Tuning.DROPPED);
                    break;
                case "LOW":
                    isValid = true;
                    guitar.setTuning(Tuning.LOW);
                    break;
                case "RUMBLIES":
                    isValid = true;
                    guitar.setTuning(Tuning.RUMBLIES);
                    break;
            }
        }
    }

    /**
     * Requests input for what effects the user uses.
     * Sets guitar.effect to one of the Effect enums
     */
    private static void getUserEffect() {
        boolean isValid = false;
        while (!isValid) {
            System.out.println("\n========================================\nDo you use any effects?");
            System.out.print("[NONE]\n[DISTORTION]\n[REVERB]\n[FLANGER]\n[PHASER]\n[DELAY]\n[OCTAVER]\n> ");
            String in = scanner.nextLine().toUpperCase();
            switch (in) {
                case "NONE":
                    isValid = true;
                    guitar.setEffect(Effect.NONE);
                    break;
                case "DISTORTION":
                    isValid = true;
                    guitar.setEffect(Effect.DISTORTION);
                    break;
                case "REVERB":
                    isValid = true;
                    guitar.setEffect(Effect.REVERB);
                    break;
                case "FLANGER":
                    isValid = true;
                    guitar.setEffect(Effect.FLANGER);
                    break;
                case "PHASER":
                    isValid = true;
                    guitar.setEffect(Effect.PHASER);
                    break;
                case "DELAY":
                    isValid = true;
                    guitar.setEffect(Effect.DELAY);
                    break;
                case "OCTAVER":
                    isValid = true;
                    guitar.setEffect(Effect.OCTAVER);
                    break;
            }
        }
    }

    /**
     * Requests input for how fast the user plays.
     * Sets guitar.speed to one of the Speed enums
     */
    private static void getUserSpeed() {
        boolean isValid = false;
        while (!isValid) {
            System.out.println("\n========================================\nHow fast do you play?");
            System.out.print("[SLOW]\n[MEDIUM]\n[FAST]\n> ");
            String in = scanner.nextLine().toUpperCase();
            switch (in) {
                case "SLOW":
                    isValid = true;
                    guitar.setSpeed(Speed.SLOW);
                    break;
                case "MEDIUM":
                    isValid = true;
                    guitar.setSpeed(Speed.MEDIUM);
                    break;
                case "FAST":
                    isValid = true;
                    guitar.setSpeed(Speed.FAST);
                    break;
            }
        }
    }

    /**
     * Assume possible genres that the user likes to play based off their guitar type, tuning, and play style.
     *
     * Acoustic with standard tuning, play slow or medium, no effects could be: country, blues, folk, latin
     * Acoustic with lower tuning, effects (not distortion), play slow or medium could be: folk, blues, jazz
     * Electric with standard, light effects, play slow or medium could be: folk, blues, jazz, math rock
     * Electric with lower tuning, effects, slow or medium could be: Grindcore, black metal
     * Electric with lower tuning, effects, play medium or fast could be: Heavy metal, black metal, djent, punk
     * Electric with higher tuning, flanger, medium could be: math rock, rock, folk
     * Electric with low/standard tuning, effects, fast/very fast could be: punk, heavy metal, black metal, djent
     * Bass with standard, slow/medium could be: jazz, folk
     * Bass with lower, effects, slow/medium could be: Black metal, heavy metal
     * Bass with lower, effects, fast could be: Heavy metal, rock, djent, grindcore, punk
     */
    private static void assumeGenre() {
        ArrayList<Genre> genres = new ArrayList<>();

        if (guitar.getGuitarType() == GuitarType.ACOUSTIC && guitar.getTuning() == Tuning.STANDARD
                && guitar.getEffect() == Effect.NONE && guitar.getSpeed() == Speed.SLOW) {
            genres.add(Genre.COUNTRY);
            genres.add(Genre.BLUES);
            genres.add(Genre.FOLK);
            genres.add(Genre.LATIN);
        }
        else if (guitar.getGuitarType() == GuitarType.ACOUSTIC && guitar.getTuning() == Tuning.LOW ||
                    guitar.getTuning() == Tuning.DROPPED && guitar.getEffect() != Effect.NONE &&
                    guitar.getEffect() != Effect.DISTORTION && guitar.getSpeed() == Speed.SLOW ||
                    guitar.getSpeed() == Speed.MEDIUM) {
            genres.add(Genre.FOLK);
            genres.add(Genre.BLUES);
            genres.add(Genre.JAZZ);
        }
        else if (guitar.getGuitarType() == GuitarType.ELECTRIC && guitar.getTuning() == Tuning.STANDARD &&
                    guitar.getEffect() == Effect.PHASER || guitar.getEffect() == Effect.REVERB &&
                    guitar.getSpeed() == Speed.SLOW || guitar.getSpeed() == Speed.MEDIUM) {
            genres.add(Genre.GRINDCORE);
            genres.add(Genre.BLACKMETAL);
        }
        else if (guitar.getGuitarType() == GuitarType.ELECTRIC && guitar.getTuning() == Tuning.LOW ||
                    guitar.getTuning() == Tuning.DROPPED || guitar.getTuning() == Tuning.RUMBLIES &&
                    guitar.getEffect() != Effect.NONE && guitar.getSpeed() == Speed.SLOW ||
                    guitar.getSpeed() == Speed.MEDIUM) {
            genres.add(Genre.GRINDCORE);
            genres.add(Genre.BLACKMETAL);
        }
        else if (guitar.getGuitarType() == GuitarType.ELECTRIC && guitar.getTuning() == Tuning.LOW ||
                    guitar.getTuning() == Tuning.DROPPED || guitar.getTuning() == Tuning.RUMBLIES &&
                    guitar.getSpeed() == Speed.MEDIUM || guitar.getSpeed() == Speed.FAST) {
            genres.add(Genre.HEAVYMETAL);
            genres.add(Genre.BLACKMETAL);
            genres.add(Genre.DJENT);
            genres.add(Genre.PUNK);
        }
        else if (guitar.getGuitarType() == GuitarType.ELECTRIC && guitar.getTuning() == Tuning.RAISED ||
                    guitar.getTuning() == Tuning.STANDARD && guitar.getEffect() == Effect.FLANGER ||
                    guitar.getEffect() == Effect.PHASER && guitar.getSpeed() != Speed.SLOW) {
            genres.add(Genre.MATHROCK);
            genres.add(Genre.ROCK);
            genres.add(Genre.FOLK);
        }
        else if (guitar.getGuitarType() == GuitarType.ELECTRIC && guitar.getTuning() == Tuning.LOW ||
                    guitar.getTuning() == Tuning.STANDARD && guitar.getEffect() != Effect.NONE &&
                    guitar.getSpeed() == Speed.FAST) {
            genres.add(Genre.PUNK);
            genres.add(Genre.HEAVYMETAL);
            genres.add(Genre.BLACKMETAL);
            genres.add(Genre.DJENT);
        }
        else if (guitar.getGuitarType() == GuitarType.BASS && guitar.getTuning() == Tuning.STANDARD &&
                    guitar.getSpeed() != Speed.FAST) {
            genres.add(Genre.JAZZ);
            genres.add(Genre.FOLK);
        }
        else if (guitar.getGuitarType() == GuitarType.BASS && guitar.getTuning() == Tuning.LOW ||
                    guitar.getTuning() == Tuning.DROPPED || guitar.getTuning() == Tuning.RUMBLIES &&
                    guitar.getEffect() != Effect.NONE &&
                    guitar.getSpeed() != Speed.FAST) {
            genres.add(Genre.HEAVYMETAL);
            genres.add(Genre.BLACKMETAL);
        }
        else if (guitar.getGuitarType() == GuitarType.BASS && guitar.getTuning() == Tuning.LOW ||
                    guitar.getTuning() == Tuning.DROPPED || guitar.getTuning() == Tuning.RUMBLIES &&
                    guitar.getEffect() != Effect.NONE &&
                    guitar.getSpeed() == Speed.FAST) {
            genres.add(Genre.HEAVYMETAL);
            genres.add(Genre.BLACKMETAL);
            genres.add(Genre.DJENT);
            genres.add(Genre.ROCK);
        }
        else {
            System.out.println("\n========================================\nYou might like any genre!");
        }

        System.out.print("\n========================================\nYou may enjoy these genres: ");
        for (Genre i : genres) {
            System.out.print(i + " ");
        }
        System.out.println("\n========================================");
    }

    private static void printGuitarInfo() {
        System.out.printf("\n========================================\nYou play a %s %s %s guitar." +
                        " Your play style is " + "%s, and you tune %s. You like to play %s and you also use %s " +
                        "effects\n========================================",
                guitar.getBrandName(), guitar.getGuitarName(),
                guitar.getGuitarType().toString().toLowerCase(), guitar.getPlayStyle().toString().toLowerCase(),
                guitar.getTuning().toString().toLowerCase(), guitar.getSpeed(),
                guitar.getEffect().toString().toLowerCase());
    }

    public static void main(String[] args) {
        // Get all of the user's input for the guitar info.
        getUserGuitarBrand();
        getUserGuitarName();
        getUserGuitarType();
        getUserPlayStyle();
        getUserTuning();
        getUserSpeed();
        getUserEffect();

        // Print the info of the guitar to the console.
        printGuitarInfo();

        // Assumes genres the user may enjoy playing based off the info of the guitar object.
        assumeGenre();
    }
}
