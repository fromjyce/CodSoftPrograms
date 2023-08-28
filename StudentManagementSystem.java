import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

class Student {
    String firstName;
    String lastName;
    String dob;
    String gender;
    String rollNumber;
    String phoneNumber;
    String email;
    String department;
    String classteacher;
    String parent1;
    String parent2;

    public Student(String firstName, String lastName, String dob, String gender, String rollNumber,
                   String phoneNumber, String email, String department, String classteacher,
                   String parent1, String parent2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.rollNumber = rollNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        this.classteacher = classteacher;
        this.parent1 = parent1;
        this.parent2 = parent2;
    }
}

public class StudentManagementSystem extends Application {
    String background = "#EFDECD";
    Stage mainStage;
   ArrayList<Student> students = new ArrayList<>();
    
    @Override
    public void start(Stage firstStage) {
         
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jaya2\\Visual Code\\StudentManagement\\src\\collegestudents.txt"))) {
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5],
                    data[6], data[7], data[8], data[9], data[10]);
            students.add(student);
        }
    } catch(IOException e) {
        e.printStackTrace();
    }
        mainStage = firstStage;
        StudentManagementSystem stumansys = new StudentManagementSystem();
        Group mainRoot = new Group();
        Label mainLabel = new Label("STUDENT MANAGEMENT SYSTEM");
        Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(60);
        mainLabel.setTranslateY(30);
        Button listStudents = new Button("LIST STUDENTS");
        listStudents.setLayoutX(150);
        listStudents.setLayoutY(85);
        listStudents.setPrefSize(300, 40);
        listStudents.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        listStudents.setOnAction(event -> showListStudentsScene());
        Button searchStudents = new Button("SEARCH STUDENTS");
        searchStudents.setLayoutX(150);
        searchStudents.setLayoutY(135);
        searchStudents.setPrefSize(300, 40);
        searchStudents.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        searchStudents.setOnAction(event -> showSearchStudentsScene());
        Button addStudents = new Button("ADD A STUDENT");
        addStudents.setLayoutX(150);
        addStudents.setLayoutY(185);
        addStudents.setPrefSize(300, 40);
        addStudents.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        addStudents.setOnAction(event -> showAddStudentsScene());
        Button editStudents = new Button("EDIT A STUDENT");
        editStudents.setLayoutX(150);
        editStudents.setLayoutY(235);
        editStudents.setPrefSize(300, 40);
        editStudents.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        editStudents.setOnAction(event -> showEditStudentsScene());
        Button removeStudents = new Button("REMOVE A STUDENT");
        removeStudents.setLayoutX(150);
        removeStudents.setLayoutY(285);
        removeStudents.setPrefSize(300, 40);
        removeStudents.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        removeStudents.setOnAction(event -> showRemoveStudentsScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(335);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
        mainRoot.getChildren().addAll(mainLabel, listStudents, searchStudents, addStudents, removeStudents, editStudents, exit);
        Scene mainScene = new Scene(mainRoot, 600, 600);
        mainScene.setFill(Color.web(stumansys.background, 1.0));
        mainStage.setTitle("Student Management System");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.show();
    }

    private void showListStudentsScene() {
        Group mainList = new Group();
         Label mainLabel = new Label("LIST STUDENTS");
         Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(190);
        mainLabel.setTranslateY(30);
        Button listButton = new Button("LIST STUDENTS");
        listButton.setLayoutX(150);
        listButton.setLayoutY(85);
        listButton.setPrefSize(300, 40);
        listButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        listButton.setOnAction(event -> listStudents());
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(135);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(185);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
         mainList.getChildren().addAll(mainLabel, listButton, goBackButton, exit);
         Scene ListScene = new Scene(mainList, 600, 600);
         ListScene.setFill(Color.web(background, 1.0));
         mainStage.setScene(ListScene);
    }

    private void showSearchStudentsScene() {
        Group mainSearch = new Group();
         Label mainLabel = new Label("SEARCH STUDENTS");
         Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(175);
        mainLabel.setTranslateY(30);
        TextField searchField = new TextField();
        searchField.setLayoutX(150);
        searchField.setLayoutY(85);
        searchField.setPrefSize(300, 40);
        Button srchButton = new Button("SEARCH");
        srchButton.setLayoutX(150);
        srchButton.setLayoutY(135);
        srchButton.setPrefSize(300, 40);
        srchButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        srchButton.setOnAction(event -> {
            String searchText = searchField.getText();
            String searchtxt = searchText.substring(0, 1).toUpperCase() + searchText.substring(1).toLowerCase(); 
            searchStudentsScene(searchtxt); 
            });
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(185);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(235);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
         mainSearch.getChildren().addAll(mainLabel,searchField,srchButton, goBackButton, exit);
         Scene SearchScene = new Scene(mainSearch, 600, 600);
         SearchScene.setFill(Color.web(background, 1.0));
         mainStage.setScene(SearchScene);
    }

    private void showAddStudentsScene() {
        Group mainAdd = new Group();
         Label mainLabel = new Label("ADD A STUDENT");
          Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(185);
        mainLabel.setTranslateY(30);
        Label fnameLabel = new Label("FIRST NAME");
        Font fieldfont = Font.font("Times New Roman", FontPosture.REGULAR, 18);
        fnameLabel.setFont(fieldfont);
        fnameLabel.setTextFill(Color.web("#706860", 1.0));
        fnameLabel.setTextAlignment(TextAlignment.CENTER);
        fnameLabel.setTranslateX(115);
        fnameLabel.setTranslateY(70);
        TextField fnameField = new TextField(); 
        fnameField.setLayoutX(115);
        fnameField.setLayoutY(90);
        fnameField.setPrefSize(170, 30);
        Label lnameLabel = new Label("LAST NAME");
        lnameLabel.setFont(fieldfont);
        lnameLabel.setTextFill(Color.web("#706860", 1.0));
        lnameLabel.setTextAlignment(TextAlignment.CENTER);
        lnameLabel.setTranslateX(325);
        lnameLabel.setTranslateY(70);
        TextField lnameField = new TextField();
        lnameField.setLayoutX(325);
        lnameField.setLayoutY(90);
        lnameField.setPrefSize(170, 30);
        Label dateLabel = new Label("DATE OF BIRTH");
        dateLabel.setFont(fieldfont);
        dateLabel.setTextFill(Color.web("#706860", 1.0));
        dateLabel.setTextAlignment(TextAlignment.CENTER);
        dateLabel.setTranslateX(115);
        dateLabel.setTranslateY(135);
        DatePicker dateOfBirth = new DatePicker();
        dateOfBirth.setLayoutX(115);
        dateOfBirth.setLayoutY(155);
        dateOfBirth.setPrefSize(170, 30);
        Label genderLabel = new Label("GENDER");
        genderLabel.setFont(fieldfont);
        genderLabel.setTextFill(Color.web("#706860", 1.0));
        genderLabel.setTextAlignment(TextAlignment.CENTER);
        genderLabel.setTranslateX(325);
        genderLabel.setTranslateY(135);
        ComboBox<String> genderField = new ComboBox<>();
        genderField.getItems().addAll("Male", "Female", "Other");
        genderField.setTranslateX(325);
        genderField.setTranslateY(155);
        genderField.setPrefSize(170, 30);
        Label registerLabel = new Label("REGISTRATION\nNUMBER");
        registerLabel.setFont(fieldfont);
        registerLabel.setTextFill(Color.web("#706860", 1.0));
        registerLabel.setTranslateX(115);
        registerLabel.setTranslateY(200);
        TextField registerField = new TextField();
        registerField.setLayoutX(115);
        registerField.setLayoutY(240);
        registerField.setPrefSize(170, 30);
        Label phonenumLabel = new Label("PHONE\nNUMBER");
        phonenumLabel.setFont(fieldfont);
        phonenumLabel.setTextFill(Color.web("#706860", 1.0));
        phonenumLabel.setTranslateX(325);
        phonenumLabel.setTranslateY(200);
        TextField phonenumField = new TextField();
        phonenumField.setLayoutX(325);
        phonenumField.setLayoutY(240);
        phonenumField.setPrefSize(170, 30);
        Label emailLabel = new Label("EMAIL ID");
        emailLabel.setFont(fieldfont);
        emailLabel.setTextFill(Color.web("#706860", 1.0));
        emailLabel.setTranslateX(115);
        emailLabel.setTranslateY(285);
        TextField emailField = new TextField();
        emailField.setLayoutX(115);
        emailField.setLayoutY(305);
        emailField.setPrefSize(170, 30);
        Label departmentLabel = new Label("DEPARTMENT");
        departmentLabel.setFont(fieldfont);
        departmentLabel.setTextFill(Color.web("#706860", 1.0));
        departmentLabel.setTranslateX(325);
        departmentLabel.setTranslateY(285);
        TextField departmentField = new TextField();
        departmentField.setLayoutX(325);
        departmentField.setLayoutY(305);
        departmentField.setPrefSize(170, 30);
        Label fatherName = new Label("FATHER");
        fatherName.setFont(fieldfont);
        fatherName.setTextFill(Color.web("#706860", 1.0));
        fatherName.setTranslateX(115);
        fatherName.setTranslateY(350);
        TextField fatherNameField = new TextField();
        fatherNameField.setLayoutX(115);
        fatherNameField.setLayoutY(370);
        fatherNameField.setPrefSize(170, 30);
        Label motherName = new Label("MOTHER");
        motherName.setFont(fieldfont);
        motherName.setTextFill(Color.web("#706860", 1.0));
        motherName.setTranslateX(325);
        motherName.setTranslateY(350);
        TextField motherNameField = new TextField();
        motherNameField.setTranslateX(325);
        motherNameField.setTranslateY(370);
        motherNameField.setPrefSize(170, 30);
        Label classadvisorLabel = new Label("CLASS ADVISOR");
        classadvisorLabel.setFont(fieldfont);
        classadvisorLabel.setTextFill(Color.web("#706860", 1.0));
        classadvisorLabel.setTranslateX(115);
        classadvisorLabel.setTranslateY(415);
        TextField classadvisorField = new TextField();
        classadvisorField.setTranslateX(115);
        classadvisorField.setTranslateY(435);
        classadvisorField.setPrefSize(170, 30);
        Button submitDetails = new Button("SUBMIT");
        submitDetails.setOnAction(event -> {
            String fname = fnameField.getText();
            String lname = lnameField.getText();
            String dob = dateOfBirth.getValue().toString();
            String gender = genderField.getValue();
            String rollNumber = registerField.getText();
            String phoneNumber = phonenumField.getText();
            String email = emailField.getText();
            String department = departmentField.getText();
            String classadvisor = classadvisorField.getText();
            String nameOfFat = fatherNameField.getText();
            String nameOfMot = motherNameField.getText();
            
            if (fname.isEmpty() || lname.isEmpty() || dob.isEmpty() || gender.isEmpty() || rollNumber.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || department.isEmpty() || classadvisor.isEmpty() || nameOfFat.isEmpty() || nameOfMot.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all required fields");
                alert.showAndWait();

            } else {
                String firstName = fname.substring(0, 1).toUpperCase() + fname.substring(1).toLowerCase(); 
                String lastName = lname.substring(0, 1).toUpperCase() + lname.substring(1).toLowerCase();
                String nameOfFather =  nameOfFat.substring(0, 1).toUpperCase() + nameOfFat.substring(1).toLowerCase();
                String nameOfMother = nameOfMot.substring(0, 1).toUpperCase() + nameOfMot.substring(1).toLowerCase();
                Student newStudent = new Student(firstName, lastName, dob, gender, rollNumber, phoneNumber, email, department, classadvisor, nameOfFather, nameOfMother);
                students.add(newStudent);
                addStudentToList(newStudent);
            }

        });
        submitDetails.setLayoutX(325);
        submitDetails.setLayoutY(425);
        submitDetails.setPrefSize(170, 30);
        submitDetails.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(475);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(525);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
         mainAdd.getChildren().addAll(mainLabel, fnameLabel, fnameField, lnameLabel, lnameField, dateLabel, dateOfBirth, genderLabel, genderField, registerLabel, registerField, phonenumLabel, phonenumField, emailLabel, emailField, departmentLabel, departmentField, fatherName, fatherNameField, motherName, motherNameField, classadvisorLabel, classadvisorField, submitDetails, goBackButton, exit);
         Scene AddScene = new Scene(mainAdd, 600, 600);
         AddScene.setFill(Color.web(background, 1.0));
         mainStage.setScene(AddScene);
    }

    private void showEditStudentsScene() {
        Font fieldfont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
        Group mainEdit = new Group();
        Label mainLabel = new Label("EDIT A STUDENT");
        Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(185);
        mainLabel.setTranslateY(30);
        Label nameLabel = new Label("ENTER NAME");
        nameLabel.setFont(fieldfont);
        nameLabel.setTextFill(Color.web("#706860", 1.0));
        nameLabel.setTextAlignment(TextAlignment.CENTER);
        nameLabel.setTranslateX(225);
        nameLabel.setTranslateY(100);
        TextField nameField = new TextField();
        nameField.setTranslateX(150);
        nameField.setTranslateY(135);
        nameField.setPrefSize(300, 40);
        Button nextbutton = new Button("NEXT");
        nextbutton.setLayoutX(150);
        nextbutton.setLayoutY(185);
        nextbutton.setPrefSize(300, 40);
        nextbutton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        nextbutton.setOnAction(event -> {
            String srchname = nameField.getText();
            String searchname = srchname.substring(0, 1).toUpperCase() + srchname.substring(1).toLowerCase(); 
            showEditDetailsScene(searchname);
        });
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(235);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(285);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
         mainEdit.getChildren().addAll(mainLabel, nameLabel, nameField, nextbutton, goBackButton, exit);
         Scene EditScene = new Scene(mainEdit, 600, 600);
         EditScene.setFill(Color.web(background, 1.0));
         mainStage.setScene(EditScene);
    }

    private void showRemoveStudentsScene() {
        Font fieldfont = Font.font("Times New Roman", FontPosture.REGULAR, 25);
        Group mainRemove = new Group();
         Label mainLabel = new Label("REMOVE A STUDENT");
           Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(160);
        mainLabel.setTranslateY(30);
        Label nameLabel = new Label("ENTER ROLL NUMBER");
        nameLabel.setFont(fieldfont);
        nameLabel.setTextFill(Color.web("#706860", 1.0));
        nameLabel.setTextAlignment(TextAlignment.CENTER);
        nameLabel.setTranslateX(170);
        nameLabel.setTranslateY(100);
        TextField nameField = new TextField();
        nameField.setTranslateX(150);
        nameField.setTranslateY(135);
        nameField.setPrefSize(300, 40);
        Button removebutton = new Button("REMOVE");
        removebutton.setLayoutX(150);
        removebutton.setLayoutY(185);
        removebutton.setPrefSize(300, 40);
        removebutton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        removebutton.setOnAction(event -> {
            String number = nameField.getText();
            removedStudent(number);
        });
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(235);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(285);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
         mainRemove.getChildren().addAll(mainLabel, nameLabel, nameField, removebutton, goBackButton, exit);
         Scene RemoveScene = new Scene(mainRemove, 600, 600);
         RemoveScene.setFill(Color.web(background, 1.0));
         mainStage.setScene(RemoveScene);
    }

    private void exitScene() {
        System.exit(0);
    }

    private void goBackScene() {
        start(mainStage);
    }

   private void listStudents() {
    int studentNumber = 1;
        Group mainLists = new Group();
        Label mainLabel = new Label("STUDENTS LIST");
        Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(160);
        mainLabel.setTranslateY(30);
        TextArea listsbox = new TextArea();
        listsbox.setLayoutX(150);
        listsbox.setLayoutY(80);
        listsbox.setPrefSize(300, 300);
        listsbox.setEditable(false);
        StringBuilder studentDetails = new StringBuilder();
        for (Student student : students) {
            studentDetails.append(studentNumber).append(". ").append(student.firstName).append(" ").append(student.lastName).append("\n");
            studentNumber++;
        }
        listsbox.setText(studentDetails.toString());
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(385);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(435);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
        mainLists.getChildren().addAll(mainLabel, listsbox, goBackButton, exit);
        Scene listsScene = new Scene(mainLists, 600, 600);
        listsScene.setFill(Color.web(background, 1.0));
        mainStage.setScene(listsScene);
}

    private void searchStudentsScene(String searchText) {
        int studentNumber = 1;
        Group mainSearch = new Group();
        Label mainLabel = new Label("SEARCH RESULTS");
        Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(160);
        mainLabel.setTranslateY(30);
        TextArea listsbox = new TextArea();
        listsbox.setLayoutX(150);
        listsbox.setLayoutY(80);
        listsbox.setPrefSize(300, 300);
        listsbox.setEditable(false);
        StringBuilder studentDetails = new StringBuilder();
        for (Student student : students) {
            String fullname = student.firstName + " " + student.lastName;
            if (searchText.equals(student.firstName) || searchText.equals(student.lastName) || searchText.equals(fullname)) {
                studentDetails.append(studentNumber).append(". ").append(student.firstName).append(" ").append(student.lastName).append(" - ").append(student.department).append("\n");
                studentNumber++;
            }
        }
        listsbox.setText(studentDetails.toString());
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(385);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(435);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
        mainSearch.getChildren().addAll(mainLabel, listsbox, goBackButton, exit);
        Scene searchScene = new Scene(mainSearch, 600, 600);
        searchScene.setFill(Color.web(background, 1.0));
        mainStage.setScene(searchScene);
    }

    private void addStudentToList(Student student){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\jaya2\\Visual Code\\StudentManagement\\src\\collegestudents.txt", true))) {
            String StudentData = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", student.firstName, student.lastName, student.dob, student.gender, student.rollNumber, student.phoneNumber, student.email, student.department, student.classteacher, student.parent1, student.parent2);
            bw.newLine();
            bw.write(StudentData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditDetailsScene(String studentname) {
        Group mainDetails = new Group();
        Label mainLabel = new Label("SEARCH RESULTS");
        Font font = Font.font("Times New Roman", FontPosture.REGULAR, 30);
        mainLabel.setFont(font);
        mainLabel.setTextFill(Color.web("#706860", 1.0));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        mainLabel.setTranslateX(160);
        mainLabel.setTranslateY(30);
        TextArea listsbox = new TextArea();
        listsbox.setLayoutX(150);
        listsbox.setLayoutY(80);
        listsbox.setPrefSize(300, 300);
        StringBuilder studentDetails = new StringBuilder();
        for (Student student : students) {
            String fullname = student.firstName + " " + student.lastName;
            if (studentname.equals(student.firstName) || studentname.equals(student.lastName) || studentname.equals(fullname)) {
                studentDetails.append(student.firstName).append("\n").append(student.lastName).append("\n").append(student.dob).append("\n").append(student.gender).append("\n").append(student.rollNumber).append("\n").append(student.phoneNumber).append("\n").append(student.email).append("\n").append(student.department).append("\n").append(student.classteacher).append("\n").append(student.parent1).append("\n").append(student.parent2);
                break;
            }
        }
        listsbox.setText(studentDetails.toString());
        Button addEdited = new Button("ADD");
        addEdited.setLayoutX(150);
        addEdited.setLayoutY(385);
        addEdited.setPrefSize(300, 40);
        addEdited.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        addEdited.setOnAction(event -> {
            int currentIndex = 0;
            String editDetails = listsbox.getText();
            String[] editedLines = editDetails.split("\n");
            for (Student student : students) {
            String fullname = student.firstName + " " + student.lastName;
            if (studentname.equals(student.firstName) || studentname.equals(student.lastName) || studentname.equals(fullname)) {
            student.firstName = editedLines[currentIndex++];
            student.lastName = editedLines[currentIndex++];
            student.dob = editedLines[currentIndex++];
            student.gender = editedLines[currentIndex++];
            student.rollNumber = editedLines[currentIndex++];
            student.phoneNumber = editedLines[currentIndex++];
            student.email = editedLines[currentIndex++];
            student.department = editedLines[currentIndex++];
            student.classteacher = editedLines[currentIndex++];
            student.parent1 = editedLines[currentIndex++];
            student.parent2 = editedLines[currentIndex++];
            removedStudent(student.rollNumber);
            Student editedStudent = new Student(editedLines[0], editedLines[1], editedLines[2], editedLines[3], editedLines[4], editedLines[5], editedLines[6], editedLines[7], editedLines[8], editedLines[9], editedLines[10]);
            students.add(editedStudent);
            addStudentToList(editedStudent);
            break;
        }
    }
        });
        Button goBackButton = new Button("BACK");
        goBackButton.setLayoutX(150);
        goBackButton.setLayoutY(435);
        goBackButton.setPrefSize(300, 40);
        goBackButton.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        goBackButton.setOnAction(event -> goBackScene());
        Button exit = new Button("EXIT");
        exit.setLayoutX(150);
        exit.setLayoutY(485);
        exit.setPrefSize(300, 40);
        exit.setStyle("-fx-background-color: #C2CDF0; -fx-text-fill: black; -fx-text-align: center; -fx-font-family: 'Times New Roman'; -fx-font-size: 16px; -fx-border-color: black;");
        exit.setOnAction(event -> exitScene());
        mainDetails.getChildren().addAll(mainLabel, listsbox, addEdited, goBackButton, exit);
        Scene editScene = new Scene(mainDetails, 600, 600);
        editScene.setFill(Color.web(background, 1.0));
        mainStage.setScene(editScene);
    }

    private void removedStudent(String number) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.rollNumber.equals(number)) {
                iterator.remove();
                break;
            }
        }

         updateTextFile();
    }

    private void updateTextFile() {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\jaya2\\Visual Code\\StudentManagement\\src\\collegestudents.txt"))) {
            for (Student student : students) {
                bw.write(student.firstName + "," + student.lastName + "," + student.dob + "," + student.gender +
                        "," + student.rollNumber + "," + student.phoneNumber + "," + student.email + "," + student.department +
                        "," + student.classteacher + "," + student.parent1 + "," + student.parent2);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
