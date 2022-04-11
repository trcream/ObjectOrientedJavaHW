package problem1;

public class Main {

  public static void main(String[] args) {
    try {
      String emailTemplateFilePath = "/Users/matthewfox/Desktop/GroupProject/Team_repo_Repo6_Arjun_Matthew_Trenton/Assignment8/src/main/java/problem1/email-template.txt";
      String csvFilePath = "/Users/matthewfox/Desktop/GroupProject/Team_repo_Repo6_Arjun_Matthew_Trenton/Assignment8/src/main/java/problem1/insurance-company-members.csv";
      String outputFilePath = "/Users/matthewfox/Desktop/GroupProject/Team_repo_Repo6_Arjun_Matthew_Trenton/Assignment8/files";
      String letterTemplateFilePath = "/Users/matthewfox/Desktop/GroupProject/Team_repo_Repo6_Arjun_Matthew_Trenton/Assignment8/src/main/java/problem1/letter-template.txt";
      String[] arguments = {"--email", "--email-template", emailTemplateFilePath, "--letter", "--letter-template", letterTemplateFilePath,"--csv-file", csvFilePath, "--output-dir", outputFilePath};
      CommandLineParser commandLine = new CommandLineParser(arguments);

    } catch (InvalidArgumentsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }
}
