package problem1;

import java.util.ArrayList;

/**
 * Interface for the file generator class
 */
public interface FileGeneratorI {

  String createFileName(Integer index);

  void parseCsv(String csv);

  void writeFileContent(Integer rowIndex, String fileName);

  void generate();
}
