//package problem1;
//
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class UpdateCSV {
//
//  public String csv;
//
//  public void updateCSV() throws IOException {
//    try {
//      BufferedWriter writer = new BufferedWriter(new FileWriter(
//          "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment9\\src\\main\\java\\problem1"
//              + "\\newfile.csv"));
//      String line;
//      for (Integer key : CSVParser.toDoList.keySet()) {
//        if ((CSVParser.toDoList.get(key).getDueDate() == null) && (
//            CSVParser.toDoList.get(key).getCategory() == null)) {
//          System.out.println("YES IT WORKING!");
//          line =
//              ("\"\"" + CSVParser.toDoList.get(key).id + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).text + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).completed + "\"\"" + "," +
//                  "\"\"" + "?" + "\"\"" + "," +     // Create condition
//                  "\"\"" + CSVParser.toDoList.get(key).priority + "\"\"" + "," +   // Good
//                  "\"\"" + "?" + "\"\"");
//          writer.write(line);
//          writer.newLine();
//
//        }
//        if (CSVParser.toDoList.get(key).getDueDate() == null && (CSVParser.toDoList.get(key).getCategory() != null) ) {
//          System.out.println("YES IT WORKING! 2");
//          line =
//              ("\"\"" + CSVParser.toDoList.get(key).id + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).text + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).completed + "\"\"" + "," +
//                  "\"\"" + "?" + "\"\"" + "," +
//                  "\"\""+ CSVParser.toDoList.get(key).priority + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).category + "\"\"");
//          writer.write(line);
//          writer.newLine();
//        }
//        if ((CSVParser.toDoList.get(key).getCategory() == null) && (CSVParser.toDoList.get(key).getDueDate() != null)) {
//          System.out.println("YES IT WORKING! 3");
//          line =
//              ("\"\"" + CSVParser.toDoList.get(key).id + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).text + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).completed + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).dueDate.getMonthValue() + "/" +
//                  CSVParser.toDoList.get(key).dueDate.getDayOfMonth() + "/" +
//                  CSVParser.toDoList.get(key).dueDate.getYear() + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).priority + "\"\"" + "," +
//                  "\"\"" + "?" + "\"\"");
//          writer.write(line);
//          writer.newLine();
//        }
//        if ((CSVParser.toDoList.get(key).getDueDate() != null) && (
//            CSVParser.toDoList.get(key).getCategory() != null)) {
//          System.out.println("YES IT WORKING! 4");
//          line =
//              ("\"\"" + CSVParser.toDoList.get(key).id + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).text + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).completed + "\"\"" + "," +
//                  "\"\"" + CSVParser.toDoList.get(key).dueDate.getMonthValue() + "/" +
//                  CSVParser.toDoList.get(key).dueDate.getDayOfMonth() + "/" +
//                  CSVParser.toDoList.get(key).dueDate.getYear() + "\"\"" + "," +
//                  // Create condition
//                  "\"\"" + CSVParser.toDoList.get(key).priority + "\"\"" + "," +   // Good
//                  "\"\"" + CSVParser.toDoList.get(key).category + "\"\"");
//          writer.write(line);
//          writer.newLine();
//        }
//      }
//      writer.close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//}