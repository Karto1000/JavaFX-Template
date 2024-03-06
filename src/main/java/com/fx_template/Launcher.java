package com.fx_template;

/**
 * Wrapper for Application because
 * "... to create a runnable jar with all the required JavaFX dependencies,
 * you will need to use a launcher class that doesn't extend from Application."
 * From <a href="https://openjfx.io/openjfx-docs/#maven">Java FX Maven Docs<a>
 */
public class Launcher {

    public static void main(String[] args) {
        Application.main(args);
    }
}
