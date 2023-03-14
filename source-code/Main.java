package com.simha.connecfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller; // Connecting controller.java file to Main.java

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar= createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane =(Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene=new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu(){
        //File Menu
        Menu fileMenu= new Menu("File");

        MenuItem newGame= new MenuItem("New game");
        newGame.setOnAction(event -> controller.resetGame());
        final MenuItem resetGame= new MenuItem("Reset game");
        resetGame.setOnAction(event -> controller.resetGame());
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        final MenuItem exitGame= new MenuItem("Exit game");
        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        //  Help Menu
        Menu helpMenu= new Menu("Help");

        MenuItem aboutGame= new MenuItem("About Connect 4");
        aboutGame.setOnAction(event -> aboutConnect4());
        SeparatorMenuItem separator=new SeparatorMenuItem();
        MenuItem aboutMe= new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame, separator, aboutMe);
        MenuBar menuBar= new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Yasani Samara Simha Reddy");
        alert.setContentText("Welcome to my game, and thank you for checking out my profile! " +
                "I'm the developer behind this exciting game, and I'm thrilled to share my passion with you. " +
                "Thank you for your support, and I hope you enjoy playing my game as much as I enjoyed creating it!");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play?");
        alert.setContentText("Connect 4 is a classic two-player connection game where you have to line up four of your colored tokens in a row before your opponent does." +
                " The game is played on a vertical board with seven columns and six rows. " +
                "Each player takes turns dropping their tokens into any column they choose. " +
                "The tokens fall to the bottom of the column or on top of any existing tokens. " +
                "The first player to form a horizontal, vertical, or diagonal line of four tokens of their color wins the game. " +
                "If the board is full and no one has connected four, the game ends in a draw." +
                " Are you ready to connect four? Download Connect 4 today and challenge yourself and your friends!");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
