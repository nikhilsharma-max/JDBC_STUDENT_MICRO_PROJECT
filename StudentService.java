package org.dnm;

import org.dnm.config.DBConfig;

import java.sql.*;

public class StudentService {

    public void addStudent(Student student){
        String sql = """
                INSERT INTO students(name,email,course,marks) VALUES (?,?,?,?);
                """;

        try{
            Connection connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getCourse());
            preparedStatement.setDouble(4,student.getMarks());
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected>0){
                System.out.println("Student added successfuly");
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in adding student");
            e.printStackTrace();
        }
    }

    public void viewAllStudent(){
        String sql = "SELECT * FROM students";
        try{
            Connection connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println();
            System.out.println("========== All Students Record ==========");
            while(resultSet.next()){
                System.out.println("--------------------------------------------------------");
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");
                double marks = resultSet.getDouble("marks");
                System.out.println("id: "+id);
                System.out.println("name: "+name);
                System.out.println("email: "+email);
                System.out.println("course: "+course);
                System.out.println("marks: "+marks);
                System.out.println("--------------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error in getting all sutudents record");
            e.printStackTrace();
        }
    }

    public void searchStudent(int id){
        String sql = """
                    SELECT * FROM students WHERE id=?
                """;
        try{
            Connection connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Student found");
                int ids = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");
                double marks = resultSet.getDouble("marks");
                System.out.println("id: "+ids);
                System.out.println("name: "+name);
                System.out.println("email: "+email);
                System.out.println("course: "+course);
                System.out.println("marks: "+marks);
            }else{
                System.out.println("Student not found");
            }

        } catch (SQLException e) {
            System.out.println("Error in Searching student");
            e.printStackTrace();
        }
    }


    public void deleteStudent(int id){
        String sql = """
                DELETE FROM students WHERE id=?
            """;
        try{
            Connection connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected>0){
                System.out.println("Student deleted successfully");
            }else{
                System.out.println("Student not found");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in deleting student");
            e.printStackTrace();
        }
    }


    public void updateStudent(int id, Student student){
        String sql = """
                UPDATE students
                SET name=?, email=?, course=?, marks=?
                WHERE id=?
            """;

        try{
            Connection connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getCourse());
            preparedStatement.setDouble(4,student.getMarks());
            preparedStatement.setInt(5,id);

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected>0){
                System.out.println("Student updated successfully");
            }else{
                System.out.println("Student not found");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in updating student");
            e.printStackTrace();
        }
    }

}
