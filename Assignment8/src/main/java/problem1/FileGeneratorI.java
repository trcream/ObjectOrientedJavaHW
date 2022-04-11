package problem1;

/**
 * Interface for the file generator class
 */
public interface FileGeneratorI {

  String createFileName(Integer index);

  void parseCsv(String csv);

  int writeFileContent(Integer rowIndex, String fileName);

  void generate();
}
