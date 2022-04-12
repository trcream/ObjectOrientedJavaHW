package problem1;

public class Main {

  public static void main(String[] args) {
    try {
      String emailTemplateFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\email-template.txt";
      String csvFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\insurance-company-members.csv";
      String outputFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\outputFiles";
      String letterTemplateFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\letter-template.txt";

      String[] arguments = {"--email", "--email-template", emailTemplateFilePath, "--letter", "--letter-template", letterTemplateFilePath,"--csv-file", csvFilePath, "--output-dir", outputFilePath};
      CommandLineParser commandLine = new CommandLineParser(arguments);


    } catch (InvalidArgumentsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }
}
